package be.kuleuven.dbproject.controllers;

import be.kuleuven.dbproject.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPlayerController implements MyController{
    @FXML
    private TextField naamTxtBox;
    @FXML
    private TextField idTxtBox;
    @FXML
    private TextField rankingTxtBox;
    @FXML
    private TextField leeftijdTxtBox;
    @FXML
    private TextField hoogstePosTxtBox;
    @FXML
    private TextField gewichtTxtBox;
    @FXML
    private TextField lengteTxtBox;
    @FXML
    private TextField geslachtTxtBox;
    @FXML
    private TextField clubTxtBox;
    @FXML
    private Button addPlayerBtn;

    private Object data;
    public void setData(Object data){
        this.data = data;
    };
    private void goToView(String id) {
        try {
            Application.setScene(id, 800, 800,new AddPlayerController(),null);
        } catch (IOException e) {
            throw new RuntimeException("Kan beheerscherm " + id + " niet vinden", e);
        }
    }
    public AddPlayerController(){}

    @FXML
    public void initialize(URL location, ResourceBundle resources) { //Niet verwijderen
        naamTxtBox.setText("");
        idTxtBox.setText("");
        rankingTxtBox.setText("");
        leeftijdTxtBox.setText("");
        hoogstePosTxtBox.setText("");
        gewichtTxtBox.setText("");
        lengteTxtBox.setText("");
        geslachtTxtBox.setText("");
        clubTxtBox.setText("");

        addPlayerBtn.setOnAction(e -> addPlayer()); //TODO knop werkt niet? Geeft geen output
    }

    public void addPlayer() {
        // TODO: Code to add a new player
        String naam = naamTxtBox.getText();
        System.out.println("naam");
    }
}
