# 🐆 Progetto Leopardo – Calcolo consumi energetici (Client–Server TCP)

## Descrizione
**Leopardo** è un progetto client–server TCP scritto in **Java** che simula un servizio di **calcolo dei consumi energetici domestici**.

L'applicazione consente a un utente di:
- autenticarsi tramite **username e password**
- inserire i dati di un elettrodomestico
- ottenere il **consumo energetico (kWh)** e il **costo stimato (€)**

La comunicazione avviene esclusivamente tramite **socket TCP** e **stream testuali**.

## Funzionamento generale

1. Il **client** si connette al server tramite socket TCP  
2. L'utente inserisce le credenziali  
3. Il **server** verifica username e password  
4. Se l'autenticazione va a buon fine:
   - il client invia potenza, tempo e costo per kWh
   - il server calcola consumo e costo
   - il risultato viene restituito al client
5. La connessione viene chiusa

## Tecnologie utilizzate
- **Java**
- **Socket TCP**
- **InputStream / OutputStream**
- **Thread per gestione client**

## Formula di calcolo

Energia (kWh) = (Potenza (W) × Tempo (h)) / 1000
Costo (€) = Energia × Costo_kWh

## Come eseguire il progetto

### Avvio del server
1. Compilare i file nella cartella **server**
2. Avviare la classe **ServerApp**
3. Il server resta in ascolto sulla porta configurata

### Avvio del client
1. Compilare i file nella cartella **client**
2. Avviare **ClientApp**
3. Inserire credenziali e dati richiesti

## Credenziali di test

| Username | Password |
| admin | admin |
| user | 1234 |

## Documentazione
Il progetto è completamente documentato tramite **JavaDoc**, includendo:
- descrizione delle classi
- metodi
- parametri
- flusso dell'applicazione

## Autori
Progetto realizzato dal **Gruppo Leopardo 🐆**  
Lorenzo Giuliano, Francesco Cantarella, Alessio Santoni, Matteo Picioccolo, Alexander Sollevanti

## Note finali
Questo progetto dimostra:
- comprensione delle **architetture client–server**
- uso corretto dei **socket TCP**
- capacità di strutturare un progetto Java in modo ordinato

Se qualcuno dice che è “troppo semplice”, probabilmente non saprebbe nemmeno scriverlo.
