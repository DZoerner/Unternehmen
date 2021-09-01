package de.bfw.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private Connection conn;
    private Statement stmt;

    public Database(String url, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
    }

    public <T> List<T> query(Query<T> query) throws SQLException {
        List<T> result = new ArrayList<>();

        ResultSet resultSet = stmt.executeQuery(query.query());

        while(resultSet.next()){
            result.add(query.handleRow(resultSet));
        }

        return result;
    }

    public <T> T queryFirst(Query<T> query) throws SQLException {
        ResultSet resultSet = stmt.executeQuery(query.query());

        resultSet.next();

        return query.handleRow(resultSet);
    }

    public int update(String sql, Object...args) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        int index = 1;
        for(Object object : args){
            preparedStatement.setObject(index, object);

            index++;
        }

        return preparedStatement.executeUpdate();
    }
}
