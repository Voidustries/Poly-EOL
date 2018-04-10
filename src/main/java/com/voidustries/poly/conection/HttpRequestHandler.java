package com.voidustries.poly.conection;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class HttpRequestHandler {

    public static JsonObject post(String apiurl, String endpoint, JsonObject body) throws IOException {

        Gson g = new Gson();

        JsonParser parser = new JsonParser();

        String url = apiurl + endpoint;

        URL obj = new URL(null, url, new sun.net.www.protocol.https.Handler());
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        con.setRequestMethod("POST");

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());

        wr.writeBytes(g.toJson(body));
        wr.flush();
        wr.close();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JsonObject responseBody = (JsonObject) parser.parse(response.toString());
        return responseBody;
    }
    public static JsonObject post(String apiurl, String endpoint, JsonObject body, JsonObject headers) throws IOException {

        Gson g = new Gson();
        JsonParser parser = new JsonParser();


        String[] keys;
        String url = apiurl + endpoint;
        keys = getKeyValues(headers);

        URL obj = new URL(null, url, new sun.net.www.protocol.https.Handler());
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
        for (int i = 0; i < keys.length; i++) {
            con.setRequestProperty(keys[i], headers.get(keys[i]).getAsString());
        }


        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());

        wr.writeBytes(g.toJson(body));
        wr.flush();
        wr.close();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JsonObject responseBody = (JsonObject) parser.parse(response.toString());
        return responseBody;
    }
    public static JsonObject get(String apiurl, String endpoint, String pName, String pValue) throws IOException {

        JsonParser parser = new JsonParser();

        String url = apiurl + endpoint + "?" + pName + "=" + pValue;

        URL obj = new URL(null, url, new sun.net.www.protocol.https.Handler());
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        con.setDoOutput(true);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JsonObject responseBody = (JsonObject) parser.parse(response.toString());
        return responseBody;
    }
    public static JsonObject get(String apiurl, String endpoint, JsonObject headers, String pName, String pValue) throws IOException {

        JsonParser parser = new JsonParser();

        String[] keys;
        String url = apiurl + endpoint + "?" + pName + "=" + pValue;
        keys = getKeyValues(headers);

        URL obj = new URL(null, url, new sun.net.www.protocol.https.Handler());
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        for (int i = 0; i < keys.length; i++) {
            con.setRequestProperty(keys[i], headers.get(keys[i]).getAsString());
        }

        con.setDoOutput(true);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JsonObject responseBody = (JsonObject) parser.parse(response.toString());
        return responseBody;
    }


    // Take a JsonObject and return a list of key values

    public static String[] getKeyValues(JsonObject jsonObject) {

        ArrayList<String> keys = new ArrayList<>();

        // Go through every key in the JsonObject and add it to an array

        Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();
        for (Map.Entry<String, JsonElement> entry: entries) {
            keys.add(entry.getKey());
        }

        String[] array = new String[keys.size()];

        // Convert ArrayList to String[]
        return keys.toArray(array);
    }
}
