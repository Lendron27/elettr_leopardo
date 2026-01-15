package server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerApp rappresenta il server TCP del progetto Leopardo.
 * <p>
 * Rimane in ascolto su una porta specifica e crea un thread
 * dedicato per ogni client connesso.
 */

public class ServerApp {

    public static void main(String[] args) {
        int port = 1234;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server avviato sulla porta " + port);

            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Nuovo client connesso");
                new Thread(new ClientHandler(client)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
