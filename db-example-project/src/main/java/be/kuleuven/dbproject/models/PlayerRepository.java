package be.kuleuven.dbproject.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public void addSpeler(Player speler) throws SQLException {
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
        String sql = "INSERT INTO `spelers` (`Naam`, `Id`, `Ranking`, `Leeftijd`, `Hoogste positie`, `Gewicht`, `Lengte`, `Geslacht`, `Toernooi`, `Club`)" +
                " VALUES ('"+ naam +"', '"+ id +"', '"+ ranking +"', '"+ leeftijd +"', '"+ hoogstePositie +"', '"+ gewicht +"', '"+ lengte +"', '"+ geslacht +"', '"+ toernooi +"', '"+ club +"')";
        s.executeUpdate(sql);
        s.close();
    }
}
