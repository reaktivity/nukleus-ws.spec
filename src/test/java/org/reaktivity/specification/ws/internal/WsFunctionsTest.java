/**
 * Copyright 2016-2019 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.specification.ws.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.kaazing.k3po.lang.internal.el.ExpressionFactoryUtils.newExpressionFactory;
import static org.reaktivity.specification.ws.internal.WsFunctions.beginEx;
import static org.reaktivity.specification.ws.internal.WsFunctions.routeEx;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import org.agrona.DirectBuffer;
import org.agrona.concurrent.UnsafeBuffer;
import org.junit.Before;
import org.junit.Test;
import org.kaazing.k3po.lang.internal.el.ExpressionContext;
import org.reaktivity.nukleus.specification.ws.internal.types.control.WsRouteExFW;
import org.reaktivity.nukleus.specification.ws.internal.types.stream.WsBeginExFW;
import org.reaktivity.specification.ws.internal.WsFunctions.WsBeginExHelper;

public class WsFunctionsTest
{
    private ExpressionFactory factory;
    private ELContext ctx;

    @Before
    public void setUp() throws Exception
    {
        factory = newExpressionFactory();
        ctx = new ExpressionContext();
    }

    @Test
    public void shouldLoadFunctions() throws Exception
    {
        String expressionText = "${ws:beginEx()}";
        ValueExpression expression = factory.createValueExpression(ctx, expressionText, WsBeginExHelper.class);
        WsBeginExHelper builder = (WsBeginExHelper) expression.getValue(ctx);
        assertNotNull(builder);
    }

    @Test
    public void shouldEncodeWsRouteExt()
    {
        final byte[] array = routeEx().protocol("primary")
                                      .scheme("http")
                                      .authority("localhost:8080")
                                      .path("/path?query")
                                      .build();

        DirectBuffer buffer = new UnsafeBuffer(array);
        WsRouteExFW wsRouteEx = new WsRouteExFW().wrap(buffer, 0, buffer.capacity());

        assertEquals(wsRouteEx.protocol().asString(), "primary");
        assertEquals(wsRouteEx.scheme().asString(), "http");
        assertEquals(wsRouteEx.authority().asString(), "localhost:8080");
        assertEquals(wsRouteEx.path().asString(), "/path?query");
    }

    @Test
    public void shouldEncodeWsBeginExt()
    {
        final byte[] array = beginEx().typeId(0x01)
                                      .protocol("primary")
                                      .scheme("http")
                                      .authority("localhost:8080")
                                      .path("/path?query")
                                      .build();

        DirectBuffer buffer = new UnsafeBuffer(array);
        WsBeginExFW wsBeginEx = new WsBeginExFW().wrap(buffer, 0, buffer.capacity());

        assertEquals(wsBeginEx.typeId(), 0x01);
        assertEquals(wsBeginEx.protocol().asString(), "primary");
        assertEquals(wsBeginEx.scheme().asString(), "http");
        assertEquals(wsBeginEx.authority().asString(), "localhost:8080");
        assertEquals(wsBeginEx.path().asString(), "/path?query");
    }
}
