package de.bfw.example.unternehmen;

import java.sql.*;

public class TestWithResult {

    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/unternehmen", "root", "");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT name FROM Kunde");

            while(rs.next()){
                //Display values
                System.out.println(rs.getString(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

