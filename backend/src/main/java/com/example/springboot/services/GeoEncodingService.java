package com.example.springboot.services;

import com.example.springboot.exceptions.CityNotFoundException;
import com.example.springboot.exceptions.GoogleApiCallException;
import com.example.springboot.models.LatLong;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GeoEncodingService {
    private static final Logger logger = LoggerFactory.getLogger(GeoEncodingService.class);

    @Value("${api_key}")
    private String apiKey;

    public LatLong getLatLongByName(String cityName) throws GoogleApiCallException, CityNotFoundException {
        GeoApiContext context = GeoApiContextSingelton.getInstance().getContext();
        GeocodingResult[] results = new GeocodingResult[0];
        try {
            results = GeocodingApi.geocode(context, cityName).await();
        } catch (ApiException e) {
            logger.error(e.getLocalizedMessage() + e.toString());
            throw new GoogleApiCallException("Something went wrong trying with the API call. Exception: " + e );
        } catch (InterruptedException e) {
            logger.error(e.getLocalizedMessage() + e.toString());
            throw new GoogleApiCallException("Something went wrong trying with the API call. Exception: " + e );
        } catch (IOException e) {
            logger.error(e.getLocalizedMessage() + e.toString());
            throw new GoogleApiCallException("Something went wrong trying with the API call. Exception: " + e );
        }

        if (results.length <= 0){
            logger.error("City Not Found in geoEncoder!");
            throw new CityNotFoundException("City Not Found in geoEncoder!");
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        logger.info(String.valueOf(results[0].geometry.location.toString()));
        logger.info(gson.toJson(results[0].addressComponents));

        return new LatLong(results[0].geometry.location.lat, results[0].geometry.location.lng);
    }

    public String getLatLongByNameString(String cityName){
        //TODO: Wenn nicht gefunden dann Wien Error message zurüclgeben mit City/Location not Found
        //TODO: Prop File verwenden
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(ApiKeyUtil.getInstance().getApiKey())
                .build();
        GeocodingResult[] results = new GeocodingResult[0];
        try {
            results = GeocodingApi.geocode(context, cityName).await();
        } catch (ApiException e) {
            logger.error(e.getLocalizedMessage() + e.toString());
        } catch (InterruptedException e) {
            logger.error(e.getLocalizedMessage() + e.toString());
        } catch (IOException e) {
            logger.error(e.getLocalizedMessage() + e.toString());
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(String.valueOf(results[0].geometry.location.toString() + results[0].addressComponents.toString()));
    }
}
