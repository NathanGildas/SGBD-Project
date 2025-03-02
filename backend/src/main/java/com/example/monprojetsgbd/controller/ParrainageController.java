package com.example.monprojetsgbd.controller;

import service.ParrainageService;
import utils.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/parrainage/*")
public class ParrainageController extends HttpServlet {

    private ParrainageService parrainageService;

    @Override
    public void init() throws ServletException {
        try {
            Connection connection = DatabaseConnection.getConnection();
            this.parrainageService = new ParrainageService(connection);
        } catch (SQLException e) {
            throw new ServletException("Erreur de connexion à la base de données", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo(); // Récupère l'action à partir de l'URL

        switch (action) {
            case "/statistiques":
                handleGetStatistiques(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Action non trouvée");
        }
    }

    private void handleGetStatistiques(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Object[]> statistiques = parrainageService.obtenirStatistiquesParrainage();

        // Afficher les statistiques
        resp.getWriter().write("Statistiques de parrainage : " + statistiques.toString());
    }
}