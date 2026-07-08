package com.sergio.sie.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.Zone;
import com.sergio.sie.repository.ZoneRepository;
import com.sergio.sie.service.ZoneService;

@Service
public class ZoneServiceImpl implements ZoneService {
    private final ZoneRepository repository;

    public ZoneServiceImpl(ZoneRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Zone> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Zone> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Zone save(Zone entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
