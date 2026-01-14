package Server;

import Shared.GsonAdapters.RequestPacket;
import Server.RequestHandler.RequestCoRFacade;
import Shared.DataIO;
import Shared.Requests.Request;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;

/**
 * Thread del server che gestisce la comunicazione con un singolo client.
 * Utilizza la classe {@link DataIO} per inviare e ricevere dati tramite socket,
 * e instrada le richieste dei client tramite {@link RequestCoRFacade}.
 */
public class ServerThread extends Thread {

    /**
     * Socket associata al client.
     */
    private Socket socket = null;

    /**
     * Costruisce un nuovo thread per gestire un client specifico.
     * @param socket la socket di comunicazione con il client
     */
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    /**
     * Invia un oggetto al client tramite la socket.
     * @param data oggetto da inviare al client
     * @throws IOException se si verifica un errore di I/O durante l'invio
     */
    public void sendData(Object data) throws IOException {
        DataIO dataIO = new DataIO(socket);
        dataIO.sendData(data);
    }

    /**
     * Riceve dati dal client tramite la socket.
     * @return la stringa letta dal client
     * @throws IOException se si verifica un errore di I/O durante la lettura
     */
    public String getData() throws IOException {
        DataIO dataIO = new DataIO(socket);

        return dataIO.getRawData();

    }

    /**
     * Metodo principale eseguito dal thread.
     * Continua a leggere dati dal client finché la connessione è attiva,
     * instradando ogni richiesta al {@link RequestCoRFacade}.
     */
    @Override
    public void run(){
        boolean didRead;
        do {
            try {
                didRead = serverInfiniteRead();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } while (didRead);
    }

    /**
     * Effettua una lettura continua dei dati provenienti dal client.
     * Legge una richiesta JSON dal client, la converte in {@link RequestPacket},
     * estrae il tipo di {@link Request} e la gestisce tramite il
     * {@link RequestCoRFacade}.
     * @return true se la lettura e l'elaborazione hanno successo, false in caso di errore
     * @throws SQLException se si verifica un errore durante l'esecuzione della query
     * @throws IOException  se si verifica un errore di I/O durante la lettura o scrittura
     */
    private boolean serverInfiniteRead() throws SQLException, IOException {
        String readData;

        try{
            readData = getData();

        } catch(Exception e) {
            return false;
        }
        System.out.println(readData);

        Gson gson = new Gson();
        RequestPacket requestEnumAdapter = gson.fromJson(readData, RequestPacket.class);
        Request request = requestEnumAdapter.request;
        System.out.println("Richiesta ricevuta: " + request);
        RequestCoRFacade requestCoRFacade = RequestCoRFacade.getInstance();
        requestCoRFacade.handleRequest(request, socket);

        return true;
    }

}
