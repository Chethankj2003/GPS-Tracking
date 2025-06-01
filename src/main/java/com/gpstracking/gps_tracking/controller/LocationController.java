//package com.gpstracking.gps_tracking.controller;
//
//public class LocationController {
//}
package com.gpstracking.gps_tracking.controller;

import com.gpstracking.gps_tracking.entity.Location;
import com.gpstracking.gps_tracking.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin("*")
public class LocationController {

    @Autowired
    private LocationService locationService;

    // Add a new location to a trip
    @PostMapping("/{tripId}/add")
    public Location addLocation(@PathVariable Long tripId,
                                @RequestParam Double latitude,
                                @RequestParam Double longitude) {
        return locationService.addLocation(tripId, latitude, longitude);
    }

    // Get all locations for a trip
    @GetMapping("/{tripId}")
    public List<Location> getLocationsByTripId(@PathVariable Long tripId) {
        return locationService.getLocationsByTripId(tripId);
    }
}
