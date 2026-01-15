package Server.QueryCommand;

import Server.QueryCommand.QueryResultObject.AdminGetTopSale;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Server.QueryStrategy.AdminGetCategoryProductListQuery;
import Server.QueryStrategy.AdminGetTopSaleQuery;
import Server.QueryStrategy.AdminRecommendsQuery;
import Shared.GsonAdapters.RecommendPacket;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * Command per gestire le raccomandazioni dell'amministratore.
 *
 * Estende {@link AbstractQueryCommand} e prende in input un {@link RecommendPacket}.
 * Esegue il processo di selezione di un prodotto da raccomandare in base
 * alla categoria preferita dell'utente e registra la raccomandazione nel database.
 */
public class AdminRecommendsCommand extends AbstractQueryCommand<RecommendPacket, Void>{

    /**
     * Costruttore che può generare {@link SQLException} se ci sono problemi di connessione.
     *
     * @throws SQLException se si verifica un errore nella configurazione della connessione
     */
    public AdminRecommendsCommand() throws SQLException {
    }

    /**
     * Esegue il comando di raccomandazione.
     *
     * 1. Ottiene la categoria più acquistata dall'utente.
     * 2. Recupera la lista dei prodotti di quella categoria.
     * 3. Seleziona un prodotto casuale dalla lista.
     * 4. Inserisce la raccomandazione nel database.
     *
     * @param params pacchetto {@link RecommendPacket} contenente email e nome utente
     * @return sempre null
     * @throws SQLException se si verifica un errore durante le query sul database
     */
    @Override
    public Void execute(RecommendPacket params) throws SQLException {

        //ottieni la categoria preferita dall'utente
        AdminGetTopSaleQuery adminGetTopSaleQuery = new AdminGetTopSaleQuery();
        String topCategory = adminGetTopSaleQuery.executeQuery(params.email);
        System.out.println("La categoria top è: " + topCategory);

        //ottieni una lista di prodotti di quella categoria
        AdminGetCategoryProductListQuery adminGetCategoryProductListQuery = new AdminGetCategoryProductListQuery();
        List<ProductQueryResult> listQuery = adminGetCategoryProductListQuery.executeQuery(topCategory);
        System.out.println(listQuery);

        //prendi un prodotto in quella lista
        Random random = new Random();
        int i = random.nextInt(listQuery.size());
        ProductQueryResult toRecommend = listQuery.get(i);

        //inserisci la raccomandazione
        AdminRecommendsQuery adminRecommendsQuery = new AdminRecommendsQuery();
        AdminGetTopSale adminGetTopSale = new AdminGetTopSale();
        adminGetTopSale.codice = toRecommend.codice;
        adminGetTopSale.email = params.email;
        adminGetTopSale.nome_utente = params.nome_utente;
        adminRecommendsQuery.executeQuery(adminGetTopSale);

        return null;
    }
}
