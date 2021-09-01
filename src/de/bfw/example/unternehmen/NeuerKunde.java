package de.bfw.example.unternehmen;

import de.bfw.database.Database;

import java.sql.*;

import static java.lang.System.exit;

public class NeuerKunde {

    public static void main(String[] args) {
        String db = "unternehmen";

        if (args.length != 2) {
            System.err.println("usage : NeuerKunde <KundenName> <db Name>");
            exit(-1);
        }


        db = args[0];

        try {
            Database database = new Database("jdbc:mysql://localhost/" + db, "root", "");

            System.out.println("Kunden ezeugt:" +
                    database.update("INSERT INTO Kunde (Name) Values(?)", args[1]));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

