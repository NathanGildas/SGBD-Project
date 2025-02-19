package controller;

import service.ElecteurService;
import utils.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/electeur/*")
public class ElecteurController extends HttpServlet {

    private ElecteurService electeurService;

    @Override
    public void init() throws ServletException {
        try {
            Connection connection = DatabaseConnection.getConnection();
            this.electeurService = new ElecteurService(connection);
        } catch (SQLException e) {
            throw new ServletException("Erreur de connexion à la base de données", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo(); // Récupère l'action à partir de l'URL

        switch (action) {
            case "/parrainer":
                handleParrainer(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Action non trouvée");
        }
    }

    private void handleParrainer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cinElecteur = req.getParameter("cinElecteur");
        String idCandidat = req.getParameter("idCandidat");

        boolean isParrainageEnregistre = electeurService.enregistrerParrainage(cinElecteur, idCandidat);

        if (isParrainageEnregistre) {
            resp.getWriter().write("Parrainage enregistré avec succès !");
        } else {
            resp.getWriter().write("Erreur lors de l'enregistrement du parrainage.");
        }
    }
}