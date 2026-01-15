package client;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * AuthClient gestisce la fase di autenticazione lato client.
 * <p>
 * Raccoglie username e password dall'utente e li invia al server,
 * attendendo l'esito dell'autenticazione.
 */

public class AuthClient {

    private Scanner scanner;
    private BufferedReader in;
    private PrintWriter out;

    public AuthClient(Scanner scanner, BufferedReader in, PrintWriter out) {
        this.scanner = scanner;
        this.in = in;
        this.out = out;
    }

    /**
     * Effettua il processo di autenticazione.
     *
     * @return true se il server risponde con "OK", false altrimenti
     */

    public boolean autentica() {
        try {
            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            out.println(username);
            out.println(password);

            String risposta = in.readLine();
            return "OK".equals(risposta);

        } catch (Exception e) {
            return false;
        }
    }
}
