package com.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    // Ajoutez les méthodes manquantes
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    @Size(max = 100, message = "Le nom ne doit pas dépasser 100 caractères")
    @Column(name = "nom", nullable = false)
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    @Size(max = 100, message = "Le prénom ne doit pas dépasser 100 caractères")
    @Column(name = "prenom", nullable = false)
    private String prenom;

    @NotBlank(message = "L'email est obligatoire")
    @Size(max = 100, message = "L'email ne doit pas dépasser 100 caractères")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Setter
    @Getter
    @NotBlank(message = "Le nom d'utilisateur est obligatoire")
    @Size(max = 50, message = "Le nom d'utilisateur ne doit pas dépasser 50 caractères")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Setter
    @Getter
    @NotBlank(message = "Le mot de passe est obligatoire")
    @Column(name = "password", nullable = false)
    private String password;

    @Setter
    @Getter
    @NotBlank(message = "Le rôle est obligatoire")
    @Column(name = "role", nullable = false)
    private String role;

}