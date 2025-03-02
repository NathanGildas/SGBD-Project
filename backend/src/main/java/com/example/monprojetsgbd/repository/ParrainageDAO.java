package com.example.monprojetsgbd.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParrainageDAO {

    private Connection connection;

    public ParrainageDAO(Connection connection) {
        this.connection = connection;
    }

    // Ajouter un parrainage
    public boolean ajouterParrainage(String cinElecteur, String idCandidat) {
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

    // Supprimer un parrainage
    public boolean supprimerParrainage(int idParrainage) {
        String sql = "DELETE FROM Parrainage WHERE idParrainage = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idParrainage);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtenir les statistiques de parrainage par candidat
    public List<Object[]> obtenirStatistiquesParrainage() {
        List<Object[]> statistiques = new ArrayList<>();
        String sql = "SELECT idCandidat, COUNT(*) AS nombreParrainages FROM Parrainage GROUP BY idCandidat";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Object[] stat = new Object[2];
                stat[0] = resultSet.getString("idCandidat");
                stat[1] = resultSet.getInt("nombreParrainages");
                statistiques.add(stat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statistiques;
    }
}