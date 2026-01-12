package Server.RequestHandler;

import Exceptions.CoRException;
import Shared.Requests.Request;

public class CoRTest {

    public static void main(String[] args) {

        RequestCoRFacade requestCoRFacade = new RequestCoRFacade();

        Request[] enumRequest = {
                Request.GET_PRODUCT_LIST,
                Request.USER_LOGIN,
                Request.USER_REGISTER,
                Request.ADMIN_LOGIN,
                Request.ADMIN_INSERT_PRODUCT,
                Request.ADMIN_RECOMMENDS,
                Request.ADMIN_GET_SALES,
                Request.USER_CHECKOUT,
                //Request.TEST
        };

        for(Request richiesta : enumRequest){
            try {
                requestCoRFacade.handleRequest(richiesta);
            } catch (CoRException e) {
                e.printStackTrace();
            }
        }

    }
}
