package com.example.ery00.plan_zajec_klient;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.support.annotation.NonNull;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class PobierzActivity extends Activity {
    public
    ListView listView1;
    String pobierz_plan;
    private ArrayList<ListaPobierz> listaPobierz;
     JSONObject jsonObject;
     JSONArray jsonArray;
     zaloguj Zaloguj;
     obsluga_pliku plik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pobierz);
        pobierz_plan = getIntent().getExtras().getString("pobierz");
        listView1 = findViewById(R.id.View1);

        listaPobierz = new ArrayList<>();

        try {
            jsonObject = new JSONObject(pobierz_plan);
            jsonArray = jsonObject.getJSONArray("server_response");
            int count = 0;
            while (count < jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                String  Nazwa = JO.getString("plan");
                listaPobierz.add(new ListaPobierz(Nazwa,"pobierz"));
                count++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }




        listView1.setAdapter(new ArrayAdapter<ListaPobierz>(this,0,listaPobierz){
            private View row;
            private LayoutInflater inflater = getLayoutInflater();
            private TextView textView;
            private TextView textView2;





            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {

                row = inflater.inflate(R.layout.pobierz_lista,parent,false);
                textView = row.findViewById(R.id.textView);
                textView2 = row.findViewById(R.id.textView2);

                ListaPobierz object = listaPobierz.get(position);
                textView.setMovementMethod(new ScrollingMovementMethod());
                textView.setText(object.nazwa);
                textView2.setText(object.pobierz);
                final String positionn = Integer.toString(position);


                textView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ListaPobierz click = listaPobierz.get(position);
                        String nazwa = click.nazwa;
                        Zaloguj = new zaloguj(getApplicationContext(),"pobierzplan");
                        Zaloguj.execute(nazwa);


                    }
                });


                return row;
            }


        });


    }


}
