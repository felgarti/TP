package com.example.tp3javaprofesseurs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IMetierImpl implements IMetier {
    private Connection connection = SingletonConnexionDB.GetConnexion();

    public IMetierImpl() throws SQLException, ClassNotFoundException {
    }

    @Override
    public List<Professeur> afficherProfesseurs() throws SQLException {
        List<Professeur> professeurs = new ArrayList<>() ;
       PreparedStatement preparedStatement = connection.prepareStatement("select * from professeur ") ;
        ResultSet resultSet = preparedStatement.executeQuery();
while(resultSet.next())
{
    Professeur professeur = new Professeur(resultSet.getInt("id_prof") ,
            resultSet.getString("nom") ,
            resultSet.getString("prenom") ,
            resultSet.getString("cin") ,
            resultSet.getString("telephone") ,
            resultSet.getString("adresse"),
            resultSet.getString("email"),
            resultSet.getDate("date_recrutement") ,
            resultSet.getInt("id_depart") ) ;
    professeurs.add(professeur) ;
}
        return professeurs;
    }

    @Override
    public List<Departement> afficherDepartements() throws SQLException {
 List<Departement> departements = new ArrayList<>() ;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from departement ") ;
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
              Departement departement = new Departement(resultSet.getInt("id_depart") ,
                      resultSet.getString("nom")) ;
              departements.add(departement) ;
        }

        return departements ;
    }

    @Override
    public void ajouterProfesseur(Professeur professeur) throws SQLException {
PreparedStatement p = connection.prepareStatement("INSERT INTO `professeur` (`id_prof`, `nom`, `prenom`, `cin`, `adresse`, `telephone`, `email`, `date_recrutement`, `id_depart`) VALUES (NULL,?,?,?,?,?,?,?,?)") ;

    p.setString(1 , professeur.nom);
        p.setString(2 , professeur.prenom);
        p.setString(3 , professeur.cin);
        p.setString(4 , professeur.adresse);
        p.setString(5 , professeur.telephone);
        p.setString(6 , professeur.email);
        p.setDate(7 ,  professeur.date_recrutement);
        p.setInt(8 , professeur.id_depart);
        int nbr = p.executeUpdate() ;
        System.out.println("insertion successful");


    }

    @Override
    public void ajouterDepartement(Departement departement) throws SQLException {
        PreparedStatement p = connection.prepareStatement("INSERT INTO `departement` (`id_depart`, `nom`) VALUES (NULL, ?)");
        p.setString(1,departement.nom);
        int nbr = p.executeUpdate() ;
        System.out.println("insertion successful");
    }

    @Override
    public Professeur rechercherParMotCleProfesseur(String keyword) throws SQLException {
        Professeur professeur=null ;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from professeur where nom like ? ") ;
        preparedStatement.setString(1,keyword);
        ResultSet resultSet = preparedStatement.executeQuery();
       if(resultSet.next())
        {
           professeur = new Professeur(resultSet.getInt("id_prof") ,
                    resultSet.getString("nom") ,
                    resultSet.getString("prenom") ,
                    resultSet.getString("cin") ,
                    resultSet.getString("telephone") ,
                    resultSet.getString("adresse"),
                   resultSet.getString("email"),
                    resultSet.getDate("date_recrutement") ,
                    resultSet.getInt("id_depart") ) ;

        }
        return professeur;
    }

    @Override
    public void supprimerProfesseur(Professeur professeur) throws SQLException {
        PreparedStatement p = connection.prepareStatement("DELETE FROM professeur WHERE `professeur`.`id_prof` = ?");
        p.setInt(1,professeur.id_prof);

        int nbr = p.executeUpdate() ;
        System.out.println("deleted successfully");
    }

    @Override
    public void modifierProfesseur(Professeur professeur) throws SQLException {
        PreparedStatement p = connection.prepareStatement("UPDATE `professeur` SET   `nom`=?, `prenom`=?, `cin`=?, `adresse`=?, `telephone`=?, `email`=?, `date_recrutement`=?, `id_depart`=?)  WHERE `professeur`.`id_prof` = ?") ;

        p.setString(1 , professeur.nom);
        p.setString(2 , professeur.prenom);
        p.setString(3 , professeur.cin);
        p.setString(4 , professeur.adresse);
        p.setString(5 , professeur.telephone);
        p.setString(6 , professeur.email);
        p.setDate(7 ,  professeur.date_recrutement);
        p.setInt(8 , professeur.id_depart);
        p.setInt(9 , professeur.id_prof);
    }

    @Override
    public void affecterProfesseurDepartement(Professeur professeur, Departement departement) throws SQLException {
      professeur.id_depart=departement.id_depart ;

    this.modifierProfesseur(professeur);
    }

    @Override
    public void supprimerDepartement(Departement departement) throws SQLException {

        PreparedStatement p = connection.prepareStatement("DELETE FROM departement WHERE `departement`.`id_depart` = ?");
        p.setInt(1,departement.id_depart);

        int nbr = p.executeUpdate() ;
        System.out.println("deleted successfully");
    }

    @Override
    public void modifierDepartement(Departement departement) throws SQLException {
        PreparedStatement p = connection.prepareStatement("UPDATE `departement` SET `nom`=?) WHERE `id_depart` = ?  ");
        p.setString(1,departement.nom);
        p.setInt(2 , departement.id_depart);
        int nbr = p.executeUpdate() ;
        System.out.println("update successful");
    }

    @Override
    public List<Professeur> afficherProfesseursDepartement(Departement departement) throws SQLException {
        List<Professeur> professeurs = new ArrayList<>() ;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from professeur  WHERE `professeur`.`id_depart` = ? ") ;
        preparedStatement.setInt(1,departement.id_depart);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next())
        {
            Professeur professeur = new Professeur(resultSet.getInt("id_prof") ,
                    resultSet.getString("nom") ,
                    resultSet.getString("prenom") ,
                    resultSet.getString("cin") ,
                    resultSet.getString("telephone") ,
                    resultSet.getString("adresse"),
                    resultSet.getString("email"),
                    resultSet.getDate("date_recrutement") ,
                    resultSet.getInt("id_depart") ) ;
            professeurs.add(professeur) ;
        }
        return professeurs;
    }
}
