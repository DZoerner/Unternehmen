package de.bfw.example.unternehmen.data;

import de.bfw.database.Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KundeQuery implements Query<Kunde> {
    @Override
    public Kunde handleRow(ResultSet resultSet) throws SQLException {
        Kunde kunde = new Kunde();

        int i= 1;
        kunde.setNummer(resultSet.getInt(i++));
        kunde.setName(resultSet.getString(i++));

        return kunde;
    }

    @Override
    public String query() {
        return "SELECT Nummer, Name FROM kunde";
    }
}
