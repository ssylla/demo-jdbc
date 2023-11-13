package fr.epsi.b32324c2.jdbc.dal.jdbc;

import fr.epsi.b32324c2.jdbc.dal.FournisseurDAO;
import fr.epsi.b32324c2.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static fr.epsi.b32324c2.Main.*;

public class FournisseurDAOJDBC implements FournisseurDAO {

    private static final String INSERT_QUERY = "INSERT INTO fournisseur (NOM) VALUES ('%s')";
    @Override
    public void insert(Fournisseur fournisseurACreer) throws SQLException {
        try(Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            Statement st = cnx.createStatement()){
            st.executeUpdate(String.format(INSERT_QUERY, fournisseurACreer.getNom()));
        }
    }
}
