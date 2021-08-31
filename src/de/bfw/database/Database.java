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

    public <T> List<T> query(String sql, RowHandler<T> rowHandler) throws SQLException {
        List<T> result = new ArrayList<>();

        ResultSet resultSet = stmt.executeQuery(sql);

        while(resultSet.next()){
            result.add(rowHandler.handleRow(resultSet));
        }

        return result;
    }
}
