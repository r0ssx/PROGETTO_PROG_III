package Server.QueryStrategy;

import Shared.GsonAdapters.CartPacket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Strategia di query utilizzata per gestire il checkout di un carrello.
 * Estende {@link AbstractQueryStrategy} e implementa i metodi concreti per
 * inserire gli acquisti effettuati nel database e restituire l'ID del carrello.
 */
public class CheckoutQuery extends AbstractQueryStrategy <CartPacket, String> {
    private String idCarrello;

    /**
     * Esegue la query SQL per inserire nel database tutti i prodotti acquistati
     * presenti in un carrello.
     * @param params oggetto {@link CartPacket} contenente i dettagli del carrello e dell'acquisto
     * @return {@link ResultSet} sempre {@code null} poiché l'inserimento non produce dati da restituire
     * @throws SQLException se si verifica un errore durante la preparazione o esecuzione della query
     */
    @Override
    protected ResultSet concreteQuery(CartPacket params) throws SQLException {
        idCarrello = UUID.randomUUID().toString();
        LocalDateTime dateTime = LocalDateTime.now();

        String query = "INSERT INTO Acquistato (data, quantità_acquistata, metodo_pagamento, IDordine, email, codice, IDcarrello)\n" +
                "VALUES (?, ? , ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        int i = 0;
        for (String codiceProdotto : params.codici_prodotto) {
            String idOrdine = UUID.randomUUID().toString();

            statement.setObject(1, dateTime);
            statement.setString(2, params.quantità_acquistata.get(i++));
            statement.setString(3, params.metodo_pagamento);
            statement.setString(4, idOrdine);
            statement.setString(5, params.email);
            statement.setString(6, codiceProdotto);
            statement.setString(7, idCarrello);
        }

        statement.executeUpdate();

        return null;
    }

    /**
     * Converte il {@link ResultSet} della query in un {@link String} rappresentante
     * l'ID del carrello degli acquisti effettuati.
     * @param resultSet {@link ResultSet} della query (sempre {@code null})
     * @return {@link String} contenente l'ID generato per il carrello
     * @throws SQLException mai lanciata in quanto non vi sono dati da leggere
     */
    @Override
    protected String convertResultSet(ResultSet resultSet) throws SQLException {
        System.out.println("id carrello acquisti effettuati: " + idCarrello);
        return idCarrello;
    }
}
