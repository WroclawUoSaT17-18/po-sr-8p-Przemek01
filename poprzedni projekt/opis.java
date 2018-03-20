package com.example.ery00.bp20;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class opis extends Activity {
    private TextView textView4;
    private WebView webView2;
    private ImageLoader mImageLoader;
    private NetworkImageView img;
    private String json_string;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    private String opis;
    private String  duze_zdiecie;
    private ConnectAdapter connectAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opis);

json_string = getIntent().getExtras().getString("DATA3");


        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("server_response");
            int count = 0;

                JSONObject JO = jsonArray.getJSONObject(count);
                  duze_zdiecie = JO.getString("duze_zdiecie");
                 opis = JO.getString("opis");


        } catch (JSONException e) {
            e.printStackTrace();
        }

        String url= "https://thumbs.dreamstime.com/t/old-book-blank-page-feather-pen-51725242.jpg";

        //connectAdapter = new ConnectAdapter(getApplicationContext(),"opis",4);
        //connectAdapter.execute();
        textView4 = (TextView)findViewById(R.id.textView);
        img = (NetworkImageView)findViewById(R.id.network_img_view2);
        mImageLoader = Volley.getInstance(getApplicationContext()).getImageLoader();

        mImageLoader.get(duze_zdiecie, ImageLoader.getImageListener(img, R.drawable.loading, R.mipmap.ic_launcher));
        img.setImageUrl(duze_zdiecie,mImageLoader);

        //webView2 = (WebView)findViewById(R.id.Webview2);

        textView4.setMovementMethod(new ScrollingMovementMethod());
        textView4.setText(opis);

       // webView2.setWebViewClient(new WebViewClient());
       // webView2.loadUrl(opis);
    }



}
