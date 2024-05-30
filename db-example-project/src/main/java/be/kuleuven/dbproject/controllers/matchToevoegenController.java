package be.kuleuven.dbproject.controllers;

import be.kuleuven.dbproject.models.Match;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

import static be.kuleuven.dbproject.Application.terugNaarStart;
import static be.kuleuven.dbproject.models.MatchRepository.matchNaarDb;

public class matchToevoegenController implements MyController{
    @FXML
    private Button homeBtn;
    @FXML
    private TextField matchIdTxt;
    @FXML
    private TextField pleinTxt;
    @FXML
    private TextField tijdsstipTxt;
    @FXML
    private TextField datumTxt;
    @FXML
    private TextField soortTxt;
    @FXML
    private TextField speler1Txt;
    @FXML
    private TextField speler2Txt;
    @FXML
    private TextField score1Txt;
    @FXML
    private TextField score2Txt;
    @FXML
    private TextField scheidsTxt;
    @FXML
    private TextField reeksTxt;
    @FXML
    private Button toevoegBtn;



    public matchToevoegenController(){}

    @FXML
    public void initialize(){ //Niet verwijderen
        matchIdTxt.setText("");
        pleinTxt.setText("");
        tijdsstipTxt.setText("");
        datumTxt.setText("");
        soortTxt.setText("");
        speler1Txt.setText("");
        speler2Txt.setText("");
        score1Txt.setText("");
        score2Txt.setText("");
        scheidsTxt.setText("");
        reeksTxt.setText("");

        homeBtn.setOnAction(e -> {
            try {
                terugNaarStart();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        toevoegBtn.setOnAction(e -> {
            try {
                voegMatchToe();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void voegMatchToe() throws SQLException {
        var matchId = matchIdTxt.getText();
        var plein = pleinTxt.getText();
        var tijdsstip = tijdsstipTxt.getText();
        var datum = datumTxt.getText();
        var soort = soortTxt.getText();
        var speler1 = speler1Txt.getText();
        var speler2 = speler2Txt.getText();
        var score1 = score1Txt.getText();
        var score2 = score2Txt.getText();
        var scheidsrechter = scheidsTxt.getText();
        var reeks = reeksTxt.getText();
        Match match = new Match(matchId, plein, tijdsstip, datum, speler1, speler2, Integer.parseInt(score1), Integer.parseInt(score2), reeks, soort, scheidsrechter);
        matchNaarDb(match);
    }

    private Object data;
    public void setData(Object data){
        this.data = data;
    };
}
