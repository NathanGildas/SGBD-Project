package com.example.monprojetsgbd.repository;

import model.HistoriqueUpload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoriqueUploadDAO {

    private Connection connection;

    public HistoriqueUploadDAO(Connection connection) {
        this.connection = connection;
    }

    // Ajouter un historique d'upload
    public boolean ajouterHistoriqueUpload(HistoriqueUpload historiqueUpload) {
        String sql = "INSERT INTO HistoriqueUpload (idAdmin, dateUpload, fichier) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, historiqueUpload.getIdAdmin());
            statement.setTimestamp(2, historiqueUpload.getDateUpload());
            statement.setString(3, historiqueUpload.getFichier());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtenir un historique d'upload par son ID
    public HistoriqueUpload obtenirHistoriqueUpload(int idHistorique) {
        String sql = "SELECT * FROM HistoriqueUpload WHERE idHistorique = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idHistorique);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new HistoriqueUpload(
                        resultSet.getInt("idHistorique"),
                        resultSet.getString("idAdmin"),
                        resultSet.getTimestamp("dateUpload"),
                        resultSet.getString("fichier")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Supprimer un historique d'upload
    public boolean supprimerHistoriqueUpload(int idHistorique) {
        String sql = "DELETE FROM HistoriqueUpload WHERE idHistorique = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idHistorique);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}