//package com.gpstracking.gps_tracking.repository;
//
//public class TripRepository {
//}
package com.gpstracking.gps_tracking.repository;

import com.gpstracking.gps_tracking.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByStatus(String status);
}
