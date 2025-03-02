package com.example.monprojetsgbd.service;

import dao.AdminDAO;
import model.Admin;

import java.sql.Connection;

public class AdminService {

    private AdminDAO adminDAO;

    public AdminService(Connection connection) {
        this.adminDAO = new AdminDAO(connection);
    }

    // Ajouter un administrateur
    public boolean ajouterAdmin(Admin admin) {
        return adminDAO.ajouterAdmin(admin);
    }

    // Obtenir un administrateur par son ID
    public Admin obtenirAdmin(String idAdmin) {
        return adminDAO.obtenirAdmin(idAdmin);
    }

    // Supprimer un administrateur
    public boolean supprimerAdmin(String idAdmin) {
        return adminDAO.supprimerAdmin(idAdmin);
    }

    // Importer un fichier électoral
    public boolean importerFichierElectoral(String cheminFichier) {
        // Logique pour importer le fichier électoral
        // (à implémenter en fonction de ton besoin)
        return true;
    }

    // Définir la période de parrainage
    public boolean definirPeriodeParrainage(String dateDebut, String dateFin) {
        // Logique pour définir la période de parrainage
        // (à implémenter en fonction de ton besoin)
        return true;
    }
}