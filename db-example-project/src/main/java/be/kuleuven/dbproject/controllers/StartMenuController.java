package be.kuleuven.dbproject.controllers;

import be.kuleuven.dbproject.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class StartMenuController implements MyController{
    @FXML
    private Button viewPlayersBtn;

    @FXML
    public void initialize(){
        viewPlayersBtn.setOnAction(e -> goToView("players-view.fxml"));
    }

    private Object data;
    public void setData(Object data){
        this.data = data;
    };

    private void goToView(String id) {
        try {
            Application.setScene(id, 800, 800,new PlayersViewController(),null);
        } catch (IOException e) {
            throw new RuntimeException("Kan beheerscherm " + id + " niet vinden", e);
        }
    }


}