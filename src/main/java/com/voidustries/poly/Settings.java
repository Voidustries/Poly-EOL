package com.voidustries.poly;
/*
Class Created by Stone Monarch on 3/27/2018

Creator Comments:

        
*/

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
