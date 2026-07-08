package com.sergio.sie.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.Pallet;
import com.sergio.sie.repository.PalletRepository;
import com.sergio.sie.service.PalletService;

@Service
public class PalletServiceImpl implements PalletService {
    private final PalletRepository repository;

    public PalletServiceImpl(PalletRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pallet> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Pallet> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Pallet save(Pallet entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
