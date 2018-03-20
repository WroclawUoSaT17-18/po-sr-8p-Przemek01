package com.example.ery00.bp20;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends Activity {
    private String json_string;
    private String odp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        json_string = getIntent().getExtras().getString("DATA");
        odp = json_string;

    }


    public void nowosci(View view) {


        Intent intent = new Intent(this, nowosci_activity.class);
        intent.putExtra("DATA2", odp);
        startActivity(intent);
        finish();

    }
}

