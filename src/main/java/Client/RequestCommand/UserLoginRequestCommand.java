package Client.RequestCommand;

import Shared.GsonAdapters.AuthPacket;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;

public class UserLoginRequestCommand extends AbstractRequestCommand<AuthPacket, Boolean> {
    @Override
    public Boolean makeRequest(AuthPacket authPacket) throws SQLException, IOException {
        // Sending request
        RequestPacket requestPacket = new RequestPacket(Request.USER_LOGIN);
        server.sendData(requestPacket);

        // Sending request parameters
        server.sendData(authPacket);

        // Getting result back
        return server.getData(Boolean.class);
    }
}
