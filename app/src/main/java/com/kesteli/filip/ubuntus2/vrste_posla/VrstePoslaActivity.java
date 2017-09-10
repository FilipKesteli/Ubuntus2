package com.kesteli.filip.ubuntus2.vrste_posla;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kesteli.filip.ubuntus2.R;
import com.kesteli.filip.ubuntus2.vrste_posla.poslovi.PosloviActivity;

public class VrstePoslaActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    POJOVrstePosla pojoVrstePosla = new POJOVrstePosla();

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private DatabaseReference childClanovi;
    private DatabaseReference childClan1;

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrste_posla);
        Toast.makeText(VrstePoslaActivity.this, "Ovo je VrstePoslaActivity", Toast.LENGTH_SHORT).show();

        setupFirebase();
        initViews();
        setupToolbar();
        setupHamburgerIcon();
        setupNavigationView();
        setupRecyclerView();
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

    private void setupListeners() {

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
        getMenuInflater().inflate(R.menu.vrste_posla, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_instrukcije) {

        } else if (id == R.id.nav_elektricni_popravak) {

        } else if (id == R.id.nav_mehanicki_popravak) {

        } else if (id == R.id.nav_ostali_popravci) {

        } else if (id == R.id.nav_manualni_rad) {

        } else if (id == R.id.nav_pisanje_projekata) {

        } else if (id == R.id.nav_programiranje) {

        } else if (id == R.id.nav_nastupanje) {

        } else if (id == R.id.nav_istrazivanje) {

        } else if (id == R.id.nav_ostalo) {

        } else if (id == R.id.nav_quanti) {

        } else if (id == R.id.nav_donacija) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * *******************************RECYCLER VIEW**********************************************
     */

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private GridLayoutManager gridLayoutManager; //kartice u mreži

    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_vrste_posla);
        gridLayoutManager = new GridLayoutManager(VrstePoslaActivity.this, 2);
        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }


    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_main_vrsta_posla, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
//            holder.znanostTitle.setText(titles[position]);
            holder.znanostTitle.setText(pojoVrstePosla.getTitles()[position]);
//            holder.znanostImage.setImageResource(images[position]);
            holder.znanostImage.setImageResource(pojoVrstePosla.getImages()[position]);
            holder.cardView.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
            //pojoVrstePosla.getColors()[position]
        }

        @Override
        public int getItemCount() {
            return pojoVrstePosla.getTitles().length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public ImageView znanostImage;
            public TextView znanostTitle;
            public CardView cardView;

            public ViewHolder(View itemView) {

                super(itemView);
                znanostImage = (ImageView) itemView.findViewById(R.id.znanost_image);
                znanostTitle = (TextView) itemView.findViewById(R.id.znanost_title);
                cardView = (CardView) itemView.findViewById(R.id.card_view);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position = getAdapterPosition();

                        sharedPreferences = getSharedPreferences(POJOVrstePosla.getWebStranicePREFERENCES(), Context.MODE_PRIVATE);
                        editor = sharedPreferences.edit();

                        if (position == 0) {
                            Intent intentEducation = new Intent(VrstePoslaActivity.this, PosloviActivity.class);
//                            editor.putString(POJOVrstePosla.getWebStranicePREFERENCES(), POJOVrstePosla.getEducation_express());
                            editor.commit();
//                            intentEducation.putExtra(POJOVrstePosla.getEducation_express(), POJOVrstePosla.getEducation_express());
                            startActivity(intentEducation);
                        } else if (position == 1) {
                            Intent intentDemocracy = new Intent(VrstePoslaActivity.this, PosloviActivity.class);
                            startActivity(intentDemocracy);
                        } else if (position == 2) {
                            Intent intentClanci = new Intent(VrstePoslaActivity.this, PosloviActivity.class);
                            startActivity(intentClanci);
                        } else if (position == 3) {
                            Intent intentDonation = new Intent(VrstePoslaActivity.this, PosloviActivity.class);
                            startActivity(intentDonation);
                        } else if (position == 4) {
                            Intent intentKZInicijativa = new Intent(VrstePoslaActivity.this, PosloviActivity.class);
                            startActivity(intentKZInicijativa);
                        } else if (position == 5) {
                            Intent intentMotivator = new Intent(VrstePoslaActivity.this, PosloviActivity.class);
                            startActivity(intentMotivator);
                        } else if (position == 6) {
                            Intent intentReality = new Intent(VrstePoslaActivity.this, PosloviActivity.class);
                            startActivity(intentReality);
                        } else if (position == 7) {
                            Intent intentSmartCity = new Intent(VrstePoslaActivity.this, PosloviActivity.class);
                            startActivity(intentSmartCity);
                        }
                    }
                });
            }
        }
    }
}
