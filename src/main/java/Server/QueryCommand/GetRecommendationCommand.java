package Server.QueryCommand;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.GetRecommendationQuery;

import javax.print.DocFlavor;
import java.sql.SQLException;
import java.util.List;

public class GetRecommendationCommand extends AbstractQueryCommand<String, List<ProductQueryResult>> {

    public GetRecommendationCommand() throws SQLException {
    }

    @Override
    public List<ProductQueryResult> execute(String params) throws SQLException {
        AbstractQueryStrategy query = new GetRecommendationQuery();
        return (List<ProductQueryResult>) query.executeQuery(params);
    }
}
