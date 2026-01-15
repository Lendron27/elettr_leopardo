package server;

import java.io.*;
import java.net.Socket;

/**
 * ClientHandler gestisce la comunicazione con un singolo client.
 * <p>
 * Ogni istanza viene eseguita in un thread separato e si occupa di:
 * <ul>
 *   <li>Autenticazione</li>
 *   <li>Ricezione dei dati</li>
 *   <li>Calcolo del consumo</li>
 *   <li>Invio del risultato</li>
 * </ul>
 */

public class ClientHandler implements Runnable {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(
                        socket.getOutputStream(), true)
        ) {
            // Autenticazione
            AuthService auth = new AuthService();
            String username = in.readLine();
            String password = in.readLine();

            if (!auth.verificaCredenziali(username, password)) {
                out.println("ERRORE");
                socket.close();
                return;
            }

            out.println("OK");

            // Ricezione dati
            double potenza = Double.parseDouble(in.readLine());
            double tempo = Double.parseDouble(in.readLine());
            double costoKwh = Double.parseDouble(in.readLine());

            ConsumoService service = new ConsumoService();
            String risultato = service.calcola(potenza, tempo, costoKwh);

            out.println(risultato);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
