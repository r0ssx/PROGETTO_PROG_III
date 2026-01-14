package Server.RequestHandler;

import Server.QueryCommand.AbstractQueryCommand;
import Server.QueryCommand.AdminInsertProductCommand;
import Server.QueryCommand.AdminModifyProductCommand;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Shared.DataIO;
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

        DataIO dataIO = new DataIO(socket);
        ProductQueryResult prodotto = dataIO.getData(ProductQueryResult.class);

        AbstractQueryCommand commandCheck = new AdminInsertProductCommand();
        Boolean productInserted = (Boolean) commandCheck.execute(prodotto);

        if(productInserted){
            dataIO.sendData(productInserted);
        } else {
            AbstractQueryCommand command = new AdminModifyProductCommand();
            Boolean modify = (Boolean) command.execute(prodotto);

            dataIO.sendData(modify);
        }





    }
}
