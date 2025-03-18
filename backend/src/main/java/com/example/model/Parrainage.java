package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Parrainage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Parrainage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idParrainage")
    private int idParrainage;

    // Ajoutez les méthodes manquantes
    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "cinElecteur", nullable = false)
    private Electeur electeur;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "idCandidat", nullable = false)
    private Candidat candidat;

    @Setter
    @Getter
    @Column(name = "dateParrainage", nullable = false)
    private LocalDateTime dateParrainage;

}