package com.kesteli.filip.ubuntus2.pocetna_stranica;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kesteli.filip.ubuntus2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PonudeFragment extends Fragment {


    public PonudeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ponude, container, false);
    }

}