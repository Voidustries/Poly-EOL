package com.voidustries.poly.conection;

import com.google.gson.JsonObject;
import com.voidustries.poly.Main;

import java.util.Locale;

public abstract class AbstractAgent {

    private static Locale locale = new Locale("en", "US");

    private String api = null;
    private String token = null;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        Main.LOGGER.config("Setting API: " + api);
        this.api = api;
    }

    public String getToken() {
        return token;
    }

    public void setToken(JsonObject token) {
        this.token = token.get("token").toString();
    }

    public static Locale getLocale() {
        return locale;
    }

    public static void setLocale(String language, String country) {
        Main.LOGGER.config("Setting Locale Lang: " + language + " Country: " + country);
        locale = new Locale(language, country);
    }
}
