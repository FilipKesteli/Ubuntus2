package com.kesteli.filip.ubuntus2.vrste_posla.poslovi.poslovi_fragmenti.manualni_rad;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kesteli.filip.ubuntus2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GradevinaFragment extends Fragment {


    public GradevinaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gradevina, container, false);
    }

}
