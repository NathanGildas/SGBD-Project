package com.example.monprojetsgbd.repository;

import model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    private Connection connection;

    public AdminDAO(Connection connection) {
        this.connection = connection;
    }

    // Ajouter un administrateur
    public boolean ajouterAdmin(Admin admin) {
        String sql = "INSERT INTO Admin (idAdmin, nom, prenom, email, motDePasseHash) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, admin.getIdAdmin());
            statement.setString(2, admin.getNom());
            statement.setString(3, admin.getPrenom());
            statement.setString(4, admin.getEmail());
            statement.setString(5, admin.getMotDePasseHash());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtenir un administrateur par son ID
    public Admin obtenirAdmin(String idAdmin) {
        String sql = "SELECT * FROM Admin WHERE idAdmin = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idAdmin);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Admin(
                        resultSet.getString("idAdmin"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("email"),
                        resultSet.getString("motDePasseHash")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Supprimer un administrateur
    public boolean supprimerAdmin(String idAdmin) {
        String sql = "DELETE FROM Admin WHERE idAdmin = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idAdmin);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}