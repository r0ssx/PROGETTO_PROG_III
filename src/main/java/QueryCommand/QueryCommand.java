package QueryCommand;

import Database.SingletonDB;
import QueryCommand.QueryResultObject.QueryResultObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class QueryCommand<T extends QueryResultObject> {
    protected SingletonDB db;

    public QueryCommand() throws SQLException {
        db = SingletonDB.getInstance();
    }

    public abstract List<T> execute() throws SQLException;
}
