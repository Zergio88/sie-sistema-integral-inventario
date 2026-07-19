package com.sergio.sie.service;

import java.util.List;
import java.util.Optional;
import com.sergio.sie.dto.request.LocationRequest;
import com.sergio.sie.dto.response.LocationResponse;

public interface LocationService {
    List<LocationResponse> findAll();
    Optional<LocationResponse> findById(Integer id);
    LocationResponse save(LocationRequest request);
    void deleteById(Integer id);
}
