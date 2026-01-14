package Client.Controllers;

import Client.RequestCommand.UserLoginRequestCommand;
import Client.RequestCommand.UserRegisterRequestCommand;
import Client.SingletonStage;
import Shared.GsonAdapters.AuthPacket;

import java.io.IOException;
import java.sql.SQLException;

public class UserRegisterController extends AuthController {

    UserRegisterController() {
        errorMessageString = "L'utente già esiste.";
    }

    @Override
    protected Boolean performAuth(AuthPacket authPacket) throws SQLException, IOException {
        UserRegisterRequestCommand command = new UserRegisterRequestCommand();
        return command.makeRequest(authPacket);
    }

    @Override
    protected void changeScene() throws IOException {
        SingletonStage.fastChangeScene("ListHome.fxml", "Home", new UserHomeController());
    }
}
