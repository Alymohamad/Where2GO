package com.example.springboot.services;


import com.example.springboot.models.Location;
import com.example.springboot.models.Place;
import com.example.springboot.models.Response;
import com.example.springboot.Enums.ResponseStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

@Component
public class PlacesService {
    private static final Logger logger = LoggerFactory.getLogger(PlacesService.class);
    private static final String LOG_TAG = "Where2GO";
    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    private static final String TYPE_AUTOCOMPLETE = "/autocomplete";
    private static final String TYPE_DETAILS = "/details";
    private static final String TYPE_SEARCH = "/search";

    private static final String OUT_JSON = "/json";

    private static String API_KEY;

    @Value("${api_key}")
    public void setNameStatic(String key){
        PlacesService.API_KEY = key;
    }

    private static final String DEFAULT_RADIUS = "30000";

    public Response getLocationByCityAndType(String keyword, double lat, double lng, int radius){
        logger.info("getting Location by type: " + keyword + " and coordinates lat: " + lat + " long: " + lng);
        ArrayList<Location> resultList;
        Location randomLocation = null;
        resultList = search(keyword, lat, lng, radius);
        if (resultList == null){
            return new Response(randomLocation, ResponseStatus.SOMETHING_WENT_WRONG);
        } else if (resultList.size() == 0) {
            return new Response(randomLocation, ResponseStatus.NO_LOCATIONS_FOUND);
        }
        randomLocation = RandomPickerService.getRandomLocation(resultList);
        return new Response(randomLocation, ResponseStatus.SUCCESSFULL);
    }

    public static ArrayList<Location> search(String keyword, double lat, double lng, int radius) {
        ArrayList<Location> resultList = null;

        HttpURLConnection conn = null;
        StringBuilder jsonResults = new StringBuilder();
        try {
            StringBuilder sb = new StringBuilder(PLACES_API_BASE);
            sb.append(TYPE_SEARCH);
            sb.append(OUT_JSON);
            sb.append("?sensor=false");
            sb.append("&key=" + ApiKeyUtil.getInstance().getApiKey());
            sb.append("&keyword=" + URLEncoder.encode(keyword, "utf8"));
            sb.append("&location=" + String.valueOf(lat) + "," + String.valueOf(lng));
            if (radius > 0 && radius <= 50){
                sb.append("&radius=" + radius*1000);

            } else {
                sb.append("&radius=" + DEFAULT_RADIUS);

            }

            URL url = new URL(sb.toString());
            conn = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(conn.getInputStream());

            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                jsonResults.append(buff, 0, read);
            }
        } catch (MalformedURLException e) {
            logger.error(LOG_TAG, "Error processing Places API URL", e);
            return resultList;
        } catch (IOException e) {
            logger.error(LOG_TAG, "Error connecting to Places API", e);
            return resultList;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        try {
            // Create a JSON object hierarchy from the results
            JSONObject jsonObj = new JSONObject(jsonResults.toString());
            JSONArray predsJsonArray = jsonObj.getJSONArray("results");

            resultList = new ArrayList<Location>(predsJsonArray.length());
            for (int i = 0; i < predsJsonArray.length(); i++) {
                Location location = fillLocation(predsJsonArray,i);
                resultList.add(location);
            }
        } catch (JSONException e) {
            logger.error(LOG_TAG, "Error processing JSON results", e);
        }

        return resultList;
    }

    private static Location fillLocation(JSONArray predsJsonArray, int i){
        Location location = new Location();
        try {
            location.setName(predsJsonArray.getJSONObject(i).getString("name"));
            location.setAddress(predsJsonArray.getJSONObject(i).getString("vicinity"));
            location.setType(predsJsonArray.getJSONObject(i).getJSONArray("types").getString(0));
            location.setRating((float) predsJsonArray.getJSONObject(i).getDouble("rating"));
            location.setRatingsNum(predsJsonArray.getJSONObject(i).getInt("user_ratings_total"));
            location.setLatitude(predsJsonArray.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lat"));
            location.setLongitude(predsJsonArray.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lng"));
            if (predsJsonArray.getJSONObject(i).has("opening_hours")
            && predsJsonArray.getJSONObject(i).getJSONObject("opening_hours").has("open_now")){
                location.setOpenNow(predsJsonArray.getJSONObject(i).getJSONObject("opening_hours").getBoolean("open_now"));
            }
        } catch (JSONException e) {
            logger.error(LOG_TAG, "Error processing JSON results", e);
            return new Location();
        }
        return location;
    }

}
