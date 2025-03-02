package com.example.monprojetsgbd.model;

public class Admin {
    private String idAdmin;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasseHash;

    // Constructeur
    public Admin(String idAdmin, String nom, String prenom, String email, String motDePasseHash) {
        this.idAdmin = idAdmin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasseHash = motDePasseHash;
    }

    // Getters et Setters
    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasseHash() {
        return motDePasseHash;
    }

    public void setMotDePasseHash(String motDePasseHash) {
        this.motDePasseHash = motDePasseHash;
    }
}