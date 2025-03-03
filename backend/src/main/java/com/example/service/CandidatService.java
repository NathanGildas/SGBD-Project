package com.example.service;

import com.example.model.Candidat;
import com.example.repository.CandidatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {

    private final CandidatRepository candidatRepository;

    public CandidatService(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    public Candidat createCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    public Candidat updateCandidat(Long id, Candidat candidat) {
        Optional<Candidat> existingCandidat = candidatRepository.findById(id);
        if (existingCandidat.isPresent()) {
            candidat.setId(id);
            return candidatRepository.save(candidat);
        }
        return null;
    }

    public boolean deleteCandidat(Long id) {
        Optional<Candidat> existingCandidat = candidatRepository.findById(id);
        if (existingCandidat.isPresent()) {
            candidatRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Candidat> getAllCandidats() {
        return candidatRepository.findAll();
    }
}
