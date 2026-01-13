package Server.QueryCommand;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Server.QueryStrategy.GetProductListQuery;
import Server.QueryStrategy.AbstractQueryStrategy;

import java.sql.SQLException;
import java.util.List;

public class GetProductListCommand extends AbstractQueryCommand<Void, List<ProductQueryResult>> {

    public GetProductListCommand() throws SQLException {
    }

    @Override
    public List<ProductQueryResult> execute(Void params) throws SQLException {
        AbstractQueryStrategy query = new GetProductListQuery();

        return (List<ProductQueryResult>) query.executeQuery(null);

    }
}
