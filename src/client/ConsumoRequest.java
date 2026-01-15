package client;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * ConsumoRequest gestisce l'inserimento e l'invio dei dati
 * necessari al calcolo del consumo energetico.
 * <p>
 * I dati inviati sono:
 * <ul>
 *   <li>Potenza in watt</li>
 *   <li>Tempo di utilizzo in ore</li>
 *   <li>Costo dell'energia per kWh</li>
 * </ul>
 */

public class ConsumoRequest {

    private Scanner scanner;
    private PrintWriter out;

    public ConsumoRequest(Scanner scanner, PrintWriter out) {
        this.scanner = scanner;
        this.out = out;
    }

    /**
     * Legge i dati da input e li invia al server.
     */

    public void invia() {
        System.out.print("Potenza (W): ");
        double potenza = scanner.nextDouble();

        System.out.print("Tempo (ore): ");
        double tempo = scanner.nextDouble();

        System.out.print("Costo kWh (€): ");
        double costo = scanner.nextDouble();

        out.println(potenza);
        out.println(tempo);
        out.println(costo);
    }
}
