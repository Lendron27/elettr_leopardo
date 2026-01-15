package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * ClientApp rappresenta l'applicazione client del progetto Leopardo.
 * <p>
 * Si occupa di:
 * <ul>
 *   <li>Stabilire una connessione TCP con il server</li>
 *   <li>Gestire l'autenticazione dell'utente</li>
 *   <li>Inviare i dati di consumo energetico</li>
 *   <li>Ricevere e visualizzare il risultato del calcolo</li>
 * </ul>
 *
 * La comunicazione avviene tramite socket TCP utilizzando flussi testuali.
 *
 * @author Gruppo Leopardo
 * @version 1.0
 */

public class ClientApp {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        try (
                Socket socket = new Socket(host, port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Connesso al server.");

            // Autenticazione
            AuthClient auth = new AuthClient(scanner, in, out);
            if (!auth.autentica()) {
                System.out.println("Autenticazione fallita");
                return;
            }

            // Invio dati consumo
            ConsumoRequest request = new ConsumoRequest(scanner, out);
            request.invia();

            // Ricezione risultato
            String riga;
            System.out.println("RISULTATO:");
            while ((riga = in.readLine()) != null) {
                System.out.println(riga);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}