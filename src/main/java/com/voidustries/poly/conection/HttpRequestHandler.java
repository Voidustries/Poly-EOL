package com.voidustries.poly.conection;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * A simple Http request handler for Poly to GET and POST
 */
public class HttpRequestHandler {

    /**
     * Post to an API endpoint
     * @param apiurl URL of the API (e.x. https://api.thetvdb.com)
     * @param endpoint The end point URL for the POST request (e.x. /login)
     * @param body Data to be sent to the endpoint in a Google JsonObject object
     * @return The response body of the request in a Google JsonObject object
     * @throws IOException if an I/O exception occurs.
     */
    public static JsonObject post(String apiurl, String endpoint, JsonObject body) throws IOException {

        Gson g = new Gson();

        JsonParser parser = new JsonParser();

        String url = apiurl + endpoint;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

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

    /**
     * Post to an API endpoint
     * @param apiurl URL of the API (e.x. https://api.thetvdb.com)
     * @param endpoint The end point URL for the POST request (e.x. /login)
     * @param body Data to be sent to the endpoint in a Google JsonObject object
     * @param headers Data to be applied to the header of the POST
     * @return The response body of the request in a Google JsonObject object
     * @throws IOException if an I/O exception occurs.
     */
    public static JsonObject post(String apiurl, String endpoint, JsonObject body, JsonObject headers) throws IOException {

        Gson g = new Gson();
        JsonParser parser = new JsonParser();


        String[] keys;
        String url = apiurl + endpoint;
        keys = getKeyValues(headers);

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

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

    /**
     * GET to an API endpoint
     * @param apiurl URL of the API (e.x. https://api.thetvdb.com)
     * @param endpoint The end point URL for the POST request (e.x. /login)
     * @param pName Name of the parameter to be sent
     * @param pValue Parameter value
     * @return The response body of the request in a Google JsonObject format
     * @throws IOException if an I/O exception occurs.
     */
    public static JsonObject get(String apiurl, String endpoint, String pName, String pValue) throws IOException {

        JsonParser parser = new JsonParser();

        String url = apiurl + endpoint + "?" + pName + "=" + pValue;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

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

    /**
     * GET to an API endpiont
     * @param apiurl URL of the API (e.x. https://api.thetvdb.com)
     * @param endpoint The end point URL for the POST request (e.x. /login)
     * @param headers Data to be applied to the header of the GET
     * @param pName Name of the parameter to be sent
     * @param pValue Parameter value
     * @return The response body of the request in a Google JsonObject format
     * @throws IOException if an I/O exception occurs.
     */
    public static JsonObject get(String apiurl, String endpoint, JsonObject headers, String pName, String pValue) throws IOException {

        JsonParser parser = new JsonParser();

        String[] keys;
        String url = apiurl + endpoint + "?" + pName + "=" + pValue;
        keys = getKeyValues(headers);

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

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

    /**
     * Return all the top level keys in a Google JsonObject object
     * @param jsonObject The JsonObject you want the keys for
     * @return String array with all the top level keys
     */
    public static String[] getKeyValues(JsonObject jsonObject) {

        ArrayList<String> keys = new ArrayList<>();

        // Go through every key in the JsonObject and add it to an array

        Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();
        for (Map.Entry<String, JsonElement> entry : entries) {
            keys.add(entry.getKey());
        }

        // Convert ArrayList to String[]
        return keys.toArray(new String[0]);
    }
}
