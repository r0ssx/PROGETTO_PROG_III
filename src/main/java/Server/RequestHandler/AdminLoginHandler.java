package Server.RequestHandler;

import Server.QueryCommand.AbstractQueryCommand;
import Server.QueryCommand.AdminLoginCommand;
import Shared.DataIO;
import Shared.GsonAdapters.AuthPacket;
import Shared.Requests.Request;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

/**
 * Handler concreto della Chain of Responsibility responsabile
 * della gestione delle richieste di tipo {@link Request#ADMIN_LOGIN}.
 * Questa classe si occupa di elaborare le richieste di autenticazione
 * inviate da un amministratore del sistema.
 */
public class AdminLoginHandler extends AbstractRequestHandler{

    /**
     * Costruisce un {@code AdminLoginHandler} associato
     * al tipo di richiesta specificato.
     * @param request il tipo di {@link Request} che questo handler è in grado di gestire
     */
    public AdminLoginHandler(Request request) {
        super(request);
    }

    /**
     * Gestisce concretamente la richiesta di login dell'amministratore.
     * Questo metodo viene invocato solo se la richiesta è riconosciuta
     * come gestibile dall'handler corrente.
     *
     * @param request la richiesta {@link Request#ADMIN_LOGIN} da elaborare
     * @param socket
     */
    @Override
    public void handleRequest(Request request, Socket socket) throws SQLException, IOException {
        System.out.println("chiamata handleRequest di AdminLoginHandler");
        AbstractQueryCommand queryCommand = new AdminLoginCommand();
        DataIO dataIO = new DataIO(socket);
        String readData = dataIO.getRawData();
        Gson gson = new Gson();
        AuthPacket loginPacket = gson.fromJson(readData, AuthPacket.class);
        String correctPassword = (String) queryCommand.execute(loginPacket.id);

        if(correctPassword.equals(loginPacket.password)){
            dataIO.sendData(true);
        } else {
            dataIO.sendData(false);
        }

    }
}
