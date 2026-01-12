package Server.QueryCommand;

import Server.QueryStrategy.QueryStrategy;
import Server.QueryStrategy.UserLoginQuery;

import java.sql.SQLException;

public class UserLoginCommand extends QueryCommand<String, String> {

    public UserLoginCommand() throws SQLException {
    }

    @Override
    public String execute(String params) throws SQLException {
        QueryStrategy query = new UserLoginQuery();

        return (String) query.executeQuery(params);
    }
}
