package be.kuleuven.dbproject.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import static be.kuleuven.dbproject.models.ConnectionManager.s;
import static be.kuleuven.dbproject.models.PlayerRepository.getMatchenOpSpelerId;

public class Player {
    private String name;
    private String id;
    private String club;
    private int ranking;
    private int leeftijd;

    public int getHoogstePositie() {return hoogstePositie;}
    public int getGewicht() {return gewicht;}
    public String getGeslacht() {return geslacht;}
    public int getLengte() {return lengte;}
    public String getToernooi() {return toernooi;}
    public int getRanking() {return ranking;}
    public int getLeeftijd() { return leeftijd;}

    private int hoogstePositie;
    private int gewicht; //gewicht int kg
    private int lengte; //lengte in cm
    private String geslacht; //M voor man V voor vrouw
    private String toernooi; //Toernooi waar de speler voor ingeschreven is

    public Player(String name, String id, String club) {
        this.name = name;
        this.club = club;
        this.id = id;
    }

    public Player(String name, String id, String club, int ranking, int leeftijd, int hoogstePositie, int gewicht, int lengte, String geslacht, String toernooi) {
        this.name = name;
        this.club = club;
        this.id = id;
        this.ranking = ranking;
        this.leeftijd = leeftijd;
        this.hoogstePositie = hoogstePositie;
        this.gewicht = gewicht;
        this.lengte = lengte;
        this.geslacht = geslacht;
        this.toernooi = toernooi;
    }
    public Player(String name, String id, String club, int ranking, int leeftijd, int hoogstePositie, int gewicht, int lengte, String geslacht) {
        this.name = name;
        this.club = club;
        this.id = id;
        this.ranking = ranking;
        this.leeftijd = leeftijd;
        this.hoogstePositie = hoogstePositie;
        this.gewicht = gewicht;
        this.lengte = lengte;
        this.geslacht = geslacht;
        //Versie voor nieuwe spelers nog niet ingeschreven voor een toernooi
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return club == player.club && id == player.id && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, club, id);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", clubId=" + club +
                ", id=" + id +
                '}';
    }

    public int getAantalMatchen(String id) throws SQLException {
        ArrayList<Match> matchen = (ArrayList<Match>) getMatchenOpSpelerId(id);
        int aantalGespeeld = matchen.size();
        return aantalGespeeld;
    }
    public int getAantalGewonnen(String id) throws SQLException {
        ArrayList<Match> matchen = (ArrayList<Match>) getMatchenOpSpelerId(id);
        int aantalGewonnen  = 0;
        //Voor elke waar id = id van speler 1 en score van speler 1 > score van speler 2
        for (Match match : matchen) {
            System.out.println("eerste loop doorlopen");
            if (match.getIdSpeler1() == id && match.getScoreSpeler1() > match.getScoreSpeler2()) {
                aantalGewonnen++;
                System.out.println("eerste if is true");
            }
        }

        // + Voor elke waar id = id van speler 2 en score van speler 2 > score van speler 1
        for (Match match : matchen) {
            if (match.getIdSpeler2() == id && match.getScoreSpeler2() > match.getScoreSpeler1()) {
                aantalGewonnen++;
            }
        }
        return aantalGewonnen;
    }

    public int getAantalVerloren(String id) throws SQLException {
        return getAantalMatchen(id) - getAantalGewonnen(id);
    }
}
