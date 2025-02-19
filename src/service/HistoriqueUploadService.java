package service;

import dao.HistoriqueUploadDAO;
import model.HistoriqueUpload;
import java.sql.Connection;

public class HistoriqueUploadService {

    private HistoriqueUploadDAO historiqueUploadDAO;

    public HistoriqueUploadService(Connection connection) {
        this.historiqueUploadDAO = new HistoriqueUploadDAO(connection);
    }

    // Ajouter un historique d'upload
    public boolean ajouterHistoriqueUpload(HistoriqueUpload historiqueUpload) {
        return historiqueUploadDAO.ajouterHistoriqueUpload(historiqueUpload);
    }

    // Obtenir un historique d'upload par son ID
    public HistoriqueUpload obtenirHistoriqueUpload(int idHistorique) {
        return historiqueUploadDAO.obtenirHistoriqueUpload(idHistorique);
    }

    // Supprimer un historique d'upload
    public boolean supprimerHistoriqueUpload(int idHistorique) {
        return historiqueUploadDAO.supprimerHistoriqueUpload(idHistorique);
    }
}