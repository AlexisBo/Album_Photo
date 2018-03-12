package Bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import Beans.Utilisateur;

public class Noms extends GenericDAO{
    
    public List<Utilisateur> recupererUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT pseudo, email FROM Utilisateur;");

            // Récupération des données
            while (resultat.next()) {
                String nom = resultat.getString("pseudo");
                String prenom = resultat.getString("email");
                
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setNom(nom);
                utilisateur.setPrenom(prenom);
                
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        
        return utilisateurs;
    }
    
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO utilisateur (pseudo, email, mdp, telephone) VALUES (?, ?, ?, ?);");
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getNom() + "@fotoen.fr");
            preparedStatement.setString(3, utilisateur.getPrenom());
            preparedStatement.setString(4, "0120304050");
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}