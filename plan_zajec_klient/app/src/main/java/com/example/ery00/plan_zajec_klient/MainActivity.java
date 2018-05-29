package com.example.ery00.plan_zajec_klient;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
zaloguj Zaloguj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void   OnPobierz(View view) {

            Zaloguj = new zaloguj(getApplicationContext(),"pobierzlisteplan");
            Zaloguj.execute();


    }


    public void   OnWyswietl(View view) {

        Intent intent = new Intent(this, WyswietlActivity.class);
        startActivity(intent);


    }
}
