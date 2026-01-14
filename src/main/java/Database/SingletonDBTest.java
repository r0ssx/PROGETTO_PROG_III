package Database;

import Server.QueryCommand.*;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Classe di test per il Singleton del database.
 * Esegue una connessione al database e utilizza un comando di query
 * per ottenere la lista dei prodotti, stampando i risultati a console.
 */
public class SingletonDBTest {

    /**
     * Metodo principale per l'esecuzione del test.
     * Configura e crea una connessione al database tramite {@link SingletonDB},
     * quindi esegue il comando {@link GetProductListCommand} per recuperare
     * tutti i prodotti presenti nel database.
     * @param args argomenti della linea di comando (non utilizzati)
     */
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
