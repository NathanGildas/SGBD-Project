package com.example.monprojetsgbd.model;

public class Candidat {
    private String idCandidat;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String partiPolitique;

    // Constructeur
    public Candidat(String idCandidat, String nom, String prenom, String email, String telephone, String partiPolitique) {
        this.idCandidat = idCandidat;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.partiPolitique = partiPolitique;
    }

    // Getters et Setters
    public String getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(String idCandidat) {
        this.idCandidat = idCandidat;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPartiPolitique() {
        return partiPolitique;
    }

    public void setPartiPolitique(String partiPolitique) {
        this.partiPolitique = partiPolitique;
    }
}