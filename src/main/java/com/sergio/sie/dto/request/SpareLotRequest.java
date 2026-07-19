package com.sergio.sie.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SpareLotRequest {

    @NotNull(message = "Device type ID is required")
    private Integer deviceTypeId;

    @NotNull(message = "Location ID is required")
    private Integer locationId;

    @NotNull(message = "Quantity is required")
    private Integer quantity;

    @NotBlank(message = "Unit is required")
    private String unit;

    @NotBlank(message = "Status is required")
    private String status;

    private String notes;

    public SpareLotRequest() { }


    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }
    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public Integer getLocationId() {
        return locationId;
    }
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;

    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
