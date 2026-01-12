package Client;

import Shared.GsonAdapters.RequestEnumAdapter;
import Server.QueryCommand.QueryResultObject.ProdottiQueryResult;
import Shared.DataIO;
import Shared.Requests.Request;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientMain {

    public static void main(String[] args) {
        try {
            //crea una socket per la connessione al server
            Socket socket = new Socket("localhost", 9000);
            Request request = Request.GET_PRODUCT_LIST;
            RequestEnumAdapter requestEnumAdapter = new RequestEnumAdapter();
            requestEnumAdapter.request = request;

            Gson gson = new Gson();

            DataIO dataIO = new DataIO(socket);
            dataIO.sendData(gson.toJson(requestEnumAdapter));

            String result = dataIO.getData();
            List<ProdottiQueryResult> list = gson.fromJson(result, List.class);
            System.out.println(list);

            //chiudo la connessione
            socket.close();

        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
