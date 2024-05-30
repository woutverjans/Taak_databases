package be.kuleuven.dbproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

import static be.kuleuven.dbproject.Application.terugNaarStart;
import static be.kuleuven.dbproject.models.PlayerRepository.schrijfInVoorToernooi;

public class InschrijfController implements MyController {
    @FXML
    private TextField spelerTxt;
    @FXML
    private TextField toernooiTxt;
    @FXML
    private Button inschrijfBtn;
    @FXML
    private Button homeBtn;

    public InschrijfController(){}

    public void initialize(){ //Niet verwijderen
        spelerTxt.setText("");
        toernooiTxt.setText("");

        homeBtn.setOnAction(e -> {
            try {
                terugNaarStart();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        inschrijfBtn.setOnAction(e -> {
            try {
                schrijfSpelerInVoorToernooi();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void schrijfSpelerInVoorToernooi() throws SQLException {
        String spelerId = spelerTxt.getText();
        String toernooiId = toernooiTxt.getText();
        schrijfInVoorToernooi(toernooiId, spelerId);
    }

    private Object data;
    public void setData(Object data){
        this.data = data;
    };
}
