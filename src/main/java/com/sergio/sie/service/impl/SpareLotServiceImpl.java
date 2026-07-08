package com.sergio.sie.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.SpareLot;
import com.sergio.sie.repository.SpareLotRepository;
import com.sergio.sie.service.SpareLotService;

@Service
public class SpareLotServiceImpl implements SpareLotService {
    private final SpareLotRepository repository;

    public SpareLotServiceImpl(SpareLotRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SpareLot> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<SpareLot> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public SpareLot save(SpareLot entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
