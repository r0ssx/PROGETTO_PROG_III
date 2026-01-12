package Client;

import Server.QueryCommand.QueryResultObject.ProdottiQueryResult;
import Shared.DataIO;

import java.io.*;
import java.net.Socket;

public class ClientMain {

    public static void main(String[] args) {
        try {
            //crea una socket per la connessione al server
            Socket socket = new Socket("localhost", 9000);

            ProdottiQueryResult data = new ProdottiQueryResult();
            data.nome = "Mouse";
            data.quantità_scorta = "10";
            data.codice = "A01";
            data.costo = "20€";
            data.descrizione = "Mouse wireless";
            data.categoria = "Elettronica";

            DataIO dataIO = new DataIO(socket);
            dataIO.sendData(data);


            //chiudo la connessione
            socket.close();

        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
