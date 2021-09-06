package de.bfw.example.unternehmen;

import de.bfw.database.Database;

import java.sql.*;

import static java.lang.System.exit;

public class Bestellungen {

    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/unternehmen", "root", "");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT Bestellung.BestellDatum, Kunde.Name, Bestellung.Anzahl, Produkt.Name, Preis, Preis*Bestellung.Anzahl " +
                    "FROM Bestellung JOIN Produkt ON ProduktId = Produkt.ID " +
                    "JOIN Kunde ON KundenNummer = Kunde.Nummer");

            while(rs.next()){
                int i= 1;
                String display = String.format(
                        "%s: Bestellung von %s über %d * \"%s\" zu je %.2f€ = %.2f€",
                        rs.getDate(i++),
                        rs.getString(i++),
                        rs.getInt(i++),
                        rs.getString(i++),
                        rs.getDouble(i++),
                        rs.getDouble(i++)
                );

                System.out.println(display);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

