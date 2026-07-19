package com.sergio.sie.service.impl;

import com.sergio.sie.dto.request.SpareLotRequest;
import com.sergio.sie.dto.response.SpareLotResponse;
import com.sergio.sie.entity.DeviceType;
import com.sergio.sie.entity.Location;
import com.sergio.sie.mapper.SpareLotMapper;
import com.sergio.sie.repository.DeviceTypeRepository;
import com.sergio.sie.repository.LocationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.SpareLot;
import com.sergio.sie.repository.SpareLotRepository;
import com.sergio.sie.service.SpareLotService;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SpareLotServiceImpl implements SpareLotService {

    private final SpareLotRepository repository;
    private final DeviceTypeRepository deviceTypeRepository;
    private final LocationRepository locationRepository;

    public SpareLotServiceImpl(SpareLotRepository repository, DeviceTypeRepository deviceTypeRepository, LocationRepository locationRepository) {
        this.repository = repository;
        this.deviceTypeRepository = deviceTypeRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<SpareLotResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(SpareLotMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<SpareLotResponse> findById(Integer id) {
        return repository.findById(id)
                .map(SpareLotMapper::toResponse);
    }

    @Override
    public SpareLotResponse save(SpareLotRequest request) {
        DeviceType deviceType = deviceTypeRepository.findById(request.getDeviceTypeId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Device type not found"));

        Location location = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Location not found"));

        SpareLot spareLot = SpareLotMapper.toEntity(request, deviceType, location, null, null);
        return SpareLotMapper.toResponse(repository.save(spareLot));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
