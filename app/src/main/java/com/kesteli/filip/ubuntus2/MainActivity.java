package com.kesteli.filip.ubuntus2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kesteli.filip.ubuntus2.biznis_plan.DonacijaActivity;
import com.kesteli.filip.ubuntus2.biznis_plan.QuantiActivity;
import com.kesteli.filip.ubuntus2.clanovi.statusi.FavoritiActivity;
import com.kesteli.filip.ubuntus2.clanovi.statusi.PonudeActivity;
import com.kesteli.filip.ubuntus2.clanovi.statusi.PotraznjeActivity;
import com.kesteli.filip.ubuntus2.clanovi.statusi.PovijestActivity;
import com.kesteli.filip.ubuntus2.clanovi.statusi.PrihvacenoActivity;
import com.kesteli.filip.ubuntus2.login.LoginActivity;
import com.kesteli.filip.ubuntus2.pocetna_stranica.FavoritiFragment;
import com.kesteli.filip.ubuntus2.pocetna_stranica.PonudeFragment;
import com.kesteli.filip.ubuntus2.pocetna_stranica.PotraznjeFragment;
import com.kesteli.filip.ubuntus2.pocetna_stranica.PovijestFragment;
import com.kesteli.filip.ubuntus2.pocetna_stranica.PrihvacenoFragment;
import com.kesteli.filip.ubuntus2.pocetna_stranica.UbuntusFragment;
import com.kesteli.filip.ubuntus2.vrste_posla.VrstePoslaActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private ProgressBar progressBar;

    private DatabaseReference databaseReference;
    private DatabaseReference childClanovi;
    private DatabaseReference childClan1;

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Ovo je VrstePoslaActivity", Toast.LENGTH_SHORT).show();

        setupFirebase();
        initViews();
        setupToolbar();
        setupHamburgerIcon();
        setupNavigationView();

        setupViewPager();
        setupTabLayout();
        setupFragments();

//        setupAuthenticationFirebase();
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
        toolbar = (Toolbar) findViewById(R.id.toolbarPoslovi);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        viewPager = (ViewPager) findViewById(R.id.viewpagerPoslovi);
        tabLayout = (TabLayout) findViewById(R.id.tabsPoslovi);
    }

    private void setupViewPager() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
    }

    private void setupTabLayout() {
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupFragments() {
        adapter.addFrag(new UbuntusFragment(), "Ubuntus");
        adapter.addFrag(new FavoritiFragment(), "Favoriti");
        adapter.addFrag(new PrihvacenoFragment(), "Prihvaćeno");
        adapter.addFrag(new PonudeFragment(), "Ponude");
        adapter.addFrag(new PotraznjeFragment(), "Potražnje");
        adapter.addFrag(new PovijestFragment(), "Povijest");
        viewPager.setAdapter(adapter);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_all_inclusive_white_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_favorite_white_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_check_circle_white_24dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_dashboard_white_24dp);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_loop_white_24dp);
        tabLayout.getTabAt(5).setIcon(R.drawable.ic_history_white_24dp);
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
    private void setupToolbar() {
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
    }

    private void setupHamburgerIcon() {
        //Hamburger icon:
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void setupNavigationView() {
        navigationView.setNavigationItemSelectedListener(this);
    }

    /*private void setupAuthenticationFirebase() {
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };

        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
    }*/

    private void setupListeners() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabVrstePosla);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VrstePoslaActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent;

        if (id == R.id.nav_prihvaceno) {
            intent = new Intent(MainActivity.this, PrihvacenoActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_ponude) {
            intent = new Intent(MainActivity.this, PonudeActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_potraznje) {
            intent = new Intent(MainActivity.this, PotraznjeActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_favoriti) {
            intent = new Intent(MainActivity.this, FavoritiActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_povijest) {
            intent = new Intent(MainActivity.this, PovijestActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_quanti) {
            intent = new Intent(MainActivity.this, QuantiActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_donacija) {
            intent = new Intent(MainActivity.this, DonacijaActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}





