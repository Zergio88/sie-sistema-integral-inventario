package com.sergio.sie.service;

import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.Zone;

public interface ZoneService {
    List<Zone> findAll();
    Optional<Zone> findById(Integer id);
    Zone save(Zone entity);
    void deleteById(Integer id);
}
