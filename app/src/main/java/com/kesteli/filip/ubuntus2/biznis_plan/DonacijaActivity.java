package com.kesteli.filip.ubuntus2.biznis_plan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.kesteli.filip.ubuntus2.R;
import com.kesteli.filip.ubuntus2.SettingsActivity;

/**
 * TODO: Plan je sloziti Adds-e
 */
public class DonacijaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donacija);
        Toast.makeText(DonacijaActivity.this, "Ovo je DonacijaActivity", Toast.LENGTH_SHORT).show();
    }
}

