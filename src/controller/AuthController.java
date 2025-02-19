package controller;

import service.AuthService;
import utils.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/auth/*")
public class AuthController extends HttpServlet {

    private AuthService authService;

    @Override
    public void init() throws ServletException {
        try {
            Connection connection = DatabaseConnection.getConnection();
            this.authService = new AuthService(connection);
        } catch (SQLException e) {
            throw new ServletException("Erreur de connexion à la base de données", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo(); // Récupère l'action à partir de l'URL

        switch (action) {
            case "/login":
                handleLogin(req, resp);
                break;
            case "/register-electeur":
                handleRegisterElecteur(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Action non trouvée");
        }
    }

    private void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String token = authService.login(email, password);

        if (token != null) {
            resp.getWriter().write("Connexion réussie ! Token : " + token);
        } else {
            resp.getWriter().write("Échec de la connexion.");
        }
    }

    private void handleRegisterElecteur(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cin = req.getParameter("cin");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String telephone = req.getParameter("telephone");
        String motDePasse = req.getParameter("motDePasse");

        boolean isRegistered = authService.registerElecteur(cin, nom, prenom, email, telephone, motDePasse);

        if (isRegistered) {
            resp.getWriter().write("Électeur enregistré avec succès !");
        } else {
            resp.getWriter().write("Erreur lors de l'enregistrement de l'électeur.");
        }
    }
}