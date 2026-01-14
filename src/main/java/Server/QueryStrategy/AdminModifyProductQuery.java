package Server.QueryStrategy;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Strategia di query utilizzata dagli amministratori per modificare un prodotto esistente nel database.
 * Estende {@link AbstractQueryStrategy} e implementa i metodi concreti per
 * aggiornare i dati di un prodotto e verificare che l'aggiornamento sia avvenuto correttamente.
 */
public class AdminModifyProductQuery extends AbstractQueryStrategy<ProductQueryResult, Boolean>{

    /**
     * Esegue la query SQL per aggiornare i dati di un prodotto esistente.
     * @param params oggetto {@link ProductQueryResult} contenente i dati aggiornati del prodotto
     * @return {@link ResultSet} contenente il prodotto aggiornato
     * @throws SQLException se si verifica un errore durante la preparazione o esecuzione della query
     */
    @Override
    protected ResultSet concreteQuery(ProductQueryResult params) throws SQLException {
        String query = "UPDATE prodotto\n" +
                "SET nome = ?, quantità_scorta = ?, codice = ?, costo = ?, descrizione = ?, categoria = ?\n" +
                "WHERE codice = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, params.nome);
        statement.setString(2, params.quantità_scorta);
        statement.setString(3, params.codice);
        statement.setString(4, params.costo);
        statement.setString(5, params.descrizione);
        statement.setString(6, params.categoria);
        statement.setString(7, params.codice);

        statement.executeUpdate();

        String query2 = "SELECT * FROM Prodotto WHERE prodotto.codice = ?";
        PreparedStatement statement1 = connection.prepareStatement(query2);
        statement1.setString(1, params.codice);

        ResultSet resultSet = statement1.executeQuery();

        return resultSet;

    }

    /**
     * Converte il {@link ResultSet} ottenuto dalla query in un {@link Boolean}
     * che indica se il prodotto aggiornato esiste nel database.
     * @param resultSet {@link ResultSet} contenente il prodotto aggiornato
     * @return {@code true} se il prodotto esiste nel database dopo l'aggiornamento, {@code false} altrimenti
     * @throws SQLException se si verifica un errore durante la lettura dei dati dal {@link ResultSet}
     */
    @Override
    protected Boolean convertResultSet(ResultSet resultSet) throws SQLException {
        Boolean exists = false;
        while(resultSet.next()){
            exists = true;
        }
        return exists;
    }
}
