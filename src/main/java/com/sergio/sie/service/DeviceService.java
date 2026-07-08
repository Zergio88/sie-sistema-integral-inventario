package com.sergio.sie.service;

import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.Device;

public interface DeviceService {
    List<Device> findAll();
    Optional<Device> findById(Integer id);
    Device save(Device device);
    void deleteById(Integer id);
}
