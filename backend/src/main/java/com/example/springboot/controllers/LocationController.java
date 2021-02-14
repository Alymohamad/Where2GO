package com.example.springboot.controllers;

import com.example.springboot.Enums.LocationType;
import com.example.springboot.exceptions.CityNotFoundException;
import com.example.springboot.exceptions.GoogleApiCallException;
import com.example.springboot.models.LatLong;
import com.example.springboot.models.Response;
import com.example.springboot.services.GeoEncodingService;
import com.example.springboot.services.PlacesService;
import com.example.springboot.services.RandomPickerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.Enums.ResponseStatus;


@Controller
public class LocationController {

    private GeoEncodingService geoEncodingService;
    private PlacesService placesService;
    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

    //TODO: Eingabe PArameter müssen überprüft werden und gefiltert und bei keinem Ergebniss eine Seite machen

    @Autowired
    public void setMyService(PlacesService placesService) {
        this.placesService = placesService;
    }

    @Autowired
    public void setMyService(GeoEncodingService geoEncodingService) {
        this.geoEncodingService = geoEncodingService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/find")
    @ResponseBody
    public Response findLocation(@RequestParam(name="city", required=false, defaultValue="Vienna") String city,
                                 @RequestParam(name="type", required=false) String type,
                                 @RequestParam(name="radius", required=false, defaultValue="30") int radius) {

        logger.info(" ---------------------- City: "+ city +" Type: "+ type +" Radius: "+ radius);
        LatLong cityLatLong;

        if (type == null){
            type = RandomPickerService.getRandomType().name();
        }
        try {
            cityLatLong = geoEncodingService.getLatLongByName(city);
        } catch (GoogleApiCallException exception) {
            return new Response(null, ResponseStatus.SOMETHING_WENT_WRONG);
        } catch (CityNotFoundException exception) {
            return new Response(null, ResponseStatus.CITY_NOT_FOUND);
        }

        Response response = placesService.getLocationByCityAndType(type, cityLatLong.getLat(), cityLatLong.getLon(), radius);
        logger.info(response.toString());
        return response;
    }

    @GetMapping("/geo")
    @ResponseBody
    public String findLocation(@RequestParam(name="city", required=false, defaultValue="The Moon") String city) {
        return geoEncodingService.getLatLongByNameString(city);
    }
}
