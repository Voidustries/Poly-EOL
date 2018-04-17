package com.voidustries.poly.conection.tvdb;

import com.google.gson.JsonObject;
import com.voidustries.poly.conection.AbstractAgent;
import com.voidustries.poly.conection.HttpRequestHandler;

import java.io.IOException;

/**
 * The Poly implementation of TheTVDB API
 */
public class TVDB extends AbstractAgent{

    /**
     * API URL for TheTVDB
     */
    private final String api_url = "https://api.thetvdb.com";

    /**
     * Token used for all requests after initial authentication
     */
    private JsonObject token;

    /**
     * Token to be added to the header of requests under the "Authorization" key
     */
    private String headerToken;

    /**
     * Constructor for TheTVDB
     * @param api your API key for TheTVDB
     */
    public TVDB(String api) {
        setApi(api);
        auth();
    }

    /**
     * Constructor for TheTVDB
     * @param api your API key for TheTVDB
     * @param lang Preferred language
     * @param country Preferred Country
     */
    public TVDB(String api, String lang, String country) {
        setApi(api);
        setLocale(lang, country);
        auth();
    }

    /**
     * Authenticates the object with TheTVDB
     */
    private void auth(){

        final JsonObject head = new JsonObject();
        final JsonObject body = new JsonObject();

        head.addProperty("Content-Type", "application/json");
        head.addProperty("Accept", "application/json");

        body.addProperty("apikey", getApi());

        try {
            token = HttpRequestHandler.post(api_url, "/login", body, head);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setToken(token);
        headerToken = "Bearer " + getToken();
    }
}
