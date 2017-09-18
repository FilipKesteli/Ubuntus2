package com.kesteli.filip.ubuntus2.vrste_posla.poslovi;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kesteli.filip.ubuntus2.R;
import com.kesteli.filip.ubuntus2.vrste_posla.POJOVrstePosla;
import com.kesteli.filip.ubuntus2.vrste_posla.poslovi.poslovi_fragmenti.instrukcije.AndroidInstrukcijeFragment;
import com.kesteli.filip.ubuntus2.vrste_posla.poslovi.poslovi_fragmenti.instrukcije.FizikaFragment;
import com.kesteli.filip.ubuntus2.vrste_posla.poslovi.poslovi_fragmenti.instrukcije.KemijaFragment;
import com.kesteli.filip.ubuntus2.vrste_posla.poslovi.poslovi_fragmenti.instrukcije.MatematikaFragment;
import com.kesteli.filip.ubuntus2.vrste_posla.poslovi.poslovi_fragmenti.instrukcije.WebInstrukcijeFragment;

import java.util.ArrayList;
import java.util.List;

public class PosloviActivity extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private DatabaseReference childClanovi;
    private DatabaseReference childClan;

    private Toolbar toolbarPoslovi;

    private TabLayout tabLayoutPoslovi;
    private ViewPager viewPagerPoslovi;
    private ViewPagerAdapter adapterPoslovi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poslovi);
        Toast.makeText(PosloviActivity.this, "Ovo je PosloviActivity", Toast.LENGTH_SHORT).show();

        setupFirebase();
        initViews();
//        setupToolbar();

        setupToolbar();
        setupViewPager();
        setupTabLayout();
        setupFragments();

        setupListeners();
    }

    private void setupFirebase() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        //get firebase auth instance
        auth = FirebaseAuth.getInstance();
        //get current user
        user = FirebaseAuth.getInstance().getCurrentUser();
    }

    private void initViews() {
        viewPagerPoslovi = (ViewPager) findViewById(R.id.viewpagerPoslovi);
        tabLayoutPoslovi = (TabLayout) findViewById(R.id.tabsPoslovi);
    }

    private void setupToolbar() {
        toolbarPoslovi = (Toolbar) findViewById(R.id.toolbarPoslovi);
        setSupportActionBar(toolbarPoslovi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupViewPager() {
        adapterPoslovi = new ViewPagerAdapter(getSupportFragmentManager());
    }

    private void setupTabLayout() {
        tabLayoutPoslovi.setupWithViewPager(viewPagerPoslovi);
    }

    private void setupFragments() {
        Intent intent = getIntent();
        if (intent.hasExtra(POJOVrstePosla.getInstrukcije())) {
            adapterPoslovi.addFrag(new FizikaFragment(), "Fizika");
            adapterPoslovi.addFrag(new KemijaFragment(), "Kemija");
            adapterPoslovi.addFrag(new MatematikaFragment(), "Matematika");
            adapterPoslovi.addFrag(new WebInstrukcijeFragment(), "Web instrukcije");
            adapterPoslovi.addFrag(new AndroidInstrukcijeFragment(), "Android instrukcije");
            viewPagerPoslovi.setAdapter(adapterPoslovi);
            tabLayoutPoslovi.getTabAt(0).setIcon(R.drawable.ic_all_inclusive_white_24dp);
            tabLayoutPoslovi.getTabAt(1).setIcon(R.drawable.ic_all_inclusive_white_24dp);
            tabLayoutPoslovi.getTabAt(2).setIcon(R.drawable.ic_all_inclusive_white_24dp);
            tabLayoutPoslovi.getTabAt(3).setIcon(R.drawable.ic_all_inclusive_white_24dp);
            tabLayoutPoslovi.getTabAt(4).setIcon(R.drawable.ic_all_inclusive_white_24dp);
        } else if (intent.hasExtra(POJOVrstePosla.getElektricni_popravak())) {
            adapterPoslovi.addFrag(new FizikaFragment(), "Fizika");
            adapterPoslovi.addFrag(new KemijaFragment(), "Kemija");
            adapterPoslovi.addFrag(new MatematikaFragment(), "Matematika");
            adapterPoslovi.addFrag(new WebInstrukcijeFragment(), "Web instrukcije");
            adapterPoslovi.addFrag(new AndroidInstrukcijeFragment(), "Android instrukcije");
            viewPagerPoslovi.setAdapter(adapterPoslovi);
            tabLayoutPoslovi.getTabAt(0).setIcon(R.drawable.ic_all_inclusive_white_24dp);
            tabLayoutPoslovi.getTabAt(1).setIcon(R.drawable.ic_all_inclusive_white_24dp);
            tabLayoutPoslovi.getTabAt(2).setIcon(R.drawable.ic_all_inclusive_white_24dp);
            tabLayoutPoslovi.getTabAt(3).setIcon(R.drawable.ic_all_inclusive_white_24dp);
            tabLayoutPoslovi.getTabAt(4).setIcon(R.drawable.ic_all_inclusive_white_24dp);
        } else if (intent.hasExtra(POJOVrstePosla.getIstrazivanje())) {

        } else if (intent.hasExtra(POJOVrstePosla.getManualni_rad())) {

        } else if (intent.hasExtra(POJOVrstePosla.getMehanicki_popravak())) {

        } else if (intent.hasExtra(POJOVrstePosla.getNastupanje())) {

        } else if (intent.hasExtra(POJOVrstePosla.getOstali_popravci())) {

        } else if (intent.hasExtra(POJOVrstePosla.getOstalo())) {

        } else if (intent.hasExtra(POJOVrstePosla.getPisanje_projekata())) {

        } else if (intent.hasExtra(POJOVrstePosla.getProgramiranje())) {

        }
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();

        private final List<String> mFragmentTitleList = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }

    private void setupListeners() {

    }
}
