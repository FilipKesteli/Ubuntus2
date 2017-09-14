package com.kesteli.filip.ubuntus2.pocetna_stranica;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.hsalf.smilerating.SmileRating;
import com.kesteli.filip.ubuntus2.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class UbuntusFragment extends Fragment {

    SmileRating smileRating;

    public UbuntusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ubuntus, container, false);

        initViews(view);
        setupListeners();

        return view;
    }

    private void initViews(View view) {
        smileRating = (SmileRating) view.findViewById(R.id.smileyRating);
        smileRating.setSelectedSmile(SmileRating.GREAT, true);
    }

    boolean flagUkljuci = true; //flag tako da covjek samo jednom moze
    private void setupListeners() {
        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley) {
                if (flagUkljuci == true) {
                    switch (smiley) {
                        case SmileRating.TERRIBLE:
                            Log.d("m1", "terrible");
                            flagUkljuci = false;
                            break;
                        case SmileRating.BAD:
                            Log.d("m1", "bad");
                            flagUkljuci = false;
                            break;
                        case SmileRating.OKAY:
                            Log.d("m1", "okay");
                            flagUkljuci = false;
                            break;
                        case SmileRating.GOOD:
                            Log.d("m1", "good");
                            flagUkljuci = false;
                            break;
                        case SmileRating.GREAT:
                            Log.d("m1", "great");
                            flagUkljuci = false;
                            break;
                    }
                }
            }
        });
    }

}
