package com.sergio.sie.controller;

import com.sergio.sie.dto.request.ZoneRequest;
import com.sergio.sie.dto.response.ZoneResponse;
import com.sergio.sie.service.ZoneService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/zones")
public class ZoneController {

    private final ZoneService zoneService;

    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @GetMapping
    public ResponseEntity<List<ZoneResponse>> findAll() {
        return ResponseEntity.ok(zoneService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZoneResponse> findById(@PathVariable Integer id) {
        return zoneService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ZoneResponse> save(@Valid @RequestBody ZoneRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(zoneService.save(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (zoneService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        zoneService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
