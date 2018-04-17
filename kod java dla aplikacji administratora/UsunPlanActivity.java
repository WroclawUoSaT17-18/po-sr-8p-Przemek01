package com.example.ery00.plan_zajec_admin;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UsunPlanActivity extends Activity {
     String login;
     String haslo;
    String nazwa_planu;
    zaloguj Zaloguj;
    EditText nazwa_Edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usun_plan);
        login = getIntent().getExtras().getString("login");
        haslo = getIntent().getExtras().getString("haslo");
        nazwa_Edit = (EditText)findViewById(R.id.editText4);
    }

    public void   Onusun(View view) {
        nazwa_planu =nazwa_Edit.getText().toString();
        Zaloguj = new zaloguj(getApplicationContext(),"usunplan");
        Zaloguj.execute(login,haslo,nazwa_planu);

    }

}
