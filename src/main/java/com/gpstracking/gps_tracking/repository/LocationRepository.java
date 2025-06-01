//package com.gpstracking.gps_tracking.repository;
//
//public class LocationRepository {
//}

package com.gpstracking.gps_tracking.repository;

import com.gpstracking.gps_tracking.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByTripId(Long tripId);
}
