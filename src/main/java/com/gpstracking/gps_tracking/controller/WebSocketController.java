//package com.gpstracking.gps_tracking.controller;
//
//public class WebSocketController {
//}

package com.gpstracking.gps_tracking.controller;

import com.gpstracking.gps_tracking.entity.Location;
import com.gpstracking.gps_tracking.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @Autowired
    private LocationService locationService;

    @MessageMapping("/location")
    @SendTo("/topic/locations")
    public Location sendLocationUpdate(Location location) {
        return location;
    }
}
