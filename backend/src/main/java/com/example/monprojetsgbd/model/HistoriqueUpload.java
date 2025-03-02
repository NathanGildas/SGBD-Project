package com.example.monprojetsgbd.model;

import java.sql.Timestamp;

public class HistoriqueUpload {
    private int idHistorique;
    private String idAdmin;
    private Timestamp dateUpload;
    private String fichier;

    // Constructeur
    public HistoriqueUpload(int idHistorique, String idAdmin, Timestamp dateUpload, String fichier) {
        this.idHistorique = idHistorique;
        this.idAdmin = idAdmin;
        this.dateUpload = dateUpload;
        this.fichier = fichier;
    }

    // Getters et Setters
    public int getIdHistorique() {
        return idHistorique;
    }

    public void setIdHistorique(int idHistorique) {
        this.idHistorique = idHistorique;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Timestamp getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(Timestamp dateUpload) {
        this.dateUpload = dateUpload;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }
}