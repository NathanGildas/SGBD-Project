package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends User {

    @Column(name = "motDePasseHash", length = 255, nullable = false)
    private String motDePasseHash;
}