package com.example.ery00.plan_zajec_admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DodajRekordActivity extends AppCompatActivity {
    String login;
    String haslo;
    String nazwa_planu;
    String godzina_od;
    String godzina_do;
    String miesiac;
    String dzien;
    String data;
    String opis;
    zaloguj Zaloguj;
    EditText nazwa_Edit, data_Edit,opis_Edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_rekord);
        login = getIntent().getExtras().getString("login");
        haslo = getIntent().getExtras().getString("haslo");
        nazwa_Edit = (EditText)findViewById(R.id.editText8);
        data_Edit = (EditText)findViewById(R.id.editText7);
        opis_Edit = (EditText)findViewById(R.id.editText6);

    }

    public void Ondodaj_rekord(View view) {
        nazwa_planu =nazwa_Edit.getText().toString();
        data = data_Edit.getText().toString();
        opis = opis_Edit.getText().toString();

        String[] parse = data.split("/");
        miesiac = parse[0];
        dzien = parse[1];
        godzina_od = parse[2];
        godzina_do = parse[3];

        Zaloguj = new zaloguj(getApplicationContext(),"dodajrekord");
        Zaloguj.execute(login,haslo,nazwa_planu,miesiac,dzien,godzina_od,godzina_do,opis);
    }
}
