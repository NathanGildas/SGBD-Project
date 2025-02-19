package service;

import dao.ElecteurDAO;
import model.Electeur;
import utils.EmailService;
import utils.SMSService;
import java.sql.Connection;

public class ElecteurService {

    private ElecteurDAO electeurDAO;
    private EmailService emailService;
    private SMSService smsService;

    public ElecteurService(Connection connection) {
        this.electeurDAO = new ElecteurDAO(connection);
        this.emailService = new EmailService();
        this.smsService = new SMSService();
    }

    // Enregistrer un électeur
    public boolean enregistrerElecteur(Electeur electeur) {
        // Vérifier si l'électeur existe déjà
        if (electeurDAO.obtenirElecteurParCin(electeur.getCin()) != null) {
            return false;
        }

        // Enregistrer l'électeur dans la base de données
        return electeurDAO.ajouterElecteur(electeur);
    }

    // Enregistrer un parrainage
    public boolean enregistrerParrainage(String cinElecteur, String idCandidat) {
        // Vérifier si l'électeur a déjà parrainé un candidat
        if (electeurDAO.aDejaParraine(cinElecteur)) {
            return false;
        }

        // Enregistrer le parrainage
        boolean isParrainageEnregistre = electeurDAO.enregistrerParrainage(cinElecteur, idCandidat);

        if (isParrainageEnregistre) {
            // Envoyer un code de confirmation par email et SMS
            String codeConfirmation = genererCodeConfirmation();
            Electeur electeur = electeurDAO.obtenirElecteurParCin(cinElecteur);
            emailService.envoyerEmail(electeur.getEmail(), "Confirmation de parrainage", "Votre code de confirmation est : " + codeConfirmation);
            smsService.envoyerSMS(electeur.getTelephone(), "Votre code de confirmation est : " + codeConfirmation);
        }

        return isParrainageEnregistre;
    }

    // Méthode pour générer un code de confirmation
    private String genererCodeConfirmation() {
        // Implémenter la logique de génération d'un code de confirmation
        return "67890"; // À implémenter
    }
}