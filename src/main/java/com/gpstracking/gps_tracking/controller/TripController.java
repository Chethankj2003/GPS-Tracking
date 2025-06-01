package com.gpstracking.gps_tracking.controller;

import com.gpstracking.gps_tracking.entity.Trip;
import com.gpstracking.gps_tracking.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController { // Removed @CrossOrigin("*")

    @Autowired
    private TripService tripService;

    @PostMapping("/start")
    public Trip startTrip(@RequestParam String userId) {
        return tripService.start(userId);
    }

    @PostMapping("/stop/{tripId}")
    public Trip stopTrip(@PathVariable Long tripId) {
        return tripService.stop(tripId);
    }

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/ongoing")
    public List<Trip> getOngoingTrips() {
        return tripService.getOngoingTrips();
    }
}