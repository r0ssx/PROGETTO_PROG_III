package Server.QueryCommand;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.AdminModifyProductQuery;

import java.sql.SQLException;

public class AdminModifyProductCommand extends AbstractQueryCommand<ProductQueryResult, Boolean>{

    public AdminModifyProductCommand() throws SQLException {
    }

    @Override
    public Boolean execute(ProductQueryResult params) throws SQLException {
        AbstractQueryStrategy query = new AdminModifyProductQuery();

        return (Boolean) query.executeQuery(params);
    }
}
