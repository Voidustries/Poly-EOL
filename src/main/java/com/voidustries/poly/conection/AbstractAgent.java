package com.voidustries.poly.conection;

import com.google.gson.JsonObject;
import com.voidustries.poly.Main;
import com.voidustries.poly.Settings;

import java.util.Locale;

/**
 * Base variables and methods for the Poly Agents
 */
public abstract class AbstractAgent {

    /**
     * Default Locale that will be used if necessary.
     */
    private static Locale locale = new Locale("en", "US");

    /**
     * The API Key
     */
    private String api = null;

    /**
     * The token as a string
     */
    private String token = null;

    /**
     * Get the api for the object
     * @return API key as a string
     */
    public String getApi() {
        return api;
    }

    /**
     * Set the API key for the object that will be used
     * @param api an API key
     */
    public void setApi(String api) {
        Main.LOGGER.config("Setting API: " + api);
        this.api = api;
    }

    /**
     * Get the token of the object
     * @return token as a string
     */
    public String getToken() {
        return token;
    }

    /**
     * Set the token in the object
     * @param token Google JsonObject containing the token
     */
    public void setToken(JsonObject token) {
        this.token = token.get("token").toString();
    }

    /**
     * Get the currently set locale of the object
     * @return A locale
     */
    public static Locale getLocale() {
        return locale;
    }

    /**
     * Set the locale of the object
     * @param language Language (e.x. "en")
     * @param country Country (e.x. "us")
     */
    public static void setLocale(String language, String country) {
        Main.LOGGER.config("Setting Locale Lang: " + language + " Country: " + country);
        locale = new Locale(language, country);
    }
}
