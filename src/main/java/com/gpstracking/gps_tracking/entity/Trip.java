package com.gpstracking.gps_tracking.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trips")
@Builder
@Data
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    @JsonManagedReference // Serializes Locations, but not back to Trip
    private List<Location> locations = new ArrayList<>(); // Initialized to avoid null

//    // Constructors
//    public Trip() {}
//    public Trip(String userId, String status, LocalDateTime startTime) {
//        this.userId = userId;
//        this.status = status;
//        this.startTime = startTime;
//    }
//
//    // Getters and Setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//    public String getUserId() { return userId; }
//    public void setUserId(String userId) { this.userId = userId; }
//    public String getStatus() { return status; }
//    public void setStatus(String status) { this.status = status; }
//    public LocalDateTime getStartTime() { return startTime; }
//    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
//    public LocalDateTime getEndTime() { return endTime; }
//    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
//    public List<Location> getLocations() { return locations; }
//    public void setLocations(List<Location> locations) { this.locations = locations; }
}