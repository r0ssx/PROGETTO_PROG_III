package Client.Utilities;

import Shared.DataIO;

import java.io.IOException;
import java.net.Socket;

/**
 * Facade singleton per la comunicazione con il server.
 * Fornisce metodi per configurare, connettere e disconnettere
 * il client dal server, oltre a inviare e ricevere dati.
 */
public class SingletonServerFacade {

    /**
     * Istanza unica del singleton.
     */
    private static SingletonServerFacade instance;

    /**
     * Socket utilizzato per la comunicazione con il server.
     */
    private Socket socket;

    /**
     * Nome host del server.
     */
    private String hostname;

    /**
     * Porta del server.
     */
    private int port;

    /**
     * Costruttore privato per implementare il pattern Singleton.
     */
    private SingletonServerFacade(){}


    /**
     * Restituisce l'istanza unica del singleton.
     * @return istanza di {@link SingletonServerFacade}
     */
    public static SingletonServerFacade getInstance() {
        if (instance == null) {
            instance = new SingletonServerFacade();
        }
        return instance;
    }

    /**
     * Configura l'indirizzo e la porta del server.
     * @param hostname nome host o indirizzo IP del server
     * @param port porta del server
     */
    public void config(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    /**
     * Stabilisce una connessione con il server.
     * @throws IOException se la connessione non può essere stabilita
     */
    public void connect() throws IOException {
        this.socket = new Socket(this.hostname, this.port);
        System.out.println("Connected to " + hostname + ":" + port);
    }

    /**
     * Chiude la connessione con il server.
     * @throws IOException se si verifica un errore durante la chiusura del socket
     */
    public void disconnect() throws IOException {
        socket.close();
        System.out.println("Disconnected by the client.");
    }

    /**
     * Invia un oggetto al server tramite il socket.
     * @param data oggetto da inviare
     * @throws IOException se si verifica un errore durante l'invio dei dati
     */
    public void sendData(Object data) throws IOException {
        DataIO dataIO = new DataIO(socket);
        dataIO.sendData(data);
    }

    /**
     * Riceve un oggetto dal server e lo converte al tipo specificato.
     * @param classType classe dell'oggetto da ricevere
     * @param <T> tipo dell'oggetto atteso
     * @return oggetto ricevuto dal server
     * @throws IOException se si verifica un errore durante la ricezione dei dati
     */
    public <T> T getData(Class<T> classType) throws IOException {
        DataIO dataIO = new DataIO(socket);
        return dataIO.getData(classType);
    }

    /**
     * Riceve una stringa raw dal server.
     * @return stringa ricevuta dal server
     * @throws IOException se si verifica un errore durante la ricezione
     */

    public String getRawData() throws IOException {
        DataIO dataIO = new DataIO(socket);
        return dataIO.getRawData();
    }
}
