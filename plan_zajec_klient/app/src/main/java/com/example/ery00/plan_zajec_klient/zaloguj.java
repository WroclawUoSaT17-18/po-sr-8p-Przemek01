package com.example.ery00.plan_zajec_klient;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;




/**
 * Created by ery00 on 2018-04-03.
 */

public class zaloguj extends AsyncTask<String,String,String> {
      Context context;
    private String parametr;
     String nazwa;
    private String haslo;
    private obsluga_pliku plik;

    public zaloguj(Context context,String parametr){

        this.context = context;
        this.parametr = parametr;



    }


    @Override
    protected String doInBackground(String... params) {

        String link = null;
        String data;


        data = "";

        try {


        if(parametr.equals("pobierzlisteplan") ) {

                link = "http://androidsql.cba.pl/lista_planow.php";

            }if(parametr.equals("pobierzplan") ) {

                link = "http://androidsql.cba.pl/pobierz_plan.php";
                nazwa = params[0];
                data = URLEncoder.encode("nazwa", "UTF-8") + "=" +
                        URLEncoder.encode(nazwa, "UTF-8");


            }
            URL url = new URL(link);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();


            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null) {
                sb.append(line);

            }


            return sb.toString();
        } catch (IOException e) {
            return "";
        }



    }

    @Override
    protected void onPostExecute(String sb) {

        if(parametr.equals("pobierzlisteplan")) {
            Toast.makeText(context, sb, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(context, PobierzActivity.class);
            intent.putExtra("pobierz", sb);
            context.startActivity(intent);
        }if(parametr.equals("pobierzplan")) {
            Toast.makeText(context, sb, Toast.LENGTH_LONG).show();
plik = new obsluga_pliku(context);
plik.zapisz(sb);



        }


    }

}

