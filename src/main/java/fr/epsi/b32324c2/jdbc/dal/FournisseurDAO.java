package fr.epsi.b32324c2.jdbc.dal;

import fr.epsi.b32324c2.jdbc.entites.Fournisseur;

import java.sql.SQLException;

public interface FournisseurDAO {

    void insert(Fournisseur fournisseurACreer) throws Exception;
}
