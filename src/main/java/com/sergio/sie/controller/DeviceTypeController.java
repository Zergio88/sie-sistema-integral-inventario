package com.sergio.sie.controller;


import com.sergio.sie.dto.request.DeviceTypeRequest;
import com.sergio.sie.dto.response.DeviceTypeResponse;
import com.sergio.sie.service.DeviceTypeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/device-types")
public class DeviceTypeController {

    private final DeviceTypeService deviceTypeService;

    public DeviceTypeController(DeviceTypeService deviceTypeService) {
        this.deviceTypeService = deviceTypeService;
    }

    @GetMapping
    public ResponseEntity<List<DeviceTypeResponse>> findAll() {
        return ResponseEntity.ok(deviceTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceTypeResponse> findById(@PathVariable Integer id) {
        return deviceTypeService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Device type not found"));
    }

    @PostMapping
    public ResponseEntity<DeviceTypeResponse> save(@Valid @RequestBody DeviceTypeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(deviceTypeService.save(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        deviceTypeService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Device type not found"));

        deviceTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
