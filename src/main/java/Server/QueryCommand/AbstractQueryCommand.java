package Server.QueryCommand;

import Database.SingletonDB;

import java.sql.SQLException;

/**
 * Classe astratta che definisce la struttura di un comando di query al database.
 * Implementa il pattern Command per le query al database, fornendo un accesso
 * al {@link SingletonDB}. Ogni sottoclasse deve implementare il metodo {@link #execute(Object)}
 * per eseguire una query specifica.
 * @param <Param> tipo del parametro di input per la query
 * @param <Res> tipo del risultato restituito dalla query
 */
public abstract class AbstractQueryCommand<Param, Res> {

    /**
     * Singleton per l'accesso al database.
     */
    protected SingletonDB db;

    /**
     * Costruttore che inizializza l'accesso al database tramite {@link SingletonDB}.
     * @throws SQLException se la connessione al database non può essere inizializzata
     */
    public AbstractQueryCommand() throws SQLException {
        db = SingletonDB.getInstance();
    }

    /**
     * Esegue la query sul database.
     * @param params parametri necessari per eseguire la query
     * @return risultato della query
     * @throws SQLException se si verifica un errore durante l'esecuzione della query
     */
    public abstract Res execute(Param params) throws SQLException;
}
