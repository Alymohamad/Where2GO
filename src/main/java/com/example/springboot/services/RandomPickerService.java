package com.example.springboot.services;

import com.example.springboot.Enums.LocationType;
import com.example.springboot.models.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class RandomPickerService {

    private static final Logger logger = LoggerFactory.getLogger(RandomPickerService.class);
    private static final List<LocationType> types =
            Collections.unmodifiableList(Arrays.asList(LocationType.values()));
    private static final int size = types.size();
    private static final Random random = new Random();

    public static LocationType getRandomType()  {
        return types.get(random.nextInt(size));
    }

    public static Location getRandomLocation(ArrayList<Location> resultList) {
        logger.info("getting radnom location from resultList" + resultList.toString());
        int randomIndex = new Random().nextInt(resultList.size());
        logger.info("choosen the location: " + resultList.get(randomIndex) + " with index: " + randomIndex);
        return resultList.get(randomIndex);
    }

}