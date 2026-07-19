package com.sergio.sie.service.impl;

import com.sergio.sie.dto.request.PalletRequest;
import com.sergio.sie.dto.response.PalletResponse;
import com.sergio.sie.entity.Location;
import com.sergio.sie.entity.Pallet;
import com.sergio.sie.mapper.PalletMapper;
import com.sergio.sie.repository.LocationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.sergio.sie.repository.PalletRepository;
import com.sergio.sie.service.PalletService;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PalletServiceImpl implements PalletService {

    private final PalletRepository repository;
    private final LocationRepository locationRepository;

    public PalletServiceImpl(PalletRepository repository, LocationRepository locationRepository) {
        this.repository = repository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<PalletResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(PalletMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<PalletResponse> findById(Integer id) {
        return repository.findById(id)
                .map(PalletMapper::toResponse);
    }

    @Override
    public PalletResponse save(PalletRequest request) {
        Location location = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Location not found"));

        Pallet pallet = PalletMapper.toEntity(request, location);
        return PalletMapper.toResponse(repository.save(pallet));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
