package com.sergio.sie.dto.response;

import java.time.LocalDateTime;

public class PalletResponse {

    private Integer id;
    private Integer locationId;
    private String locationName;
    private String code;
    private Integer maxFloors;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PalletResponse() { }

    public PalletResponse(Integer id, Integer locationId, String locationName, String code, Integer maxFloors, String notes, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.locationId = locationId;
        this.locationName = locationName;
        this.code = code;
        this.maxFloors = maxFloors;
        this.notes = notes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getMaxFloors() {
        return maxFloors;
    }

    public void setMaxFloors(Integer maxFloors) {
        this.maxFloors = maxFloors;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
