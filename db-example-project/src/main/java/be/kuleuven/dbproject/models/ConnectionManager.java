package be.kuleuven.dbproject.models;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
    private static Connection connection;
    static Statement s = null;

    public static void createDb() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:mydb.db");
            s = connection.createStatement();
            s.executeUpdate("""
                    BEGIN TRANSACTION;
                                                    
                    DROP TABLE IF EXISTS clubs;
                    CREATE TABLE clubs (
                      Naam text NOT NULL PRIMARY KEY,
                      Adres text NOT NULL
                    );
                                                    
                    DROP TABLE IF EXISTS matchen;
                    CREATE TABLE matchen (
                      match_id text NOT NULL PRIMARY KEY,
                      Plein text NOT NULL,
                      Tijdstip text NOT NULL,
                      Datum date NOT NULL,
                      Soort text,
                      Speler_1 text NOT NULL,
                      Speler_2 text NOT NULL,
                      Score_speler_1 INTEGER NOT NULL,
                      Score_speler_2 INTEGER NOT NULL,
                      id_scheidsrechter text,
                      Reeks text NOT NULL
                    );
                                                    
                    DROP TABLE IF EXISTS reeksen;
                    CREATE TABLE reeksen (
                      Naam text NOT NULL PRIMARY KEY,
                      Geslacht text NOT NULL,
                      Max_aantal_punten INTEGER NOT NULL,
                      Toernooi text NOT NULL
                    );
                                                    
                    DROP TABLE IF EXISTS spelers;
                    CREATE TABLE spelers (
                      Naam text NOT NULL,
                      Id text NOT NULL PRIMARY KEY,
                      Ranking INTEGER NOT NULL,
                      Leeftijd INTEGER NOT NULL,
                      Hoogste_positie INTEGER,
                      Gewicht INTEGER NOT NULL,
                      Lengte INTEGER NOT NULL,
                      Geslacht text NOT NULL,
                      Toernooi text,
                      Club text
                    );
                                                    
                    DROP TABLE IF EXISTS toernooien;
                    CREATE TABLE toernooien (
                      ID text NOT NULL PRIMARY KEY,
                      Naam text NOT NULL,
                      Locatie text NOT NULL,
                      Startdatum text not NULL
                    );
                                                    
                    INSERT INTO clubs (Naam, Adres) VALUES
                      ('G.T. Tessenderlo', 'Sportpark Tessenderlo'),
                      ('T.C. Ham', 'Tennisterreinen Ham'),
                      ('TennisDiepenbeek', 'UHasselt Campus Diepenbeek');
                                                    
                    INSERT INTO matchen (match_id, Plein, Tijdstip, Datum, Soort, Speler_1, Speler_2, Score_speler_1, Score_speler_2, id_scheidsrechter, Reeks) VALUES
                      ('anaerts0anaerts114304april2024', 'Plein 4', '14:30', '2024-04-04', NULL, 'anaerts0', 'anaerts1', 2, 1, NULL, 'Vrouwenn t.e.m. 10 punten');
                                                    
                    INSERT INTO reeksen (Naam, Geslacht, Max_aantal_punten, Toernooi) VALUES
                      ('Mannen t.e.m. 5 punten', 'M', 5, 'gttessenderlo4april2024'),
                      ('Vrouwenn t.e.m. 10 punten', 'V', 10, 'gttessenderlo4april2024');
                                                    
                    INSERT INTO spelers (Naam, Id, Ranking, Leeftijd, Hoogste_positie, Gewicht, Lengte, Geslacht, Toernooi, Club) VALUES
                      ('An Aerts', 'anaerts0', 3, 30, 2, 60, 170, 'V', NULL, 'G.T. Tessenderlo'),
                      ('An Aerts', 'anaerts1', 10, 20, 6, 65, 180, 'V', NULL, 'G.T. Tessenderlo'),
                      ('Ben Berent', 'benberent0', 1, 40, 4, 80, 190, 'M', NULL, 'T.C. Ham');
                                                    
                    INSERT INTO toernooien (ID, Naam, Locatie, Startdatum) VALUES
                      ('gttessenderlo4april2024', 'Paastoernooi G.T. Tessenderlo', 'G.T. Tessenderlo', '4 april 2024');
                                                    
                    COMMIT;
                                """);
        } catch (SQLException e) { //SQL van de database gemaakt in myphpadmin
            throw new RuntimeException("Error bij het aanmaken van de database");
        } finally {
            try {
                s.close();
            } catch (SQLException e){
                throw new RuntimeException("Errpr bij het sluiten van statement");
            }
        }

    }
}