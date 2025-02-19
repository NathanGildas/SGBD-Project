package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static String URL;
    private static String USER;
    private static String PASSWORD;

    // Charger les propriétés de la base de données depuis un fichier de configuration
    static {
        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("config/database.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            URL = properties.getProperty("db.url");
            USER = properties.getProperty("db.user");
            PASSWORD = properties.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors du chargement des propriétés de la base de données");
        }
    }

    // Méthode pour obtenir une connexion à la base de données
    public static Connection getConnection() throws SQLException {
        try {
            // Charger le driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erreur de connexion à la base de données");
        }
    }

    // Méthode pour fermer une connexion
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}