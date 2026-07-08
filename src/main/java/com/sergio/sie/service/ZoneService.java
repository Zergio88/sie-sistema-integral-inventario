package com.sergio.sie.service;

import java.util.List;
import java.util.Optional;

import com.sergio.sie.dto.request.ZoneRequest;
import com.sergio.sie.dto.response.ZoneResponse;
import com.sergio.sie.entity.Zone;

public interface ZoneService {
    List<ZoneResponse> findAll();
    Optional<ZoneResponse> findById(Integer id);
    ZoneResponse save(ZoneRequest entity);
    void deleteById(Integer id);
}
