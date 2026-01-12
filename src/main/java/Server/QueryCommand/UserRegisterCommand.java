package Server.QueryCommand;

import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.UserExistsQuery;
import Server.QueryStrategy.UserRegisterQuery;
import Shared.GsonAdapters.AuthPacket;

import java.sql.SQLException;

public class UserRegisterCommand extends AbstractQueryCommand<AuthPacket, Boolean> {

    public UserRegisterCommand() throws SQLException {
    }

    @Override
    public Boolean execute(AuthPacket params) throws SQLException {
        //check se l'utente esiste
       AbstractQueryStrategy query = new UserExistsQuery();
       String check = (String) query.executeQuery(params.id);

       if(check.equals(params.id)){
           return false;
       }
       //registrazione se l'utente non esite
        AbstractQueryStrategy query2 = new UserRegisterQuery();
        Integer check2 = (Integer) query2.executeQuery(params);

        if(check2 > 0){
            return true;
        } else {
            return false;
        }

    }
}
