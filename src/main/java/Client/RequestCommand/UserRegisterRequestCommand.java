package Client.RequestCommand;

import Shared.GsonAdapters.AuthPacket;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;

public class UserRegisterRequestCommand extends AbstractRequestCommand<AuthPacket, Boolean> {

    @Override
    public Boolean makeRequest(AuthPacket authPacket) throws SQLException, IOException {
        RequestPacket requestPacket = new RequestPacket(Request.USER_REGISTER);
        server.sendData(requestPacket);

        server.sendData(authPacket);

        return server.getData(Boolean.class);
    }
}
