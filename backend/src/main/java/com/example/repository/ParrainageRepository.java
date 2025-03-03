package com.example.repository;

import com.example.model.Parrainage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParrainageRepository extends JpaRepository<Parrainage, Integer> {
    List<Parrainage> findByCandidatId(Long candidatId);
}