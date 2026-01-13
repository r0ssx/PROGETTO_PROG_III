package Client;

import Client.RequestCommand.AbstractRequestCommand;
import Client.RequestCommand.GetProductListRequestCommand;
import Client.RequestCommand.UserLoginRequestCommand;
import Server.QueryCommand.QueryResultObject.AdminGetSalesQueryResult;
import Shared.GsonAdapters.RequestPacket;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Shared.DataIO;
import Shared.GsonAdapters.AuthPacket;
import Shared.Requests.Request;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

public class ClientMain {
    public static void main(String[] args) throws SQLException {
        try {
            // Inizializza il server
            SingletonServerFacade server = SingletonServerFacade.getInstance();
            server.config("localhost", 9000);
            server.connect();

            // Get product
            AbstractRequestCommand getProductRequest = new GetProductListRequestCommand();
            List<ProductQueryResult> productQueryResultList = (List<ProductQueryResult>) getProductRequest.makeRequest(null);
            System.out.println(productQueryResultList);

            // User login
            AbstractRequestCommand userLoginRequest = new UserLoginRequestCommand();
            Boolean userLoginResult = (Boolean) userLoginRequest.makeRequest(new AuthPacket("federica.deamicis@mail.com", "winx37"));
            System.out.println("Stato login: " + userLoginResult);

            /*
            // Admin login
            Request request2 = Request.ADMIN_LOGIN;
            RequestPacket requestEnumAdapter2 = new RequestPacket();
            requestEnumAdapter2.request = request2;

            dataIO.sendData(requestEnumAdapter2);

            AuthPacket packet1 = new AuthPacket();
            packet1.id = "marty_mcfly";
            packet1.password = "grande_giove85";
            dataIO.sendData(packet1);

            Gson gson = new Gson();
            String result2 = dataIO.getRawData();
            Boolean bool1 = gson.fromJson(result2, Boolean.class);
            System.out.println(bool1);

            // Admin get sales by category
            Request request3 = Request.ADMIN_GET_SALES;
            RequestPacket requestEnumAdapter3 = new RequestPacket();
            requestEnumAdapter3.request = request3;

            dataIO.sendData(requestEnumAdapter3);

            String result3 = dataIO.getRawData();
            List<AdminGetSalesQueryResult> list1 = gson.fromJson(result3, List.class);
            System.out.println(list1);

            // User register
            Request request4 = Request.USER_REGISTER;
            RequestPacket requestEnumAdapter4 = new RequestPacket();
            requestEnumAdapter4.request = request4;

            dataIO.sendData(requestEnumAdapter4);

            AuthPacket packet4 = new AuthPacket();
            packet4.id = "forzanapol11@1926.it";
            packet4.password = "lukaku";
            dataIO.sendData(packet4);

            String result4 = dataIO.getRawData();
            Boolean bool4 = gson.fromJson(result4, Boolean.class);
            System.out.println(bool4);
*/
            //chiudo la connessione
            server.disconnect();

        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
