package com.sergio.sie.service.impl;

import com.sergio.sie.dto.request.DeviceRequest;
import com.sergio.sie.dto.response.DeviceResponse;
import com.sergio.sie.entity.DeviceType;
import com.sergio.sie.entity.Pallet;
import com.sergio.sie.mapper.DeviceMapper;
import com.sergio.sie.repository.DeviceTypeRepository;
import com.sergio.sie.repository.PalletRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.sergio.sie.entity.Device;
import com.sergio.sie.repository.DeviceRepository;
import com.sergio.sie.service.DeviceService;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository repository;
    private final DeviceTypeRepository deviceTypeRepository;
    private final PalletRepository palletRepository;

    public DeviceServiceImpl(DeviceRepository repository, DeviceTypeRepository deviceTypeRepository, PalletRepository palletRepository) {
        this.repository = repository;
        this.deviceTypeRepository = deviceTypeRepository;
        this.palletRepository = palletRepository;
    }

    @Override
    public List<DeviceResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(DeviceMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<DeviceResponse> findById(Integer id) {
        return repository.findById(id)
                .map(DeviceMapper::toResponse);
    }

    @Override
    public DeviceResponse save(DeviceRequest request) {
        DeviceType deviceType = deviceTypeRepository.findById(request.getDeviceTypeId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Device type not found"));

        Pallet pallet = palletRepository.findById(request.getPalletId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pallet not found"));
        Device device = DeviceMapper.toEntity(request, deviceType, pallet, null, null);
        return DeviceMapper.toResponse(repository.save(device));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
