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
 * RFC-6455, section 5.4 "Fragmentation"
 */
public class FragmentationIT
{
    private final K3poRule k3po = new K3poRule()
            .addScriptRoot("streams", "org/reaktivity/specification/nukleus/ws/streams/fragmentation");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    private final NukleusRule nukleus = new NukleusRule()
        .directory("target/nukleus-itests");

    @Rule
    public final TestRule chain = outerRule(nukleus).around(k3po).around(timeout);

    @Test
    @Specification({
        "${streams}/client.send.continuation.payload.length.125.not.fragmented/handshake.request.and.frame",
        "${streams}/client.send.continuation.payload.length.125.not.fragmented/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendContinuationFrameWithPayloadNotFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.continuation.payload.length.125.fragmented/handshake.request.and.frames",
        "${streams}/client.send.continuation.payload.length.125.fragmented/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendContinuationFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.echo.text.payload.length.125.not.fragmented/handshake.request.and.frame",
        "${streams}/client.echo.text.payload.length.125.not.fragmented/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoClientSendTextFrameWithPayloadNotFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.echo.text.payload.length.0.fragmented/handshake.request.and.frames",
        "${streams}/client.echo.text.payload.length.0.fragmented/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoClientSendTextFrameWithEmptyPayloadFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.echo.text.payload.length.0.fragmented.with.injected.ping.pong/handshake.request.and.frames",
        "${streams}/client.echo.text.payload.length.0.fragmented.with.injected.ping.pong/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoClientSendTextFrameWithEmptyPayloadFragmentedAndInjectedPingPong()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.echo.text.payload.length.125.fragmented/handshake.request.and.frames",
        "${streams}/client.echo.text.payload.length.125.fragmented/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoClientSendTextFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.echo.text.payload.length.125.fragmented.with.some.empty.fragments/handshake.request.and.frames",
        "${streams}/client.echo.text.payload.length.125.fragmented.with.some.empty.fragments/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoClientSendTextFrameWithPayloadFragmentedWithSomeEmptyFragments()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.echo.text.payload.length.125.fragmented.but.not.utf8.aligned/handshake.request.and.frames",
        "${streams}/client.echo.text.payload.length.125.fragmented.but.not.utf8.aligned/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoClientSendTextFrameWithPayloadFragmentedEvenWhenNotUTF8Aligned()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.echo.text.payload.length.125.fragmented.with.injected.ping.pong/handshake.request.and.frames",
        "${streams}/client.echo.text.payload.length.125.fragmented.with.injected.ping.pong/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoClientSendTextFrameWithPayloadFragmentedAndInjectedPingPong()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.text.payload.length.125.fragmented.but.not.continued/handshake.request.and.frames",
        "${streams}/client.send.text.payload.length.125.fragmented.but.not.continued/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendTextFrameWithPayloadFragmentedButNotContinued()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.echo.binary.payload.length.125.not.fragmented/handshake.request.and.frame",
        "${streams}/client.echo.binary.payload.length.125.not.fragmented/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoClientSendBinaryFrameWithPayloadNotFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.echo.binary.payload.length.0.fragmented/handshake.request.and.frames",
        "${streams}/client.echo.binary.payload.length.0.fragmented/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoClientSendBinaryFrameWithEmptyPayloadFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.echo.binary.payload.length.0.fragmented.with.injected.ping.pong/handshake.request.and.frames",
        "${streams}/client.echo.binary.payload.length.0.fragmented.with.injected.ping.pong/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoClientSendBinaryFrameWithEmptyPayloadFragmentedAndInjectedPingPong()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.echo.binary.payload.length.125.fragmented/handshake.request.and.frames",
        "${streams}/client.echo.binary.payload.length.125.fragmented/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoClientSendBinaryFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.echo.binary.payload.length.125.fragmented.with.some.empty.fragments/handshake.request.and.frames",
        "${streams}/client.echo.binary.payload.length.125.fragmented.with.some.empty.fragments/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoClientSendBinaryFrameWithPayloadFragmentedWithSomeEmptyFragments()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.echo.binary.payload.length.125.fragmented.with.injected.ping.pong/handshake.request.and.frames",
        "${streams}/client.echo.binary.payload.length.125.fragmented.with.injected.ping.pong/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoClientSendBinaryFrameWithPayloadFragmentedAndInjectedPingPong()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.binary.payload.length.125.fragmented.but.not.continued/handshake.request.and.frames",
        "${streams}/client.send.binary.payload.length.125.fragmented.but.not.continued/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendBinaryFrameWithPayloadFragmentedButNotContinued()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.close.payload.length.2.fragmented/handshake.request.and.frames",
        "${streams}/client.send.close.payload.length.2.fragmented/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.ping.payload.length.0.fragmented/handshake.request.and.frames",
        "${streams}/client.send.ping.payload.length.0.fragmented/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.send.pong.payload.length.0.fragmented/handshake.request.and.frames",
        "${streams}/client.send.pong.payload.length.0.fragmented/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.echo.binary.payload.length.0.fragmented/handshake.request.and.frame",
        "${streams}/server.echo.binary.payload.length.0.fragmented/handshake.response.and.frames" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoServerSendBinaryFrameWithEmptyPayloadFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.echo.binary.payload.length.0.fragmented.with.injected.ping.pong/handshake.request.and.frame",
        "${streams}/server.echo.binary.payload.length.0.fragmented.with.injected.ping.pong/handshake.response.and.frames" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoServerSendBinaryFrameWithEmptyPayloadFragmentedAndInjectedPingPong()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.echo.binary.payload.length.125.fragmented/handshake.request.and.frame",
        "${streams}/server.echo.binary.payload.length.125.fragmented/handshake.response.and.frames" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoServerSendBinaryFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.echo.binary.payload.length.125.fragmented.with.injected.ping.pong/handshake.request.and.frame",
        "${streams}/server.echo.binary.payload.length.125.fragmented.with.injected.ping.pong/handshake.response.and.frames" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoServerSendBinaryFrameWithPayloadFragmentedAndInjectedPingPong()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.echo.binary.payload.length.125.fragmented.with.some.empty.fragments/handshake.request.and.frame",
        "${streams}/server.echo.binary.payload.length.125.fragmented.with.some.empty.fragments/handshake.response.and.frames" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoServerSendBinaryFrameWithPayloadFragmentedWithSomeEmptyFragments()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.echo.binary.payload.length.125.not.fragmented/handshake.request.and.frame",
        "${streams}/server.echo.binary.payload.length.125.not.fragmented/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoServerSendBinaryFrameWithPayloadNotFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.echo.text.payload.length.0.fragmented/handshake.request.and.frame",
        "${streams}/server.echo.text.payload.length.0.fragmented/handshake.response.and.frames" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoServerSendTextFrameWithEmptyPayloadFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.echo.text.payload.length.0.fragmented.with.injected.ping.pong/handshake.request.and.frame",
        "${streams}/server.echo.text.payload.length.0.fragmented.with.injected.ping.pong/handshake.response.and.frames" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoServerSendTextFrameWithEmptyPayloadFragmentedAndInjectedPingPong()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.echo.text.payload.length.125.fragmented/handshake.request.and.frame",
        "${streams}/server.echo.text.payload.length.125.fragmented/handshake.response.and.frames" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoServerSendTextFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.echo.text.payload.length.125.fragmented.but.not.utf8.aligned/handshake.request.and.frame",
        "${streams}/server.echo.text.payload.length.125.fragmented.but.not.utf8.aligned/handshake.response.and.frames" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoServerSendTextFrameWithPayloadFragmentedEvenWhenNotUTF8Aligned()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.echo.text.payload.length.125.fragmented.with.injected.ping.pong/handshake.request.and.frame",
        "${streams}/server.echo.text.payload.length.125.fragmented.with.injected.ping.pong/handshake.response.and.frames" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoServerSendTextFrameWithPayloadFragmentedAndInjectedPingPong()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.echo.text.payload.length.125.fragmented.with.some.empty.fragments/handshake.request.and.frame",
        "${streams}/server.echo.text.payload.length.125.fragmented.with.some.empty.fragments/handshake.response.and.frames" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoServerSendTextFrameWithPayloadFragmentedWithSomeEmptyFragments()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.echo.text.payload.length.125.not.fragmented/handshake.request.and.frame",
        "${streams}/server.echo.text.payload.length.125.not.fragmented/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldEchoServerSendTextFrameWithPayloadNotFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.binary.payload.length.125.fragmented.but.not.continued/handshake.request.and.frame",
        "${streams}/server.send.binary.payload.length.125.fragmented.but.not.continued/handshake.response.and.frames" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendBinaryFrameWithPayloadFragmentedButNotContinued()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.close.payload.length.2.fragmented/handshake.request.and.frame",
        "${streams}/server.send.close.payload.length.2.fragmented/handshake.response.and.frames" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendCloseFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.continuation.payload.length.125.fragmented/handshake.request.and.frame",
        "${streams}/server.send.continuation.payload.length.125.fragmented/handshake.response.and.frames" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendContinuationFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.continuation.payload.length.125.not.fragmented/handshake.request.and.frame",
        "${streams}/server.send.continuation.payload.length.125.not.fragmented/handshake.response.and.frame" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendContinuationFrameWithPayloadNotFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.ping.payload.length.0.fragmented/handshake.request.and.frame",
        "${streams}/server.send.ping.payload.length.0.fragmented/handshake.response.and.frames" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendPingFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/server.send.pong.payload.length.0.fragmented/handshake.request.and.frame",
        "${streams}/server.send.pong.payload.length.0.fragmented/handshake.response.and.frames" })
    @ScriptProperty("serverConnect \"nukleus://ws/streams/source\"")
    public void shouldFailWebSocketConnectionWhenServerSendPongFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }
}
