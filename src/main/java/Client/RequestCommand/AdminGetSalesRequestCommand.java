package Client.RequestCommand;

import Server.QueryCommand.QueryResultObject.AdminGetSalesQueryResult;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminGetSalesRequestCommand extends AbstractRequestCommand<Void, List<AdminGetSalesQueryResult>>{

    @Override
    public List<AdminGetSalesQueryResult> makeRequest(Void unused) throws SQLException, IOException {
        RequestPacket requestPacket = new RequestPacket(Request.ADMIN_GET_SALES);
        server.sendData(requestPacket);

        return server.getData(List.class);
    }
}
