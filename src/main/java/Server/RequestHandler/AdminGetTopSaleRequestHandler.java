package Server.RequestHandler;

import Server.QueryCommand.AbstractQueryCommand;
import Server.QueryCommand.AdminGetTopSaleCommand;
import Shared.DataIO;
import Shared.Requests.Request;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class AdminGetTopSaleRequestHandler extends AbstractRequestHandler{

    /**
     * Costruisce un handler associato a uno specifico tipo di richiesta.
     *
     * @param request il tipo di {@link Request} che questo handler può gestire
     */
    public AdminGetTopSaleRequestHandler(Request request) {
        super(request);
    }

    @Override
    public void handleRequest(Request request, Socket socket) throws SQLException, IOException {
        System.out.println("Chiamata handleRequest di AdminGetTopSaleRequestHandler");
        AbstractQueryCommand queryCommand = new AdminGetTopSaleCommand();
        DataIO dataIO = new DataIO(socket);
        String readData = dataIO.getData(String.class);
        System.out.println(readData);
        String result = (String) queryCommand.execute(readData);

        dataIO.sendData(result);



    }
}
