package utils;

public class EmailService {

    // Méthode pour envoyer un email
    public void envoyerEmail(String destinataire, String sujet, String contenu) {
        // Implémenter la logique d'envoi d'email
        // (utiliser une API comme JavaMail ou un service tiers comme SendGrid)
        System.out.println("Email envoyé à " + destinataire + " : " + sujet + " - " + contenu);
    }
}