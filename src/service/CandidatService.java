package service;

import dao.CandidatDAO;
import model.Candidat;
import utils.DatabaseConnection;
import utils.EmailService;
import utils.SMSService;
import java.sql.Connection;
import java.sql.SQLException;

public class CandidatService {

    private CandidatDAO candidatDAO;
    private EmailService emailService;
    private SMSService smsService;

    public CandidatService(Connection connection) {
        this.candidatDAO = new CandidatDAO(connection);
        this.emailService = new EmailService();
        this.smsService = new SMSService();
    }

    // Ajouter un candidat
    public boolean ajouterCandidat(Candidat candidat) {
        boolean isAdded = candidatDAO.ajouterCandidat(candidat);
        if (isAdded) {
            // Envoyer un code de sécurité par email et SMS
            String codeSecurite = genererCodeSecurite();
            emailService.envoyerEmail(candidat.getEmail(), "Code de sécurité", "Votre code de sécurité est : " + codeSecurite);
            smsService.envoyerSMS(candidat.getTelephone(), "Votre code de sécurité est : " + codeSecurite);
        }
        return isAdded;
    }

    // Obtenir un candidat par son ID
    public Candidat obtenirCandidat(String idCandidat) {
        return candidatDAO.obtenirCandidat(idCandidat);
    }

    // Supprimer un candidat
    public boolean supprimerCandidat(String idCandidat) {
        return candidatDAO.supprimerCandidat(idCandidat);
    }

    // Méthode pour générer un code de sécurité
    private String genererCodeSecurite() {
        // Implémenter la logique de génération d'un code de sécurité
        return "12345"; // À implémenter
    }
}