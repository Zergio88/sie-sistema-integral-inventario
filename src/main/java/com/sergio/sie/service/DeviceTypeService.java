package com.sergio.sie.service;

import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.DeviceType;

public interface DeviceTypeService {
    List<DeviceType> findAll();
    Optional<DeviceType> findById(Integer id);
    DeviceType save(DeviceType entity);
    void deleteById(Integer id);
}
