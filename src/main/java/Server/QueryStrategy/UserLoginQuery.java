package Server.QueryStrategy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Strategia di query per ottenere la password di un utente dal database
 * durante il processo di login.
 * Estende {@link AbstractQueryStrategy} e implementa i metodi concreti per
 * eseguire la query sulla tabella {@code Utente} e restituire la password associata all'email.
 */
public class UserLoginQuery extends AbstractQueryStrategy<String, String> {

    /**
     * Esegue la query SQL per ottenere la password di un utente dato l'email.
     * @param params email dell'utente
     * @return {@link ResultSet} contenente la password dell'utente
     * @throws SQLException se si verifica un errore durante la preparazione o esecuzione della query
     */
    @Override
    protected ResultSet concreteQuery(String params) throws SQLException {
        String query = "SELECT password FROM Utente WHERE email = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, params);

        ResultSet resultSet = statement.executeQuery();

        return resultSet;
    }

    /**
     * Converte il {@link ResultSet} ottenuto dalla query in una stringa contenente la password.
     * @param resultSet {@link ResultSet} della query
     * @return password dell'utente se presente nel database, altrimenti stringa vuota
     * @throws SQLException se si verifica un errore durante la lettura dei dati dal {@link ResultSet}
     */
    @Override
    protected String convertResultSet(ResultSet resultSet) throws SQLException {

        String queryResult = "";
        while (resultSet.next()){
            queryResult = resultSet.getString("password");
        }

        return queryResult;
    }
}
