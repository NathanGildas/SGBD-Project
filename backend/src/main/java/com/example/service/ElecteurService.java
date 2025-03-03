package com.example.service;

import com.example.model.Electeur;
import com.example.repository.ElecteurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElecteurService {

    private final ElecteurRepository electeurRepository;

    public ElecteurService(ElecteurRepository electeurRepository) {
        this.electeurRepository = electeurRepository;
    }

    public Electeur createElecteur(Electeur electeur) {
        return electeurRepository.save(electeur);
    }

    public Electeur updateElecteur(Long id, Electeur electeur) {
        Optional<Electeur> existingElecteur = electeurRepository.findById(id);
        if (existingElecteur.isPresent()) {
            electeur.setId(id);
            return electeurRepository.save(electeur);
        }
        return null;
    }

    public boolean deleteElecteur(Long id) {
        Optional<Electeur> existingElecteur = electeurRepository.findById(id);
        if (existingElecteur.isPresent()) {
            electeurRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Electeur> getAllElecteurs() {
        return electeurRepository.findAll();
    }
}
