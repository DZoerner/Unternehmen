package de.bfw.example.unternehmen;

import de.bfw.database.Database;
import de.bfw.database.SQLDate;
import de.bfw.example.unternehmen.data.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.System.exit;

public class RandomBestellung {
    private Random rnd = new Random();

    private SQLDate createRandomDate() {
        return new SQLDate(1990 + rnd.nextInt(21), 1 + rnd.nextInt(13), 1 + rnd.nextInt(29));
    }

    private int createRandomBestellung(String db) throws SQLException {
        Database database = new Database("jdbc:mysql://localhost/" + db, "root", "");

        List<Kunde> kunden = database.query(new KundeQuery());
        List<Produkt> produkte = database.query(new ProduktQuery());

        TableCounts tableCounts = database.queryFirst(new TableCountsQuery());

        SQLDate[] dates = new SQLDate[2];
        dates[0] = createRandomDate();
        dates[1] = createRandomDate();

        Arrays.sort(dates);

        return database.update(
                "INSERT INTO Bestellung (KundenNummer, ProduktID, Bestelldatum, Lieferdatum, Anzahl) Values(?,?,?,?,?)",
                kunden.get(rnd.nextInt(kunden.size())).getNummer(),
                produkte.get(rnd.nextInt(produkte.size())).getId(),
                dates[0].toString(),
                dates[1].toString(),
                1 + rnd.nextInt(20)
        );
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("usage : RandomBestellung <db Name>");
            exit(-1);
        }

        try {
            RandomBestellung randomBestellung = new RandomBestellung();

            System.out.println("Bestellung ezeugt:" + randomBestellung.createRandomBestellung(args[0]));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

