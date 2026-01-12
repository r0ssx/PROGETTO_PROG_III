package Server.QueryCommand;
import Server.QueryCommand.QueryResultObject.ProdottiQueryResult;
import Server.QueryStrategy.GetProductListQuery;
import Server.QueryStrategy.QueryStrategy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductCatalog extends QueryCommand<List<ProdottiQueryResult>> {

    public ProductCatalog() throws SQLException {
    }

    @Override
    public List<ProdottiQueryResult> execute() throws SQLException {
        QueryStrategy query = new GetProductListQuery();

        return (List<ProdottiQueryResult>) query.executeQuery(null);

    }
}
