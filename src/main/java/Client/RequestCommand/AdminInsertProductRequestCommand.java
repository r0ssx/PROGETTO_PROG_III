package Client.RequestCommand;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;

public class AdminInsertProductRequestCommand extends AbstractRequestCommand<ProductQueryResult, Boolean>{

    @Override
    public Boolean makeRequest(ProductQueryResult productQueryResult) throws SQLException, IOException {
        RequestPacket requestPacket = new RequestPacket(Request.ADMIN_INSERT_PRODUCT);
        server.sendData(requestPacket);

        server.sendData(productQueryResult);

        return server.getData(Boolean.class);
    }
}
