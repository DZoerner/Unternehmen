package de.bfw.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Query<T> {
    T handleRow(ResultSet resultSet) throws SQLException;
    String query();
}
