package com.example.service;

import com.example.model.Parrainage;
import com.example.repository.ParrainageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParrainageService {

    private final ParrainageRepository parrainageRepository;

    public ParrainageService(ParrainageRepository parrainageRepository) {
        this.parrainageRepository = parrainageRepository;
    }

    public List<Parrainage> getParrainagesByCandidat(Long candidatId) {
        return parrainageRepository.findByCandidatId(candidatId);
    }

    public Parrainage createParrainage(Parrainage parrainage) {
        return parrainageRepository.save(parrainage);
    }

    public boolean deleteParrainage(Long id) {
        parrainageRepository.deleteById(Math.toIntExact(id));
        return false;
    }

    public List<Parrainage> getAllParrainages() {
        return parrainageRepository.findAll();
    }

    public Parrainage updateParrainage(Long id, Parrainage parrainageDetails) {
        // Récupérer le parrainage existant par son ID
        Parrainage existingParrainage = parrainageRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Parrainage non trouvé avec l'ID : " + id));

        // Mettre à jour les champs de l'objet existant avec les nouvelles valeurs
        existingParrainage.setElecteur(parrainageDetails.getElecteur()); // Mettre à jour l'électeur
        existingParrainage.setCandidat(parrainageDetails.getCandidat()); // Mettre à jour le candidat
        existingParrainage.setDateParrainage(parrainageDetails.getDateParrainage()); // Mettre à jour la date

        // Sauvegarder l'objet mis à jour dans la base de données
        return parrainageRepository.save(existingParrainage);
    }
}