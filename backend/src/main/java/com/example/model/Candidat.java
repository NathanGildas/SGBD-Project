package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Candidat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidat extends User {

    @Column(name = "telephone", length = 20, nullable = false)
    private String telephone;

    @Column(name = "partiPolitique", length = 100)
    private String partiPolitique;

    // Ajoutez les méthodes manquantes
    public void setId(Long id) {
        super.setId(id);
    }
}