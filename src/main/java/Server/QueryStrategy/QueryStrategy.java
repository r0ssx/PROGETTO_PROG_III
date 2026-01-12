package Server.QueryStrategy;

import Database.SingletonDB;
import Server.QueryCommand.QueryResultObject.QueryResultObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class QueryStrategy<Param,Res>{
    protected SingletonDB db;
    protected Connection connection;

    public QueryStrategy(){
        db = SingletonDB.getInstance();
    }

    protected abstract ResultSet concreteQuery(Param params) throws SQLException;

    protected abstract Res convertResultSet(ResultSet resultSet) throws SQLException;

    public Res executeQuery(Param params) throws SQLException {

        connection = db.createConnection();
        ResultSet resultSet = concreteQuery(params);
        Res res = convertResultSet(resultSet);
        connection.close();

        return res;
    }


}
