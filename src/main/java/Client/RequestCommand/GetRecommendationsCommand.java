package Client.RequestCommand;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GetRecommendationsCommand extends AbstractRequestCommand<String, List<ProductQueryResult>> {

    @Override
    public List<ProductQueryResult> makeRequest(String s) throws SQLException, IOException {
        RequestPacket requestPacket = new RequestPacket(Request.GET_RECOMMENDATIONS);
        server.sendData(requestPacket);

        server.sendData(s);

        return server.getData(List.class);
    }
}
