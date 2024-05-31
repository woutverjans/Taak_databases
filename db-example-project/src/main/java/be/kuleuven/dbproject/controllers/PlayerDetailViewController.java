package be.kuleuven.dbproject.controllers;

import be.kuleuven.dbproject.models.Player;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.Date;

public class PlayerDetailViewController implements MyController {

    @FXML
    private Label playerLbl;
    @FXML
    private TableView matchesTbl;

    private Player player;
    @FXML
    public void initialize(){
        player = (Player) this.data;
        playerLbl.setText("Hello "+player.getName());
        initMatchesTbl();
    }

    private static Object data;
    public void setData(Object data){
        this.data = data;
    };

    public void initMatchesTbl(){
        int colIndex = 0;
        for(var colName : new String[]{"Tennisclub", "Reeks", "Datum"}) {
            TableColumn<ObservableList<String>, String> col = new TableColumn<>(colName);
            final int finalColIndex = colIndex;
            col.setCellValueFactory(f -> new ReadOnlyObjectWrapper<>(f.getValue().get(finalColIndex)));
            matchesTbl.getColumns().add(col);
            colIndex++;
        }

        matchesTbl.getItems().add(FXCollections.observableArrayList("TPTessenderlo","Heren 2", ""+new Date(2024, 6, 6)));
    }
}
