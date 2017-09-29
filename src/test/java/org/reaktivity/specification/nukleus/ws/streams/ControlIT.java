/**
 * Copyright 2016-2017 The Reaktivity Project
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
package org.reaktivity.specification.nukleus.ws.streams;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.rules.RuleChain.outerRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.kaazing.k3po.junit.annotation.ScriptProperty;
import org.kaazing.k3po.junit.annotation.Specification;
import org.kaazing.k3po.junit.rules.K3poRule;
import org.reaktivity.specification.nukleus.NukleusRule;

/**
 * RFC-6455, section 4.1 "Client-Side Requirements" RFC-6455, section 4.2
 * "Server-Side Requirements"
 */
public class ControlIT
{
    private final K3poRule k3po = new K3poRule()
            .addScriptRoot("streams", "org/reaktivity/specification/nukleus/ws/streams/control")
            .addScriptRoot("spec", "org/reaktivity/specification/ws/control");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    private final NukleusRule nukleus = new NukleusRule()
        .directory("target/nukleus-itests");

    @Rule
    public final TestRule chain = outerRule(nukleus).around(k3po).around(timeout);

    @Test
    @Specification({
        "${streams}/client.send.pong.payload.length.0/handshake.request",
        "${streams}/client.send.pong.payload.length.0/handshake.response" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldReceiveClientPongFrameWithEmptyPayload() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.pong.payload.length.125/handshake.request",
        "${streams}/client.send.pong.payload.length.125/handshake.response" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldReceiveClientPongFrameWithPayload() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.pong.payload.length.126/handshake.request",
        "${streams}/client.send.pong.payload.length.126/handshake.response" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldRejectClientPongFrameWithPayloadTooLong() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }
}
