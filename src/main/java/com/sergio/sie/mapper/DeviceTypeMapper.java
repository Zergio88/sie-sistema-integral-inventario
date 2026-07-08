package com.sergio.sie.mapper;

import com.sergio.sie.dto.request.DeviceTypeRequest;
import com.sergio.sie.dto.response.DeviceTypeResponse;
import com.sergio.sie.entity.DeviceType;

import java.time.LocalDateTime;

public class DeviceTypeMapper {

    public static DeviceType toEntity(DeviceTypeRequest request){
        DeviceType deviceType = new DeviceType();
        deviceType.setName(request.getName());
        deviceType.setBrand(request.getBrand());
        deviceType.setModel(request.getModel());
        deviceType.setCategory(request.getCategory());
        deviceType.setDescription(request.getDescription());
        deviceType.setCreatedAt(LocalDateTime.now());
        deviceType.setUpdatedAt(LocalDateTime.now());
        return deviceType;
    }

    public static DeviceTypeResponse toResponse(DeviceType deviceType){
        return new DeviceTypeResponse(
                deviceType.getId(),
                deviceType.getName(),
                deviceType.getBrand(),
                deviceType.getModel(),
                deviceType.getCategory(),
                deviceType.getDescription(),
                deviceType.getCreatedAt(),
                deviceType.getUpdatedAt()
        );
    }
}
