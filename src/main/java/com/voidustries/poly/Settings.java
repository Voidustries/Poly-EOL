package com.voidustries.poly;

import java.util.Locale;
import java.util.ResourceBundle;

public class Settings {

    public static String getApplicationProperty(String key) {
        return ResourceBundle.getBundle(Settings.class.getName(), Locale.ROOT).getString(key);
    }

    public static String getApiKey(String name) {
        return getApplicationProperty("apikey." + name);
    }

}
