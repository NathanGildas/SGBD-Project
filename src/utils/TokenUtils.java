package utils;

import java.util.Base64;
import java.util.Date;

public class TokenUtils {

    // Générer un token d'authentification
    public String genererToken(String cin) {
        String token = cin + "|" + new Date().getTime();
        return Base64.getEncoder().encodeToString(token.getBytes());
    }

    // Vérifier un token d'authentification
    public boolean verifierToken(String token) {
        try {
            String decodedToken = new String(Base64.getDecoder().decode(token));
            String[] parts = decodedToken.split("\\|");
            if (parts.length == 2) {
                // Vérifier la date d'expiration du token (optionnel)
                long timestamp = Long.parseLong(parts[1]);
                long currentTime = new Date().getTime();
                long expirationTime = 24 * 60 * 60 * 1000; // 24 heures
                return (currentTime - timestamp) < expirationTime;
            }
        } catch (Exception e) {
            // Token invalide
        }
        return false;
    }
}