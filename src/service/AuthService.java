package service;

import dao.ElecteurDAO;
import model.Electeur;
import utils.PasswordUtils;
import utils.TokenUtils;
import java.sql.Connection;

public class AuthService {

    private ElecteurDAO electeurDAO;
    private PasswordUtils passwordUtils;
    private TokenUtils tokenUtils;

    public AuthService(Connection connection) {
        this.electeurDAO = new ElecteurDAO(connection);
        this.passwordUtils = new PasswordUtils();
        this.tokenUtils = new TokenUtils();
    }

    // Connexion d'un électeur
    public String login(String email, String password) {
        Electeur electeur = electeurDAO.obtenirElecteurParEmail(email);

        if (electeur != null && passwordUtils.verifierMotDePasse(password, electeur.getMotDePasseHash())) {
            return tokenUtils.genererToken(electeur.getCin());
        }

        return null;
    }

    // Enregistrement d'un électeur
    public boolean registerElecteur(String cin, String nom, String prenom, String email, String telephone, String motDePasse) {
        // Vérifier si l'électeur existe déjà
        if (electeurDAO.obtenirElecteurParCin(cin) != null) {
            return false;
        }

        // Hasher le mot de passe
        String motDePasseHash = passwordUtils.hacherMotDePasse(motDePasse);

        // Créer un nouvel électeur
        Electeur electeur = new Electeur(cin, nom, prenom, email, telephone, motDePasseHash);

        // Enregistrer l'électeur dans la base de données
        return electeurDAO.ajouterElecteur(electeur);
    }
}