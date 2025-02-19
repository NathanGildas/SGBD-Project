import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConnexion {
    public static void main(String[] args) {
        try {
            // Obtenir une connexion à la base de données
            Connection connection = DatabaseConnection.getConnection();
            System.out.println("Connexion à la base de données réussie !");

            // Fermer la connexion
            DatabaseConnection.closeConnection(connection);
        } catch (SQLException e) {
            System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
        }
    }
}