package com.sergio.sie.service.impl;

import com.sergio.sie.dto.request.SerialNumberRequest;
import com.sergio.sie.dto.response.SerialNumberResponse;
import com.sergio.sie.entity.Device;
import com.sergio.sie.mapper.DeviceMapper;
import com.sergio.sie.mapper.SerialNumberMapper;
import com.sergio.sie.repository.DeviceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.SerialNumber;
import com.sergio.sie.repository.SerialNumberRepository;
import com.sergio.sie.service.SerialNumberService;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SerialNumberServiceImpl implements SerialNumberService {
    private final SerialNumberRepository repository;
    private final DeviceRepository deviceRepository;

    public SerialNumberServiceImpl(SerialNumberRepository repository, DeviceRepository deviceRepository) {
        this.repository = repository;
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<SerialNumberResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(SerialNumberMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<SerialNumberResponse> findById(Integer id) {
        return repository.findById(id)
                .map(SerialNumberMapper::toResponse);
    }

    @Override
    public SerialNumberResponse save(SerialNumberRequest request) {
        Device device = deviceRepository.findById(request.getDeviceId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Device not found"));

        if(Boolean.TRUE.equals(request.isPrimary())) {
            repository.findByDeviceAndPrimaryTrue(device).ifPresent(existing ->{
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Device already has a primary serial number");
            });
        }

        SerialNumber serialNumber = SerialNumberMapper.toEntity(request, device);
        return SerialNumberMapper.toResponse(repository.save(serialNumber));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
