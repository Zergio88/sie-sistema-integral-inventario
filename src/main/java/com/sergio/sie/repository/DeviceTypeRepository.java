package com.sergio.sie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sergio.sie.entity.DeviceType;

public interface DeviceTypeRepository extends JpaRepository<DeviceType, Integer> {
}
