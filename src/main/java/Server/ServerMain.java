package Server;

import Database.DBConfig;
import Database.SingletonDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Classe principale del server.
 * Si occupa dell'avvio del server, della configurazione del database
 * e dell'ascolto delle connessioni dei client sulla porta specificata.
 * Per ogni client connesso viene creato un nuovo {@link ServerThread}.
 */
public class ServerMain {

    /**
     * ServerSocket utilizzata per accettare le connessioni dei client.
     */
    private static ServerSocket serverSocket;

    /**
     * Metodo principale dell'applicazione server.
     * Avvia il server sulla porta 9000, configura il database
     * e crea un nuovo {@link ServerThread} per ogni client che si connette.
     * Il server rimane in ascolto indefinitamente.
     * @param args argomenti da linea di comando (non utilizzati)
     */
    public static void main(String[] args){
        SingletonDB db = SingletonDB.getInstance();
        db.config(DBConfig.URL, DBConfig.user, DBConfig.password);

        try {
            // Crea una ServerSocket sulla porta 9000
            serverSocket = new ServerSocket(9001);
            System.out.println("Waiting for client connection...");

            // Loop infinito per accettare connessioni dai client
            while(true){
                new ServerThread(serverSocket.accept()).start();
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Ferma il server chiudendo la ServerSocket.
     * Questo metodo può essere usato per terminare l'esecuzione del server
     * in modo controllato.
     */
    public static void stop() {
        try{
            serverSocket.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
