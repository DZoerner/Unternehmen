package de.bfw.example.unternehmen;

import de.bfw.database.Database;
import de.bfw.example.unternehmen.data.Kunde;
import de.bfw.example.unternehmen.data.KundeQuery;

import java.sql.SQLException;
import java.util.List;

public class TestWithList {

    public static void main(String[] args) {
        String db = "unternehmen";

        if(args.length > 0){
            db = args[0];
        }

        try {
            Database database = new Database("jdbc:mysql://localhost/" + db, "root", "");

            List<Kunde> kunden = database.query(new KundeQuery());

            System.out.println(kunden.size() + " Kunden found.");

            for (Kunde kunde : kunden) {
                System.out.println(kunde.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
