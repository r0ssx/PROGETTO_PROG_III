package Client.Controllers;

import Client.RequestCommand.AdminLoginRequestCommand;
import Client.RequestCommand.UserLoginRequestCommand;
import Shared.GsonAdapters.AuthPacket;

import java.io.IOException;
import java.sql.SQLException;

public class AdminLoginController extends AuthController {

    AdminLoginController() {
        errorMessageString = "L'admin non esiste o la password è errata.";
    }

    @Override
    protected Boolean performAuth(AuthPacket authPacket) throws SQLException, IOException {
        AdminLoginRequestCommand command = new AdminLoginRequestCommand();
        return command.makeRequest(authPacket);
    }

    @Override
    protected void changeScene() {

    }
}
