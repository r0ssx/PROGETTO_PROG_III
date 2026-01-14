package Server.QueryCommand;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.AdminInsertProducQuery;

import java.sql.SQLException;

public class AdminInsertProductCommand extends AbstractQueryCommand<ProductQueryResult, Boolean>{

    public AdminInsertProductCommand() throws SQLException {
    }

    @Override
    public Boolean execute(ProductQueryResult params) throws SQLException {
        AbstractQueryStrategy query = new AdminInsertProducQuery();

        return (Boolean) query.executeQuery(params);
    }
}
