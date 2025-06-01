//package com.gpstracking.gps_tracking.service;
//
//public class TripService {
//}

package com.gpstracking.gps_tracking.service;

import com.gpstracking.gps_tracking.entity.Trip;
import com.gpstracking.gps_tracking.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    // Start a new trip
    public Trip start(String userId) {
        Trip trip = Trip.builder()
                .userId(userId)
                .status("ONGOING")
                .startTime(LocalDateTime.now()).build();
        return tripRepository.save(trip);
    }

    // Stop an ongoing trip
    public Trip stop(Long tripId) {
        Optional<Trip> optionalTrip = tripRepository.findById(tripId);
        if (optionalTrip.isPresent()) {
            Trip trip = optionalTrip.get();
            trip.setStatus("COMPLETED");
            trip.setEndTime(LocalDateTime.now());
            return tripRepository.save(trip);
        }
        return null;
    }

    // Get all trips
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    // Get all ongoing trips
    public List<Trip> getOngoingTrips() {
        return tripRepository.findByStatus("ONGOING");
    }
}
