package Client.RequestCommand;

import Shared.GsonAdapters.CartPacket;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;

public class CheckoutRequestCommand extends AbstractRequestCommand<CartPacket, String> {
    @Override
    public String makeRequest(CartPacket cartPacket) throws SQLException, IOException {
        RequestPacket requestPacket = new RequestPacket(Request.USER_CHECKOUT);
        server.sendData(requestPacket);

        server.sendData(cartPacket);

        return server.getData(String.class);
    }
}