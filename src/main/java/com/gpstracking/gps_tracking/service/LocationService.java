package com.gpstracking.gps_tracking.service;

import com.gpstracking.gps_tracking.entity.Location;
import com.gpstracking.gps_tracking.entity.Trip;
import com.gpstracking.gps_tracking.repository.LocationRepository;
import com.gpstracking.gps_tracking.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public Location addLocation(Long tripId, Double latitude, Double longitude) {
        Optional<Trip> optionalTrip = tripRepository.findById(tripId);
        if (optionalTrip.isPresent()) {
            Trip trip = optionalTrip.get();
            Location location = Location.builder()
                    .latitude(latitude)
                    .longitude(longitude)
                    .trip(trip)
                    .timestamp(LocalDateTime.now())
                    .build();

            Location savedLocation = locationRepository.save(location);

            try {
                messagingTemplate.convertAndSend("/topic/locations", savedLocation);
            } catch (Exception e) {
                System.err.println("Failed to send WebSocket update: " + e.getMessage());
            }

            return savedLocation;
        }
        else{
            //todo add else part
        }
        return null;
    }

    public List<Location> getLocationsByTripId(Long tripId) {
        return locationRepository.findByTripId(tripId);
    }
}