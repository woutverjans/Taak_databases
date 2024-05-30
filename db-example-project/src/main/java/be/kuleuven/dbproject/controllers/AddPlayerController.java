package be.kuleuven.dbproject.controllers;

import be.kuleuven.dbproject.Application;
import be.kuleuven.dbproject.models.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static be.kuleuven.dbproject.Application.setScene;
import static be.kuleuven.dbproject.Application.terugNaarStart;
import static be.kuleuven.dbproject.models.PlayerRepository.addPlayerToDb;
import static be.kuleuven.dbproject.models.PlayerRepository.schrijfInVoorToernooi;

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
    private Button voegToeBtn;
    @FXML
    private Button homeBtn;

    private Object data;
    public void setData(Object data){
        this.data = data;
    };

    public AddPlayerController(){}

    @FXML
    public void initialize() { //Niet verwijderen
        naamTxtBox.setText("");
        idTxtBox.setText("");
        rankingTxtBox.setText("");
        leeftijdTxtBox.setText("");
        hoogstePosTxtBox.setText("");
        gewichtTxtBox.setText("");
        lengteTxtBox.setText("");
        geslachtTxtBox.setText("");
        clubTxtBox.setText("");

        homeBtn.setOnAction(e -> {
            try {
                terugNaarStart();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        voegToeBtn.setOnAction(e -> {
            try {
                addPlayer();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void addPlayer() throws SQLException {
        String naam = naamTxtBox.getText();
        String id = idTxtBox.getText();
        String ranking = rankingTxtBox.getText();
        String leeftijd = leeftijdTxtBox.getText();
        String hoogstePositie = hoogstePosTxtBox.getText();
        String gewicht = gewichtTxtBox.getText();
        String lengte = lengteTxtBox.getText();
        String geslacht = geslachtTxtBox.getText();
        String club = clubTxtBox.getText();
        System.out.println(naam + " " + id + " " + ranking + " " + leeftijd + " " + hoogstePositie + " " + gewicht + " " + lengte + " " + geslacht + " " + club + " ");
        Player speler = new Player(naam, id, club, Integer.parseInt(ranking), Integer.parseInt(leeftijd), Integer.parseInt(hoogstePositie), Integer.parseInt(gewicht), Integer.parseInt(lengte), geslacht);
        addPlayerToDb(speler);
    }
}
