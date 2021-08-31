package de.bfw.example.unternehmen;

import de.bfw.database.Database;
import de.bfw.example.unternehmen.data.Kunde;
import de.bfw.example.unternehmen.data.KundeRowHandler;

import java.sql.SQLException;
import java.util.List;

public class TestWithList {

    public static void main(String[] args) {

        try {
            Database database = new Database("jdbc:mysql://localhost/unternehmen", "root", "");

            List<Kunde> kunden = database.query("SELECT Name FROM kunde", new KundeRowHandler());

            System.out.println(kunden.size() + " Kunden found.");

            for (Kunde kunde : kunden) {
                System.out.println(kunde.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
