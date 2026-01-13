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

public class AdminRecommendsCommand extends AbstractQueryCommand<RecommendPacket, Void>{

    public AdminRecommendsCommand() throws SQLException {
    }

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
