package com.example.admin.myapplication;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

public class FitappActivity extends AppCompatActivity {
    public static final String Fitapp_API = "com.FITAPP_API";
    public List<Exercice> exerList;
    public FitAppAdapter fitapp;
    public RecyclerView rv;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_fitapp);

        Intent intent = new Intent(FitappActivity.this, MyIntentServiceFit.class);
        startService(intent);

        rv = (RecyclerView) findViewById(R.id.recycle_fitapp);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));


        fitapp = new FitAppAdapter(this, exerList);
        rv.setAdapter(fitapp);
    }


    class FixturesUpdate extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"Data available", Toast.LENGTH_SHORT).show();


            String contentFile = readFile("exe.txt");
            Log.d("js",""+contentFile);
            try
            {
                JSONArray jsonarr = new JSONArray(contentFile);
                Log.d("js",""+jsonarr);
                int test = jsonarr.length();
                if(exerList.size() > 0)
                {
                    exerList.clear();
                }
                for(int i = 0;i < test;i++)
                {
                    JSONObject jsonobj =  jsonarr.getJSONObject(i);
                    exerList.add(new Exercice(jsonobj.getString("name"),jsonobj.getString("creation_date"),jsonobj.getString("description")));
                }
                fitapp.notifyDataSetChanged();

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    public String readFile(String file)
    {
        String text = "";

        try {
            FileInputStream fis = openFileInput(file);
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            fis.close();
            text = new String(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

}
