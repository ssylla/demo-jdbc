package fr.epsi.b32324c2.jdbc;

import fr.epsi.b32324c2.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static fr.epsi.b32324c2.Main.*;

public class TestSelect {

    public static void main(String[] args) {
        try(Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM FOURNISSEUR")){

            List<Fournisseur> fournisseurs = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt("ID");
                String nom = rs.getString("NOM");
                Fournisseur itemFournisseur = new Fournisseur(id, nom);
                fournisseurs.add(itemFournisseur);
                //fournisseurs.add(new Fournisseur(rs.getInt("ID"), rs.getString("NOM")));
            }

            fournisseurs.forEach(System.out::println);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
