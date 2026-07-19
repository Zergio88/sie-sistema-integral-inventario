package com.sergio.sie.service.impl;

import com.sergio.sie.dto.request.LocationRequest;
import com.sergio.sie.dto.response.LocationResponse;
import com.sergio.sie.entity.Location;
import com.sergio.sie.entity.Zone;
import com.sergio.sie.mapper.LocationMapper;
import com.sergio.sie.repository.LocationRepository;
import com.sergio.sie.repository.ZoneRepository;
import com.sergio.sie.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository repository;
    private final ZoneRepository zoneRepository;

    public LocationServiceImpl(LocationRepository repository, ZoneRepository zoneRepository) {
        this.repository = repository;
        this.zoneRepository = zoneRepository;
    }

    @Override
    public List<LocationResponse> findAll() {
        return repository.findAll().stream()
                .map(LocationMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<LocationResponse> findById(Integer id) {
        return repository.findById(id)
                .map(LocationMapper::toResponse);
    }

    @Override
    public LocationResponse save(LocationRequest request) {
        Zone zone = zoneRepository.findById(request.getZoneId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zone not found"));

        Location location = LocationMapper.toEntity(request, zone);
        return LocationMapper.toResponse(repository.save(location));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
