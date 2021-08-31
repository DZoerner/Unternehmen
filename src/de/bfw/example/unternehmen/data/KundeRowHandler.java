package de.bfw.example.unternehmen.data;

import de.bfw.database.RowHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KundeRowHandler implements RowHandler<Kunde>{
    @Override
    public Kunde handleRow(ResultSet resultSet) throws SQLException {
        Kunde kunde = new Kunde();

        kunde.setName(resultSet.getString(1));

        return kunde;
    }
}
