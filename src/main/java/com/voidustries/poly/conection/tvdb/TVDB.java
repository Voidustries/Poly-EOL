package com.voidustries.poly.conection.tvdb;

import com.google.gson.JsonObject;
import com.voidustries.poly.conection.AbstractAgent;
import com.voidustries.poly.conection.HttpsRequestHandler;

import java.io.IOException;

public class TVDB extends AbstractAgent{

    private final String api_url = "https://api.thetvdb.com";
    private JsonObject token;


    public TVDB(String api) {
        setApi(api);
        auth();
    }

    public TVDB(String api, String lang, String country) {
        setApi(api);
        setLocale(lang, country);
        auth();
    }

    private void auth(){

        final JsonObject head = new JsonObject();
        final JsonObject body = new JsonObject();

        head.addProperty("Content-Type", "application/json");
        head.addProperty("Accept", "application/json");

        body.addProperty("apikey", getApi());

        try {
            token = HttpsRequestHandler.post(api_url, "/login", body, head);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setToken(token);
    }
}
