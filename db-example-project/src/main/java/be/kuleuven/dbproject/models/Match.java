package be.kuleuven.dbproject.models;


import java.sql.Date;

public class Match {
    private String matchId;
    private String plein;
    private String tijdsStip;
    private String datum;
    private String soort; //Finale, halve finale, ...
    private String idSpeler1;
    private String idSpeler2;
    private int scoreSpeler1;
    private int scoreSpeler2;
    private String idScheidsRechter;
    private String reeks;

    public Match(String matchId, String plein, String tijdsStip, String datum, String idSpeler1, String idSpeler2, int score1, int score2, String reeks, String soort, String scheidsId){
        this.matchId = matchId;
        this.plein = plein;
        this.tijdsStip = tijdsStip;
        this.datum = datum;
        this.idSpeler1 = idSpeler1;
        this.idSpeler2 = idSpeler2;
        this.scoreSpeler1 = score1;
        this.scoreSpeler2 = score2;
        this.reeks = reeks;
        this.soort = soort;
        this.idScheidsRechter = scheidsId;
    }

    public String getMatchId() {return matchId;}

    public String getPlein() {return plein;}

    public String getTijdsStip() {return tijdsStip;}

    public String getDatum() {return datum;}

    public String getSoort() {return soort;}

    public String getIdSpeler1() {return idSpeler1;}

    public String getIdSpeler2() {return idSpeler2;}

    public int getScoreSpeler1() {return scoreSpeler1;}

    public int getScoreSpeler2() {return scoreSpeler2;}

    public String getIdScheidsRechter() {return idScheidsRechter;}

    public String getReeks() {return reeks;}
}
