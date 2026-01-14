package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe SingletonDB.
 * Gestisce la connessione a un database MySQL tramite JDBC
 * utilizzando il pattern Singleton.
 */
public class SingletonDB {

    /**
     * Istanza unica della classe SingletonDB.
     */
    private static SingletonDB instance;

    /**
     * URL JDBC del database.
     */
    private String URL;

    /**
     * Username del database.
     */
    private String user;

    /**
     * Password del database.
     */
    private String password;

    /**
     * Costruttore privato del Singleton.
     */
    private SingletonDB() {
    }

    /**
     * Restituisce l'istanza unica della classe.
     * @return istanza di SingletonDB
     */
    public static SingletonDB getInstance() {
        if (instance == null) {
            instance = new SingletonDB();
        }
        return instance;
    }

    /**
     * Configura i parametri di connessione al database.
     * @param URL URL JDBC del database
     * @param user nome utente del database
     * @param password password del database
     */
    public void config(String URL, String user, String password) {
        this.URL = URL;
        this.user = user;
        this.password = password;
    }

    /**
     * Crea una connessione JDBC al database configurato.
     * @return connessione al database
     * @throws SQLException se la connessione fallisce
     */
    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, user, password);
    }
}
