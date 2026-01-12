package Server.QueryCommand;

import Server.QueryCommand.QueryResultObject.AdminGetSalesQueryResult;
import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.AdminGetSalesQuery;

import java.sql.SQLException;
import java.util.List;

public class AdminGetSalesCommand extends AbstractQueryCommand<Void, List<AdminGetSalesQueryResult>>{

    public AdminGetSalesCommand() throws SQLException {
    }

    @Override
    public List<AdminGetSalesQueryResult> execute(Void params) throws SQLException {
        AbstractQueryStrategy query = new AdminGetSalesQuery();

        return (List<AdminGetSalesQueryResult>) query.executeQuery(null);
    }
}
