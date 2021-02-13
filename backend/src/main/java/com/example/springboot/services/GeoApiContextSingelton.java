package com.example.springboot.services;

import com.google.maps.GeoApiContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class GeoApiContextSingelton {

    private static GeoApiContextSingelton contextInstance = null;
    private GeoApiContext context;
    private static final Logger logger = LoggerFactory.getLogger(GeoApiContextSingelton.class);
    private String apiKey;

    private GeoApiContextSingelton() {
        //TODO: Prop File verwenden

        context = new GeoApiContext.Builder()
                .apiKey(ApiKeyUtil.getInstance().getApiKey())
                .build();
    }

    public static GeoApiContextSingelton getInstance() {
        if (contextInstance == null) {
            contextInstance = new GeoApiContextSingelton();
            logger.info("Created new Instance of GeoApiContextSingelton");
        }
        return contextInstance;
    }

    public GeoApiContext getContext() {
        return context;
    }
}
