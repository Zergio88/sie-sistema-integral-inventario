package com.sergio.sie.service.impl;

import com.sergio.sie.dto.request.ZoneRequest;
import com.sergio.sie.dto.response.ZoneResponse;
import com.sergio.sie.mapper.ZoneMapper;
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
    public List<ZoneResponse> findAll() {
        return repository.findAll().stream()
                .map(ZoneMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<ZoneResponse> findById(Integer id) {
        return repository.findById(id)
                .map(ZoneMapper::toResponse);
    }

    @Override
    public ZoneResponse save(ZoneRequest request) {
        return ZoneMapper.toResponse(repository.save(ZoneMapper.toEntity(request)));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
