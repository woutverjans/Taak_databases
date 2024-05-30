package be.kuleuven.dbproject.models;

public class Toernooi {
    private String id;
    private String naam;
    private String locatie;

    public String getIdWedstrijdleider() {
        return idWedstrijdleider;
    }

    public void setIdWedstrijdleider(String idWedstrijdleider) {
        this.idWedstrijdleider = idWedstrijdleider;
    }

    private String idWedstrijdleider;

    public Toernooi(String id, String naam, String locatie) {
        this.id = id;
        this.naam = naam;
        this.locatie = locatie;
    }

    public String getId() {return id;}
    public String getNaam() {return naam;}
    public String getLocatie() {return locatie;}
}
