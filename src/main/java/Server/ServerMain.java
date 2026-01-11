package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Classe principale del server.
 *
 * Si occupa dell'avvio del server e dell'ascolto delle connessioni
 * dei client sulla porta specificata.
 */
public class ServerMain {

    /**
     * ServerSocket utilizzata per accettare le connessioni dei client.
     */
    private static ServerSocket serverSocket;

    /**
     * Metodo main dell'applicazione server.
     *
     * Avvia il server sulla porta 9000 e crea un nuovo {@link ServerThread}
     * per ogni client che si connette.
     *
     * @param args argomenti da linea di comando (non utilizzati)
     */
    public static void main(String[] args){
        {
            try {
                //crea una server socket
                serverSocket = new ServerSocket(9000);
                System.out.println("Waiting for client connection...");

                while(true){
                    new ServerThread(serverSocket.accept()).start();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            finally {
                stop();
            }
        }
    }

    /**
     * Chiude la ServerSocket e arresta il server.
     */
    public static void stop() {
        try{
            serverSocket.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
