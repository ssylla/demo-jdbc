package fr.epsi.b32324c2.jdbc;

import fr.epsi.b32324c2.jdbc.dal.FournisseurDAO;
import fr.epsi.b32324c2.jdbc.dal.jdbc.FournisseurDAOJDBC;
import fr.epsi.b32324c2.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static fr.epsi.b32324c2.Main.*;

public class TestInsertion {
    public static void main(String[] args) {

        FournisseurDAO dao = new FournisseurDAOJDBC();
        try {
            dao.insert(new Fournisseur("EPSI"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
