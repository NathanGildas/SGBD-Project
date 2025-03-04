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

    @ManyToOne
    @JoinColumn(name = "cinElecteur", nullable = false)
    private Electeur electeur;

    @ManyToOne
    @JoinColumn(name = "idCandidat", nullable = false)
    private Candidat candidat;

    @Column(name = "dateParrainage", nullable = false)
    private LocalDateTime dateParrainage;
}