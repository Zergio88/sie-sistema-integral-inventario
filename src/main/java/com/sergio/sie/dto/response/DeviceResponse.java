package com.sergio.sie.dto.response;

import java.time.LocalDateTime;

public class DeviceResponse {

    private Integer id;
    private Integer deviceTypeId;
    private String deviceTypeName;
    private Integer palletId;
    private String palletCode;
    private Integer floorNumber;
    private String status;
    private String notes;
    private Integer createdBy;
    private Integer updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public DeviceResponse() { }

    public DeviceResponse(Integer id, Integer deviceTypeId, String deviceTypeName, Integer palletId, String palletCode, Integer floorNumber, String status, String notes, Integer createdBy, Integer updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.deviceTypeId = deviceTypeId;
        this.deviceTypeName = deviceTypeName;
        this.palletId = palletId;
        this.palletCode = palletCode;
        this.floorNumber = floorNumber;
        this.status = status;
        this.notes = notes;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public Integer getPalletId() {
        return palletId;
    }

    public void setPalletId(Integer palletId) {
        this.palletId = palletId;
    }

    public String getPalletCode() {
        return palletCode;
    }

    public void setPalletCode(String palletCode) {
        this.palletCode = palletCode;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
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

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
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
