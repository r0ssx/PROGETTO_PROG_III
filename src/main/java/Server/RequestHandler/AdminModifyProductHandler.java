package Server.RequestHandler;

import Shared.Requests.Request;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class AdminModifyProductHandler extends AbstractRequestHandler{

    /**
     * Costruisce un handler associato a uno specifico tipo di richiesta.
     * @param request il tipo di {@link Request} che questo handler può gestire
     */
    public AdminModifyProductHandler(Request request) {
        super(request);
    }

    @Override
    public void handleRequest(Request request, Socket socket) throws SQLException, IOException {
        System.out.println("chiamata handleRequest di AdminModifyProductHandler");


    }
}
