package com.example.controller;

import com.example.model.Candidat;
import com.example.service.CandidatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/candidats")
@Tag(name = "Candidat Controller", description = "Gestion des candidats")
public class CandidatController {

    private final CandidatService candidatService;

    public CandidatController(CandidatService candidatService) {
        this.candidatService = candidatService;
    }

    @Operation(summary = "Créer un candidat")
    @PostMapping
    public ResponseEntity<Candidat> createCandidat(@Valid @RequestBody Candidat candidat) {
        Candidat createdCandidat = candidatService.createCandidat(candidat);
        return ResponseEntity.ok(createdCandidat);
    }

    @Operation(summary = "Mettre à jour un candidat")
    @PutMapping("/{id}")
    public ResponseEntity<Candidat> updateCandidat(@PathVariable Long id, @Valid @RequestBody Candidat candidat) {
        Candidat updatedCandidat = candidatService.updateCandidat(id, candidat);
        return updatedCandidat != null ? ResponseEntity.ok(updatedCandidat) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Supprimer un candidat")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidat(@PathVariable Long id) {
        boolean isDeleted = candidatService.deleteCandidat(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Obtenir tous les candidats")
    @GetMapping
    public ResponseEntity<List<Candidat>> getAllCandidats() {
        List<Candidat> candidats = candidatService.getAllCandidats();
        return ResponseEntity.ok(candidats);
    }
}