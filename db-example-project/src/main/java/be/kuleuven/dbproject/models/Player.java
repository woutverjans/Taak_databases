package be.kuleuven.dbproject.models;
import java.util.Objects;

public class Player {
    private String name;
    private String id;
    private String club;
    private int ranking;
    private int leeftijd;
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
}
