package Server.QueryStrategy;

import Shared.GsonAdapters.AuthPacket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Strategia di query per registrare un nuovo utente nel database.
 * Estende {@link AbstractQueryStrategy} e implementa i metodi concreti per
 * inserire un nuovo utente nella tabella {@code Utente} e verificare se l'inserimento è avvenuto correttamente.
 */
public class UserRegisterQuery extends AbstractQueryStrategy<AuthPacket, Integer>{

    /**
     * Esegue la query SQL per inserire un nuovo utente nel database.
     * @param params oggetto {@link AuthPacket} contenente l'email e la password dell'utente
     * @return {@link ResultSet} contenente l'utente appena inserito
     * @throws SQLException se si verifica un errore durante la preparazione o esecuzione della query
     */
    @Override
    protected ResultSet concreteQuery(AuthPacket params) throws SQLException {
        String query = "INSERT INTO Utente (email, password) VALUES (?, ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, params.id);
        statement.setString(2, params.password);
        statement.executeUpdate();

        String query2 = "SELECT * FROM Utente WHERE email = ?";
        PreparedStatement statement2 = connection.prepareStatement(query2);
        statement2.setString(1, params.id);

        ResultSet resultSet = statement2.executeQuery();


        return resultSet;
    }

    /**
     * Converte il {@link ResultSet} ottenuto dalla query in un numero intero
     * rappresentante il numero di righe inserite nel database (0 se non inserito, >0 se inserito).
     * @param resultSet {@link ResultSet} della query
     * @return numero di righe inserite (intero)
     * @throws SQLException se si verifica un errore durante la lettura dei dati dal {@link ResultSet}
     */
    @Override
    protected Integer convertResultSet(ResultSet resultSet) throws SQLException {
        Integer queryResult = 0;
        while (resultSet.next()){
            queryResult++;
        }
        return queryResult;
    }
}
