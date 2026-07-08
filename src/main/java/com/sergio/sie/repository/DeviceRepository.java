package com.sergio.sie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sergio.sie.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
