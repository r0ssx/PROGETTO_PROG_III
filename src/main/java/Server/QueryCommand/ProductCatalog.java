package Server.QueryCommand;
import Server.QueryCommand.QueryResultObject.ProdottiQueryResult;
import Server.QueryStrategy.GetProductListQuery;
import Server.QueryStrategy.QueryStrategy;

import java.sql.SQLException;
import java.util.List;

public class ProductCatalog extends QueryCommand<Void, List<ProdottiQueryResult>> {

    public ProductCatalog() throws SQLException {
    }

    @Override
    public List<ProdottiQueryResult> execute(Void params) throws SQLException {
        QueryStrategy query = new GetProductListQuery();

        return (List<ProdottiQueryResult>) query.executeQuery(null);

    }
}
