package Server.QueryStrategy;

import Database.DBConfig;
import Database.SingletonDB;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;

import java.sql.SQLException;
import java.util.List;

/**
 * Classe di test per verificare il funzionamento delle strategie di query lato server.
 * In particolare, utilizza {@link GetProductListQuery} per ottenere la lista dei prodotti dal database
 * e stampa i risultati sulla console.
 */
public class StategyTest {

    /**
     * Metodo principale della classe di test.
     * @param args argomenti della linea di comando (non utilizzati)
     * @throws SQLException se si verifica un errore nella connessione al database o nell'esecuzione della query
     */
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
