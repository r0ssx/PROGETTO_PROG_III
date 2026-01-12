package Server.QueryStrategy;

import Database.SingletonDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractQueryStrategy<Param,Res>{
    protected SingletonDB db;
    protected Connection connection;

    public AbstractQueryStrategy(){
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
