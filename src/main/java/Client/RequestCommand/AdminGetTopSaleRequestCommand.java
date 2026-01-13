package Client.RequestCommand;

import Server.QueryCommand.AbstractQueryCommand;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;

public class AdminGetTopSaleRequestCommand extends AbstractRequestCommand<String, String>{


    @Override
    public String makeRequest(String s) throws SQLException, IOException {
        //Sending request
        RequestPacket requestPacket = new RequestPacket(Request.ADMIN_GET_USER_TOP_SALE);
        server.sendData(requestPacket);

        //Sending request parameters
        server.sendData(s);

        //Getting result back
        return server.getData(String.class);

    }
}
