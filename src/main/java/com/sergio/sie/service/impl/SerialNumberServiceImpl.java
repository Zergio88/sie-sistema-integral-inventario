package com.sergio.sie.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.SerialNumber;
import com.sergio.sie.repository.SerialNumberRepository;
import com.sergio.sie.service.SerialNumberService;

@Service
public class SerialNumberServiceImpl implements SerialNumberService {
    private final SerialNumberRepository repository;

    public SerialNumberServiceImpl(SerialNumberRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SerialNumber> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<SerialNumber> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public SerialNumber save(SerialNumber entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
