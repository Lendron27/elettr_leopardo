package server;

/**
 * ConsumoService esegue il calcolo del consumo energetico.
 * <p>
 * Formula utilizzata:
 * <pre>
 * energia (kWh) = (potenza * tempo) / 1000
 * costo = energia * costo_kWh
 * </pre>
 */

public class ConsumoService {

    /**
     * Calcola energia consumata e costo totale.
     *
     * @param potenza potenza in watt
     * @param tempo tempo di utilizzo in ore
     * @param costoKwh costo dell'energia per kWh
     * @return stringa contenente il risultato formattato
     */

    public String calcola(double potenza, double tempo, double costoKwh) {

        if (potenza <= 0 || tempo <= 0 || costoKwh <= 0) {
            return "Errore: valori non validi";
        }

        double energia = (potenza * tempo) / 1000;
        double costo = energia * costoKwh;

        return "Energia consumata: " + energia + " kWh\n" + "Costo stimato: " + costo + " euro";
    }
}
