package com.example.repository;

import com.example.model.Electeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElecteurRepository extends JpaRepository<Electeur, Long> {
}