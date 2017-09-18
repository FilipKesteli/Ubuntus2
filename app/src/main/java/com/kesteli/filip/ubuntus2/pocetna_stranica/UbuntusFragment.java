package com.kesteli.filip.ubuntus2.pocetna_stranica;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.hsalf.smilerating.SmileRating;
import com.kesteli.filip.ubuntus2.R;
import com.kesteli.filip.ubuntus2.clanovi.Clan2;
import com.kesteli.filip.ubuntus2.login.POJOLogin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class UbuntusFragment extends Fragment {

    SmileRating smileRating;

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private FirebaseUser user;

    private DatabaseReference databaseReference;
    private DatabaseReference childClanovi2;
    private DatabaseReference childClan2;
//    private String idClan2="", ime2="", prezime2="", eMail2="", instrukcije="";
    private Map<String, Integer> instrukcijeMap;

    private SharedPreferences sharedPreferences;

    public UbuntusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ubuntus, container, false);

        setupFirebase();
        setupSharedPreferences();
        addToFirebase();

        initViews(view);
        setupListeners();
        return view;
    }

    private void setupFirebase() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        //get firebase auth instance
        auth = FirebaseAuth.getInstance();
        //get current user
        user = FirebaseAuth.getInstance().getCurrentUser();
    }

    private void setupSharedPreferences() {
        sharedPreferences = getActivity().getSharedPreferences(POJOLogin.KEY_MOJ_LOGIN_SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    //TODO: Mozda staviti kakav boolean flag!
    private void addToFirebase() {
        if (user != null) {
            String idClan2 = user.getUid();
            String eMail2 = user.getEmail();
            String ime2 = sharedPreferences.getString(POJOLogin.KEY_IME, "nista");
            String prezime2 = sharedPreferences.getString(POJOLogin.KEY_PREZIME, "nista");
            String instrukcije = sharedPreferences.getString(POJOLogin.KEY_INSTRUKCIJE, "nista");

            instrukcijeMap = new HashMap<>();
            instrukcijeMap.put("fizika", 1);
            instrukcijeMap.put("matematika", 0);
            instrukcijeMap.put(instrukcije, 1);
            instrukcijeMap.put("androidInstrukcije", 0);
            instrukcijeMap.put("webInstrukcije", 0);

            childClanovi2 = databaseReference.child("Clanovi2");
            childClan2 = childClanovi2.child(idClan2);
            childClan2.child("ime").setValue(ime2);
            childClan2.child("prezime").setValue(prezime2);
            childClan2.child("eMail").setValue(eMail2);
            childClan2.child("instrukcijeMap").setValue(instrukcijeMap);

            Log.d("u3", ime2);
        }
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
