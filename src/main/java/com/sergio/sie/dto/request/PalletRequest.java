package com.sergio.sie.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PalletRequest {

    @NotNull(message = "Location ID is required")
    private Integer locationId;

    @NotBlank(message = "Code is required")
    @Size(max = 50, message = "Code must not exceed 50 characters")
    private String code;

    @NotNull(message = "Max floors is required")
    private Integer maxFloors;

    private String notes;

    public PalletRequest() { }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
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

}