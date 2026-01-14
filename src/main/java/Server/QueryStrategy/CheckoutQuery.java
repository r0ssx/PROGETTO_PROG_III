package Server.QueryStrategy;

import Shared.GsonAdapters.CartPacket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

public class CheckoutQuery extends AbstractQueryStrategy <CartPacket, String> {
    private String idCarrello;

    @Override
    protected ResultSet concreteQuery(CartPacket params) throws SQLException {
        idCarrello = UUID.randomUUID().toString();
        LocalDateTime dateTime = LocalDateTime.now();

        String query = "INSERT INTO Acquistato (data, quantità_acquistata, metodo_pagamento, IDordine, email, codice, IDcarrello)\n" +
                "VALUES (?, ? , ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        for (String codiceProdotto : params.codici_prodotto) {
            String idOrdine = UUID.randomUUID().toString();

            statement.setObject(1, dateTime);
            statement.setString(2, params.quantità_acquistata);
            statement.setString(3, params.metodo_pagamento);
            statement.setString(4, idOrdine);
            statement.setString(5, params.email);
            statement.setString(6, codiceProdotto);
            statement.setString(7, idCarrello);
        }

        statement.executeUpdate();

        return null;
    }

    @Override
    protected String convertResultSet(ResultSet resultSet) throws SQLException {
        System.out.println("id carrello acquisti effettuati: " + idCarrello);
        return idCarrello;
    }
}
