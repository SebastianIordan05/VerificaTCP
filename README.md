# IIS “Levi-Ponti” – Mirano

Verifica di Sistemi e Reti

Problema
Il guidatore di un taxi (client) invia alla sede centrale (server) i dati di ogni trasporto (oggetto).
Ogni trasporto deve avere le seguenti caratteristiche:
- codice taxi (stringa);
- quantità di chilometri (numero intero);
- numero persone trasportate (byte);
- prezzo per chilometro (numero con la virgola).

# Prima parte (voto fino a 7)
Il client invia di volta in volta al server il singolo trasporto, fino a quando gli invierà come
condizione di uscita la quantità di chilometri 0.
Il server, ricevuto ogni trasporto dal client, ne visualizza i dati e invia al client il costo del trasporto
per persona (numero con la virgola, uguale al prodotto tra quantità di chilometri e prezzo per
chilometro, diviso per il numero di persone trasportate) che viene visualizzato dal client.
Quando il server riceve l’oggetto che ha come numero di chilometri 0, chiude la connessione col
client.

# Seconda parte (voto da 7 a 10)
Il server calcola il costo totale dei trasporti e, quando il client gli invia il trasporto con numero di
chilometri 0, glielo invia. Il client lo visualizza.
Il server determina il trasporto dal costo in assoluto maggiore e lo invia al client che ne visualizza i
dati.
