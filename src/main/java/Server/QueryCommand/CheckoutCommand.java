package Server.QueryCommand;

import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.CheckoutQuery;
import Shared.GsonAdapters.CartPacket;

import java.sql.SQLException;

/**
 * Comando di query utilizzato per eseguire il checkout di un carrello utente.
 * Estende {@link AbstractQueryCommand} e utilizza {@link CheckoutQuery}
 * per processare il carrello e finalizzare l'acquisto nel database.
 */
public class CheckoutCommand extends AbstractQueryCommand<CartPacket, String>{

    /**
     * Costruttore che inizializza l'accesso al database.
     * @throws SQLException se si verifica un errore durante l'inizializzazione del database
     */
    public CheckoutCommand() throws SQLException {
    }

    /**
     * Esegue il checkout del carrello.
     * @param params oggetto {@link CartPacket} contenente i prodotti nel carrello
     * @return {@link String} contenente il risultato o messaggio dell'operazione di checkout
     * @throws SQLException se si verifica un errore durante l'esecuzione della query
     */
    @Override
    public String execute(CartPacket params) throws SQLException {
        AbstractQueryStrategy command = new CheckoutQuery();
        return (String) command.executeQuery(params);
    }
}
