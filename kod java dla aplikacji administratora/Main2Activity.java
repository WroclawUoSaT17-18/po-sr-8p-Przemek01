package com.example.ery00.plan_zajec_admin;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends Activity {
 String login;
 String haslo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        login = getIntent().getExtras().getString("login");
        haslo = getIntent().getExtras().getString("haslo");

    }

    public void Ondodaj (View view)
    {
        Intent intent = new Intent(getApplicationContext(),DodajPlanActivity.class);
        intent.putExtra("login",login );
        intent.putExtra("haslo",login);
        startActivity(intent);

    }

    public void OnModyfikuj (View view)
    {

        Intent intent = new Intent(getApplicationContext(),ModyfikujActivity.class);
        intent.putExtra("login",login );
        intent.putExtra("haslo",login);
        startActivity(intent);
    }

    public void OnUsun (View view)
    {

        Intent intent = new Intent(getApplicationContext(),UsunPlanActivity.class);
        intent.putExtra("login",login );
        intent.putExtra("haslo",login);
        startActivity(intent);
    }
}
