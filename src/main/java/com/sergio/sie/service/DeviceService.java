package com.sergio.sie.service;

import java.util.List;
import java.util.Optional;

import com.sergio.sie.dto.request.DeviceRequest;
import com.sergio.sie.dto.response.DeviceResponse;
import com.sergio.sie.entity.Device;

public interface DeviceService {
    List<DeviceResponse> findAll();
    Optional<DeviceResponse> findById(Integer id);
    DeviceResponse save(DeviceRequest request);
    void deleteById(Integer id);
}
