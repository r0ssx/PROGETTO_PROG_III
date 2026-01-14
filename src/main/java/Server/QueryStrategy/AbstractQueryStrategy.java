package Server.QueryStrategy;

import Database.SingletonDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe astratta che definisce la strategia per l'esecuzione di query sul database.
 * Fornisce il template method {@link #executeQuery(Object)} che gestisce la connessione,
 * l'esecuzione della query concreta e la conversione del {@link ResultSet} in un risultato
 * di tipo generico.
 * @param <Param> tipo dei parametri di input della query
 * @param <Res> tipo del risultato restituito dalla query
 */
public abstract class AbstractQueryStrategy<Param,Res>{

    /**
     * Singleton per l'accesso al database.
     */
    protected SingletonDB db;

    /**
     * Connessione al database utilizzata durante l'esecuzione della query.
     */
    protected Connection connection;

    /**
     * Costruttore che inizializza l'accesso al database tramite {@link SingletonDB}.
     */
    public AbstractQueryStrategy(){
        db = SingletonDB.getInstance();
    }

    /**
     * Esegue la query concreta sul database.
     * Le sottoclassi devono implementare questo metodo per specificare la query SQL da eseguire.
     * @param params parametri necessari per eseguire la query
     * @return {@link ResultSet} risultante dall'esecuzione della query
     * @throws SQLException se si verifica un errore durante l'esecuzione della query
     */
    protected abstract ResultSet concreteQuery(Param params) throws SQLException;

    /**
     * Converte il {@link ResultSet} ottenuto dalla query in un risultato di tipo {@code Res}.
     * Le sottoclassi devono implementare questo metodo per mappare i dati del {@link ResultSet}
     * negli oggetti del dominio.
     * @param resultSet {@link ResultSet} ottenuto dall'esecuzione della query
     * @return risultato convertito di tipo {@code Res}
     * @throws SQLException se si verifica un errore durante la conversione del {@link ResultSet}
     */
    protected abstract Res convertResultSet(ResultSet resultSet) throws SQLException;

    /**
     * Metodo template che gestisce l'intero flusso di esecuzione di una query.
     * Apre la connessione, esegue la query concreta tramite {@link #concreteQuery(Object)},
     * converte il {@link ResultSet} con {@link #convertResultSet(ResultSet)} e chiude la connessione.
     * @param params parametri necessari per eseguire la query
     * @return risultato della query di tipo {@code Res}
     * @throws SQLException se si verifica un errore durante la connessione o l'esecuzione della query
     */
    public Res executeQuery(Param params) throws SQLException {

        connection = db.createConnection();
        ResultSet resultSet = concreteQuery(params);
        Res res = convertResultSet(resultSet);
        connection.close();

        return res;
    }


}
