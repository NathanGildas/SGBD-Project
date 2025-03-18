package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Electeur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Electeur extends User {

    @Column(name = "telephone", length = 20, nullable = false)
    private String telephone;

    @Column(name = "motDePasseHash", length = 255, nullable = false)
    private String motDePasseHash;

    // Ajoutez les méthodes manquantes
    public void setId(Long id) {
        super.setId(id);
    }
}