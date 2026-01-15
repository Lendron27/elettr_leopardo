package server;

import java.util.HashMap;
import java.util.Map;

/**
 * AuthService fornisce il servizio di verifica delle credenziali.
 * <p>
 * Le credenziali sono memorizzate localmente in una struttura dati.
 */

public class AuthService {

    private Map<String, String> utenti = new HashMap<>();

    public AuthService() {
        utenti.put("admin", "admin");
        utenti.put("user", "1234");
    }

    /**
     * Verifica la validità delle credenziali fornite.
     *
     * @param username nome utente
     * @param password password
     * @return true se le credenziali sono corrette
     */

    public boolean verificaCredenziali(String username, String password) {
        return utenti.containsKey(username) &&
                utenti.get(username).equals(password);
    }
}
