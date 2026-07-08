package com.sergio.sie.service;

import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.SpareLot;

public interface SpareLotService {
    List<SpareLot> findAll();
    Optional<SpareLot> findById(Integer id);
    SpareLot save(SpareLot entity);
    void deleteById(Integer id);
}
