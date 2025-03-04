package com.example.controller;

import com.example.model.Parrainage;
import com.example.service.ParrainageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/parrainages")
@Tag(name = "Parrainage Controller", description = "Gestion des parrainages")
public class ParrainageController {

    private final ParrainageService parrainageService;

    public ParrainageController(ParrainageService parrainageService) {
        this.parrainageService = parrainageService;
    }

    @Operation(summary = "Créer un parrainage")
    @PostMapping
    public ResponseEntity<Parrainage> createParrainage(@Valid @RequestBody Parrainage parrainage) {
        Parrainage createdParrainage = parrainageService.createParrainage(parrainage);
        return ResponseEntity.ok(createdParrainage);
    }

    @Operation(summary = "Mettre à jour un parrainage")
    @PutMapping("/{id}")
    public ResponseEntity<Parrainage> updateParrainage(@PathVariable Long id, @Valid @RequestBody Parrainage parrainage) {
        Parrainage updatedParrainage = parrainageService.updateParrainage(id, parrainage);
        return updatedParrainage != null ? ResponseEntity.ok(updatedParrainage) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Supprimer un parrainage")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParrainage(@PathVariable Long id) {
        boolean isDeleted = parrainageService.deleteParrainage(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Obtenir tous les parrainages")
    @GetMapping
    public ResponseEntity<List<Parrainage>> getAllParrainages() {
        List<Parrainage> parrainages = parrainageService.getAllParrainages();
        return ResponseEntity.ok(parrainages);
    }
}