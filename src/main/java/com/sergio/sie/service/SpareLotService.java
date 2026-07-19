package com.sergio.sie.service;

import java.util.List;
import java.util.Optional;

import com.sergio.sie.dto.request.SpareLotRequest;
import com.sergio.sie.dto.response.SpareLotResponse;

public interface SpareLotService {
    List<SpareLotResponse> findAll();
    Optional<SpareLotResponse> findById(Integer id);
    SpareLotResponse save(SpareLotRequest request);
    void deleteById(Integer id);
}
