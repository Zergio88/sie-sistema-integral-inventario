package com.sergio.sie.controller;


import com.sergio.sie.dto.request.SerialNumberRequest;
import com.sergio.sie.dto.response.SerialNumberResponse;
import com.sergio.sie.service.SerialNumberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/serial-numbers")
public class SerialNumberController {

    private final SerialNumberService serialNumberService;

    public SerialNumberController(SerialNumberService serialNumberService) {
        this.serialNumberService = serialNumberService;
    }

    @GetMapping
    public ResponseEntity<List<SerialNumberResponse>> findAll() {
        return ResponseEntity.ok(serialNumberService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SerialNumberResponse> findById(@PathVariable Integer id) {
        return serialNumberService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serial number not found"));
    }

    @PostMapping
    public ResponseEntity<SerialNumberResponse> save(@Valid @RequestBody SerialNumberRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serialNumberService.save(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        serialNumberService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serial number not found"));

        serialNumberService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
