package com.example.ery00.plan_zajec_klient;

import java.util.Comparator;

/**
 * Created by ery00 on 2018-04-29.
 */

public class Kalendarz {
    public String Miesiac;
    public String dzien;
    public String od;
    public String doo;
    public String opis;
    public int id;

    public Kalendarz(String Miesiac, String dzien, String od,String doo, String opis) {
        this.Miesiac = Miesiac;
        this.dzien =dzien;
        this.od =od;
        this.doo =doo;
        this.opis =opis;
        this.id = Integer.parseInt(Miesiac + dzien + od + doo);

    }

    public String GetDate() {
        return dzien + "/" + od + ":00" + "-" + doo + ":00";
    }

    public static class Sortuj implements Comparator<Kalendarz> {
        @Override
        public int compare(Kalendarz arg0, Kalendarz arg1) {
            return arg0.id - arg1.id;
        }
    }
}
