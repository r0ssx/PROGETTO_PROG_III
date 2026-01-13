package Server.QueryCommand;

import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.AdminGetTopSaleQuery;

import java.sql.SQLException;

public class AdminGetTopSaleCommand extends AbstractQueryCommand<String, String>{

    public AdminGetTopSaleCommand() throws SQLException {
    }

    @Override
    public String execute(String params) throws SQLException {
        AbstractQueryStrategy query = new AdminGetTopSaleQuery();

        return (String) query.executeQuery(params);
    }
}
