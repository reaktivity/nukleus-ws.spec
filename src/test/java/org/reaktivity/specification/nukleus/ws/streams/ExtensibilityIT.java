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
 * RFC-6455, section 5.8 "Extensibility"
 */
public class ExtensibilityIT
{
    private final K3poRule k3po = new K3poRule()
            .addScriptRoot("streams", "org/reaktivity/specification/nukleus/ws/streams/extensibility");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    private final NukleusRule nukleus = new NukleusRule()
        .directory("target/nukleus-itests");

    @Rule
    public final TestRule chain = outerRule(nukleus).around(k3po).around(timeout);

    @Test
    @Specification({
        "${streams}/client.send.text.frame.with.rsv.1/handshake.request.and.frame",
        "${streams}/client.send.text.frame.with.rsv.1/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendTextFrameWithRsv1()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.binary.frame.with.rsv.1/handshake.request.and.frame",
        "${streams}/client.send.binary.frame.with.rsv.1/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendBinaryFrameWithRsv1()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.close.frame.with.rsv.1/handshake.request.and.frame",
        "${streams}/client.send.close.frame.with.rsv.1/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithRsv1()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.ping.frame.with.rsv.1/handshake.request.and.frame",
        "${streams}/client.send.ping.frame.with.rsv.1/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithRsv1()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.pong.frame.with.rsv.1/handshake.request.and.frame",
        "${streams}/client.send.pong.frame.with.rsv.1/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithRsv1()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.text.frame.with.rsv.2/handshake.request.and.frame",
        "${streams}/client.send.text.frame.with.rsv.2/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendTextFrameWithRsv2()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.binary.frame.with.rsv.2/handshake.request.and.frame",
        "${streams}/client.send.binary.frame.with.rsv.2/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendBinaryFrameWithRsv2()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.close.frame.with.rsv.2/handshake.request.and.frame",
        "${streams}/client.send.close.frame.with.rsv.2/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithRsv2()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.ping.frame.with.rsv.2/handshake.request.and.frame",
        "${streams}/client.send.ping.frame.with.rsv.2/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithRsv2()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.pong.frame.with.rsv.2/handshake.request.and.frame",
        "${streams}/client.send.pong.frame.with.rsv.2/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithRsv2()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.text.frame.with.rsv.3/handshake.request.and.frame",
        "${streams}/client.send.text.frame.with.rsv.3/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendTextFrameWithRsv3()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.binary.frame.with.rsv.3/handshake.request.and.frame",
        "${streams}/client.send.binary.frame.with.rsv.3/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendBinaryFrameWithRsv3()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.close.frame.with.rsv.3/handshake.request.and.frame",
        "${streams}/client.send.close.frame.with.rsv.3/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithRsv3()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.ping.frame.with.rsv.3/handshake.request.and.frame",
        "${streams}/client.send.ping.frame.with.rsv.3/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithRsv3()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.pong.frame.with.rsv.3/handshake.request.and.frame",
        "${streams}/client.send.pong.frame.with.rsv.3/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithRsv3()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.text.frame.with.rsv.4/handshake.request.and.frame",
        "${streams}/client.send.text.frame.with.rsv.4/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendTextFrameWithRsv4()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.binary.frame.with.rsv.4/handshake.request.and.frame",
        "${streams}/client.send.binary.frame.with.rsv.4/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendBinaryFrameWithRsv4()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.close.frame.with.rsv.4/handshake.request.and.frame",
        "${streams}/client.send.close.frame.with.rsv.4/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithRsv4()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.ping.frame.with.rsv.4/handshake.request.and.frame",
        "${streams}/client.send.ping.frame.with.rsv.4/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithRsv4()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.pong.frame.with.rsv.4/handshake.request.and.frame",
        "${streams}/client.send.pong.frame.with.rsv.4/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithRsv4()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.text.frame.with.rsv.5/handshake.request.and.frame",
        "${streams}/client.send.text.frame.with.rsv.5/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendTextFrameWithRsv5()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.binary.frame.with.rsv.5/handshake.request.and.frame",
        "${streams}/client.send.binary.frame.with.rsv.5/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendBinaryFrameWithRsv5()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.close.frame.with.rsv.5/handshake.request.and.frame",
        "${streams}/client.send.close.frame.with.rsv.5/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithRsv5()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.ping.frame.with.rsv.5/handshake.request.and.frame",
        "${streams}/client.send.ping.frame.with.rsv.5/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithRsv5()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.pong.frame.with.rsv.5/handshake.request.and.frame",
        "${streams}/client.send.pong.frame.with.rsv.5/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithRsv5()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.text.frame.with.rsv.6/handshake.request.and.frame",
        "${streams}/client.send.text.frame.with.rsv.6/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendTextFrameWithRsv6()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.binary.frame.with.rsv.6/handshake.request.and.frame",
        "${streams}/client.send.binary.frame.with.rsv.6/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendBinaryFrameWithRsv6()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.close.frame.with.rsv.6/handshake.request.and.frame",
        "${streams}/client.send.close.frame.with.rsv.6/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithRsv6()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.ping.frame.with.rsv.6/handshake.request.and.frame",
        "${streams}/client.send.ping.frame.with.rsv.6/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithRsv6()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.pong.frame.with.rsv.6/handshake.request.and.frame",
        "${streams}/client.send.pong.frame.with.rsv.6/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithRsv6()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.text.frame.with.rsv.7/handshake.request.and.frame",
        "${streams}/client.send.text.frame.with.rsv.7/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendTextFrameWithRsv7()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.binary.frame.with.rsv.7/handshake.request.and.frame",
        "${streams}/client.send.binary.frame.with.rsv.7/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendBinaryFrameWithRsv7()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.close.frame.with.rsv.7/handshake.request.and.frame",
        "${streams}/client.send.close.frame.with.rsv.7/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithRsv7()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.ping.frame.with.rsv.7/handshake.request.and.frame",
        "${streams}/client.send.ping.frame.with.rsv.7/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithRsv7()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.pong.frame.with.rsv.7/handshake.request.and.frame",
        "${streams}/client.send.pong.frame.with.rsv.7/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithRsv7()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.text.frame.with.rsv.1/handshake.request.and.frame",
        "${streams}/server.send.text.frame.with.rsv.1/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendTextFrameWithRsv1()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.binary.frame.with.rsv.1/handshake.request.and.frame",
        "${streams}/server.send.binary.frame.with.rsv.1/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendBinaryFrameWithRsv1()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.close.frame.with.rsv.1/handshake.request.and.frame",
        "${streams}/server.send.close.frame.with.rsv.1/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendCloseFrameWithRsv1()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.ping.frame.with.rsv.1/handshake.request.and.frame",
        "${streams}/server.send.ping.frame.with.rsv.1/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendPingFrameWithRsv1()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.pong.frame.with.rsv.1/handshake.request.and.frame",
        "${streams}/server.send.pong.frame.with.rsv.1/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendPongFrameWithRsv1()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.text.frame.with.rsv.2/handshake.request.and.frame",
        "${streams}/server.send.text.frame.with.rsv.2/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendTextFrameWithRsv2()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.binary.frame.with.rsv.2/handshake.request.and.frame",
        "${streams}/server.send.binary.frame.with.rsv.2/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendBinaryFrameWithRsv2()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.close.frame.with.rsv.2/handshake.request.and.frame",
        "${streams}/server.send.close.frame.with.rsv.2/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendCloseFrameWithRsv2()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.ping.frame.with.rsv.2/handshake.request.and.frame",
        "${streams}/server.send.ping.frame.with.rsv.2/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendPingFrameWithRsv2()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.pong.frame.with.rsv.2/handshake.request.and.frame",
        "${streams}/server.send.pong.frame.with.rsv.2/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendPongFrameWithRsv2()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.text.frame.with.rsv.3/handshake.request.and.frame",
        "${streams}/server.send.text.frame.with.rsv.3/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendTextFrameWithRsv3()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.binary.frame.with.rsv.3/handshake.request.and.frame",
        "${streams}/server.send.binary.frame.with.rsv.3/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendBinaryFrameWithRsv3()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.close.frame.with.rsv.3/handshake.request.and.frame",
        "${streams}/server.send.close.frame.with.rsv.3/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendCloseFrameWithRsv3()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.ping.frame.with.rsv.3/handshake.request.and.frame",
        "${streams}/server.send.ping.frame.with.rsv.3/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendPingFrameWithRsv3()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.pong.frame.with.rsv.3/handshake.request.and.frame",
        "${streams}/server.send.pong.frame.with.rsv.3/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendPongFrameWithRsv3()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.text.frame.with.rsv.4/handshake.request.and.frame",
        "${streams}/server.send.text.frame.with.rsv.4/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendTextFrameWithRsv4()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.binary.frame.with.rsv.4/handshake.request.and.frame",
        "${streams}/server.send.binary.frame.with.rsv.4/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendBinaryFrameWithRsv4()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.close.frame.with.rsv.4/handshake.request.and.frame",
        "${streams}/server.send.close.frame.with.rsv.4/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendCloseFrameWithRsv4()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.ping.frame.with.rsv.4/handshake.request.and.frame",
        "${streams}/server.send.ping.frame.with.rsv.4/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendPingFrameWithRsv4()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.pong.frame.with.rsv.4/handshake.request.and.frame",
        "${streams}/server.send.pong.frame.with.rsv.4/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendPongFrameWithRsv4()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.text.frame.with.rsv.5/handshake.request.and.frame",
        "${streams}/server.send.text.frame.with.rsv.5/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendTextFrameWithRsv5()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.binary.frame.with.rsv.5/handshake.request.and.frame",
        "${streams}/server.send.binary.frame.with.rsv.5/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendBinaryFrameWithRsv5()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.close.frame.with.rsv.5/handshake.request.and.frame",
        "${streams}/server.send.close.frame.with.rsv.5/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendCloseFrameWithRsv5()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.ping.frame.with.rsv.5/handshake.request.and.frame",
        "${streams}/server.send.ping.frame.with.rsv.5/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendPingFrameWithRsv5()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.pong.frame.with.rsv.5/handshake.request.and.frame",
        "${streams}/server.send.pong.frame.with.rsv.5/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendPongFrameWithRsv5()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.text.frame.with.rsv.6/handshake.request.and.frame",
        "${streams}/server.send.text.frame.with.rsv.6/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendTextFrameWithRsv6()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.binary.frame.with.rsv.6/handshake.request.and.frame",
        "${streams}/server.send.binary.frame.with.rsv.6/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendBinaryFrameWithRsv6()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.close.frame.with.rsv.6/handshake.request.and.frame",
        "${streams}/server.send.close.frame.with.rsv.6/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendCloseFrameWithRsv6()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.ping.frame.with.rsv.6/handshake.request.and.frame",
        "${streams}/server.send.ping.frame.with.rsv.6/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendPingFrameWithRsv6()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.pong.frame.with.rsv.6/handshake.request.and.frame",
        "${streams}/server.send.pong.frame.with.rsv.6/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendPongFrameWithRsv6()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.text.frame.with.rsv.7/handshake.request.and.frame",
        "${streams}/server.send.text.frame.with.rsv.7/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendTextFrameWithRsv7()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.binary.frame.with.rsv.7/handshake.request.and.frame",
        "${streams}/server.send.binary.frame.with.rsv.7/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendBinaryFrameWithRsv7()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.close.frame.with.rsv.7/handshake.request.and.frame",
        "${streams}/server.send.close.frame.with.rsv.7/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendCloseFrameWithRsv7()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.ping.frame.with.rsv.7/handshake.request.and.frame",
        "${streams}/server.send.ping.frame.with.rsv.7/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendPingFrameWithRsv7()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.pong.frame.with.rsv.7/handshake.request.and.frame",
        "${streams}/server.send.pong.frame.with.rsv.7/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendPongFrameWithRsv7()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }
}
