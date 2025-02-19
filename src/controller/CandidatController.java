package controller;

import model.Candidat;
import service.CandidatService;
import utils.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/candidat/*")
public class CandidatController extends HttpServlet {

    private CandidatService candidatService;

    @Override
    public void init() throws ServletException {
        try {
            Connection connection = DatabaseConnection.getConnection();
            this.candidatService = new CandidatService(connection);
        } catch (SQLException e) {
            throw new ServletException("Erreur de connexion à la base de données", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo(); // Récupère l'action à partir de l'URL

        switch (action) {
            case "/register":
                handleRegisterCandidat(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Action non trouvée");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo(); // Récupère l'action à partir de l'URL

        switch (action) {
            case "/get":
                handleGetCandidat(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Action non trouvée");
        }
    }

    private void handleRegisterCandidat(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idCandidat = req.getParameter("idCandidat");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String telephone = req.getParameter("telephone");
        String partiPolitique = req.getParameter("partiPolitique");

        // Créer un objet Candidat
        Candidat candidat = new Candidat(idCandidat, nom, prenom, email, telephone, partiPolitique);

        boolean isAdded = candidatService.ajouterCandidat(candidat);

        if (isAdded) {
            resp.getWriter().write("Candidat enregistré avec succès !");
        } else {
            resp.getWriter().write("Erreur lors de l'enregistrement du candidat.");
        }
    }

    private void handleGetCandidat(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idCandidat = req.getParameter("idCandidat");

        Candidat candidat = candidatService.obtenirCandidat(idCandidat);

        if (candidat != null) {
            resp.getWriter().write("Candidat trouvé : " + candidat.getNom() + " " + candidat.getPrenom());
        } else {
            resp.getWriter().write("Candidat non trouvé.");
        }
    }
}