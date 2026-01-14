package Server.QueryStrategy;

import Client.RequestCommand.AbstractRequestCommand;
import Server.QueryCommand.QueryResultObject.AdminGetTopSale;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Strategia di query utilizzata dagli amministratori per inserire raccomandazioni
 * nel database.
 * Estende {@link AbstractQueryStrategy} e implementa i metodi concreti per
 * eseguire l'inserimento di una raccomandazione e gestire il risultato.
 */
public class AdminRecommendsQuery extends AbstractQueryStrategy<AdminGetTopSale, Void>{

    /**
     * Esegue la query SQL per inserire una nuova raccomandazione nel database.
     * @param params oggetto {@link AdminGetTopSale} contenente le informazioni della raccomandazione
     * @return {@code null} poiché l'inserimento non restituisce risultati
     * @throws SQLException se si verifica un errore durante la preparazione o esecuzione della query
     */
    @Override
    protected ResultSet concreteQuery(AdminGetTopSale params) throws SQLException {
        String query = "INSERT INTO Raccomanda (EMAIL, CODICE, NOME_UTENTE) VALUES (?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, params.email);
        statement.setString(2, params.codice);
        statement.setString(3, params.nome_utente);
        statement.executeUpdate();

        return null;
    }


    /**
     * Converte il {@link ResultSet} ottenuto dalla query.
     * In questo caso non restituisce nulla, poiché l'inserimento non produce risultati.
     * @param resultSet {@link ResultSet} della query (sempre {@code null})
     * @return {@code null}
     * @throws SQLException mai lanciata in quanto non vi sono dati da leggere
     */
    @Override
    protected Void convertResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }
}
