package com.kesteli.filip.ubuntus2.clanovi;

import java.util.List;
import java.util.Map;

/**
 * Created by Valemate on 17.9.2017..
 */

public class Clan2 {

    //opcenite informacije clana
    private String idClan, ime, prezime, eMail;
    private int godine, brojUspjesnihTransakcija;
    private Map<String, Integer> instrukcijeMap;

    public Map<String, Integer> getInstrukcijeMap() {
        return instrukcijeMap;
    }

    public void setInstrukcijeMap(Map<String, Integer> instrukcijeMap) {
        this.instrukcijeMap = instrukcijeMap;
    }

    public Clan2(String idClan, String ime, String prezime, String eMail, int godine, int brojUspjesnihTransakcija, Map<String, Integer> instrukcijeMap) {
        this.idClan = idClan;
        this.ime = ime;
        this.prezime = prezime;
        this.eMail = eMail;
        this.godine = godine;
        this.brojUspjesnihTransakcija = brojUspjesnihTransakcija;
        this.instrukcijeMap = instrukcijeMap;
    }

    public Clan2() {
    }

    public String getIdClan() {
        return idClan;
    }

    public void setIdClan(String idClan) {
        this.idClan = idClan;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

    public int getBrojUspjesnihTransakcija() {
        return brojUspjesnihTransakcija;
    }

    public void setBrojUspjesnihTransakcija(int brojUspjesnihTransakcija) {
        this.brojUspjesnihTransakcija = brojUspjesnihTransakcija;
    }
}
