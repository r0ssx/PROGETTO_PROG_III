package Server.QueryStrategy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Strategia di query per verificare se un utente esiste nel database.
 * Estende {@link AbstractQueryStrategy} e implementa i metodi concreti per
 * eseguire la query sulla tabella {@code Utente} e restituire l'email se presente.
 */
public class UserExistsQuery extends AbstractQueryStrategy<String, String>{

    /**
     * Esegue la query SQL per verificare se un utente con una determinata email esiste.
     * @param params email dell'utente da verificare
     * @return {@link ResultSet} contenente l'utente trovato (se presente)
     * @throws SQLException se si verifica un errore durante la preparazione o esecuzione della query
     */
    @Override
    protected ResultSet concreteQuery(String params) throws SQLException {
        String query = "SELECT * FROM Utente WHERE email = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, params);

        ResultSet resultSet = statement.executeQuery();
        return resultSet;
    }

    /**
     * Converte il {@link ResultSet} ottenuto dalla query in una stringa contenente l'email dell'utente.
     * @param resultSet {@link ResultSet} della query
     * @return email dell'utente se presente nel database, altrimenti stringa vuota
     * @throws SQLException se si verifica un errore durante la lettura dei dati dal {@link ResultSet}
     */
    @Override
    protected String convertResultSet(ResultSet resultSet) throws SQLException {

        String queryResult = "";
        while(resultSet.next()){
            queryResult = resultSet.getString("email");
        }
        return queryResult;
    }
}
