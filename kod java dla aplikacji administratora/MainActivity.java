package com.example.ery00.plan_zajec_admin;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    zaloguj Zaloguj;
String login,haslo;
EditText login_Edit,haslo_Edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_Edit = (EditText)findViewById(R.id.editText);
        haslo_Edit = (EditText)findViewById(R.id.editText2);
    }

    public void Onlogin (View view)
    {
        login =login_Edit.getText().toString();
        haslo = haslo_Edit.getText().toString();

        Zaloguj = new zaloguj(this,"zaloguj");
        Zaloguj.execute(login,haslo,"");

    }
}
