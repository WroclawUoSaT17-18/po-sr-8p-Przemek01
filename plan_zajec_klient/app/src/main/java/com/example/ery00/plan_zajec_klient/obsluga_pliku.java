package com.example.ery00.plan_zajec_klient;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Created by ery00 on 2018-04-30.
 */

public class obsluga_pliku {
Context context;


   public obsluga_pliku(Context context){
this.context =context;

   }

   public void zapisz(String dane)
   {
      String state;
      state = Environment.getExternalStorageState();
      if(Environment.MEDIA_MOUNTED.equals(state))
      {
         File Root =  Environment.getExternalStorageDirectory();
         File Dir = new File("/mnt/sdcard/Mojplan");
         if(!Dir.exists())
         {
            Dir.mkdir();
         }

         File file = new File(Dir,"plan.txt");

         FileOutputStream out = null;
         try {

            out = new FileOutputStream(file);
            out.write(dane.getBytes());
            out.close();
         } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(context,e.toString(), Toast.LENGTH_LONG).show();


         } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context,e.toString(), Toast.LENGTH_LONG).show();
         }


      }else
      {        Toast.makeText(context,"blad", Toast.LENGTH_LONG).show();
      }

   }

public String wczytaj()  {
   File Dir = new File("/mnt/sdcard/Mojplan");
   File file = new File(Dir,"plan.txt");
String plan = "";
FileInputStream in;

   try {
      int rozmiar = (int)file.length();
      in = new FileInputStream(file);
      byte[] bytes = new  byte[rozmiar];
      in.read(bytes);
      plan = new String(bytes);

   } catch (FileNotFoundException e) {
      e.printStackTrace();
   }catch (IOException e) {
      e.printStackTrace();
   }
   return plan;
   }
}
