package com.sergio.sie.mapper;

import com.sergio.sie.dto.request.SpareLotRequest;
import com.sergio.sie.dto.response.SpareLotResponse;
import com.sergio.sie.entity.DeviceType;
import com.sergio.sie.entity.Location;
import com.sergio.sie.entity.SpareLot;
import com.sergio.sie.entity.User;

import java.time.LocalDateTime;

public class SpareLotMapper {

    public static SpareLot toEntity(SpareLotRequest request, DeviceType deviceType, Location location, User createdBy, User updatedBy) {
        SpareLot spareLot = new SpareLot();
        spareLot.setDeviceType(deviceType);
        spareLot.setLocation(location);
        spareLot.setCreatedBy(createdBy);
        spareLot.setUpdatedBy(updatedBy);
        spareLot.setQuantity(request.getQuantity());
        spareLot.setUnit(request.getUnit());
        spareLot.setStatus(request.getStatus());
        spareLot.setNotes(request.getNotes());
        spareLot.setCreatedAt(LocalDateTime.now());
        spareLot.setUpdatedAt(LocalDateTime.now());
        return spareLot;
    }

    public static SpareLotResponse toResponse(SpareLot spareLot) {
        DeviceType deviceType = spareLot.getDeviceType();
        Location location = spareLot.getLocation();
        User createdBy = spareLot.getCreatedBy();
        User updatedBy = spareLot.getUpdatedBy();
        return new SpareLotResponse(
                spareLot.getId(),
                deviceType != null ? deviceType.getId() : null,
                deviceType != null ? deviceType.getName() : null,
                location != null ? location.getId() : null,
                location != null ? location.getName() : null,
                spareLot.getQuantity(),
                spareLot.getUnit(),
                spareLot.getStatus(),
                spareLot.getNotes(),
                createdBy != null ? createdBy.getId() : null,
                updatedBy != null ? updatedBy.getId() : null,
                spareLot.getCreatedAt(),
                spareLot.getUpdatedAt()
        );
    }
}
