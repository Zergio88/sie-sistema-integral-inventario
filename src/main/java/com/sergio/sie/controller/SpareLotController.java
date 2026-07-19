package com.sergio.sie.controller;

import com.sergio.sie.dto.request.SpareLotRequest;
import com.sergio.sie.dto.response.SpareLotResponse;
import com.sergio.sie.service.SpareLotService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/spare-lots")
public class SpareLotController {

    private final SpareLotService spareLotService;

    public SpareLotController(SpareLotService spareLotService) {
        this.spareLotService = spareLotService;
    }

    @GetMapping
    public ResponseEntity<List<SpareLotResponse>> findAll() {
        return ResponseEntity.ok(spareLotService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpareLotResponse> findById(@PathVariable Integer id) {
        return spareLotService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Spare lot not found"));
    }

    @PostMapping
    public ResponseEntity<SpareLotResponse> save(@Valid @RequestBody SpareLotRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(spareLotService.save(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        spareLotService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Spare lot not found"));

        spareLotService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
