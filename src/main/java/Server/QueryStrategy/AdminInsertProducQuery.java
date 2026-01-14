package Server.QueryStrategy;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Strategia di query utilizzata dagli amministratori per inserire un nuovo prodotto nel database.
 * Estende {@link AbstractQueryStrategy} e implementa i metodi concreti per
 * inserire il prodotto e verificare l'inserimento.
 */
public class AdminInsertProducQuery extends AbstractQueryStrategy<ProductQueryResult, Boolean>{

    /**
     * Esegue la query SQL per inserire un nuovo prodotto nel database.
     * @param params oggetto {@link ProductQueryResult} contenente i dati del prodotto da inserire
     * @return {@link ResultSet} contenente il prodotto appena inserito
     * @throws SQLException se si verifica un errore durante la preparazione o esecuzione della query
     */
    @Override
    protected ResultSet concreteQuery(ProductQueryResult params) throws SQLException {
        String query = "INSERT INTO dbprog3.prodotto (nome, quantità_scorta, codice, costo, descrizione, categoria)\n" +
                "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, params.nome);
        statement.setString(2, params.quantità_scorta);
        statement.setString(3, params.codice);
        statement.setString(4, params.costo);
        statement.setString(5, params.descrizione);
        statement.setString(6, params.categoria);

        statement.executeUpdate();

        String query2 = "SELECT * FROM Prodotto WHERE prodotto.codice = ?";
        PreparedStatement statement1 = connection.prepareStatement(query2);
        statement1.setString(1, params.codice);

        ResultSet resultSet = statement1.executeQuery();

        return resultSet;
    }

    /**
     * Converte il {@link ResultSet} ottenuto dalla query in un {@link Boolean}
     * che indica se il prodotto è stato inserito correttamente.
     * @param resultSet {@link ResultSet} contenente il prodotto inserito
     * @return {@code true} se il prodotto esiste nel database, {@code false} altrimenti
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
