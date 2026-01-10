package Database;

import QueryCommand.*;
import QueryCommand.QueryResultObject.ProdottiQueryResult;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SingletonDBTest {
    public static void main(String[] args){


        SingletonDB db = SingletonDB.getInstance();
        db.config(DBConfig.URL, DBConfig.user, DBConfig.password);
        Connection connection= null;

        try{
            connection = db.createConnection();
        } catch(SQLException e){
            e.printStackTrace();
        }

        try {
            if (connection != null) {
                QueryCommand queryCommand = new ProductCatalog();

                List<ProdottiQueryResult> prodottiQueryResults = queryCommand.execute();

                prodottiQueryResults.forEach(System.out::println);
                  }else {
                    System.out.println("Not Connected...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
