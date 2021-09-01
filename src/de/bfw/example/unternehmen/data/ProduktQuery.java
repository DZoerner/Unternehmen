package de.bfw.example.unternehmen.data;

import de.bfw.database.Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProduktQuery implements Query<Produkt> {
    @Override
    public Produkt handleRow(ResultSet resultSet) throws SQLException {
        Produkt produkt = new Produkt();

        int i= 1;
        produkt.setId(resultSet.getInt(i++));
        produkt.setName(resultSet.getString(i++));

        return produkt;
    }

    @Override
    public String query() {
        return "SELECT ID, Name FROM produkt";
    }
}
