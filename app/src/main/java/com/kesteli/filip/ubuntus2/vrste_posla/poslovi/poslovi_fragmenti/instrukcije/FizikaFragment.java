package com.kesteli.filip.ubuntus2.vrste_posla.poslovi.poslovi_fragmenti.instrukcije;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kesteli.filip.ubuntus2.R;
import com.kesteli.filip.ubuntus2.clanovi.statusi.Album;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FizikaFragment extends Fragment {

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private DatabaseReference childClanovi;
    private DatabaseReference childClan;

    private Toolbar toolbar;

    private Context mContext;
    private List<Album> albumList;

    public FizikaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fizika, container, false);

        initViews(view);
        setupFirebase();
        setupListeners();
        setupRecyclerView(view);

        return view;
    }

    private void initViews(View view) {
        toolbar = (Toolbar) view.findViewById(R.id.toolbarPoslovi);
    }

    private void setupFirebase() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        //get firebase auth instance
        auth = FirebaseAuth.getInstance();
        //get current user
        user = FirebaseAuth.getInstance().getCurrentUser();
    }

    private void setupListeners() {

    }


    /**
     * *******************************RECYCLER VIEW**********************************************
     */

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private GridLayoutManager gridLayoutManager; //kartice u mreži

    private void setupRecyclerView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_fizika);

        albumList = new ArrayList<>();
        adapter = new FizikaAdapter(getActivity(), albumList);

        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        try {
            Glide.with(this).load(R.drawable.pic_aragorn).into((ImageView) view.findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.pic_frodo,
                R.drawable.pic_legolas,
                R.drawable.pic_uruk_hai,
                R.drawable.pic_aragorn,
                R.drawable.pic_saruman,
                R.drawable.pic_sauron,
                R.drawable.pic_gandalf,
        };

        Album a = new Album("frodo", 13, covers[0]);
        albumList.add(a);

        a = new Album("legolas", 8, covers[1]);
        albumList.add(a);

        a = new Album("Maroon 5", 11, covers[2]);
        albumList.add(a);

        a = new Album("Born to Die", 12, covers[3]);
        albumList.add(a);

        a = new Album("Honeymoon", 14, covers[4]);
        albumList.add(a);

        a = new Album("I Need a Doctor", 1, covers[5]);
        albumList.add(a);

        a = new Album("Loud", 11, covers[6]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public class FizikaAdapter extends RecyclerView.Adapter<FizikaAdapter.ViewHolder> {


        private Context mContext;
        private List<Album> albumList;

        public FizikaAdapter(Context mContext, List<Album> albumList) {
            this.mContext = mContext;
            this.albumList = albumList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_album, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            Album album = albumList.get(position);
            holder.title.setText(album.getName());
            holder.count.setText(album.getNumOfSongs() + " songs");

            // loading album cover using Glide library
            Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

            holder.overflow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showPopupMenu(holder.overflow);
                }
            });
        }

        @Override
        public int getItemCount() {
            return albumList.size();
        }

        /**
         * Showing popup menu when tapping on 3 dots
         */
        private void showPopupMenu(View view) {
            // inflate menu
            PopupMenu popup = new PopupMenu(mContext, view);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.menu_album, popup.getMenu());
            popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
            popup.show();
        }

        /**
         * Klasa koja sluzi za PopupMenu
         */
        class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

            public MyMenuItemClickListener() {
            }

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_nova_ponuda:
                        composeEmail(new String[] {"sasa@gmail.com"}, "Tema");
                        return true;
                    case R.id.action_dodaj_u_favorite:
                        /*childClanovi = databaseReference.child("Clanovi");
                        childClan = childClanovi.child(user.getUid());
                        childClan.child("favoriti").setValue(123);*/
                        //TODO Sloziti to da se zna vrijednost iz neke liste, pa to dohvatiti i obraditi
                        return true;
                    default:
                }
                return false;
            }
        }

        public void composeEmail(String[] addresses, String subject) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, addresses);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                startActivity(intent);
            }
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView title, count;
            public ImageView thumbnail, overflow;

            public ViewHolder(View view) {
                super(view);
                title = (TextView) view.findViewById(R.id.title);
                count = (TextView) view.findViewById(R.id.count);
                thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
                overflow = (ImageView) view.findViewById(R.id.overflow);
            }
        }
    }


    /*
     *********************************************Firebase******************************************
     */
    /*private void addToFirebase() {
        childDinosaurs = databaseReference.child("Dinosaurs");

        DatabaseReference childLambeosaurus = childDinosaurs.child("Lambeosaurus");
        DatabaseReference childStegosaurus = childDinosaurs.child("Stegosaurus");
        DatabaseReference childTiranosaurus = childDinosaurs.child("Tiranosaurus");

        childLambeosaurus.child("height").setValue(2.1);
        childLambeosaurus.child("length").setValue(12.5);
        childLambeosaurus.child("weight").setValue(5000);

        childStegosaurus.child("height").setValue(4);
        childStegosaurus.child("length").setValue(9);
        childStegosaurus.child("weight").setValue(2500);

        childTiranosaurus.child("height").setValue(3.6);
        childTiranosaurus.child("length").setValue(7.4);
        childTiranosaurus.child("weight").setValue(3000);

        childTimovi = databaseReference.child("Timovi");
        childClanovi = childTimovi.child("Tim1865").child("Clanovi");

        childTimovi.child("Tim1865").child("motivacija").setValue(10);

        DatabaseReference childClan1 = childClanovi.child("Clan1Ivo");
        DatabaseReference childClan2 = childClanovi.child("Clan2Pero");
        DatabaseReference childClan3 = childClanovi.child("Clan3Bato");

        godine = Integer.parseInt(etGodine.getText().toString());
        Log.d("s1", "" + godine);

        childClan1.child("ime").setValue("Ivo");
        childClan1.child("prezime").setValue("Salic");
        childClan1.child("godine").setValue(godine);

        childClan2.child("ime").setValue("Pero");
        childClan2.child("prezime").setValue("Ivic");
        childClan2.child("godine").setValue(2500);

        childClan3.child("ime").setValue("Bato");
        childClan3.child("prezime").setValue("Peric");
        childClan3.child("godine").setValue(3000);
    }*/
}







