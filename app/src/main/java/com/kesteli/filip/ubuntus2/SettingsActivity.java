package com.kesteli.filip.ubuntus2;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.kesteli.filip.ubuntus2.clanovi.Clan;
import com.kesteli.filip.ubuntus2.login.LoginActivity;
import com.kesteli.filip.ubuntus2.login.SignUpActivity;

public class SettingsActivity extends AppCompatActivity {

    private Button btnChangeEmail, btnChangePassword, btnSendResetEmail, btnRemoveUser,
            changeEmail, changePassword, sendEmail, remove, signOut,
            btnUpdateUserData, btnGetUserData, btnProbaFirebase, btnProbaPoslovi;
    private EditText oldEmail, newEmail, password, newPassword;
    private ProgressBar progressBar;
    private String idClan, ime, prezime, eMail;
    private int godine, brojUspjesnihTransakcija,
            fizika, matematika, vesMasina, mobitel,
            kompjutor, automobil, poljoprivreda,
            gradevina, pazitelj;

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private FirebaseUser user;

    private Toolbar toolbar;

    private DatabaseReference databaseReference;
    private DatabaseReference childClanovi;
    private DatabaseReference childClan1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toast.makeText(SettingsActivity.this, "Ovo je SettingsActivity", Toast.LENGTH_SHORT).show();

        setupFirebase();
        initViews();
        setupToolbar();
        setupAuthenticationFirebase();
        setupListener();
    }

    private void setupFirebase() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        //get firebase auth instance
        auth = FirebaseAuth.getInstance();
        //get current user
        user = FirebaseAuth.getInstance().getCurrentUser();
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnChangeEmail = (Button) findViewById(R.id.change_email_button);
        btnChangePassword = (Button) findViewById(R.id.change_password_button);
        btnSendResetEmail = (Button) findViewById(R.id.sending_pass_reset_button);
        btnRemoveUser = (Button) findViewById(R.id.remove_user_button);
        btnUpdateUserData = (Button) findViewById(R.id.btnUpdateUserData);
        btnGetUserData = (Button) findViewById(R.id.btnGetUserData);
        btnProbaFirebase = (Button) findViewById(R.id.btnProbaFirebase);
        btnProbaPoslovi = (Button) findViewById(R.id.btnProbaPoslovi);
        changeEmail = (Button) findViewById(R.id.changeEmail);
        changePassword = (Button) findViewById(R.id.changePass);
        sendEmail = (Button) findViewById(R.id.send);
        remove = (Button) findViewById(R.id.remove);
        signOut = (Button) findViewById(R.id.sign_out);

        oldEmail = (EditText) findViewById(R.id.old_email);
        newEmail = (EditText) findViewById(R.id.new_email);
        password = (EditText) findViewById(R.id.password);
        newPassword = (EditText) findViewById(R.id.newPassword);

        oldEmail.setVisibility(View.GONE);
        newEmail.setVisibility(View.GONE);
        password.setVisibility(View.GONE);
        newPassword.setVisibility(View.GONE);
        changeEmail.setVisibility(View.GONE);
        changePassword.setVisibility(View.GONE);
        sendEmail.setVisibility(View.GONE);
        remove.setVisibility(View.GONE);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    private void setupToolbar() {
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
    }

    /**
     * Postavlja se firebase authentication - ako user nije logiran, onda ga intent baca direktno na LoginActivity
     */
    private void setupAuthenticationFirebase() {
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(SettingsActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };

        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void setupListener() {
        btnChangeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oldEmail.setVisibility(View.GONE);
                newEmail.setVisibility(View.VISIBLE);
                password.setVisibility(View.GONE);
                newPassword.setVisibility(View.GONE);
                changeEmail.setVisibility(View.VISIBLE);
                changePassword.setVisibility(View.GONE);
                sendEmail.setVisibility(View.GONE);
                remove.setVisibility(View.GONE);
            }
        });

        changeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                if (user != null && !newEmail.getText().toString().trim().equals("")) {
                    user.updateEmail(newEmail.getText().toString().trim())
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SettingsActivity.this, "Email address is updated. Please sign in with new email id!", Toast.LENGTH_LONG).show();
                                        signOut();
                                        progressBar.setVisibility(View.GONE);
                                    } else {
                                        Toast.makeText(SettingsActivity.this, "Failed to update email!", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                } else if (newEmail.getText().toString().trim().equals("")) {
                    newEmail.setError("Enter email");
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oldEmail.setVisibility(View.GONE);
                newEmail.setVisibility(View.GONE);
                password.setVisibility(View.GONE);
                newPassword.setVisibility(View.VISIBLE);
                changeEmail.setVisibility(View.GONE);
                changePassword.setVisibility(View.VISIBLE);
                sendEmail.setVisibility(View.GONE);
                remove.setVisibility(View.GONE);
            }
        });

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                if (user != null && !newPassword.getText().toString().trim().equals("")) {
                    if (newPassword.getText().toString().trim().length() < 6) {
                        newPassword.setError("Password too short, enter minimum 6 characters");
                        progressBar.setVisibility(View.GONE);
                    } else {
                        user.updatePassword(newPassword.getText().toString().trim())
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(SettingsActivity.this, "Password is updated, sign in with new password!", Toast.LENGTH_SHORT).show();
                                            signOut();
                                            progressBar.setVisibility(View.GONE);
                                        } else {
                                            Toast.makeText(SettingsActivity.this, "Failed to update password!", Toast.LENGTH_SHORT).show();
                                            progressBar.setVisibility(View.GONE);
                                        }
                                    }
                                });
                    }
                } else if (newPassword.getText().toString().trim().equals("")) {
                    newPassword.setError("Enter password");
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        btnSendResetEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oldEmail.setVisibility(View.VISIBLE);
                newEmail.setVisibility(View.GONE);
                password.setVisibility(View.GONE);
                newPassword.setVisibility(View.GONE);
                changeEmail.setVisibility(View.GONE);
                changePassword.setVisibility(View.GONE);
                sendEmail.setVisibility(View.VISIBLE);
                remove.setVisibility(View.GONE);
            }
        });

        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                if (!oldEmail.getText().toString().trim().equals("")) {
                    auth.sendPasswordResetEmail(oldEmail.getText().toString().trim())
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SettingsActivity.this, "Reset password email is sent!", Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                    } else {
                                        Toast.makeText(SettingsActivity.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                } else {
                    oldEmail.setError("Enter email");
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        btnRemoveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                if (user != null) {
                    user.delete()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SettingsActivity.this, "Your profile is deleted:( Create a account now!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(SettingsActivity.this, SignUpActivity.class));
                                        finish();
                                        progressBar.setVisibility(View.GONE);
                                    } else {
                                        Toast.makeText(SettingsActivity.this, "Failed to delete your account!", Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                }
            }
        });

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        btnUpdateUserData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = "Janica";
                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                        .setDisplayName(name)
//                        .setPhotoUri(Uri.parse("https://example.com/jane-q-user/profile.jpg"))
                        .build();

                user.updateProfile(profileUpdates)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d("a1", name + "User profile updated.");
                                }
                            }
                        });
            }
        });
        btnGetUserData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user != null) {
                    // Name, email address, and profile photo Url
                    String name = user.getDisplayName();
                    String email = user.getEmail();
                    Uri photoUrl = user.getPhotoUrl();

                    // The user's ID, unique to the Firebase project. Do NOT use this value to
                    // authenticate with your backend server, if you have one. Use
                    // FirebaseUser.getToken() instead.
                    String uid = user.getUid();
                    Log.d("a2", name + " " + email + " " + photoUrl + " " + uid);
                }
            }
        });
        btnProbaFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnProbaFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToFirebase();
                firebaseQueryUpdateRootClan();
            }
        });
        btnProbaPoslovi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void addToFirebase() {
        idClan = "fawfsa";
        ime = "dalmfa";
        prezime = "dmals";
        eMail = "amlfa";
        godine = 21;
        brojUspjesnihTransakcija = 43;
        fizika = 32;
        matematika = 34;
        vesMasina = 324;
        mobitel = 32;
        kompjutor = 432;
        automobil = 32;
        poljoprivreda = 329;
        gradevina = 328;
        pazitelj = 329;

        childClanovi = databaseReference.child("Clanovi");

        DatabaseReference childClan1 = childClanovi.child(idClan + 1);
        DatabaseReference childClan2 = childClanovi.child(idClan + 2);
        DatabaseReference childClan3 = childClanovi.child(idClan + 3);

        childClan1.child("ime").setValue(ime);
        childClan1.child("prezime").setValue(prezime);
        childClan1.child("eMail").setValue(eMail);
        childClan1.child("godine").setValue(godine);
        childClan1.child("brojUspjesnihTransakcija").setValue(brojUspjesnihTransakcija);
        childClan1.child("fizika").setValue(fizika);
        childClan1.child("matematika").setValue(matematika);
        childClan1.child("vesMasina").setValue(vesMasina);
        childClan1.child("mobitel").setValue(mobitel);
        childClan1.child("kompjutor").setValue(kompjutor);
        childClan1.child("automobil").setValue(automobil);
        childClan1.child("poljoprivreda").setValue(poljoprivreda);
        childClan1.child("gradevina").setValue(gradevina);
        childClan1.child("pazitelj").setValue(pazitelj);

        childClan2.child("ime").setValue(ime);
        childClan2.child("prezime").setValue(prezime);
        childClan2.child("eMail").setValue(eMail);
        childClan2.child("godine").setValue(godine);
        childClan2.child("brojUspjesnihTransakcija").setValue(brojUspjesnihTransakcija);
        childClan2.child("fizika").setValue(fizika);
        childClan2.child("matematika").setValue(matematika);
        childClan2.child("vesMasina").setValue(vesMasina);
        childClan2.child("mobitel").setValue(mobitel);
        childClan2.child("kompjutor").setValue(kompjutor);
        childClan2.child("automobil").setValue(automobil);
        childClan2.child("poljoprivreda").setValue(poljoprivreda);
        childClan2.child("gradevina").setValue(gradevina);
        childClan2.child("pazitelj").setValue(pazitelj);

        childClan3.child("ime").setValue(ime);
        childClan3.child("prezime").setValue(prezime);
        childClan3.child("eMail").setValue(eMail);
        childClan3.child("godine").setValue(godine);
        childClan3.child("brojUspjesnihTransakcija").setValue(brojUspjesnihTransakcija);
        childClan3.child("fizika").setValue(fizika);
        childClan3.child("matematika").setValue(matematika);
        childClan3.child("vesMasina").setValue(vesMasina);
        childClan3.child("mobitel").setValue(mobitel);
        childClan3.child("kompjutor").setValue(kompjutor);
        childClan3.child("automobil").setValue(automobil);
        childClan3.child("poljoprivreda").setValue(poljoprivreda);
        childClan3.child("gradevina").setValue(gradevina);
        childClan3.child("pazitelj").setValue(pazitelj);
    }

    private void firebaseQueryUpdateRootClan() {
        Query queryRefUpdateRootClan = childClanovi.orderByChild("prezime");

        queryRefUpdateRootClan.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Clan clan = dataSnapshot.getValue(Clan.class);
                Log.d("a3", dataSnapshot.getKey() + " " + clan.getIme() + " " + clan.getPrezime() + " " + clan.getGodine());
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

    //sign out method
    public void signOut() {
        auth.signOut();
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }
}
