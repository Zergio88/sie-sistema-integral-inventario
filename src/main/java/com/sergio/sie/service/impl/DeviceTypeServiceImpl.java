package com.sergio.sie.service.impl;

import com.sergio.sie.dto.request.DeviceTypeRequest;
import com.sergio.sie.dto.response.DeviceTypeResponse;
import com.sergio.sie.mapper.DeviceTypeMapper;
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
    public List<DeviceTypeResponse> findAll() {
        return repository.findAll().stream()
                .map(DeviceTypeMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<DeviceTypeResponse> findById(Integer id) {
        return repository.findById(id)
                .map(DeviceTypeMapper::toResponse);
    }

    @Override
    public DeviceTypeResponse save(DeviceTypeRequest request) {
        return DeviceTypeMapper.toResponse(repository.save(DeviceTypeMapper.toEntity(request)));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
