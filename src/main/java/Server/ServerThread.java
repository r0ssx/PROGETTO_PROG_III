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
 *
 * Utilizza la classe {@link DataIO} per l'invio e la ricezione dei dati
 * tramite socket.
 */
public class ServerThread extends Thread {

    /**
     * Socket associata al client.
     */
    private Socket socket = null;

    /**
     * Costruttore della classe ServerThread.
     *
     * @param socket la socket di comunicazione con il client
     */
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    /**
     * Invia un oggetto al client tramite la socket.
     *
     * @param data oggetto da inviare
     * @throws IOException se si verifica un errore di I/O durante l'invio
     */
    public void sendData(Object data) throws IOException {
        DataIO dataIO = new DataIO(socket);
        dataIO.sendData(data);
    }

    /**
     * Riceve una stringa JSON dal client tramite la socket.
     *
     * @return la stringa letta dalla socket
     * @throws IOException se si verifica un errore di I/O durante la lettura
     */
    public String getData() throws IOException {
        DataIO dataIO = new DataIO(socket);

        return dataIO.getRawData();

    }

    /**
     * Metodo eseguito dal thread.
     * Continua a leggere dati dal client finché la comunicazione è attiva.
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
     *
     * @return true se la lettura ha successo, false in caso di errore
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
