package com.example.monprojetsgbd.service;

import dao.ParrainageDAO;

import java.sql.Connection;
import java.util.List;

public class ParrainageService {

    private ParrainageDAO parrainageDAO;

    public ParrainageService(Connection connection) {
        this.parrainageDAO = new ParrainageDAO(connection);
    }

    // Ajouter un parrainage
    public boolean ajouterParrainage(String cinElecteur, String idCandidat) {
        return parrainageDAO.ajouterParrainage(cinElecteur, idCandidat);
    }

    // Supprimer un parrainage
    public boolean supprimerParrainage(int idParrainage) {
        return parrainageDAO.supprimerParrainage(idParrainage);
    }

    // Obtenir les statistiques de parrainage par candidat
    public List<Object[]> obtenirStatistiquesParrainage() {
        return parrainageDAO.obtenirStatistiquesParrainage();
    }
}