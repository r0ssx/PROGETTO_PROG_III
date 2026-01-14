package Client.RequestCommand;

import Client.SingletonServerFacade;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Classe astratta che rappresenta un comando di richiesta verso il server.
 * Implementa il pattern Command e fornisce una struttura generica
 * per l'invio di richieste al server tramite il {@link SingletonServerFacade}.
 * @param <Input>  tipo dell'input della richiesta
 * @param <Output> tipo dell'output restituito dal server
 */
public abstract class AbstractRequestCommand <Input, Output> {

    /**
     * Facade singleton utilizzata per la comunicazione con il server.
     */
    protected SingletonServerFacade server;

    /**
     * Costruttore della classe.
     * Inizializza la facade del server.
     */
    public AbstractRequestCommand() {
        server = SingletonServerFacade.getInstance();
    }

    /**
     * Invia una richiesta al server utilizzando i dati forniti in input.
     * Le sottoclassi devono implementare la logica specifica della richiesta.
     * @param input dati di input necessari per la richiesta
     * @return risposta del server
     * @throws SQLException se si verifica un errore di accesso al database
     * @throws IOException se si verifica un errore di comunicazione
     */
    public abstract Output makeRequest(Input input) throws SQLException, IOException;
}
