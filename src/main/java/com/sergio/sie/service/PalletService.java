package com.sergio.sie.service;

import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.Pallet;

public interface PalletService {
    List<Pallet> findAll();
    Optional<Pallet> findById(Integer id);
    Pallet save(Pallet entity);
    void deleteById(Integer id);
}
