/**
 * Copyright 2016-2020 The Reaktivity Project
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
package org.reaktivity.specification.ws.streams;

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

/**
 * RFC-6455, section 7 "Closing the Connection"
 */
public class ClosingHandshakeIT
{
    private final K3poRule k3po = new K3poRule()
            .setScriptRoot("org/reaktivity/specification/ws/closing");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    @Rule
    public final TestRule chain = outerRule(k3po).around(timeout);

    @Test
    @Specification({
        "client.send.empty.close.frame/handshake.request.and.frame",
        "client.send.empty.close.frame/handshake.response.and.frame" })
    @ScriptProperty("serverTransport \"nukleus://streams/ws#0\"")
    public void shouldCompleteCloseHandshakeWhenClientSendEmptyCloseFrame()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "client.send.close.frame.with.code.1000/handshake.request.and.frame",
        "client.send.close.frame.with.code.1000/handshake.response.and.frame" })
    public void shouldCompleteCloseHandshakeWhenClientSendCloseFrameWithCode1000()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "client.send.close.frame.with.code.1000.and.reason/handshake.request.and.frame",
        "client.send.close.frame.with.code.1000.and.reason/handshake.response.and.frame" })
    public void shouldCompleteCloseHandshakeWhenClientSendCloseFrameWithCode1000AndReason()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "client.send.close.frame.with.code.1000.and.invalid.utf8.reason/handshake.request.and.frame",
        "client.send.close.frame.with.code.1000.and.invalid.utf8.reason/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithCode1000AndInvalidUTF8Reason()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "client.send.close.frame.with.code.1001/handshake.request.and.frame",
        "client.send.close.frame.with.code.1001/handshake.response.and.frame" })
    public void shouldCompleteCloseHandshakeWhenClientSendCloseFrameWithCode1001()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "client.send.close.frame.with.code.1005/handshake.request.and.frame",
        "client.send.close.frame.with.code.1005/handshake.response.and.frame" })
    @ScriptProperty("serverTransport \"nukleus://streams/ws#0\"")
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithCode1005()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "client.send.close.frame.with.code.1006/handshake.request.and.frame",
        "client.send.close.frame.with.code.1006/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithCode1006()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "client.send.close.frame.with.code.1015/handshake.request.and.frame",
        "client.send.close.frame.with.code.1015/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithCode1015()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "server.send.empty.close.frame/handshake.request.and.frame",
        "server.send.empty.close.frame/handshake.response.and.frame" })
    public void shouldCompleteCloseHandshakeWhenServerSendEmptyCloseFrame()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "server.send.close.frame.with.code.1000/handshake.request.and.frame",
        "server.send.close.frame.with.code.1000/handshake.response.and.frame" })
    public void shouldCompleteCloseHandshakeWhenServerSendCloseFrameWithCode1000()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "server.send.close.frame.with.code.1000.and.reason/handshake.request.and.frame",
        "server.send.close.frame.with.code.1000.and.reason/handshake.response.and.frame" })
    public void shouldCompleteCloseHandshakeWhenServerSendCloseFrameWithCode1000AndReason()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "server.send.close.frame.with.code.1000.and.invalid.utf8.reason/handshake.request.and.frame",
        "server.send.close.frame.with.code.1000.and.invalid.utf8.reason/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenServerSendCloseFrameWithCode1000AndInvalidUTF8Reason()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "server.send.close.frame.with.code.1001/handshake.request.and.frame",
        "server.send.close.frame.with.code.1001/handshake.response.and.frame" })
    public void shouldCompleteCloseHandshakeWhenServerSendCloseFrameWithCode1001()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "server.send.close.frame.with.code.1005/handshake.request.and.frame",
        "server.send.close.frame.with.code.1005/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenServerSendCloseFrameWithCode1005()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "server.send.close.frame.with.code.1006/handshake.request.and.frame",
        "server.send.close.frame.with.code.1006/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenServerSendCloseFrameWithCode1006()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "server.send.close.frame.with.code.1015/handshake.request.and.frame",
        "server.send.close.frame.with.code.1015/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenServerSendCloseFrameWithCode1015()
            throws Exception
    {
        k3po.finish();
    }
}
