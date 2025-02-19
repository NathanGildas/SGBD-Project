package model;

import java.sql.Timestamp;

public class Parrainage {
    private int idParrainage;
    private String cinElecteur;
    private String idCandidat;
    private Timestamp dateParrainage;

    // Constructeur
    public Parrainage(int idParrainage, String cinElecteur, String idCandidat, Timestamp dateParrainage) {
        this.idParrainage = idParrainage;
        this.cinElecteur = cinElecteur;
        this.idCandidat = idCandidat;
        this.dateParrainage = dateParrainage;
    }

    // Getters et Setters
    public int getIdParrainage() {
        return idParrainage;
    }

    public void setIdParrainage(int idParrainage) {
        this.idParrainage = idParrainage;
    }

    public String getCinElecteur() {
        return cinElecteur;
    }

    public void setCinElecteur(String cinElecteur) {
        this.cinElecteur = cinElecteur;
    }

    public String getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(String idCandidat) {
        this.idCandidat = idCandidat;
    }

    public Timestamp getDateParrainage() {
        return dateParrainage;
    }

    public void setDateParrainage(Timestamp dateParrainage) {
        this.dateParrainage = dateParrainage;
    }
}