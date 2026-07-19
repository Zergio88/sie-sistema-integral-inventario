package com.sergio.sie.mapper;

import com.sergio.sie.dto.request.DeviceRequest;
import com.sergio.sie.dto.response.DeviceResponse;
import com.sergio.sie.entity.Device;
import com.sergio.sie.entity.DeviceType;
import com.sergio.sie.entity.Pallet;
import com.sergio.sie.entity.User;

import java.time.LocalDateTime;

public class DeviceMapper {

    public static Device toEntity(DeviceRequest request, DeviceType deviceType, Pallet pallet, User createdBy, User updatedBy) {
        Device device = new Device();
        device.setDeviceType(deviceType);
        device.setPallet(pallet);
        device.setCreatedBy(createdBy);
        device.setUpdatedBy(updatedBy);
        device.setFloorNumber(request.getFloorNumber());
        device.setStatus(request.getStatus());
        device.setNotes(request.getNotes());
        device.setCreatedAt(LocalDateTime.now());
        device.setUpdatedAt(LocalDateTime.now());
        return device;
    }

    public static DeviceResponse toResponse(Device device) {
        DeviceType deviceType = device.getDeviceType();
        Pallet pallet = device.getPallet();
        User createdBy = device.getCreatedBy();
        User updatedBy = device.getUpdatedBy();
        return new DeviceResponse(
                device.getId(),
                deviceType != null ? deviceType.getId() : null,
                deviceType != null ? deviceType.getName() : null,
                pallet != null ? pallet.getId() : null,
                pallet != null ? pallet.getCode() : null,
                device.getFloorNumber(),
                device.getStatus(),
                device.getNotes(),
                createdBy != null ? createdBy.getId() : null,
                updatedBy != null ? updatedBy.getId() : null,
                device.getCreatedAt(),
                device.getUpdatedAt()
        );
    }
}
