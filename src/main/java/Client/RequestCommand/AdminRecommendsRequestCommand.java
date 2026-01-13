package Client.RequestCommand;

import Shared.GsonAdapters.RecommendPacket;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;

public class AdminRecommendsRequestCommand extends AbstractRequestCommand<RecommendPacket, Void>{

    @Override
    public Void makeRequest(RecommendPacket recommendPacket) throws SQLException, IOException {
        //Sending request
        RequestPacket requestPacket = new RequestPacket(Request.ADMIN_RECOMMENDS);
        server.sendData(requestPacket);

        //Sending request parameters
        server.sendData(recommendPacket);

        return null;
    }
}
