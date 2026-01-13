package Server.RequestHandler;

import Server.QueryCommand.AbstractQueryCommand;
import Server.QueryCommand.UserRegisterCommand;
import Shared.DataIO;
import Shared.GsonAdapters.AuthPacket;
import Shared.Requests.Request;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

/**
 * Handler concreto della Chain of Responsibility responsabile
 * della gestione delle richieste di tipo {@link Request#USER_REGISTER}.
 * Questa classe si occupa di elaborare le richieste di registrazione
 * inviate da un nuovo utente del sistema.
 */
public class UserRegisterHandler extends AbstractRequestHandler{

    /**
     * Costruisce un {@code UserRegisterHandler} associato
     * al tipo di richiesta specificato.
     * @param request il tipo di {@link Request} che questo handler è in grado di gestire
     */
    public UserRegisterHandler(Request request) {
        super(request);
    }

    /**
     * Gestisce concretamente la richiesta di registrazione dell'utente.
     * Questo metodo viene invocato solo se la richiesta è riconosciuta
     * come gestibile dall'handler corrente.
     * @param request la richiesta {@link Request#USER_REGISTER} da elaborare
     * @param socket
     */
    @Override
    public void handleRequest(Request request, Socket socket) throws SQLException, IOException {
        System.out.println("chiamata handleRequest di UserRegisterHandler");
        AbstractQueryCommand queryCommand = new UserRegisterCommand();
        DataIO dataIO = new DataIO(socket);
        String readData = dataIO.getRawData();
        Gson gson = new Gson();
        AuthPacket registerPacket = gson.fromJson(readData, AuthPacket.class);
        Boolean bool = (Boolean) queryCommand.execute(registerPacket);

        dataIO.sendData(bool);


    }
}
