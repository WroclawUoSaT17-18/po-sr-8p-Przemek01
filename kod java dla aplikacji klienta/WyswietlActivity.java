package com.example.ery00.plan_zajec_klient;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class WyswietlActivity extends Activity implements View.OnClickListener {
    String plan;
    ArrayList<Kalendarz> kalendarz;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ListView listView2;

    obsluga_pliku plik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyswietl);

        listView2 = findViewById(R.id.View2);

        kalendarz = new ArrayList<>();


        Button styczen = (Button) findViewById(R.id.button3);
        styczen.setOnClickListener(this); // calling onClick() method
        Button luty = (Button) findViewById(R.id.button4);
        luty.setOnClickListener(this);
        Button marzec = (Button) findViewById(R.id.button5);
        marzec.setOnClickListener(this);
        Button kwiecien = (Button) findViewById(R.id.button6);
        kwiecien.setOnClickListener(this); // calling onClick() method
        Button maj = (Button) findViewById(R.id.button7);
        maj.setOnClickListener(this);
        Button czerwiec = (Button) findViewById(R.id.button8);
        czerwiec.setOnClickListener(this);
        Button lipiec = (Button) findViewById(R.id.button9);
        lipiec.setOnClickListener(this); // calling onClick() method
        Button sierpien = (Button) findViewById(R.id.button10);
        sierpien.setOnClickListener(this);
        Button wrzesien = (Button) findViewById(R.id.button11);
        wrzesien.setOnClickListener(this);
        Button pazdziernik = (Button) findViewById(R.id.button12);
        pazdziernik.setOnClickListener(this); // calling onClick() method
        Button listopad = (Button) findViewById(R.id.button13);
        listopad.setOnClickListener(this);
        Button grudzien = (Button) findViewById(R.id.button14);
        grudzien.setOnClickListener(this);




        try {
            plik = new obsluga_pliku(getApplicationContext());
            plan = plik.wczytaj();
            jsonObject = new JSONObject(plan);
            jsonArray = jsonObject.getJSONArray("server_response");
            int count = 0;
            while (count < jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                String  miesiac = JO.getString("miesiac");
                String  dzien = JO.getString("dzien");
                String  od = JO.getString("od");
                String  doo = JO.getString("do");
                String  opis = JO.getString("opis");
                kalendarz.add(new Kalendarz(miesiac,dzien,od,doo,opis));
                count++;
            }

        } catch (JSONException e) {
            e.printStackTrace();

    }

      Collections.sort(kalendarz, new Kalendarz.Sortuj());







}



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button3:
            {
                ArrayList<Kalendarz> kalendarz2 = new ArrayList<>();
                int i = 0;
                for (Kalendarz k : kalendarz) {

                    if (Integer.parseInt(k.Miesiac) == 1) {

                        kalendarz2.add(kalendarz.get(i));
                    }
                    i++;
                }
                lista(kalendarz2);
            }
                break;

            case R.id.button4:
            {
                ArrayList<Kalendarz> kalendarz2 = new ArrayList<>();
                int i = 0;
                for (Kalendarz k : kalendarz) {

                    if (Integer.parseInt(k.Miesiac) == 2) {

                        kalendarz2.add(kalendarz.get(i));
                    }
                    i++;
                }
                lista(kalendarz2);
            }
                break;

            case R.id.button5:
            {
                ArrayList<Kalendarz> kalendarz2 = new ArrayList<>();
                int i = 0;
                for (Kalendarz k : kalendarz) {

                    if (Integer.parseInt(k.Miesiac) == 3) {

                        kalendarz2.add(kalendarz.get(i));
                    }
                    i++;
                }
                lista(kalendarz2);
            }
                break;

            case R.id.button6:
            {
                ArrayList<Kalendarz> kalendarz2 = new ArrayList<>();
                int i = 0;
                for (Kalendarz k : kalendarz) {

                    if (Integer.parseInt(k.Miesiac) == 4) {

                        kalendarz2.add(kalendarz.get(i));
                    }
                    i++;
                }
                lista(kalendarz2);
            }
                break;

            case R.id.button7:
            {
                ArrayList<Kalendarz> kalendarz2 = new ArrayList<>();
                int i = 0;
                for (Kalendarz k : kalendarz) {

                    if (Integer.parseInt(k.Miesiac) == 5) {

                        kalendarz2.add(kalendarz.get(i));
                    }
                    i++;
                }
                lista(kalendarz2);
            }
                break;

            case R.id.button8:
            {
                ArrayList<Kalendarz> kalendarz2 = new ArrayList<>();
                int i = 0;
                for (Kalendarz k : kalendarz) {

                    if (Integer.parseInt(k.Miesiac) == 6) {

                        kalendarz2.add(kalendarz.get(i));
                    }
                    i++;
                }
                lista(kalendarz2);
            }
                break;

            case R.id.button9:
            {
                ArrayList<Kalendarz> kalendarz2 = new ArrayList<>();
                int i = 0;
                for (Kalendarz k : kalendarz) {

                    if (Integer.parseInt(k.Miesiac) == 7) {

                        kalendarz2.add(kalendarz.get(i));
                    }
                    i++;
                }
                lista(kalendarz2);
            }
                break;

            case R.id.button10:
            {
                ArrayList<Kalendarz> kalendarz2 = new ArrayList<>();
                int i = 0;
                for (Kalendarz k : kalendarz) {

                    if (Integer.parseInt(k.Miesiac) == 8) {

                        kalendarz2.add(kalendarz.get(i));
                    }
                    i++;
                }
                lista(kalendarz2);
            }
                break;

            case R.id.button11:
            {
                ArrayList<Kalendarz> kalendarz2 = new ArrayList<>();
                int i = 0;
                for (Kalendarz k : kalendarz) {

                    if (Integer.parseInt(k.Miesiac) == 9) {

                        kalendarz2.add(kalendarz.get(i));
                    }
                    i++;
                }
                lista(kalendarz2);
            }
                break;

            case R.id.button12:
            {
                ArrayList<Kalendarz> kalendarz2 = new ArrayList<>();
                int i = 0;
                for (Kalendarz k : kalendarz) {

                    if (Integer.parseInt(k.Miesiac) == 10) {

                        kalendarz2.add(kalendarz.get(i));
                    }
                    i++;
                }
                lista(kalendarz2);
            }
                break;

            case R.id.button13:
            {
                ArrayList<Kalendarz> kalendarz2 = new ArrayList<>();
                int i = 0;
                for (Kalendarz k : kalendarz) {

                    if (Integer.parseInt(k.Miesiac) == 11) {

                        kalendarz2.add(kalendarz.get(i));
                    }
                    i++;
                }
                lista(kalendarz2);
            }
                break;

            case R.id.button14:
            {
                ArrayList<Kalendarz> kalendarz2 = new ArrayList<>();
                int i = 0;
                for (Kalendarz k : kalendarz) {

                    if (Integer.parseInt(k.Miesiac) == 12) {

                        kalendarz2.add(kalendarz.get(i));
                    }
                    i++;
                }
                lista(kalendarz2);
            }
                break;


            default:
                break;
        }
    }

    public void lista( final ArrayList<Kalendarz> kalendarz2)
    {
        listView2.setAdapter(new ArrayAdapter<Kalendarz>(this,0,kalendarz2){
            private View row;
            private LayoutInflater inflater = getLayoutInflater();
            private TextView textView3;
            private TextView textView4;





            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {

                row = inflater.inflate(R.layout.kalendarz,parent,false);
                textView3 = row.findViewById(R.id.textView3);
                textView4 = row.findViewById(R.id.textView4);

                Kalendarz object = kalendarz2.get(position);
                textView4.setMovementMethod(new ScrollingMovementMethod());
                textView3.setText(object.GetDate());
                textView4.setText(object.opis);




                return row;
            }


        });
    }

    }

