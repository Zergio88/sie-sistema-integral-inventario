package com.sergio.sie.service;

import java.util.List;
import java.util.Optional;

import com.sergio.sie.dto.request.SerialNumberRequest;
import com.sergio.sie.dto.response.SerialNumberResponse;
import com.sergio.sie.entity.SerialNumber;

public interface SerialNumberService {
    List<SerialNumberResponse> findAll();
    Optional<SerialNumberResponse> findById(Integer id);
    SerialNumberResponse save(SerialNumberRequest request);
    void deleteById(Integer id);
}
