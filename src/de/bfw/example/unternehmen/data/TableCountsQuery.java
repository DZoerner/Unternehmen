package de.bfw.example.unternehmen.data;

import de.bfw.database.Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TableCountsQuery implements Query<TableCounts> {
    @Override
    public TableCounts handleRow(ResultSet resultSet) throws SQLException {
        TableCounts tableCounts = new TableCounts();

        int i= 1;

        tableCounts.setKunden(resultSet.getInt(i++));
        tableCounts.setProdukte(resultSet.getInt(i++));
        tableCounts.setProduktKategorien(resultSet.getInt(i++));

        return tableCounts;
    }

    @Override
    public String query() {
        return "SELECT\n" +
                "(SELECT count(0) FROM Kunde),\n" +
                "(SELECT count(0) FROM Produkt),\n" +
                "(SELECT count(0) FROM ProduktKategorie)";
    }
}
