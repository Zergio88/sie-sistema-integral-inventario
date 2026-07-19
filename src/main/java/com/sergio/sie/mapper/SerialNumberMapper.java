package com.sergio.sie.mapper;

import com.sergio.sie.dto.request.SerialNumberRequest;
import com.sergio.sie.dto.response.SerialNumberResponse;
import com.sergio.sie.entity.Device;
import com.sergio.sie.entity.SerialNumber;

public class SerialNumberMapper {

    public static SerialNumber toEntity(SerialNumberRequest serialNumberRequest, Device device) {
        SerialNumber serialNumber = new SerialNumber();
        serialNumber.setDevice(device);
        serialNumber.setValue(serialNumberRequest.getValue());
        serialNumber.setSource(serialNumberRequest.getSource());
        serialNumber.setPrimary(serialNumberRequest.isPrimary());
        return serialNumber;
    }

    public static SerialNumberResponse toResponse(SerialNumber serialNumber) {
        Device device = serialNumber.getDevice();
        return new SerialNumberResponse(
                serialNumber.getId(),
                device != null ? device.getId() : null,
                serialNumber.getValue(),
                serialNumber.getSource(),
                serialNumber.isPrimary()
        );
    }
}
