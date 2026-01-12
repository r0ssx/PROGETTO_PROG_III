package Server.QueryCommand;

import Database.SingletonDB;
import Server.QueryCommand.QueryResultObject.QueryResultObject;

import java.sql.SQLException;
import java.util.List;

public abstract class QueryCommand<T> {
    protected SingletonDB db;

    public QueryCommand() throws SQLException {
        db = SingletonDB.getInstance();
    }

    public abstract T execute() throws SQLException;
}
