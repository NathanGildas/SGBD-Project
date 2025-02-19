package dao;

import model.Candidat;
import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidatDAO {

    private Connection connection;

    public CandidatDAO(Connection connection) {
        this.connection = connection;
    }

    // Ajouter un candidat
    public boolean ajouterCandidat(Candidat candidat) {
        String sql = "INSERT INTO Candidat (idCandidat, nom, prenom, email, telephone, partiPolitique) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, candidat.getIdCandidat());
            statement.setString(2, candidat.getNom());
            statement.setString(3, candidat.getPrenom());
            statement.setString(4, candidat.getEmail());
            statement.setString(5, candidat.getTelephone());
            statement.setString(6, candidat.getPartiPolitique());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtenir un candidat par son ID
    public Candidat obtenirCandidat(String idCandidat) {
        String sql = "SELECT * FROM Candidat WHERE idCandidat = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idCandidat);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Candidat(
                        resultSet.getString("idCandidat"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("email"),
                        resultSet.getString("telephone"),
                        resultSet.getString("partiPolitique")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Supprimer un candidat
    public boolean supprimerCandidat(String idCandidat) {
        String sql = "DELETE FROM Candidat WHERE idCandidat = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idCandidat);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}