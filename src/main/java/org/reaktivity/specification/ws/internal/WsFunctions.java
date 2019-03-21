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

import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;
import static java.nio.charset.StandardCharsets.US_ASCII;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64.Encoder;
import java.util.Random;

import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.UnsafeBuffer;
import org.kaazing.k3po.lang.el.Function;
import org.kaazing.k3po.lang.el.spi.FunctionMapperSpi;
import org.reaktivity.nukleus.specification.ws.internal.types.control.WsRouteExFW;
import org.reaktivity.nukleus.specification.ws.internal.types.stream.WsBeginExFW;

public final class WsFunctions
{
    private static final Encoder BASE64_ENCODER = java.util.Base64.getEncoder();
    private static final int MAX_BUFFER_SIZE = 1024 * 8;

    public static class WsBeginExHelper
    {
        private final WsBeginExFW.Builder wsBeginExRW;

        public WsBeginExHelper()
        {
            MutableDirectBuffer writeBuffer = new UnsafeBuffer(new byte[MAX_BUFFER_SIZE]);
            this.wsBeginExRW = new WsBeginExFW.Builder()
                                    .wrap(writeBuffer, 0, writeBuffer.capacity());
        }

        public WsBeginExHelper protocol(
            String protocol)
        {
            wsBeginExRW.protocol(protocol);
            return this;
        }

        public WsBeginExHelper scheme(
            String scheme)
        {
            wsBeginExRW.scheme(scheme);
            return this;
        }

        public WsBeginExHelper authority(
            String authority)
        {
            wsBeginExRW.authority(authority);
            return this;
        }

        public WsBeginExHelper path(
            String path)
        {
            wsBeginExRW.path(path);
            return this;
        }

        public byte[] build()
        {
            final WsBeginExFW wsBeginEx = wsBeginExRW.build();
            final byte[] result = new byte[wsBeginEx.sizeof()];
            wsBeginEx.buffer().getBytes(0, result);
            return result;
        }
    }

    public static class WsRouteExHelper
    {
        private final WsRouteExFW.Builder wsRouteExRW;

        public WsRouteExHelper()
        {
            MutableDirectBuffer writeBuffer = new UnsafeBuffer(new byte[MAX_BUFFER_SIZE]);
            this.wsRouteExRW = new WsRouteExFW.Builder()
                                    .wrap(writeBuffer, 0, writeBuffer.capacity());
        }

        public WsRouteExHelper protocol(
            String protocol)
        {
            wsRouteExRW.protocol(protocol);
            return this;
        }

        public WsRouteExHelper scheme(
            String scheme)
        {
            wsRouteExRW.scheme(scheme);
            return this;
        }

        public WsRouteExHelper authority(
            String authority)
        {
            wsRouteExRW.authority(authority);
            return this;
        }

        public WsRouteExHelper path(
            String path)
        {
            wsRouteExRW.path(path);
            return this;
        }

        public byte[] build()
        {
            final WsRouteExFW wsRouteEx = wsRouteExRW.build();
            final byte[] result = new byte[wsRouteEx.sizeof()];
            wsRouteEx.buffer().getBytes(0, result);
            return result;
        }
    }

    @Function
    public static WsBeginExHelper beginEx()
    {
        return new WsBeginExHelper();
    }

    @Function
    public static WsRouteExHelper routeEx()
    {
        return new WsRouteExHelper();
    }

    private static final byte[] WEBSOCKET_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11".getBytes(US_ASCII);
    private static final Random RANDOM = new Random();
    private static final int MAX_ACCEPTABLE_HEADER_LENGTH = 200;

    @Function
    public static String base64Encode(String text)
    {
        byte[] bytes = text.getBytes(UTF_8);
        return BASE64_ENCODER.encodeToString(bytes);
    }

    @Function
    public static String append(String... strings)
    {
        StringBuilder x = new StringBuilder();
        for (String s:strings)
        {
            x.append(s);
        }
        return x.toString();
    }

    @Function
    public static String handshakeKey()
    {
        byte[] bytes = new byte[16];
        RANDOM.nextBytes(bytes);
        return BASE64_ENCODER.encodeToString(bytes);
    }

    @Function
    public static String handshakeHash(String wsKey) throws NoSuchAlgorithmException
    {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        sha1.update(wsKey.getBytes(US_ASCII));
        byte[] digest = sha1.digest(WEBSOCKET_GUID);
        return BASE64_ENCODER.encodeToString(digest);
    }

    @Function
    public static byte[] randomBytes(int length)
    {
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++)
        {
            bytes[i] = (byte) RANDOM.nextInt(0x100);
        }
        return bytes;
    }

    @Function
    public static byte[] randomBytesUTF8(int length)
    {
        byte[] bytes = new byte[length];
        randomBytesUTF8(bytes, 0, length);
        return bytes;
    }

    @Function
    public static byte[] randomBytesInvalidUTF8(int length)
    {
        // TODO: make invalid UTF-8 bytes less like valid UTF-8 (!)
        byte[] bytes = new byte[length];
        bytes[0] = (byte) 0x80;
        randomBytesUTF8(bytes, 1, length - 1);
        return bytes;
    }

    @Function
    public static byte[] randomBytesUnalignedUTF8(int length, int unalignAt)
    {
        assert unalignAt < length;

        byte[] bytes = new byte[length];
        int straddleWidth = RANDOM.nextInt(3) + 2;
        int straddleAt = unalignAt - straddleWidth + 1;
        randomBytesUTF8(bytes, 0, straddleAt);
        int realignAt = randomCharBytesUTF8(bytes, straddleAt, straddleWidth);
        randomBytesUTF8(bytes, realignAt, length);
        return bytes;
    }

    @Function
    public static byte[] copyOfRange(byte[] original, int from, int to)
    {
        return Arrays.copyOfRange(original, from, to);
    }

    /**
     * Takes a string and randomizes which letters in the text are upper or
     * lower case
     * @param text
     * @return
     */
    @Function
    public static String randomizeLetterCase(String text)
    {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (RANDOM.nextBoolean())
            {
                c = toUpperCase(c);
            }
            else
            {
                c = toLowerCase(c);
            }
            result.append(c);
        }
        return result.toString();
    }

    @Function
    public static String randomHeaderNot(String header)
    {
        // random strings from bytes can generate random bad chars like \n \r \f \v etc which are not allowed
        // except under special conditions, and will crash the http pipeline
        String commonHeaderChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "1234567890!@#$%^&*()_+-=`~[]\\{}|;':\",./<>?";
        StringBuilder result = new StringBuilder();
        do
        {
            int randomHeaderLength = RANDOM.nextInt(MAX_ACCEPTABLE_HEADER_LENGTH) + 1;
            for (int i = 0; i < randomHeaderLength; i++)
            {
                result.append(commonHeaderChars.charAt(RANDOM.nextInt(commonHeaderChars.length())));
            }
        } while (result.toString().equalsIgnoreCase(header));
        return result.toString();
    }

    @Function
    public static String randomCaseNot(String value)
    {
        String result;
        char[] resultChars = new char[value.length()];

        do
        {
            for (int i = 0; i < value.length(); i++)
            {
                char c = value.charAt(i);
                resultChars[i] = RANDOM.nextBoolean() ? toUpperCase(c) : toLowerCase(c);
            }
            result = new String(resultChars);
        } while(!result.equals(value));

        return result;
    }

    @Function
    public static String randomMethodNot(String method)
    {
        String[] methods = new String[]{"GET", "OPTIONS", "HEAD", "POST", "PUT", "DELETE", "TRACE", "CONNECT"};
        String result;
        do
        {
            result = methods[RANDOM.nextInt(methods.length)];
        } while (result.equalsIgnoreCase(method));
        return result;
    }

    private static void randomBytesUTF8(byte[] bytes, int start, int end)
    {
        for (int offset = start; offset < end;)
        {
            int remaining = end - offset;
            int width = Math.min(RANDOM.nextInt(4) + 1, remaining);

            offset = randomCharBytesUTF8(bytes, offset, width);
        }
    }

    private static int randomCharBytesUTF8(byte[] bytes, int offset, int width)
    {
        switch (width)
        {
        case 1:
            bytes[offset++] = (byte) RANDOM.nextInt(0x80);
            break;
        case 2:
            bytes[offset++] = (byte) (0xc0 | RANDOM.nextInt(0x20) | 1 << (RANDOM.nextInt(4) + 1));
            bytes[offset++] = (byte) (0x80 | RANDOM.nextInt(0x40));
            break;
        case 3:
            // UTF-8 not legal for 0xD800 through 0xDFFF (see RFC 3269)
            bytes[offset++] = (byte) (0xe0 | RANDOM.nextInt(0x08) | 1 << RANDOM.nextInt(3));
            bytes[offset++] = (byte) (0x80 | RANDOM.nextInt(0x40));
            bytes[offset++] = (byte) (0x80 | RANDOM.nextInt(0x40));
            break;
        case 4:
            // UTF-8 ends at 0x10FFFF (see RFC 3269)
            bytes[offset++] = (byte) (0xf0 | RANDOM.nextInt(0x04) | 1 << RANDOM.nextInt(2));
            bytes[offset++] = (byte) (0x80 | RANDOM.nextInt(0x10));
            bytes[offset++] = (byte) (0x80 | RANDOM.nextInt(0x40));
            bytes[offset++] = (byte) (0x80 | RANDOM.nextInt(0x40));
            break;
        }
        return offset;
    }

    public static class Mapper extends FunctionMapperSpi.Reflective
    {
        public Mapper()
        {
            super(WsFunctions.class);
        }

        @Override
        public String getPrefixName()
        {
            return "ws";
        }
    }

    private WsFunctions()
    {
        // utility
    }
}
