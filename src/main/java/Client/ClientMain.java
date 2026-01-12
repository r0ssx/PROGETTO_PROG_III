package Client;

import Shared.GsonAdapters.RequestEnumAdapter;
import Server.QueryCommand.QueryResultObject.ProdottiQueryResult;
import Shared.DataIO;
import Shared.GsonAdapters.UserLoginPacket;
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

            DataIO dataIO = new DataIO(socket);
            dataIO.sendData(requestEnumAdapter);

            String result = dataIO.getData();
            Gson gson = new Gson();
            List<ProdottiQueryResult> list = gson.fromJson(result, List.class);
            System.out.println(list);

            Request request1 = Request.USER_LOGIN;
            RequestEnumAdapter requestEnumAdapter1 = new RequestEnumAdapter();
            requestEnumAdapter1.request = request1;

            dataIO.sendData(requestEnumAdapter1);

            UserLoginPacket packet = new UserLoginPacket();
            packet.email = "luca.deluca@mail.com";
            packet.password = "delulu90";
            dataIO.sendData(packet);

            String result1 = dataIO.getData();
            Boolean bool = gson.fromJson(result1, Boolean.class);
            System.out.println(bool);

            //chiudo la connessione
            socket.close();

        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
