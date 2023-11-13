package fr.epsi.b32324c2.jdbc.dal.jdbc;

import fr.epsi.b32324c2.jdbc.dal.UtilisateurDAO;
import fr.epsi.b32324c2.jdbc.entites.Utilisateur;

import java.sql.*;

import static fr.epsi.b32324c2.Main.*;

public class UtilisateurDAOJDBC implements UtilisateurDAO {

    private static final String LOGIN_QUERY = "SELECT * FROM utilisateur WHERE LOGIN = '%s' AND MDP = '%s'";
    private static final String SECURED_LOGIN_QUERY = "SELECT * FROM utilisateur WHERE LOGIN = ? AND MDP = ?";
    @Override
    public Utilisateur login(String login, String pwd) throws SQLException {
        Utilisateur utilisateur=null;
        try(Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(String.format(LOGIN_QUERY, login, pwd))){
            System.out.println(String.format(LOGIN_QUERY, login, pwd));
            if (rs.next()) {
                int id = rs.getInt("ID");
                String identifiant = rs.getString("LOGIN");
                String password = rs.getString("MDP");
                utilisateur = new Utilisateur(id, identifiant, password);
            }
        }
        return utilisateur;
    }

    @Override
    public Utilisateur securedLogin(String login, String pwd) throws SQLException {
        Utilisateur utilisateur=null;
        try(Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            PreparedStatement pst = cnx.prepareStatement(SECURED_LOGIN_QUERY);){
            pst.setString(1, login);
            pst.setString(2, pwd);
            System.out.println(pst);
            try(ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("ID");
                    String identifiant = rs.getString("LOGIN");
                    String password = rs.getString("MDP");
                    utilisateur = new Utilisateur(id, identifiant, password);
                }
            }
        }
        return utilisateur;
    }
}
