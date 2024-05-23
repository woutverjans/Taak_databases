module be.kuleuven.dbproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens be.kuleuven.dbproject to javafx.fxml;
    exports be.kuleuven.dbproject;
    exports be.kuleuven.dbproject.controllers;
    opens be.kuleuven.dbproject.controllers to javafx.fxml;
}