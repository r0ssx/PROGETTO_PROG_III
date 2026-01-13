package Client.RequestCommand;

import Client.SingletonServerFacade;

import java.io.IOException;
import java.sql.SQLException;

public abstract class AbstractRequestCommand <Input, Output> {
    protected SingletonServerFacade server;

    public AbstractRequestCommand() {
        server = SingletonServerFacade.getInstance();
    }

    public abstract Output makeRequest(Input input) throws SQLException, IOException;
}
