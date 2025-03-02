package com.example.monprojetsgbd.repository;

import model.Electeur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ElecteurDAO {

    private Connection connection;

    public ElecteurDAO(Connection connection) {
        this.connection = connection;
    }

    // Ajouter un électeur
    public boolean ajouterElecteur(Electeur electeur) {
        String sql = "INSERT INTO Electeur (cin, nom, prenom, email, telephone, motDePasseHash) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, electeur.getCin());
            statement.setString(2, electeur.getNom());
            statement.setString(3, electeur.getPrenom());
            statement.setString(4, electeur.getEmail());
            statement.setString(5, electeur.getTelephone());
            statement.setString(6, electeur.getMotDePasseHash());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtenir un électeur par son CIN
    public Electeur obtenirElecteurParCin(String cin) {
        String sql = "SELECT * FROM Electeur WHERE cin = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cin);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Electeur(
                        resultSet.getString("cin"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("email"),
                        resultSet.getString("telephone"),
                        resultSet.getString("motDePasseHash")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // Obtenir un électeur par son email
    public Electeur obtenirElecteurParEmail(String email) {
        String sql = "SELECT * FROM Electeur WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Electeur(
                        resultSet.getString("cin"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("email"),
                        resultSet.getString("telephone"),
                        resultSet.getString("motDePasseHash")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Vérifier si un électeur a déjà parrainé un candidat
    public boolean aDejaParraine(String cinElecteur) {
        String sql = "SELECT COUNT(*) FROM Parrainage WHERE cinElecteur = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cinElecteur);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Enregistrer un parrainage
    public boolean enregistrerParrainage(String cinElecteur, String idCandidat) {
        String sql = "INSERT INTO Parrainage (cinElecteur, idCandidat) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cinElecteur);
            statement.setString(2, idCandidat);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}