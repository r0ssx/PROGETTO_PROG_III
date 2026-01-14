package Client;

import Client.RequestCommand.*;
import Server.QueryCommand.AdminInsertProductCommand;
import Server.QueryCommand.QueryResultObject.AdminGetSalesQueryResult;
import Shared.GsonAdapters.RecommendPacket;
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


            // Admin login
            AbstractRequestCommand adminLoginRequest = new AdminLoginRequestCommand();
            Boolean adminLoginResult = (Boolean) adminLoginRequest.makeRequest(new AuthPacket("marty_mcfly", "grande_giove85"));
            System.out.println("Stato Login: "+ adminLoginResult);


            // Admin get sales by category
            AbstractRequestCommand adminGetSalesRequest = new AdminGetSalesRequestCommand();
            List<AdminGetSalesQueryResult> adminGetSalesresult = (List<AdminGetSalesQueryResult>) adminGetSalesRequest.makeRequest(null);
            System.out.println(adminGetSalesresult);


            // User register
            AbstractRequestCommand userRegisterRequest = new UserRegisterRequestCommand();
            Boolean userRegisterResult = (Boolean) userRegisterRequest.makeRequest(new AuthPacket("federica.deamicis@mail.com", "winx37"));
            System.out.println("Stato Register: "+ userRegisterResult);

            //Admin get user top sale
            AbstractRequestCommand adminGetTopSaleRequest = new AdminGetTopSaleRequestCommand();
            String adminGetTopSaleResult = (String) adminGetTopSaleRequest.makeRequest("federica.deamicis@mail.com");
            System.out.println(adminGetTopSaleResult);

//            //Admin recommends
//            AbstractRequestCommand adminRecommendsRequest = new AdminRecommendsRequestCommand();
//            adminRecommendsRequest.makeRequest(new RecommendPacket( "federica.deamicis@mail.com", "marty_mcfly"));

            AbstractRequestCommand getRecommendations = new GetRecommendationsCommand();
            List<ProductQueryResult> getreclist = (List<ProductQueryResult>) getRecommendations.makeRequest("federica.deamicis@mail.com");
            System.out.println(getreclist);

            //Admin insert product
            ProductQueryResult prodottoNuovo = new ProductQueryResult();
            prodottoNuovo.nome = "Detergente Viso";
            prodottoNuovo.quantità_scorta = "3";
            prodottoNuovo.codice = "DT67891";
            prodottoNuovo.costo = "15";
            prodottoNuovo.descrizione = "Detergente Viso per pelli delicate";
            prodottoNuovo.categoria = "Bellezza";
            AbstractRequestCommand adminInsertProductRequest = new AdminInsertProductRequestCommand();
            Boolean insert = (Boolean) adminInsertProductRequest.makeRequest(prodottoNuovo);
            System.out.println(insert);

            //Admin modify product
            ProductQueryResult prodottoNuovo2 = new ProductQueryResult();
            prodottoNuovo2.nome = "Detergente Viso Idratante";
            prodottoNuovo2.quantità_scorta = "3";
            prodottoNuovo2.codice = "DT67891";
            prodottoNuovo2.costo = "15";
            prodottoNuovo2.descrizione = "Detergente Viso per pelli delicate";
            prodottoNuovo2.categoria = "Bellezza";
            AbstractRequestCommand adminModify= new AdminModifyProductRequestCommand();
            Boolean modify = (Boolean) adminModify.makeRequest(prodottoNuovo2);
            System.out.println(modify);


            //chiudo la connessione
            server.disconnect();

        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
