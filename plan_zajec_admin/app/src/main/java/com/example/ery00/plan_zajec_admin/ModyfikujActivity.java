package com.example.ery00.plan_zajec_admin;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ModyfikujActivity extends Activity {
     String login;
     String haslo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modyfikuj);
        login = getIntent().getExtras().getString("login");
        haslo = getIntent().getExtras().getString("haslo");
    }

    public void   OnDodaj_rekord(View view) {
        Intent intent = new Intent(getApplicationContext(),DodajRekordActivity.class);
        intent.putExtra("login",login );
        intent.putExtra("haslo",login);
        startActivity(intent);

    }

    public void   OnUsun_rekord(View view) {

        Intent intent = new Intent(getApplicationContext(), UsunRekordActivity.class);
        intent.putExtra("login",login );
        intent.putExtra("haslo",login);
        startActivity(intent);
    }
}
