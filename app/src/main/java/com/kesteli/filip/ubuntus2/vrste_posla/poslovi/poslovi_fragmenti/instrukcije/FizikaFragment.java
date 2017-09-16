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
import android.util.Log;
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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.kesteli.filip.ubuntus2.R;
import com.kesteli.filip.ubuntus2.clanovi.Clan;
import com.kesteli.filip.ubuntus2.clanovi.statusi.Album;
import com.kesteli.filip.ubuntus2.ugovor.UgovorActivity;

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
        firebaseQuery();
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
                        Intent intent = new Intent(getActivity(), UgovorActivity.class);
                        startActivity(intent);
                        /*childClanovi = databaseReference.child("Clanovi");
                        childClan = childClanovi.child(user.getUid());
                        childClan.child("favoriti").setValue(123);*/
                        //TODO Sloziti to da se zna vrijednost iz neke liste, pa to dohvatiti i obraditi
                        //TODO Sloziti Shared Preferences
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

    /**
     * Poredaj po weight-u - najveca tezina 3200
     */
    private void firebaseQuery() {
        childClanovi = databaseReference.child("Clanovi");
//        childClan = childClanovi.child(user.getUid());
        Query query = childClanovi.orderByChild("fizika").startAt(1);

        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Clan clan = dataSnapshot.getValue(Clan.class);
                Log.d("a6", dataSnapshot.getKey() + " " + clan.getIme() + " was " + clan.getFizika() + " meters tall");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}







