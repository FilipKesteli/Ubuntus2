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
    private int fizika;
    private int matematika;
    private int kemija;
    private int androidDevelopment;

    //elektro-mehanicki popravak
    private int vesMasina, suderica, bojler, hidrofor, mobitel, kompjutor;

    //ostali popravci - posebno staviti mogucnost biranja naziva popravka
    private int ostaliPopravci;

    //manualni rad
    private int poljoprivreda, gradevina, pazitelj;

    //programiranje
    private int android, iOS, web, machineLearning, bazePodataka;

    //nastup
    private int radio, tv, javniGovor;

    //ostalo
    private int ostalo;

    public Clan() {
    }

    public Clan(String idClan, String ime, String prezime, String eMail, int godine, int brojUspjesnihTransakcija, int fizika, int matematika, int kemija, int androidDevelopment, int vesMasina, int suderica, int bojler, int hidrofor, int mobitel, int kompjutor, int ostaliPopravci, int poljoprivreda, int gradevina, int pazitelj, int android, int iOS, int web, int machineLearning, int bazePodataka, int radio, int tv, int javniGovor, int ostalo) {
        this.idClan = idClan;
        this.ime = ime;
        this.prezime = prezime;
        this.eMail = eMail;
        this.godine = godine;
        this.brojUspjesnihTransakcija = brojUspjesnihTransakcija;
        this.fizika = fizika;
        this.matematika = matematika;
        this.kemija = kemija;
        this.androidDevelopment = androidDevelopment;
        this.vesMasina = vesMasina;
        this.suderica = suderica;
        this.bojler = bojler;
        this.hidrofor = hidrofor;
        this.mobitel = mobitel;
        this.kompjutor = kompjutor;
        this.ostaliPopravci = ostaliPopravci;
        this.poljoprivreda = poljoprivreda;
        this.gradevina = gradevina;
        this.pazitelj = pazitelj;
        this.android = android;
        this.iOS = iOS;
        this.web = web;
        this.machineLearning = machineLearning;
        this.bazePodataka = bazePodataka;
        this.radio = radio;
        this.tv = tv;
        this.javniGovor = javniGovor;
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

    public int getAndroidDevelopment() {
        return androidDevelopment;
    }

    public void setAndroidDevelopment(int androidDevelopment) {
        this.androidDevelopment = androidDevelopment;
    }

    public int getVesMasina() {
        return vesMasina;
    }

    public void setVesMasina(int vesMasina) {
        this.vesMasina = vesMasina;
    }

    public int getSuderica() {
        return suderica;
    }

    public void setSuderica(int suderica) {
        this.suderica = suderica;
    }

    public int getBojler() {
        return bojler;
    }

    public void setBojler(int bojler) {
        this.bojler = bojler;
    }

    public int getHidrofor() {
        return hidrofor;
    }

    public void setHidrofor(int hidrofor) {
        this.hidrofor = hidrofor;
    }

    public int getMobitel() {
        return mobitel;
    }

    public void setMobitel(int mobitel) {
        this.mobitel = mobitel;
    }

    public int getKompjutor() {
        return kompjutor;
    }

    public void setKompjutor(int kompjutor) {
        this.kompjutor = kompjutor;
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

    public int getOstalo() {
        return ostalo;
    }

    public void setOstalo(int ostalo) {
        this.ostalo = ostalo;
    }
}
