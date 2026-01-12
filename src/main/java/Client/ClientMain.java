package Client;

import Server.QueryCommand.QueryResultObject.AdminGetSalesQueryResult;
import Shared.GsonAdapters.RequestPacket;
import Server.QueryCommand.QueryResultObject.ProdottiQueryResult;
import Shared.DataIO;
import Shared.GsonAdapters.AuthPacket;
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
            RequestPacket requestEnumAdapter = new RequestPacket();
            requestEnumAdapter.request = request;

            DataIO dataIO = new DataIO(socket);
            dataIO.sendData(requestEnumAdapter);

            String result = dataIO.getData();
            Gson gson = new Gson();
            List<ProdottiQueryResult> list = gson.fromJson(result, List.class);
            System.out.println(list);

            Request request1 = Request.USER_LOGIN;
            RequestPacket requestEnumAdapter1 = new RequestPacket();
            requestEnumAdapter1.request = request1;

            dataIO.sendData(requestEnumAdapter1);

            AuthPacket packet = new AuthPacket();
            packet.id = "luca.deluca@mail.com";
            packet.password = "delulu90";
            dataIO.sendData(packet);

            String result1 = dataIO.getData();
            Boolean bool = gson.fromJson(result1, Boolean.class);
            System.out.println(bool);


            Request request2 = Request.ADMIN_LOGIN;
            RequestPacket requestEnumAdapter2 = new RequestPacket();
            requestEnumAdapter2.request = request2;

            dataIO.sendData(requestEnumAdapter2);

            AuthPacket packet1 = new AuthPacket();
            packet1.id = "marty_mcfly";
            packet1.password = "grande_giove85";
            dataIO.sendData(packet1);

            String result2 = dataIO.getData();
            Boolean bool1 = gson.fromJson(result2, Boolean.class);
            System.out.println(bool1);

            Request request3 = Request.ADMIN_GET_SALES;
            RequestPacket requestEnumAdapter3 = new RequestPacket();
            requestEnumAdapter3.request = request3;

            dataIO.sendData(requestEnumAdapter3);

            String result3 = dataIO.getData();
            List<AdminGetSalesQueryResult> list1 = gson.fromJson(result3, List.class);
            System.out.println(list1);

            Request request4 = Request.USER_REGISTER;
            RequestPacket requestEnumAdapter4 = new RequestPacket();
            requestEnumAdapter4.request = request4;

            dataIO.sendData(requestEnumAdapter4);

            AuthPacket packet4 = new AuthPacket();
            packet4.id = "forzanapol11@1926.it";
            packet4.password = "lukaku";
            dataIO.sendData(packet4);

            String result4 = dataIO.getData();
            Boolean bool4 = gson.fromJson(result4, Boolean.class);
            System.out.println(bool4);

            //chiudo la connessione
            socket.close();

        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
