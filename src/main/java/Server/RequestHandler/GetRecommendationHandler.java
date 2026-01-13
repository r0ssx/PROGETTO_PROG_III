package Server.RequestHandler;

import Server.QueryCommand.AbstractQueryCommand;
import Server.QueryCommand.GetRecommendationCommand;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Shared.DataIO;
import Shared.Requests.Request;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

public class GetRecommendationHandler extends AbstractRequestHandler {
    /**
     * Costruisce un handler associato a uno specifico tipo di richiesta.
     *
     * @param request il tipo di {@link Request} che questo handler può gestire
     */
    public GetRecommendationHandler(Request request) {
        super(request);
    }

    @Override
    public void handleRequest(Request request, Socket socket) throws SQLException, IOException {
        System.out.println("chiamata handleRequest di GetRecommendationHandler");

        DataIO dataIO = new DataIO(socket);
        String email = dataIO.getData(String.class);

        AbstractQueryCommand command = new GetRecommendationCommand();
        List<ProductQueryResult> recommendations = (List<ProductQueryResult>) command.execute(email);

        dataIO.sendData(recommendations);
    }
}
