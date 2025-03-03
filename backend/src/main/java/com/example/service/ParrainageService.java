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
}