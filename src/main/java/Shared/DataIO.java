package Shared;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.List;

/**
 * Classe di supporto per la gestione dell'invio e della ricezione
 * di dati tramite socket.
 * I dati vengono serializzati in formato JSON prima dell'invio.
 */
public class DataIO {

    /**
     * Socket utilizzata per la comunicazione.
     */
    private Socket socket;


    /**
     * Costruttore della classe DataIO.
     *
     * @param socket la socket utilizzata per comunicare con il peer
     */
    public DataIO(Socket socket){
        this.socket = socket;
    }

    /**
     * Invia un oggetto serializzato in formato JSON attraverso la socket.
     *
     * @param data oggetto da inviare
     * @throws IOException se si verifica un errore di I/O durante l'invio
     */
    public void sendData(Object data) throws IOException {

        //serializza l'oggetto da inviare
        Gson gson = new Gson();
        String jsonToSend = gson.toJson(data);

        //ottieni il printWriter per inviare dati
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF(jsonToSend);
        dataOutputStream.flush();
    }

    /**
     * Riceve una stringa JSON dalla socket.
     * @return la stringa letta dalla socket
     * @throws IOException se si verifica un errore di I/O durante la lettura
     */
    public String getRawData() throws IOException {

        //ottieni l'input stream
        InputStream inputStream = socket.getInputStream();

        //ottieni il buffered reader per l'input stream
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        //legge dalla socket e la ritorna
        String recv = dataInputStream.readUTF();
        return recv;
    }

    public <T> T getData(Class<T> classType) throws IOException {
        String recv = this.getRawData();
        Gson gson = new Gson();
        return gson.fromJson(recv, classType);
    }
}
