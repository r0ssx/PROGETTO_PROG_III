package Server.QueryStrategy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Strategia di query utilizzata per autenticare un amministratore.
 * Estende {@link AbstractQueryStrategy} e implementa i metodi concreti per
 * eseguire la query e ottenere la password dell'amministratore dal database.
 */
public class AdminLoginQuery extends AbstractQueryStrategy<String, String> {

    /**
     * Esegue la query SQL per ottenere la password di un amministratore.
     * @param params nome utente dell'amministratore
     * @return {@link ResultSet} contenente la password dell'amministratore
     * @throws SQLException se si verifica un errore durante la preparazione o esecuzione della query
     */
    @Override
    protected ResultSet concreteQuery(String params) throws SQLException {
        String query = "SELECT password FROM Amministratore WHERE nome_utente = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, params);

        ResultSet resultSet = statement.executeQuery();

        return resultSet;
    }

    /**
     * Converte il {@link ResultSet} ottenuto dalla query in una {@link String}
     * rappresentante la password dell'amministratore.
     * @param resultSet {@link ResultSet} contenente la password
     * @return password dell'amministratore, o stringa vuota se non trovata
     * @throws SQLException se si verifica un errore durante la lettura dei dati dal {@link ResultSet}
     */
    @Override
    protected String convertResultSet(ResultSet resultSet) throws SQLException {

        String queryResult = "";
        while(resultSet.next()){
            queryResult = resultSet.getString("password");
        }
        return queryResult;
    }
}
