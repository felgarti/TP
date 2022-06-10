package com.example.tp3javaprofesseurs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

       IMetierImpl metier = new IMetierImpl() ;
        metier.ajouterProfesseur(new Professeur());

       System.out.println(metier.rechercherParMotCleProfesseur("chafiq").nom);
       metier.afficherProfesseurs().stream().forEach( p ->{
           System.out.println("name : " + p.nom);

       });

    }

    public static void main(String[] args) {
        launch();
    }
}