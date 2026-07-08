package com.sergio.sie.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.Device;
import com.sergio.sie.repository.DeviceRepository;
import com.sergio.sie.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository repository;

    public DeviceServiceImpl(DeviceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Device> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Device> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Device save(Device device) {
        return repository.save(device);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
