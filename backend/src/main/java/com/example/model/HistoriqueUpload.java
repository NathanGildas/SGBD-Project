package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "HistoriqueUpload")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoriqueUpload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHistorique")
    private int idHistorique;

    @ManyToOne
    @JoinColumn(name = "idAdmin", nullable = false)
    private Admin admin;

    @Column(name = "dateUpload", nullable = false)
    private LocalDateTime dateUpload;

    @Column(name = "fichier", length = 255, nullable = false)
    private String fichier;
}