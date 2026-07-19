package com.sergio.sie.service;

import java.util.List;
import java.util.Optional;

import com.sergio.sie.dto.request.DeviceTypeRequest;
import com.sergio.sie.dto.response.DeviceTypeResponse;
import com.sergio.sie.entity.DeviceType;

public interface DeviceTypeService {
    List<DeviceTypeResponse> findAll();
    Optional<DeviceTypeResponse> findById(Integer id);
    DeviceTypeResponse save(DeviceTypeRequest request);
    void deleteById(Integer id);
}
