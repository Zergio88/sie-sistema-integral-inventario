package com.sergio.sie.controller;

import com.sergio.sie.dto.request.PalletRequest;
import com.sergio.sie.dto.response.PalletResponse;
import com.sergio.sie.service.PalletService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pallets")
public class PalletController {

    private final PalletService palletService;

    public PalletController(PalletService palletService) {
        this.palletService = palletService;
    }

    @GetMapping
    public ResponseEntity<List<PalletResponse>> findAll() {
        return ResponseEntity.ok(palletService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PalletResponse> findById(@PathVariable Integer id) {
        return palletService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PalletResponse> save(@Valid @RequestBody PalletRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(palletService.save(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (palletService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        palletService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
