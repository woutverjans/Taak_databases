package be.kuleuven.dbproject.controllers;

import be.kuleuven.dbproject.models.Match;
import be.kuleuven.dbproject.models.PlayerRepository;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MatchOverzichtController implements MyController {
    private ArrayList<Match> matchen;
    @FXML
    private TextField idTxt;
    @FXML
    private Button zoekBtn;
    @FXML
    private TableView matchTbl;

    public MatchOverzichtController(){};
    @FXML
    public void initialize(){
        idTxt.setText("");
        zoekBtn.setOnAction(e -> {
            try {
                vernieuwLijst();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void vernieuwLijst() throws SQLException {
        this.matchen = new ArrayList<>();
        this.matchen.addAll(PlayerRepository.getMatchenOpSpelerId(idTxt.getText()));
        initTable();
    }

    private void initTable() {
        matchTbl.getColumns().clear();
        matchTbl.getItems().clear();

        int colIndex = 0;
        for (var colName : new String[]{"Speler 1", "Speler 2", "Score speler 1", "Score speler 2"}) {
            TableColumn<ObservableList<String>, String> col = new TableColumn<>(colName);
            final int finalColIndex = colIndex;
            col.setCellValueFactory(f -> new ReadOnlyObjectWrapper<>(String.valueOf(f.getValue().get(finalColIndex))));
            matchTbl.getColumns().add(col);
            colIndex++;
        }
        matchTbl.getItems().addAll(matchen.stream()
                .map(match -> FXCollections.observableArrayList(match.getIdSpeler1(), match.getIdSpeler2(), match.getScoreSpeler1(), match.getScoreSpeler2()))
                .collect(Collectors.toList()));
    }

    private Object data;
    public void setData(Object data){
        this.data = data;
    };
}
