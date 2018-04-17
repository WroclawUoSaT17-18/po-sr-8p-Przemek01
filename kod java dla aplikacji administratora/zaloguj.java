package com.example.ery00.plan_zajec_admin;

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
    private String login;
    private String haslo;

    public zaloguj(Context context,String parametr){

        this.context = context;
        this.parametr = parametr;



    }


    @Override
    protected String doInBackground(String... params) {

        String link = null;
        String data;
         login = params[0];
         haslo = params[1];

data = "";

        try {
if(parametr.equals("zaloguj") ) {
               link = "http://androidsql.cba.pl/zaloguj.php";
               data = URLEncoder.encode("login", "UTF-8") + "=" +
                      URLEncoder.encode(login, "UTF-8") + "&" + URLEncoder.encode("haslo", "UTF-8") + "=" +
                      URLEncoder.encode(haslo, "UTF-8");
}if(parametr.equals("dodajplan") ) {
                link = "http://androidsql.cba.pl/dodaj_plan.php";
                String nazwa = params[2];
                data = URLEncoder.encode("login", "UTF-8") + "=" +
                        URLEncoder.encode(login, "UTF-8") + "&" + URLEncoder.encode("haslo", "UTF-8") + "=" +
                        URLEncoder.encode(haslo, "UTF-8")+ "&" + URLEncoder.encode("plan_add", "UTF-8") + "=" +
                        URLEncoder.encode(nazwa, "UTF-8");
}if(parametr.equals("usunplan") ) {
                link = "http://androidsql.cba.pl/Usun_plan.php";
                String nazwa = params[2];
                data = URLEncoder.encode("login", "UTF-8") + "=" +
                        URLEncoder.encode(login, "UTF-8") + "&" + URLEncoder.encode("haslo", "UTF-8") + "=" +
                        URLEncoder.encode(haslo, "UTF-8")+ "&" + URLEncoder.encode("plan_delete", "UTF-8") + "=" +
                        URLEncoder.encode(nazwa, "UTF-8");
}if(parametr.equals("dodajrekord") ) {
                String nazwa = params[2];
                String godzina_od= params[5];
                String godzina_do= params[6];
                String miesiac= params[3];
                String dzien= params[4];
                String opis= params[7];
                link = "http://androidsql.cba.pl/dodaj_rekord.php";
                data = URLEncoder.encode("login", "UTF-8") + "=" +
                        URLEncoder.encode(login, "UTF-8") + "&" + URLEncoder.encode("haslo", "UTF-8") + "=" +
                        URLEncoder.encode(haslo, "UTF-8") + "&" + URLEncoder.encode("plan_add", "UTF-8") + "=" +
                        URLEncoder.encode(nazwa, "UTF-8") + "&" + URLEncoder.encode("plan_miesiac", "UTF-8") + "=" +
                        URLEncoder.encode(miesiac, "UTF-8") + "&" + URLEncoder.encode("plan_dzien", "UTF-8") + "=" +
                        URLEncoder.encode(dzien, "UTF-8") + "&" + URLEncoder.encode("plan_od", "UTF-8") + "=" +
                        URLEncoder.encode(godzina_od, "UTF-8") + "&" + URLEncoder.encode("plan_do", "UTF-8") + "=" +
                        URLEncoder.encode(godzina_do, "UTF-8") + "&" + URLEncoder.encode("plan_opis", "UTF-8") + "=" +
                        URLEncoder.encode(opis, "UTF-8");
            }if(parametr.equals("usunrekord") ) {
                String nazwa = params[2];
                String godzina_od = params[5];
                String godzina_do = params[6];
                String miesiac = params[3];
                String dzien = params[4];
                link = "http://androidsql.cba.pl/usun_rekord.php";
                data = URLEncoder.encode("login", "UTF-8") + "=" +
                        URLEncoder.encode(login, "UTF-8") + "&" + URLEncoder.encode("haslo", "UTF-8") + "=" +
                        URLEncoder.encode(haslo, "UTF-8") + "&" + URLEncoder.encode("plan_add", "UTF-8") + "=" +
                        URLEncoder.encode(nazwa, "UTF-8") + "&" + URLEncoder.encode("plan_miesiac", "UTF-8") + "=" +
                        URLEncoder.encode(miesiac, "UTF-8") + "&" + URLEncoder.encode("plan_dzien", "UTF-8") + "=" +
                        URLEncoder.encode(dzien, "UTF-8") + "&" + URLEncoder.encode("plan_od", "UTF-8") + "=" +
                        URLEncoder.encode(godzina_od, "UTF-8") + "&" + URLEncoder.encode("plan_do", "UTF-8") + "=" +
                        URLEncoder.encode(godzina_do, "UTF-8");
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


        if(parametr.equals("zaloguj") ) {

            if (sb.equals("zalogowano")) {
Intent intent = new Intent(context,Main2Activity.class);
                intent.putExtra("login",login );
                intent.putExtra("haslo",login);
                context.startActivity(intent);


            } else {
                Toast.makeText(context, sb, Toast.LENGTH_LONG).show();
            }
        }
else
            {

                Toast.makeText(context, sb, Toast.LENGTH_LONG).show();

            }



        }

}

