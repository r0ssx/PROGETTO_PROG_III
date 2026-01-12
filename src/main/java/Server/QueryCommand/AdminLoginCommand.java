package Server.QueryCommand;

import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.AdminLoginQuery;

import java.sql.SQLException;

public class AdminLoginCommand extends AbstractQueryCommand<String, String> {

    public AdminLoginCommand() throws SQLException {
    }

    @Override
    public String execute(String params) throws SQLException {
        AbstractQueryStrategy query = new AdminLoginQuery();

        return (String) query.executeQuery(params);
    }





}
