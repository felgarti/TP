package com.example.tp3javaprofesseurs;
import java.sql.*;

public class SingletonConnexionDB {

    private static String user = "root";
    private static String password = "";

        private static Connection connection ;
           static {
               try {
                   Class.forName("com.mysql.cj.jdbc.Driver");
               } catch (ClassNotFoundException e) {
                   throw new RuntimeException(e);
               }
               try {
                   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prof_db", user, password);
               } catch (SQLException e) {
                   throw new RuntimeException(e);
               }
               System.out.println("Established connection");

           }
        public static Connection GetConnexion() throws ClassNotFoundException, SQLException {
         return connection ;}
}
