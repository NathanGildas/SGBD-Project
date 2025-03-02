package com.example.monprojetsgbd.controller;

import service.AdminService;
import utils.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/admin/*")
public class AdminController extends HttpServlet {

    private AdminService adminService;

    @Override
    public void init() throws ServletException {
        try {
            Connection connection = DatabaseConnection.getConnection();
            this.adminService = new AdminService(connection);
        } catch (SQLException e) {
            throw new ServletException("Erreur de connexion à la base de données", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo(); // Récupère l'action à partir de l'URL

        switch (action) {
            case "/upload-electeurs":
                handleUploadElecteurs(req, resp);
                break;
            case "/set-parrainage-period":
                handleSetParrainagePeriod(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Action non trouvée");
        }
    }

    private void handleUploadElecteurs(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cheminFichier = req.getParameter("cheminFichier");
        boolean isUploaded = adminService.importerFichierElectoral(cheminFichier);

        if (isUploaded) {
            resp.getWriter().write("Fichier électoral uploadé avec succès !");
        } else {
            resp.getWriter().write("Erreur lors de l'upload du fichier électoral.");
        }
    }

    private void handleSetParrainagePeriod(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String dateDebut = req.getParameter("dateDebut");
        String dateFin = req.getParameter("dateFin");

        boolean isPeriodSet = adminService.definirPeriodeParrainage(dateDebut, dateFin);

        if (isPeriodSet) {
            resp.getWriter().write("Période de parrainage définie avec succès !");
        } else {
            resp.getWriter().write("Erreur lors de la définition de la période de parrainage.");
        }
    }
}