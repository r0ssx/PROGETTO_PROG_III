package Server.QueryStrategy;

import Database.DBConfig;
import Database.SingletonDB;
import Server.QueryCommand.QueryResultObject.ProdottiQueryResult;

import java.sql.SQLException;
import java.util.List;

public class StategyTest {

    public static void main(String[] args) throws SQLException {
        SingletonDB db = SingletonDB.getInstance();
        db.config(DBConfig.URL, DBConfig.user, DBConfig.password);
        AbstractQueryStrategy queryStrategy = new GetProductListQuery();

        List<ProdottiQueryResult> queryResultObjectList = (List<ProdottiQueryResult>) queryStrategy.executeQuery(null);
        for (ProdottiQueryResult p : queryResultObjectList){
            System.out.println(p);
        }
    }
}
