package Client.Controllers;

import Client.RequestCommand.UserLoginRequestCommand;
import Shared.GsonAdapters.AuthPacket;

import java.io.IOException;
import java.sql.SQLException;

public class UserLoginController extends AuthController {

    UserLoginController() {
        errorMessageString = "L'utente non esiste o la password è errata.";
    }

    @Override
    protected Boolean performAuth(AuthPacket authPacket) throws SQLException, IOException {
        UserLoginRequestCommand command = new UserLoginRequestCommand();
        return command.makeRequest(authPacket);
    }

    @Override
    protected void changeScene() {

    }
}
