package com.example.tp3javaprofesseurs;

import java.sql.Date;

public class Professeur {
   int  id_prof  ;
   String nom ;
   String prenom ;
   String cin ;
   String telephone ;
   String adresse ;
   String email ;
    Date date_recrutement ;
   int id_depart ;

   public Professeur(int id_prof, String nom, String prenom, String cin, String telephone, String adresse, String email, Date date_recrutement, int id_depart) {
      this.id_prof = id_prof;
      this.nom = nom;
      this.prenom = prenom;
      this.cin = cin;
      this.telephone = telephone;
      this.adresse = adresse;
      this.email = email;
      this.date_recrutement = date_recrutement;
      this.id_depart = id_depart;
   }
   public Professeur(){

      this.nom = "benr"+Math.random()*100;
      this.prenom = "sanae";
      this.cin = "lk5566";
      this.telephone = "0566656565";
      this.adresse = "2513254354djvjkshdku;hdv";
      this.email =  this.nom+"@email.com";
      this.date_recrutement = Date.valueOf("2015-05-02") ;
      this.id_depart = 3;
   }
}
