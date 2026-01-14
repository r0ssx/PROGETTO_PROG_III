package Server.QueryStrategy;

import Server.QueryCommand.AbstractQueryCommand;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Strategia di query per ottenere la lista dei prodotti di una specifica categoria.
 * Estende {@link AbstractQueryStrategy} e implementa i metodi concreti per
 * eseguire la query e convertire i risultati in una lista di {@link ProductQueryResult}.
 */
public class AdminGetCategoryProductListQuery extends AbstractQueryStrategy<String, List<ProductQueryResult>> {

    /**
     * Esegue la query SQL per ottenere tutti i prodotti di una determinata categoria.
     * @param params nome della categoria dei prodotti da recuperare
     * @return {@link ResultSet} contenente i prodotti della categoria
     * @throws SQLException se si verifica un errore durante la preparazione o esecuzione della query
     */
    @Override
    protected ResultSet concreteQuery(String params) throws SQLException {

        String query = "SELECT * From Prodotto WHERE categoria = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, params);

        ResultSet resultSet = statement.executeQuery();
        return resultSet;

    }

    /**
     * Converte il {@link ResultSet} ottenuto dalla query in una lista di {@link ProductQueryResult}.
     * @param resultSet {@link ResultSet} contenente i dati dei prodotti
     * @return lista di {@link ProductQueryResult} con i dati dei prodotti
     * @throws SQLException se si verifica un errore durante la lettura dei dati dal {@link ResultSet}
     */
    @Override
    protected List<ProductQueryResult> convertResultSet(ResultSet resultSet) throws SQLException {

        List<ProductQueryResult> queryResultObjectList = new ArrayList<>();

        while(resultSet.next()) {
            ProductQueryResult prodottiQueryResult = new ProductQueryResult();
            prodottiQueryResult.nome = resultSet.getString("nome");
            prodottiQueryResult.quantità_scorta = resultSet.getString("quantità_scorta");
            prodottiQueryResult.codice = resultSet.getString("codice");
            prodottiQueryResult.costo = resultSet.getString("costo");
            prodottiQueryResult.descrizione = resultSet.getString("descrizione");
            prodottiQueryResult.categoria = resultSet.getString("categoria");
            queryResultObjectList.add(prodottiQueryResult);
        }

        return queryResultObjectList;
    }




}
