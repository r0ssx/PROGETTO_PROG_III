package Database;

import Server.QueryCommand.*;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;


import java.sql.Connection;
import java.sql.SQLException;
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
                AbstractQueryCommand queryCommand = new GetProductListCommand();

                List<ProductQueryResult> prodottiQueryResults = (List<ProductQueryResult>) queryCommand.execute(null);

                prodottiQueryResults.forEach(System.out::println);
                  }else {
                    System.out.println("Not Connected...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
