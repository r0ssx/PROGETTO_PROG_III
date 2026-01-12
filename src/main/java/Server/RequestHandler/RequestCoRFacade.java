package Server.RequestHandler;

import Shared.Requests.Request;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

/**
 * Facade per la gestione della Chain of Responsibility (CoR)
 * degli {@link AbstractRequestHandler}.
 * Questa classe ha il compito di:
 *   <li>costruire la catena di handler</li>
 *   <li>mantenere il riferimento alla testa della catena</li>
 *   <li>delegare la gestione delle richieste alla Chain of Responsibility</li>
 * In questo modo il resto del sistema non deve conoscere
 * i dettagli di costruzione e collegamento della catena.
 */
public class RequestCoRFacade {

    private static RequestCoRFacade instance = new RequestCoRFacade();


    /**
     * Testa della Chain of Responsibility.
     * Tutte le richieste vengono inizialmente delegate a questo handler.
     */
    private AbstractRequestHandler chainHead;

    /**
     * Costruisce la Chain of Responsibility inizializzando
     * e collegando tutti gli handler disponibili nel sistema.
     * L'ordine degli handler nella catena riflette la priorità
     * con cui le richieste vengono valutate.
     */
    public RequestCoRFacade(){
        AbstractRequestHandler getProductList = new GetProductListHandler(Request.GET_PRODUCT_LIST);
        this.chainHead = getProductList;

        AbstractRequestHandler userLogin = new UserLoginHandler(Request.USER_LOGIN);
        getProductList.setNextHandler(userLogin);

        AbstractRequestHandler userRegister = new UserRegisterHandler(Request.USER_REGISTER);
        userLogin.setNextHandler(userRegister);

        AbstractRequestHandler adminLogin = new AdminLoginHandler(Request.ADMIN_LOGIN);
        userRegister.setNextHandler(adminLogin);

        AbstractRequestHandler adminInsertProduct = new AdminInsertProductHandler(Request.ADMIN_INSERT_PRODUCT);
        adminLogin.setNextHandler(adminInsertProduct);

        AbstractRequestHandler adminRecommends = new AdminRecommendsHandler(Request.ADMIN_RECOMMENDS);
        adminInsertProduct.setNextHandler(adminRecommends);

        AbstractRequestHandler adminGetSales = new AdminGetSalesHandler(Request.ADMIN_GET_SALES);
        adminRecommends.setNextHandler(adminGetSales);

        AbstractRequestHandler userCheckOut = new UserCheckOutHandler(Request.USER_CHECKOUT);
        adminGetSales.setNextHandler(userCheckOut);

    }

    /**
     * Delegata la gestione della richiesta alla Chain of Responsibility.
     * La richiesta viene inizialmente passata alla testa della catena,
     * che provvederà a gestirla o a delegarla agli handler successivi.
     * @param request la richiesta da gestire
     */
    public void handleRequest(Request request, Socket socket) throws SQLException, IOException {
        chainHead.handle(request, socket);
    }

    public static RequestCoRFacade getInstance() {
        return instance;
    }
}
