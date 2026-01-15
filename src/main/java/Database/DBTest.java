package Database;

import Server.QueryCommand.*;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBTest {
    public static void main(String[] args){

// Ottiene l'istanza del singleton del database
        SingletonDB db = SingletonDB.getInstance();
        db.config(DBConfig.URL, DBConfig.user, DBConfig.password);
        Connection connection= null;

        // Prova a creare una connessione al database
        try{
            connection = db.createConnection();
        } catch(SQLException e){
            e.printStackTrace();
        }

        // Esegue il comando di query se la connessione è valida
        try {
            if (connection != null) {
                AbstractQueryCommand queryCommand = new GetProductListCommand();

                List<ProductQueryResult> prodottiQueryResults = (List<ProductQueryResult>) queryCommand.execute(null);

                // Stampa dei risultati
                prodottiQueryResults.forEach(System.out::println);
                  }else {
                    System.out.println("Not Connected...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
