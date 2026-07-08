package com.sergio.sie.service;

import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.SerialNumber;

public interface SerialNumberService {
    List<SerialNumber> findAll();
    Optional<SerialNumber> findById(Integer id);
    SerialNumber save(SerialNumber entity);
    void deleteById(Integer id);
}
