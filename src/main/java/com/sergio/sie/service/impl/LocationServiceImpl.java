package com.sergio.sie.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.Location;
import com.sergio.sie.repository.LocationRepository;
import com.sergio.sie.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository repository;

    public LocationServiceImpl(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Location> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Location> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Location save(Location entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
