package com.example.ery00.bp20;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class nowosci_activity extends Activity {
    private ListView list ;
    private ArrayAdapter<String> adapter ;
    private ListView listView1;
    private ArrayList<RowBean> rowBeanList;
    private String json_string;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    ConnectAdapter connectAdapter;
    ConnectOpis connectOpis;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowosci_activity);
        json_string = getIntent().getExtras().getString("DATA2");

        listView1 = (ListView)findViewById(R.id.View1);
        rowBeanList = new ArrayList<>();

        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("server_response");
            int count = 0;
            while (count < jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                String  male_zdiecie = JO.getString("male_zdiecie");
                String autor = JO.getString("autor");
                String tytul = JO.getString("tytul");
                rowBeanList.add(new RowBean(male_zdiecie,tytul,autor,"pokaż opis"));
                count++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }




            listView1.setAdapter(new ArrayAdapter<RowBean>(this,0,rowBeanList){
                private View row;
                private LayoutInflater inflater = getLayoutInflater();
                private TextView textView;
                private TextView textView2;
                private TextView textView3;
                private ImageLoader mImageLoader;
                private NetworkImageView img;

                // private WebView webView;


                @Override
                public View getView(final int position, View convertView, ViewGroup parent) {

                    row = inflater.inflate(R.layout.row,parent,false);
                    textView = (TextView)row.findViewById(R.id.Row);
                    textView2 = (TextView)row.findViewById(R.id.Row2);
                    textView3 = (TextView)row.findViewById(R.id.Row3);
                    img = (NetworkImageView)row.findViewById(R.id.network_img_view);
                    //webView = (WebView) row.findViewById(R.id.web);
                    RowBean object = rowBeanList.get(position);
                    textView.setMovementMethod(new ScrollingMovementMethod());
                    textView.setText(object.title);
                    textView2.setText(object.autor);
                    textView3.setText(object.wiecej);
                    mImageLoader = Volley.getInstance(getApplicationContext()).getImageLoader();

                    mImageLoader.get(object.url, ImageLoader.getImageListener(img, R.drawable.loading, R.mipmap.ic_launcher));
                    img.setImageUrl(object.url,mImageLoader);
                   // webView.setWebViewClient(new WebViewClient());
                   // webView.loadUrl(object.url);

                    textView3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            connectAdapter = new ConnectAdapter(getApplicationContext(),"opis",position);
                            connectAdapter.execute();

                        }
                    });


                    return row;
                }
            });




    }
}
