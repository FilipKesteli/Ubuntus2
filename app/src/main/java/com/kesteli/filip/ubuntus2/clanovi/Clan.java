package com.kesteli.filip.ubuntus2.clanovi;

/**
 * (1) Stavljam sve moguce feature-e koje clan moze imati
 * odnosno poslove koje moze raditi, tako da dok umecem, da samo ovdje umetnem
 */

public class Clan {
    //opcenite informacije clana
    private String idClan, ime, prezime, eMail;
    private int godine, brojUspjesnihTransakcija;

    //instrukcije
    private int fizika, matematika, kemija, androidInstrukcije, webInstrukcije;

    //elektricni popravak
    private int vesMasinaElektricni, sudericaElektricni, bojlerElektricni, hidroforElektricni, mobitelElektricni, kompjutorElektricni;

    //mehanicki popravak
    private int vesMasinaMehanicki, sudericaMehanicki, bojlerMehanicki, hidroforMehanicki, kompjutorMehanicki;

    //ostali popravci - posebno staviti mogucnost biranja naziva popravka
    private int ostaliPopravci;

    //manualni rad
    private int poljoprivreda, gradevina, vinograd, pazitelj;

    //programiranje
    private int android, iOS, web, machineLearning, bazePodataka;

    //nastup
    private int radio, tv, javniGovor, kazaliste, politika;

    //ostalo
    private int ostalo;

    public Clan() {
    }

    public Clan(String idClan, String ime, String prezime, String eMail, int godine, int brojUspjesnihTransakcija, int fizika, int matematika, int kemija, int androidInstrukcije, int webInstrukcije, int vesMasinaElektricni, int sudericaElektricni, int bojlerElektricni, int hidroforElektricni, int mobitelElektricni, int kompjutorElektricni, int vesMasinaMehanicki, int sudericaMehanicki, int bojlerMehanicki, int hidroforMehanicki, int kompjutorMehanicki, int ostaliPopravci, int poljoprivreda, int gradevina, int vinograd, int pazitelj, int android, int iOS, int web, int machineLearning, int bazePodataka, int radio, int tv, int javniGovor, int kazaliste, int politika, int ostalo) {
        this.idClan = idClan;
        this.ime = ime;
        this.prezime = prezime;
        this.eMail = eMail;
        this.godine = godine;
        this.brojUspjesnihTransakcija = brojUspjesnihTransakcija;
        this.fizika = fizika;
        this.matematika = matematika;
        this.kemija = kemija;
        this.androidInstrukcije = androidInstrukcije;
        this.webInstrukcije = webInstrukcije;
        this.vesMasinaElektricni = vesMasinaElektricni;
        this.sudericaElektricni = sudericaElektricni;
        this.bojlerElektricni = bojlerElektricni;
        this.hidroforElektricni = hidroforElektricni;
        this.mobitelElektricni = mobitelElektricni;
        this.kompjutorElektricni = kompjutorElektricni;
        this.vesMasinaMehanicki = vesMasinaMehanicki;
        this.sudericaMehanicki = sudericaMehanicki;
        this.bojlerMehanicki = bojlerMehanicki;
        this.hidroforMehanicki = hidroforMehanicki;
        this.kompjutorMehanicki = kompjutorMehanicki;
        this.ostaliPopravci = ostaliPopravci;
        this.poljoprivreda = poljoprivreda;
        this.gradevina = gradevina;
        this.vinograd = vinograd;
        this.pazitelj = pazitelj;
        this.android = android;
        this.iOS = iOS;
        this.web = web;
        this.machineLearning = machineLearning;
        this.bazePodataka = bazePodataka;
        this.radio = radio;
        this.tv = tv;
        this.javniGovor = javniGovor;
        this.kazaliste = kazaliste;
        this.politika = politika;
        this.ostalo = ostalo;
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

    public int getFizika() {
        return fizika;
    }

    public void setFizika(int fizika) {
        this.fizika = fizika;
    }

    public int getMatematika() {
        return matematika;
    }

    public void setMatematika(int matematika) {
        this.matematika = matematika;
    }

    public int getKemija() {
        return kemija;
    }

    public void setKemija(int kemija) {
        this.kemija = kemija;
    }

    public int getAndroidInstrukcije() {
        return androidInstrukcije;
    }

    public void setAndroidInstrukcije(int androidInstrukcije) {
        this.androidInstrukcije = androidInstrukcije;
    }

    public int getWebInstrukcije() {
        return webInstrukcije;
    }

    public void setWebInstrukcije(int webInstrukcije) {
        this.webInstrukcije = webInstrukcije;
    }

    public int getVesMasinaElektricni() {
        return vesMasinaElektricni;
    }

    public void setVesMasinaElektricni(int vesMasinaElektricni) {
        this.vesMasinaElektricni = vesMasinaElektricni;
    }

    public int getSudericaElektricni() {
        return sudericaElektricni;
    }

    public void setSudericaElektricni(int sudericaElektricni) {
        this.sudericaElektricni = sudericaElektricni;
    }

    public int getBojlerElektricni() {
        return bojlerElektricni;
    }

    public void setBojlerElektricni(int bojlerElektricni) {
        this.bojlerElektricni = bojlerElektricni;
    }

    public int getHidroforElektricni() {
        return hidroforElektricni;
    }

    public void setHidroforElektricni(int hidroforElektricni) {
        this.hidroforElektricni = hidroforElektricni;
    }

    public int getMobitelElektricni() {
        return mobitelElektricni;
    }

    public void setMobitelElektricni(int mobitelElektricni) {
        this.mobitelElektricni = mobitelElektricni;
    }

    public int getKompjutorElektricni() {
        return kompjutorElektricni;
    }

    public void setKompjutorElektricni(int kompjutorElektricni) {
        this.kompjutorElektricni = kompjutorElektricni;
    }

    public int getVesMasinaMehanicki() {
        return vesMasinaMehanicki;
    }

    public void setVesMasinaMehanicki(int vesMasinaMehanicki) {
        this.vesMasinaMehanicki = vesMasinaMehanicki;
    }

    public int getSudericaMehanicki() {
        return sudericaMehanicki;
    }

    public void setSudericaMehanicki(int sudericaMehanicki) {
        this.sudericaMehanicki = sudericaMehanicki;
    }

    public int getBojlerMehanicki() {
        return bojlerMehanicki;
    }

    public void setBojlerMehanicki(int bojlerMehanicki) {
        this.bojlerMehanicki = bojlerMehanicki;
    }

    public int getHidroforMehanicki() {
        return hidroforMehanicki;
    }

    public void setHidroforMehanicki(int hidroforMehanicki) {
        this.hidroforMehanicki = hidroforMehanicki;
    }

    public int getKompjutorMehanicki() {
        return kompjutorMehanicki;
    }

    public void setKompjutorMehanicki(int kompjutorMehanicki) {
        this.kompjutorMehanicki = kompjutorMehanicki;
    }

    public int getOstaliPopravci() {
        return ostaliPopravci;
    }

    public void setOstaliPopravci(int ostaliPopravci) {
        this.ostaliPopravci = ostaliPopravci;
    }

    public int getPoljoprivreda() {
        return poljoprivreda;
    }

    public void setPoljoprivreda(int poljoprivreda) {
        this.poljoprivreda = poljoprivreda;
    }

    public int getGradevina() {
        return gradevina;
    }

    public void setGradevina(int gradevina) {
        this.gradevina = gradevina;
    }

    public int getVinograd() {
        return vinograd;
    }

    public void setVinograd(int vinograd) {
        this.vinograd = vinograd;
    }

    public int getPazitelj() {
        return pazitelj;
    }

    public void setPazitelj(int pazitelj) {
        this.pazitelj = pazitelj;
    }

    public int getAndroid() {
        return android;
    }

    public void setAndroid(int android) {
        this.android = android;
    }

    public int getiOS() {
        return iOS;
    }

    public void setiOS(int iOS) {
        this.iOS = iOS;
    }

    public int getWeb() {
        return web;
    }

    public void setWeb(int web) {
        this.web = web;
    }

    public int getMachineLearning() {
        return machineLearning;
    }

    public void setMachineLearning(int machineLearning) {
        this.machineLearning = machineLearning;
    }

    public int getBazePodataka() {
        return bazePodataka;
    }

    public void setBazePodataka(int bazePodataka) {
        this.bazePodataka = bazePodataka;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getTv() {
        return tv;
    }

    public void setTv(int tv) {
        this.tv = tv;
    }

    public int getJavniGovor() {
        return javniGovor;
    }

    public void setJavniGovor(int javniGovor) {
        this.javniGovor = javniGovor;
    }

    public int getKazaliste() {
        return kazaliste;
    }

    public void setKazaliste(int kazaliste) {
        this.kazaliste = kazaliste;
    }

    public int getPolitika() {
        return politika;
    }

    public void setPolitika(int politika) {
        this.politika = politika;
    }

    public int getOstalo() {
        return ostalo;
    }

    public void setOstalo(int ostalo) {
        this.ostalo = ostalo;
    }
}
