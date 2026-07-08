package com.sergio.sie.service;

import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.Location;

public interface LocationService {
    List<Location> findAll();
    Optional<Location> findById(Integer id);
    Location save(Location entity);
    void deleteById(Integer id);
}
