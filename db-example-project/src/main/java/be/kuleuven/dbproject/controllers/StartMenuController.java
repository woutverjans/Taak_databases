package be.kuleuven.dbproject.controllers;

import be.kuleuven.dbproject.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;
import static be.kuleuven.dbproject.Application.setScene;

public class StartMenuController implements MyController{
    @FXML
    private Button viewPlayersBtn;
    @FXML
    private Button addPlayerBtn;
    @FXML
    private Button schrijfInVoorToernooiBtn;
    @FXML
    private Button matchOverzichtBtn;

    @FXML
    public void initialize(){
        viewPlayersBtn.setOnAction(e -> goToView("players-view.fxml"));
        addPlayerBtn.setOnAction(e -> goToAddPlayerView("addPlayer-view.fxml"));
        schrijfInVoorToernooiBtn.setOnAction(e -> goToInschrijfView("inschrijvenVoorToernooi-view.fxml"));
        matchOverzichtBtn.setOnAction(e -> goToMatchOverzicht("matchOverzicht-view.fxml"));
    }

    private Object data;
    public void setData(Object data){
        this.data = data;
    };

    private void goToView(String id) {
        try {
            setScene(id, 800, 800,new PlayersViewController(),null);
        } catch (IOException e) {
            throw new RuntimeException("Kan beheerscherm " + id + " niet vinden", e);
        }
    }
    private void goToAddPlayerView(String id){
        try {
            setScene(id, 800, 800, new AddPlayerController(),null);
        } catch (IOException e) {
            throw new RuntimeException("Kan toevoegscherm " + id + " niet vinden", e);
        }
    }

    private void goToInschrijfView(String id){
        try {
            setScene(id, 800, 800, new InschrijfController(),null);
        } catch (IOException e) {
            throw new RuntimeException("Kan inschrijfscherm " + id + " niet vinden", e);
        }
    }

    private void goToMatchOverzicht(String id){
        try {
            setScene(id, 800, 800, new MatchOverzichtController(),null);
        } catch (IOException e) {
            throw new RuntimeException("Kan inschrijfscherm " + id + " niet vinden", e);
        }
    }
}