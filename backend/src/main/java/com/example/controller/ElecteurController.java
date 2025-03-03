package com.example.controller;

import com.example.model.Electeur;
import com.example.service.ElecteurService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/electeurs")
@Tag(name = "Electeur Controller", description = "Gestion des électeurs")
public class ElecteurController {

    private final ElecteurService electeurService;

    public ElecteurController(ElecteurService electeurService) {
        this.electeurService = electeurService;
    }

    @Operation(summary = "Créer un électeur")
    @PostMapping
    public ResponseEntity<Electeur> createElecteur(@Valid @RequestBody Electeur electeur) {
        Electeur createdElecteur = electeurService.createElecteur(electeur);
        return ResponseEntity.ok(createdElecteur);
    }

    @Operation(summary = "Mettre à jour un électeur")
    @PutMapping("/{id}")
    public ResponseEntity<Electeur> updateElecteur(@PathVariable Long id, @Valid @RequestBody Electeur electeur) {
        Electeur updatedElecteur = electeurService.updateElecteur(id, electeur);
        return updatedElecteur != null ? ResponseEntity.ok(updatedElecteur) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Supprimer un électeur")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElecteur(@PathVariable Long id) {
        boolean isDeleted = electeurService.deleteElecteur(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Obtenir tous les électeurs")
    @GetMapping
    public ResponseEntity<List<Electeur>> getAllElecteurs() {
        List<Electeur> electeurs = electeurService.getAllElecteurs();
        return ResponseEntity.ok(electeurs);
    }
}