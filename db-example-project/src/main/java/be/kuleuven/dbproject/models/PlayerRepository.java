package be.kuleuven.dbproject.models;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static be.kuleuven.dbproject.models.ConnectionManager.s;

public class PlayerRepository {
    public static List<Player> getAlleSpelers() throws SQLException{
        List<Player> spelersLijst = new ArrayList<>();
        Statement statement = null;
        Connection connection  = null;
        connection = DriverManager.getConnection("jdbc:sqlite:mydb.db");
        statement = connection.createStatement();
        var result = statement.executeQuery("SELECT * FROM spelers;");
        while(result.next()){
            var naam = result.getString("Naam");
            var id = result.getString("Id");
            var ranking = result.getInt("Ranking");
            var leeftijd = result.getInt("Leeftijd");
            var hoogstePos = result.getInt("Hoogste_positie");
            var gewicht = result.getInt("Gewicht");
            var lengte = result.getInt("Lengte");
            var geslacht = result.getString("Geslacht");
            var toernooi = result.getString("Toernooi");
            var club = result.getString("Club");
            Player speler = new Player(naam, id, club, ranking, leeftijd, hoogstePos, gewicht, lengte, geslacht, toernooi);
            spelersLijst.add(speler);
        }
        statement.close();
        return spelersLijst;
    }
    public static void addPlayerToDb(Player speler) throws SQLException {
        Connection connection  = null;
        connection = DriverManager.getConnection("jdbc:sqlite:mydb.db");
        var s = connection.createStatement();
        var naam = speler.getName();
        var id = speler.getId();
        var ranking = speler.getRanking();
        var leeftijd = speler.getLeeftijd();
        var hoogstePositie = speler.getHoogstePositie();
        var gewicht = speler.getGewicht();
        var lengte = speler.getLengte();
        var geslacht = speler.getGeslacht();
        var toernooi = speler.getToernooi();
        var club = speler.getClub();
        String sql = "INSERT INTO `spelers` (`Naam`, `Id`, `Ranking`, `Leeftijd`, `Hoogste_positie`, `Gewicht`, `Lengte`, `Geslacht`, `Toernooi`, `Club`)" +
                " VALUES ('"+ naam +"', '"+ id +"', '"+ ranking +"', '"+ leeftijd +"', '"+ hoogstePositie +"', '"+ gewicht +"', '"+ lengte +"', '"+ geslacht +"', '"+ toernooi +"', '"+ club +"')";
        s.executeUpdate(sql);
        s.close();
    }
    public static void schrijfInVoorToernooi(String toernooiId, String spelerId) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:mydb.db");
             PreparedStatement statement = connection.prepareStatement("UPDATE spelers SET toernooi =? WHERE id =?")) {

            statement.setString(1, toernooiId);
            statement.setString(2, spelerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        s.close();
    }
    public static List<Match> getMatchenOpSpelerId(String id) throws SQLException {
        List<Match> matchLijst = new ArrayList<>();
        Statement statement = null;
        Connection connection  = null;
        connection = DriverManager.getConnection("jdbc:sqlite:mydb.db");
        statement = connection.createStatement();

        String sql = "SELECT * FROM matchen WHERE Speler_1 = ? OR Speler_2 = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, id);
        ResultSet result = preparedStatement.executeQuery();

        while(result.next()){
            var matchId = result.getString("match_id");
            var plein = result.getString("Plein");
            var tijdsStip = result.getString("Tijdstip");
            var datum = result.getString("Datum");
            var idSpeler1 = result.getString("Speler_1");
            var idSpeler2 = result.getString("Speler_2");
            var scoreSpeler1 = result.getInt("Score_speler_1");
            var scoreSpeler2 = result.getInt("Score_speler_2");
            var reeks = result.getString("Reeks");
            Match match = new Match(matchId, plein, tijdsStip, datum, idSpeler1, idSpeler2, scoreSpeler1, scoreSpeler2, reeks, null, null);
            matchLijst.add(match);
        }
        statement.close();
        return matchLijst;
    }
}
