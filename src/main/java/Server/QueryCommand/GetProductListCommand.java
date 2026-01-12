package Server.QueryCommand;
import Server.QueryCommand.QueryResultObject.ProdottiQueryResult;
import Server.QueryStrategy.GetProductListQuery;
import Server.QueryStrategy.AbstractQueryStrategy;

import java.sql.SQLException;
import java.util.List;

public class GetProductListCommand extends AbstractQueryCommand<Void, List<ProdottiQueryResult>> {

    public GetProductListCommand() throws SQLException {
    }

    @Override
    public List<ProdottiQueryResult> execute(Void params) throws SQLException {
        AbstractQueryStrategy query = new GetProductListQuery();

        return (List<ProdottiQueryResult>) query.executeQuery(null);

    }
}
