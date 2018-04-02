package com.voidustries.poly.conection.tvdb;

import com.google.gson.JsonObject;
import com.voidustries.poly.conection.AbstractAgent;
import com.voidustries.poly.conection.HttpsRequestHandler;

public class TVDB extends AbstractAgent{

    private final String api_url = "https://api.thetvdb.com";


    public TVDB(String api) {
        setApi(api);
    }

    public TVDB(String api, String lang, String country) {
        setApi(api);
        setLocale(lang, country);
    }

    private void auth(){

        final JsonObject head = new JsonObject();
        final JsonObject body = new JsonObject();

        head.addProperty("Content-Type", "application/json");
        head.addProperty("Accept", "application/json");

        body.addProperty("apikey", getApi());

        setToken(HttpsRequestHandler.post(api_url, "/login", body, head));
    }
}
