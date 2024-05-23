package be.kuleuven.dbproject.models;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {
    public List<Player> getAlleSpelers() throws SQLException{
        List<Player> spelersLijst = new ArrayList<>();
        Statement statement = null;
        var result = statement.executeQuery("SELECT * FROM student;");
        while(result.next()){
            var naam = result.getString("Naam");
            var id = result.getString("Id");
            var ranking = result.getInt("Ranking");
            var leeftijd = result.getInt("Leeftijd");
            var hoogstePos = result.getInt("Hoogste positie");
            var gewicht = result.getInt("Gewicht");
            var lengte = result.getInt("Lengte");
            var geslacht = result.getString("Geslacht");
            var toernooi = result.getString("Toernooi");
            var club = result.getString("Club");
            Player speler = new Player(naam, id, club, ranking, leeftijd, hoogstePos, gewicht, lengte, geslacht, toernooi);
            spelersLijst.add(speler);
        }
        return spelersLijst;
    }
    public void addSpeler(Player speler){
        //TODO methode afmaken
    }
}
