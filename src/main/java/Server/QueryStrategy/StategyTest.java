package Server.QueryStrategy;

import Database.DBConfig;
import Database.SingletonDB;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;

import java.sql.SQLException;
import java.util.List;

public class StategyTest {
    public static void main(String[] args) throws SQLException {
        // Configurazione del database
        SingletonDB db = SingletonDB.getInstance();
        db.config(DBConfig.URL, DBConfig.user, DBConfig.password);

        // Creazione della strategia di query
        AbstractQueryStrategy queryStrategy = new GetProductListQuery();

        // Esecuzione della query e ottenimento dei risultati
        List<ProductQueryResult> queryResultObjectList = (List<ProductQueryResult>) queryStrategy.executeQuery(null);

        // Stampa dei risultati
        for (ProductQueryResult p : queryResultObjectList){
            System.out.println(p);
        }
    }
}
