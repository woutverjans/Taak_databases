package be.kuleuven.dbproject.controllers;

import be.kuleuven.dbproject.Application;
import be.kuleuven.dbproject.models.Player;
import be.kuleuven.dbproject.models.ConnectionManager;
import be.kuleuven.dbproject.models.PlayerRepository;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlayersViewController implements MyController{
    @FXML
    private TableView playersTbl;

    private ArrayList<Player> players;

    @FXML
    public void initialize() throws SQLException {
        //TODO: retrieve the correct data from your database
        Player testPlayer = new Player("Arne Duyver", "101", "100001");
        this.players = new ArrayList<>();
        this.players.add(testPlayer);
        ConnectionManager.createDb();
        this.players.addAll(PlayerRepository.getAlleSpelers());
        initTable();
        playersTbl.setOnMouseClicked(e -> playerDoubleClicked(e));
    }
    private Object data;
    public void setData(Object data){
        this.data = data;
    };

    private void initTable() {
        //TODO: change this example to fit your needs
        int colIndex = 0;
        for(var colName : new String[]{"Player ID", "Player name"}) {
            TableColumn<ObservableList<String>, String> col = new TableColumn<>(colName);
            final int finalColIndex = colIndex;
            col.setCellValueFactory(f -> new ReadOnlyObjectWrapper<>(f.getValue().get(finalColIndex)));
            playersTbl.getColumns().add(col);
            colIndex++;
        }

        playersTbl.getItems().add(FXCollections.observableArrayList(""+players.get(0).getId(), players.get(0).getName()));
    }

    private void playerDoubleClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && playersTbl.getSelectionModel().getSelectedItem() != null) {
            var selectedRow = playersTbl.getSelectionModel().getSelectedIndex();
            Player wantedPlayer = players.get(selectedRow);
//            System.out.println(wantedPlayer);
            String id = "player-detail-view.fxml";
            try {
                System.out.println("pvc: "+wantedPlayer);
                Application.setScene(id, 800, 800,new PlayerDetailViewController(),wantedPlayer);
            } catch (IOException ex) {
                throw new RuntimeException("Kan beheerscherm " + id + " niet vinden", ex);
            }
        }
    }

}
