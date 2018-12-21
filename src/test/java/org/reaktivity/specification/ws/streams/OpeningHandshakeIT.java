/**
 * Copyright 2016-2018 The Reaktivity Project
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
 * RFC-6455, section 4.1 "Client-Side Requirements" RFC-6455, section 4.2
 * "Server-Side Requirements"
 */
public class OpeningHandshakeIT
{
    private final K3poRule k3po = new K3poRule()
            .addScriptRoot("streams", "org/reaktivity/specification/ws/opening");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    @Rule
    public final TestRule chain = outerRule(k3po).around(timeout);

    @Test
    @Specification({
        "${streams}/connection.established/handshake.request",
        "${streams}/connection.established/handshake.response" })
    @ScriptProperty("serverTransport \"nukleus://streams/ws#0\"")
    public void shouldEstablishConnection() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    // TODO: get the rest of the tests to run using nukleus transport

    @Test
    @Specification({
        "${streams}/request.header.cookie/handshake.request",
        "${streams}/request.header.cookie/handshake.response" })
    public void shouldEstablishConnectionWithCookieRequestHeader()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.headers.random.case/handshake.request",
        "${streams}/request.headers.random.case/handshake.response" })
    public void shouldEstablishConnectionWithRandomCaseRequestHeaders()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/response.headers.random.case/handshake.request",
        "${streams}/response.headers.random.case/handshake.response" })
    public void shouldEstablishConnectionWithRandomCaseResponseHeaders()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.header.origin/handshake.request",
        "${streams}/request.header.origin/handshake.response" })
    public void shouldEstablishConnectionWithRequestHeaderOrigin()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.header.sec.websocket.protocol/handshake.request",
        "${streams}/request.header.sec.websocket.protocol/handshake.response" })
    @ScriptProperty("serverTransport \"nukleus://streams/ws#0\"")
    public void shouldEstablishConnectionWithRequestHeaderSecWebSocketProtocol()
            throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.header.sec.websocket.protocol.negotiated/handshake.request",
        "${streams}/request.header.sec.websocket.protocol.negotiated/handshake.response" })
    public void shouldEstablishConnectionWithRequestHeaderSecWebSocketProtocolNegotiated()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.header.sec.websocket.extensions/handshake.request",
        "${streams}/request.header.sec.websocket.extensions/handshake.response" })
    public void shouldEstablishConnectionWithRequestHeaderSecWebSocketExtensions()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/response.header.sec.websocket.extensions.partial.agreement/handshake.request",
        "${streams}/response.header.sec.websocket.extensions.partial.agreement/handshake.response" })
    public void shouldEstablishConnectionWithSomeExtensionsNegotiated()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/response.header.sec.websocket.extensions.reordered/handshake.request",
        "${streams}/response.header.sec.websocket.extensions.reordered/handshake.response" })
    public void shouldEstablishConnectionWhenOrderOfExtensionsNegotiatedChanged()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.method.not.get/handshake.request",
        "${streams}/request.method.not.get/handshake.response" })
    public void shouldFailHandshakeWhenMethodNotGet() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.version.not.http.1.1/handshake.request",
        "${streams}/request.version.not.http.1.1/handshake.response" })
    public void shouldFailHandshakeWhenVersionNotHttp11() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.header.host.missing/handshake.request",
        "${streams}/request.header.host.missing/handshake.response" })
    public void shouldFailHandshakeWhenRequestHeaderHostMissing()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.header.upgrade.missing/handshake.request",
        "${streams}/request.header.upgrade.missing/handshake.response" })
    public void shouldFailHandshakeWhenRequestHeaderUpgradeMissing()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.header.upgrade.not.websocket/handshake.request",
        "${streams}/request.header.upgrade.not.websocket/handshake.response" })
    public void shouldFailHandshakeWhenRequestHeaderUpgradeNotWebSocket()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.header.connection.missing/handshake.request",
        "${streams}/request.header.connection.missing/handshake.response" })
    public void shouldFailHandshakeWhenRequestHeaderConnectionMissing()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.header.connection.not.upgrade/handshake.request",
        "${streams}/request.header.connection.not.upgrade/handshake.response" })
    public void shouldFailHandshakeWhenRequestHeaderConnectionNotUpgrade()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.header.sec.websocket.key.missing/handshake.request",
        "${streams}/request.header.sec.websocket.key.missing/handshake.response" })
    public void shouldFailHandshakeWhenRequestHeaderSecWebSocketKeyMissing()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.header.sec.websocket.key.not.16bytes.base64/handshake.request",
        "${streams}/request.header.sec.websocket.key.not.16bytes.base64/handshake.response" })
    public void shouldFailHandshakeWhenRequestHeaderSecWebSocketKeyNot16BytesBase64()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.header.sec.websocket.version.not.13/handshake.request",
        "${streams}/request.header.sec.websocket.version.not.13/handshake.response" })
    public void shouldFailHandshakeWhenRequestHeaderSecWebSocketVersionNot13()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/response.header.connection.not.upgrade/handshake.request",
        "${streams}/response.header.connection.not.upgrade/handshake.response" })
    public void shouldFailConnectionWhenResponseHeaderConnectionNotUpgrade()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/response.header.connection.missing/handshake.request",
        "${streams}/response.header.connection.missing/handshake.response" })
    public void shouldFailConnectionWhenResponseHeaderConnectionMissing()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/response.header.upgrade.not.websocket/handshake.request",
        "${streams}/response.header.upgrade.not.websocket/handshake.response" })
    public void shouldFailConnectionWhenResponseHeaderUpgradeNotWebSocket()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/response.header.upgrade.missing/handshake.request",
        "${streams}/response.header.upgrade.missing/handshake.response" })
    public void shouldFailConnectionWhenResponseHeaderUpgradeMissing()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/response.header.sec.websocket.accept.not.hashed/handshake.request",
        "${streams}/response.header.sec.websocket.accept.not.hashed/handshake.response" })
    public void shouldFailConnectionWhenResponseHeaderSecWebSocketAcceptNotHashed()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/response.header.sec.websocket.accept.missing/handshake.request",
        "${streams}/response.header.sec.websocket.accept.missing/handshake.response" })
    public void shouldFailConnectionWhenResponseHeaderSecWebSocketAcceptMissing()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/response.header.sec.websocket.extensions.not.negotiated/handshake.request",
        "${streams}/response.header.sec.websocket.extensions.not.negotiated/handshake.response" })
    public void shouldFailConnectionWhenResponseHeaderSecWebSocketExtensionsNotNegotiated()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/response.header.sec.websocket.protocol.not.negotiated/handshake.request",
        "${streams}/response.header.sec.websocket.protocol.not.negotiated/handshake.response" })
    public void shouldFailConnectionWhenResponseHeaderSecWebSocketProtocolNotNegotiated()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/multiple.connections.established/handshake.requests",
        "${streams}/multiple.connections.established/handshake.responses" })
    public void shouldEstablishMultipleConnections() throws Exception
    {
        k3po.finish();
    }
}
