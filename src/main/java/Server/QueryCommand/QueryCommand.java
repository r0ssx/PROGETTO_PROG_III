package Server.QueryCommand;

import Database.SingletonDB;

import java.sql.SQLException;

public abstract class QueryCommand<Param, Res> {
    protected SingletonDB db;

    public QueryCommand() throws SQLException {
        db = SingletonDB.getInstance();
    }

    public abstract Res execute(Param params) throws SQLException;
}
