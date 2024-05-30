package be.kuleuven.dbproject.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MatchRepository {
    public static void matchNaarDb(Match match) throws SQLException {
        Connection connection  = null;
        connection = DriverManager.getConnection("jdbc:sqlite:mydb.db");
        var s = connection.createStatement();
        var matchId = match.getMatchId();
        var plein = match.getPlein();
        var tijdsstip = match.getTijdsStip();
        var datum = match.getDatum();
        var soort = match.getSoort();
        var speler1 = match.getIdSpeler1();
        var speler2 = match.getIdSpeler2();
        var score1 = match.getScoreSpeler1();
        var score2 = match.getScoreSpeler2();
        var scheidsrechter = match.getIdScheidsRechter();
        var reeks = match.getReeks();
        String sql = "INSERT INTO `matchen` (`match_id`, `Plein`, `Tijdstip`, `Datum`, `Soort`, `Speler_1`, `Speler_2`, `Score_speler_1`, `Score_speler_2`, `id_scheidsrechter`, 'Reeks')" +
                " VALUES ('"+ matchId +"', '"+ plein +"', '"+ tijdsstip +"', '"+ datum +"', '"+ soort +"', '"+ speler1 +"', '"+ speler2 +"', '"+ score1 +"', '"+ score2 +"', '"+ scheidsrechter +"', '"+ reeks +"')";
        s.executeUpdate(sql);
        s.close();
    }
}
