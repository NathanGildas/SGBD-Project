package com.example.monprojetsgbd.model;

import java.sql.Date;

public class PeriodeParrainage {
    private int idPeriode;
    private Date dateDebut;
    private Date dateFin;

    // Constructeur
    public PeriodeParrainage(int idPeriode, Date dateDebut, Date dateFin) {
        this.idPeriode = idPeriode;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    // Getters et Setters
    public int getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(int idPeriode) {
        this.idPeriode = idPeriode;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}