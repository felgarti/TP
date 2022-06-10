module com.example.tp3javaprofesseurs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tp3javaprofesseurs to javafx.fxml;
    exports com.example.tp3javaprofesseurs;
}