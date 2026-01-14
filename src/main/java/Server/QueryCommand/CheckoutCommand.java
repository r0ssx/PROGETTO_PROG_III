package Server.QueryCommand;

import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.CheckoutQuery;
import Shared.GsonAdapters.CartPacket;

import java.sql.SQLException;

public class CheckoutCommand extends AbstractQueryCommand<CartPacket, String>{
    public CheckoutCommand() throws SQLException {
    }

    @Override
    public String execute(CartPacket params) throws SQLException {
        AbstractQueryStrategy command = new CheckoutQuery();
        return (String) command.executeQuery(params);
    }
}
