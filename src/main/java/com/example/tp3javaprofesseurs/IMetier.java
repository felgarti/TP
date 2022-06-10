package com.example.tp3javaprofesseurs;

import java.security.cert.PolicyNode;
import java.sql.SQLException;
import java.util.List;

public interface IMetier {
    public List<Professeur> afficherProfesseurs() throws SQLException;
    public List<Departement> afficherDepartements() throws SQLException;
    public void ajouterProfesseur(Professeur professeur ) throws SQLException;
    public void ajouterDepartement(Departement departement ) throws SQLException;
    public  Professeur rechercherParMotCleProfesseur(String keyword) throws SQLException;
    public void supprimerProfesseur(Professeur p ) throws SQLException;
    public void modifierProfesseur(Professeur professeur) throws SQLException;
    public void affecterProfesseurDepartement(Professeur professeur , Departement departement) throws SQLException;
    public void supprimerDepartement(Departement departement ) throws SQLException;
    public void modifierDepartement(Departement departement) throws SQLException;
    public List<Professeur> afficherProfesseursDepartement (Departement departement) throws SQLException;

}
