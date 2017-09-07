package com.kesteli.filip.ubuntus2.vrste_posla;

import android.graphics.Color;

import com.kesteli.filip.ubuntus2.R;

/**
 * Created by Valemate on 5.9.2017..
 */

public class POJOVrstePosla {

    /**
     * *******************************************************************************************
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

    public int[] getImages() {
        return images;
    }

    public void setImages(int[] images) {
        this.images = images;
    }

    public int[] getColors() {
        return colors;
    }

    public void setColors(int[] colors) {
        this.colors = colors;
    }
}
