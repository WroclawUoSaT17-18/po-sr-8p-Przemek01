package com.example.ery00.bp20;

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
 * Created by ery00 on 2017-02-27.
 */

    public class ConnectAdapter extends AsyncTask<String,String,String> {
        private Context context;
        private String method;
        private String position;


        public ConnectAdapter(Context context,String method,int position){

            this.context = context;
            this.method = method;
            this.position = Integer.toString(position+1);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            cancel(true);
        }

        @Override
        protected String doInBackground(String... params) {
            String link = null;
            String data;
            if(method == "lista") {
                link = "http://androidsql.cba.pl/json_get2.php";
            }
            else {link = "http://androidsql.cba.pl/json_get3.php";}

            try {
                data = URLEncoder.encode("pozycja", "UTF-8") + "=" +
                        URLEncoder.encode(position, "UTF-8");

                URL url = new URL(link);
                URLConnection conn = url.openConnection();
                if(method != "lista") {
                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    wr.write(data);
                    wr.flush();
                }
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
        String Data = "DATA";
        Intent intent[] = new Intent[2];
        intent[1] = new Intent(context, opis.class);
        intent[0] = new Intent(context, Main2Activity.class);
         int x = 0;
        if(method == "lista") {
            Toast.makeText(context,sb,Toast.LENGTH_LONG).show();





        }
        if( method == "opis") { Toast.makeText(context,sb,Toast.LENGTH_LONG).show();
            Data = "DATA3";
            //intent.putExtra("DATA3", sb);
            x = 1;

        }
            intent[0].setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent[1].setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            intent[x].putExtra(Data, sb);
        context.startActivity(intent[x]);


    }


}