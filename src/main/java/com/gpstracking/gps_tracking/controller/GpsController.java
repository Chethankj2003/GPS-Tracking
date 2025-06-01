package com.gpstracking.gps_tracking.controller;

import com.gpstracking.gps_tracking.dtos.GPS;
import com.gpstracking.gps_tracking.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class GpsController {
    private static final Logger logger = LoggerFactory.getLogger(GpsController.class);

    @Autowired
    private LocationService locationService;

    @MessageMapping("/sendGPS") // Matches "/app/sendGPS"
    @SendTo("/topic/gps") // Broadcasts to all subscribers
    public GPS  processGps(GPS gpsData) {
        logger.info("📡 Received GPS Data: TripId={}, Lat={}, Lon={}", gpsData.getTripId(), gpsData.getLat(), gpsData.getLon());

        // Save location to database
        locationService.addLocation(gpsData.getTripId(), gpsData.getLat(), gpsData.getLon());

        return gpsData; // Broadcast data to frontend subscribers
    }
}
