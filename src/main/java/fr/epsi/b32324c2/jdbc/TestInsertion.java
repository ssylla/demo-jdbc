package fr.epsi.b32324c2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static fr.epsi.b32324c2.Main.*;

public class TestInsertion {
    public static void main(String[] args) {
        try(Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
        Statement st = cnx.createStatement()){
            int nb = st.executeUpdate("INSERT INTO fournisseur (NOM) VALUES ('Sebsy Corp.')");
            System.out.println(nb);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
