package de.bfw.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowHandler <T> {
    T handleRow(ResultSet resultSet) throws SQLException;
}
