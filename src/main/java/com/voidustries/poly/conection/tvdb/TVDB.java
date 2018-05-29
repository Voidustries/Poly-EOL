package com.voidustries.poly.conection.tvdb;

import com.google.gson.JsonArray;
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
     * Time the JWT Token was created
     */
    private Long tokenCreationTime;

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
        tokenCreationTime = System.currentTimeMillis()/1000;
        setHeaderToken(getToken());
    }

    /**
     * Search TheTVDB for a show
     * @param Series Show to search for
     * @return a JsonArray of possible matches
     */
    public JsonArray searchSeries(String Series) {
        tokenAge();

        JsonObject response = new JsonObject();
        final JsonObject head = new JsonObject();

        head.addProperty("Content-Type", "application/json");
        head.addProperty("Accept", "application/json");
        head.addProperty("Authorization", headerToken);

        try {
            response = HttpRequestHandler.get(api_url, "/search/series", head, "name", Series);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonArray array = response.getAsJsonArray("data");
        return array;
    }

    public JsonObject seriesID(String id) {
        tokenAge();

        JsonObject response = new JsonObject();
        final JsonObject head = new JsonObject();

        head.addProperty("Content-Type", "application/json");
        head.addProperty("Accept", "application/json");
        head.addProperty("Authorization", headerToken);

        try {
            response = HttpRequestHandler.get(api_url, "/series/" + id, head, null, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    public JsonArray seriesIDEpisode(String id) {
        tokenAge();

        JsonObject response = new JsonObject();
        final JsonObject head = new JsonObject();

        head.addProperty("Content-Type", "application/json");
        head.addProperty("Accept", "application/json");
        head.addProperty("Authorization", headerToken);

        try {
            response = HttpRequestHandler.get(api_url, "/series/" + id + "/episodes", head, null, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonArray responseArray = response.getAsJsonArray("data");

        return responseArray;
    }


    /**
     * fail safe to make sure token is always valid
     */
    private long tokenAge() {
        return System.currentTimeMillis()/1000 - tokenCreationTime;
    }

    /**
     * Refresh the token used to make API calls
     */
    private void refreshHeaderToken() {

        final JsonObject head = new JsonObject();

        head.addProperty("Content-Type", "application/json");
        head.addProperty("Accept", "application/json");
        head.addProperty("Authorization", headerToken);

        try {
            token = HttpRequestHandler.get(api_url, "/refresh_token", "", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        setToken(token);
        setHeaderToken(getToken());
    }

    /**
     * Sets token that is used in header
     * @param token Token
     */
    private void setHeaderToken(String token) {
        headerToken = "Bearer " + getToken();
    }
}
