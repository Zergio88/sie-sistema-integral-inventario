package com.sergio.sie.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.DeviceType;
import com.sergio.sie.repository.DeviceTypeRepository;
import com.sergio.sie.service.DeviceTypeService;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    private final DeviceTypeRepository repository;

    public DeviceTypeServiceImpl(DeviceTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DeviceType> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<DeviceType> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public DeviceType save(DeviceType entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
