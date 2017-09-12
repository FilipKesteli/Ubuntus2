package com.kesteli.filip.ubuntus2.vrste_posla;

import android.graphics.Color;

import com.kesteli.filip.ubuntus2.R;

/**
 * Created by Valemate on 5.9.2017..
 */

public class POJOVrstePosla {

    /**
     * ********************************VRSTE POSLA**************************
     */

    private String[] titles = {
            "Instrukcije",
            "Električni popravak",
            "Mehanički popravak",
            "Ostali popravci",
            "Manualni rad",
            "Pisanje projekata",
            "Programiranje",
            "Nastupanje",
            "Istraživanje",
            "Ostalo"
    };

    private int[] images = {
            R.drawable.ic_group_white_24dp,
            R.drawable.ic_scanner_white_24dp,
            R.drawable.ic_directions_car_white_24dp,
            R.drawable.ic_toys_white_24dp,
            R.drawable.ic_format_paint_white_24dp,
            R.drawable.ic_spellcheck_white_24dp,
            R.drawable.ic_laptop_mac_white_24dp,
            R.drawable.ic_accessibility_white_24dp,
            R.drawable.ic_memory_white_24dp,
            R.drawable.ic_music_video_white_24dp
    };

    private int[] colors = {
            Color.CYAN,
            Color.CYAN,
            Color.YELLOW,
            Color.YELLOW,
            Color.RED,
            Color.RED,
            Color.GREEN,
            Color.GREEN,
            Color.CYAN,
            Color.CYAN
    };

    /**
     * *******************************************************************************************
     */

    private static final String vrste_posla_PREFERENCES = "vrste_posla_preferences";

    private static final String elektricni_popravak = "elektricni_popravak";
    private static final String instrukcije = "instrukcije";
    private static final String istrazivanje = "istrazivanje";
    private static final String manualni_rad = "manualni_rad";
    private static final String mehanicki_popravak = "mehanicki_popravak";
    private static final String nastupanje = "nastupanje";
    private static final String ostali_popravci = "ostali_popravci";
    private static final String ostalo = "ostalo";
    private static final String pisanje_projekata = "pisanje_projekata";
    private static final String programiranje = "programiranje";

    public static String getVrste_posla_PREFERENCES() {
        return vrste_posla_PREFERENCES;
    }

    public static String getElektricni_popravak() {
        return elektricni_popravak;
    }

    public static String getInstrukcije() {
        return instrukcije;
    }

    public static String getIstrazivanje() {
        return istrazivanje;
    }

    public static String getManualni_rad() {
        return manualni_rad;
    }

    public static String getMehanicki_popravak() {
        return mehanicki_popravak;
    }

    public static String getNastupanje() {
        return nastupanje;
    }

    public static String getOstali_popravci() {
        return ostali_popravci;
    }

    public static String getOstalo() {
        return ostalo;
    }

    public static String getPisanje_projekata() {
        return pisanje_projekata;
    }

    public static String getProgramiranje() {
        return programiranje;
    }

    public static String[] getPitanjaTimReality() {
        return pitanjaTimReality;
    }

    public static String[] getPitanjaClanReality() {
        return pitanjaClanReality;
    }

    public void setIdejeTitles(String[] idejeTitles) {
        this.idejeTitles = idejeTitles;
    }

    public void setIdejeColors(int[] idejeColors) {
        this.idejeColors = idejeColors;
    }

    public void setEdukacija(String[] edukacija) {
        this.edukacija = edukacija;
    }

    private static final String MyClanakPREFERENCE = "clanak"; //ne koristim vise

    public static String getMyClanakPREFERENCE() {
        return MyClanakPREFERENCE;
    }

    private static final String MyPREFERENCES = "MyPrefs"; //ne koristim vise

    public static String getWebStranicePREFERENCES() {
        return webStranicePREFERENCES;
    }

    private static final String webStranicePREFERENCES = "PreferencaWebStranice";

    public static String getSitePREFERENCES() {
        return sitePREFERENCES;
    }

    private static final String sitePREFERENCES = "PreferencaWebStranice";

    public static String getMyPREFERENCES() {
        return MyPREFERENCES;
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public int[] getColors() {
        return colors;
    }

    public void setColors(int[] colors) {
        this.colors = colors;
    }






    /**
     * *******************************************************************************************
     */


    /**
     * *******************************************************************************************
     * PITANJA ZA REALITY CHECK
     */

    //TODO Napraviti bazu podataka RealityCheck s tablicama Tim i Clan, sve u ovoj aplikaciji
    private static final String[] pitanjaTimReality = {
            "Koliko je ljudi koje će zahvatiti projekt?",
            "Koliko takvih projekata već postoji na internetu?",
            "Koliko vi vjerujete da će projekt uspjeti?",
            "Koliko ćete uložiti u projekt?",
            "Koliko je realno da će projekt uspjeti?",
            "Tko će uložiti u projekt?",
            "Koja je motivacija za za projekt?",
            "Koliko ste Vi kao ekipa motivirani za projekt?",
            "Zabilježite koja sve područja projekt pokriva.",
            "Kolika je šansa da će netko uložiti u projekt?"
    };

    private static final String[] pitanjaClanReality = {
            "Ime",
            "Prezime",
            "Godine",
            "Iskustvo u tehnologiji kojom će se tim baviti (u mjesecima)",
            "Iskustvo općenito (u mjesecima)",
            "Obrazovanje",
            "Koliko je dana prošlo od kad je zadnji puta radio?"
    };


    /**
     * *******************************************************************************************
     */

    private static final String fizika_clanci = "fizika_clanci";
    private static final String kemija_clanci = "kemija_clanci";
    private static final String matematika_clanci = "matematika_clanci";
    private static final String tehnika_clanci = "tehnika_clanci";
    private static final String medicina_clanci = "medicina_clanci";
    private static final String biologija_clanci = "biologija_clanci";
    private static final String astronomija_clanci = "astronomija_clanci";
    private static final String geologija_clanci = "geologija_clanci";

    private static final String reality_check = "reality_check";
    private static final String education_express = "education_express";
    private static final String kz_inicijativa = "kz_inicijativa";
    private static final String smart_city = "smart_city";
    private static final String apsolute_democracy = "apsolute_democracy";
    private static final String motivator = "motivator";
    private static final String clanci = "clanci";
    private static final String donation = "donation";

    /**
     * *******************************************************************************************
     */



    /**
     *
     * ********************************************************************************************
     */

    private String[] idejeTitles = {
            "Education express",
            "Absolute democracy",
            "Znanstveni časopisi",
            "Donacije",
            "KŽ Inicijativa",
            "Motivator",
            "Reality checker",
            "Smart city"
    };

    private int[] idejeColors = {
            Color.CYAN,
            Color.CYAN,
            Color.YELLOW,
            Color.YELLOW,
            Color.RED,
            Color.RED,
            Color.GREEN,
            Color.GREEN
    };

    /**
     *
     * ********************************************************************************************
     */

    public static String getReality_check() {
        return reality_check;
    }

    public static String getFizika_clanci() {
        return fizika_clanci;
    }

    public static String getKemija_clanci() {
        return kemija_clanci;
    }

    public static String getMatematika_clanci() {
        return matematika_clanci;
    }

    public static String getTehnika_clanci() {
        return tehnika_clanci;
    }

    public static String getMedicina_clanci() {
        return medicina_clanci;
    }

    public static String getBiologija_clanci() {
        return biologija_clanci;
    }

    public static String getAstronomija_clanci() {
        return astronomija_clanci;
    }

    public static String getGeologija_clanci() {
        return geologija_clanci;
    }

    public static String getEducation_express() {
        return education_express;
    }

    public static String getKz_inicijativa() {
        return kz_inicijativa;
    }

    public static String getSmart_city() {
        return smart_city;
    }

    public static String getApsolute_democracy() {
        return apsolute_democracy;
    }

    public static String getMotivator() {
        return motivator;
    }

    public static String getClanci() {
        return clanci;
    }

    public static String getDonation() {
        return donation;
    }

    public String[] getIdejeTitles() {
        return idejeTitles;
    }

    public int[] getIdejeColors() {
        return idejeColors;
    }

    private String[] clanci_fizika = {
            "https://www.sciencedaily.com/news/matter_energy/physics/",
            "https://www.sciencedaily.com/news/matter_energy/physics/",
            "http://physicsworld.com/cws/channel/news",
            "http://www.physics.org/news.asp",
            "http://scitation.aip.org/content/aip/magazine/physicstoday/news",
            "http://www.scientificamerican.com/physics/",
            "http://discovermagazine.com/tags/physics",
            "https://physics.aps.org/",
            "https://www.newscientist.com/subject/physics/",
            "http://www.sci-news.com/news/physics"
    };

    private String[] fizika = {"phys.org", "science daily", "physics world", "physics.org", "scitation.aip", "sci american", "discover", "physics.aps", "new scientist", "sci news"};
    private String[] edukacija = {"Android", "iOS", "Web", "Machine Learning", "Internet of things", ".NET", "Big Data", "Deep Learning", "Neural Networks", "Database management"};

    public String[] getEdukacija() {
        return edukacija;
    }

    private String[] clanci_kemija = {
            "http://www.scientificamerican.com/chemistry/",
            "http://www.scientificamerican.com/chemistry/",
            "http://www.iflscience.com/chemistry/",
            "https://www.sciencedaily.com/news/matter_energy/chemistry/",
            "http://www.sciencemag.org/category/chemistry",
            "https://www.rsc.org/chemistryworld/news",
            "http://www.nytimes.com/topic/subject/chemistry",
            "http://www.sci-news.com/news/othersciences/chemistry",
            "http://cen.acs.org/news.html",
            "http://scienceworld.scholastic.com/Chemistry-News/"
    };

    private String[] kemija = {"sci american", "phys.org", "ifl science", "science daily", "science mag", "chem world", "ny times", "sci-news", "cen.acs.org", "science world"};

    private String[] clanci_matematika = {
            "http://www.scientificamerican.com/math/",
            "https://www.sciencedaily.com/news/computers_math/mathematics/",
            "http://phys.org/science-news/mathematics/",
            "https://plus.maths.org/content/News",
            "http://www.independent.co.uk/topic/Mathematics",
            "http://news.mit.edu/topic/mathematics",
            "http://www.usnews.com/topics/subjects/math",
            "http://math.alltop.com/",
            "http://www.nytimes.com/topic/subject/mathematics",
            "http://www.ams.org/news/math-in-the-media/mathdigest-index"
    };

    private String[] matematika = {"sci american", "science daily", "phys.org", "plus.maths.org", "independent.co.uk", "news mit", "us news", "math.alltop", "ny times", "ams.org"};

    private String[] clanci_tehnika = {
            "http://www.bbc.com/news/technology",
            "http://edition.cnn.com/tech",
            "http://www.cnet.com/news/",
            "http://www.technewsworld.com/",
            "http://www.theverge.com/tech",
            "http://timesofindia.indiatimes.com/tech/tech-news",
            "http://www.telegraph.co.uk/technology/news/",
            "http://www.extremetech.com/",
            "http://www.news.com.au/technology",
            "http://www.reuters.com/news/technology"
    };

    private String[] tehnika = {"bbc", "cnn", "cnet", "tech news world", "the verge", "times of india", "telegraph", "extreme tech", "news.com", "reuters"};

    private String[] clanci_medicina = {
            "http://www.bbc.com/news/us/health",
            "http://www.medicalnewstoday.com/",
            "https://www.sciencedaily.com/news/health_medicine/",
            "http://www.news-medical.net/",
            "http://www.livescience.com/health",
            "http://www.internalmedicinenews.com/",
            "http://www.medpagetoday.com/specialty",
            "http://med.stanford.edu/news.html",
            "http://med.stanford.edu/news/all-news.html",
            "http://edition.cnn.com/health"
    };

    private String[] medicina = {"bbc", "medical news today", "sci daily", "news medical", "live science", "inter med news", "med page", "standford", "stanford all", "cnn"};

    private String[] clanci_biologija = {
            "http://www.scientificamerican.com/biology/",
            "https://www.sciencedaily.com/news/plants_animals/biology/",
            "http://www.sci-news.com/news/biology",
            "http://phys.org/biology-news/",
            "http://www.biologynews.net/",
            "https://nsf.gov/news/index.jsp?prio_area=3",
            "http://www.sciencemag.org/category/biology",
            "http://www.usnews.com/topics/subjects/biology",
            "https://www.theguardian.com/science/biology",
            "http://scienceworld.scholastic.com/Biology-News/"
    };

    private String[] biologija = {"sci american", "sci daily", "sci news", "phys.org", "bio news", "nsf.gov", "science mag", "us news", "the guardian", "sci world"};

    private String[] clanci_astronomija = {
            "http://www.astronomy.com/news",
            "http://www.skyandtelescope.com/astronomy-news/",
            "http://phys.org/space-news/astronomy/",
            "https://www.sciencedaily.com/news/space_time/astronomy/",
            "https://astronomynow.com/category/news/",
            "http://www.sci-news.com/news/astronomy",
            "http://www.space.com/science-astronomy",
            "https://www.newscientist.com/subject/space/",
            "http://www.universetoday.com/",
            "http://www.skyatnightmagazine.com/astronomy-news"
    };

    private String[] astronomija = {"astronomy.com", "sky and telescope", "phys.org", "sci daily", "astronomy now", "sci news", "space", "new scientist", "universe today", "sky and night"};

    private String[] clanci_geologija = {
            "https://www.sciencedaily.com/news/earth_climate/geology/",
            "http://geology.com/",
            "http://www.sci-news.com/news/geology",
            "https://www.theguardian.com/science/geology",
            "http://geology.alltop.com/",
            "http://www.nature.com/subjects/geology",
            "http://www.livescience.com/environment",
            "http://www.geosociety.org/news/",
            "http://www.telegraph.co.uk/news/earth/environment/geology/",
            "http://www.independent.co.uk/topic/Geology"
    };

    private String[] geologija = {"sci daily", "geology", "sci news", "the guardian", "geology.alltop", "nature", "live sci", "geo society", "telegraph", "independent"};

    public String[] getClanci_fizika() {
        return clanci_fizika;
    }

    public void setClanci_fizika(String[] clanci_fizika) {
        this.clanci_fizika = clanci_fizika;
    }

    public String[] getFizika() {
        return fizika;
    }

    public void setFizika(String[] fizika) {
        this.fizika = fizika;
    }

    public String[] getClanci_kemija() {
        return clanci_kemija;
    }

    public void setClanci_kemija(String[] clanci_kemija) {
        this.clanci_kemija = clanci_kemija;
    }

    public String[] getKemija() {
        return kemija;
    }

    public void setKemija(String[] kemija) {
        this.kemija = kemija;
    }

    public String[] getClanci_matematika() {
        return clanci_matematika;
    }

    public void setClanci_matematika(String[] clanci_matematika) {
        this.clanci_matematika = clanci_matematika;
    }

    public String[] getMatematika() {
        return matematika;
    }

    public void setMatematika(String[] matematika) {
        this.matematika = matematika;
    }

    public String[] getClanci_tehnika() {
        return clanci_tehnika;
    }

    public void setClanci_tehnika(String[] clanci_tehnika) {
        this.clanci_tehnika = clanci_tehnika;
    }

    public String[] getTehnika() {
        return tehnika;
    }

    public void setTehnika(String[] tehnika) {
        this.tehnika = tehnika;
    }

    public String[] getClanci_medicina() {
        return clanci_medicina;
    }

    public void setClanci_medicina(String[] clanci_medicina) {
        this.clanci_medicina = clanci_medicina;
    }

    public String[] getMedicina() {
        return medicina;
    }

    public void setMedicina(String[] medicina) {
        this.medicina = medicina;
    }

    public String[] getClanci_biologija() {
        return clanci_biologija;
    }

    public void setClanci_biologija(String[] clanci_biologija) {
        this.clanci_biologija = clanci_biologija;
    }

    public String[] getBiologija() {
        return biologija;
    }

    public void setBiologija(String[] biologija) {
        this.biologija = biologija;
    }

    public String[] getClanci_astronomija() {
        return clanci_astronomija;
    }

    public void setClanci_astronomija(String[] clanci_astronomija) {
        this.clanci_astronomija = clanci_astronomija;
    }

    public String[] getAstronomija() {
        return astronomija;
    }

    public void setAstronomija(String[] astronomija) {
        this.astronomija = astronomija;
    }

    public String[] getClanci_geologija() {
        return clanci_geologija;
    }

    public void setClanci_geologija(String[] clanci_geologija) {
        this.clanci_geologija = clanci_geologija;
    }

    public String[] getGeologija() {
        return geologija;
    }

    public void setGeologija(String[] geologija) {
        this.geologija = geologija;
    }

    public int[] getImages() {
        return images;
    }

    public void setImages(int[] images) {
        this.images = images;
    }
}
