package com.voidustries.poly.conection;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HttpsRequestHandlerTest {

    @Test
    void getKeyValues() {

        HttpsRequestHandler test = new HttpsRequestHandler();

        final JsonObject in = new JsonObject();
        final String[] expectedOut = new String[]{"111", "333", "555"};

        in.addProperty("111", "222");
        in.addProperty("333", "444");
        in.addProperty("555", "666");

        String[] out = test.getKeyValues(in);
        assertArrayEquals(expectedOut, out);
    }

    @Test
    void post() {
        final HttpsRequestHandler test = new HttpsRequestHandler();
        final JsonObject body = new JsonObject();
        JsonObject out = new JsonObject();

        body.addProperty("111", "222");

        try {
            out = test.post("http://httpbin.org", "/post", body);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("{\"{\\\"111\\\":\\\"222\\\"}\":\"\"}", out.get("form").toString());
    }

    @Test
    void postWithHead() {
        final HttpsRequestHandler test = new HttpsRequestHandler();
        final JsonObject head = new JsonObject();
        final JsonObject body = new JsonObject();
        JsonObject out = new JsonObject();

        head.addProperty("Content-Type", "application/json");
        head.addProperty("Accept", "application/json");

        body.addProperty("111", "222");

        try {
            out = test.post("http://httpbin.org", "/post", body, head);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("\"222\"", out.getAsJsonObject("json").get("111").toString());
        assertEquals("\"application/json\"", out.getAsJsonObject("headers").get("Content-Type").toString());
        assertEquals("\"application/json\"", out.getAsJsonObject("headers").get("Accept").toString());

    }

    @Test
    void get() {
        HttpsRequestHandler test = new HttpsRequestHandler();
        JsonObject out = new JsonObject();

        try {
            out = test.get("http://httpbin.org", "/get", "111", "222");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("\"222\"", out.getAsJsonObject("args").get("111").toString());
    }

    @Test
    void getWithHead() {
        final HttpsRequestHandler test = new HttpsRequestHandler();
        final JsonObject head = new JsonObject();
        JsonObject out = new JsonObject();

        head.addProperty("Content-Type", "application/json");
        head.addProperty("Accept", "application/json");

        try {
            out = test.get("http://httpbin.org", "/get", head,"111", "222");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("\"222\"", out.getAsJsonObject("args").get("111").toString());
        assertEquals("\"application/json\"", out.getAsJsonObject("headers").get("Content-Type").toString());
        assertEquals("\"application/json\"", out.getAsJsonObject("headers").get("Accept").toString());
    }
}