package Server.QueryCommand;

import Database.SingletonDB;

import java.sql.SQLException;

public abstract class AbstractQueryCommand<Param, Res> {
    protected SingletonDB db;

    public AbstractQueryCommand() throws SQLException {
        db = SingletonDB.getInstance();
    }

    public abstract Res execute(Param params) throws SQLException;
}
