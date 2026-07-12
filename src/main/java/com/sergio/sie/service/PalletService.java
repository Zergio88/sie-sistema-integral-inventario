package com.sergio.sie.service;

import java.util.List;
import java.util.Optional;

import com.sergio.sie.dto.request.PalletRequest;
import com.sergio.sie.dto.response.PalletResponse;

public interface PalletService {
    List<PalletResponse> findAll();
    Optional<PalletResponse> findById(Integer id);
    PalletResponse save(PalletRequest entity);
    void deleteById(Integer id);
}
