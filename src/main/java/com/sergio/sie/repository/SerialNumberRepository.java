package com.sergio.sie.repository;

import com.sergio.sie.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sergio.sie.entity.SerialNumber;

import java.util.List;
import java.util.Optional;

public interface SerialNumberRepository extends JpaRepository<SerialNumber, Integer> {

    List<SerialNumber> findByDevice(Device device);
    Optional<SerialNumber> findByDeviceAndPrimaryTrue(Device device);
    Optional<SerialNumber> findByValue(String value);
}
