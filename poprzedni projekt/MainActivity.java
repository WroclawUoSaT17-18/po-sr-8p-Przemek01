package com.example.ery00.bp20;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    ConnectAdapter connectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }




    public void activity2(View view) {
        connectAdapter = new ConnectAdapter(this,"lista",0);
        connectAdapter.execute();




    }


}
