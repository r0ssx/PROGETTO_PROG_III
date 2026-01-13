package Client.RequestCommand;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GetProductListRequestCommand extends AbstractRequestCommand<Void, List<ProductQueryResult>> {

    @Override
    public List<ProductQueryResult> makeRequest(Void unused) throws SQLException, IOException {
        RequestPacket requestPacket = new RequestPacket(Request.GET_PRODUCT_LIST);
        server.sendData(requestPacket);

        return server.getData(List.class);
    }
}
