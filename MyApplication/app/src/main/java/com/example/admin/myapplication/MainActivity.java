package com.example.admin.myapplication;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabItem;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    public RecyclerView rv_fitapp;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationCompat.Builder notif = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setContentTitle("Bienvenue")
                .setAutoCancel(true)
                .setPriority(Notification.PRIORITY_HIGH)
                .setContentText("Cette application est en cours de developpement");

        Notification builder = notif.build();
        NotificationManagerCompat.from(this).notify(1, builder);



        button = findViewById(R.id.exercice);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

            public Object Menu;
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FitappActivity.class);
                startActivity(intent);

                @Override
                public boolean onOptionsItemSelected (MenuItem)

                        {
                switch (MenuItem.getItemId())
                {

                    case R.id.get_faq:
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://football-api.com"));
                        startActivity(browserIntent);
                        break;
                }
                return super.onOptionsItemSelected(MenuItem);
                }


            });
        ;
    }


    public void ToastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

    }

    public void displayToastMsg(View v) {
        ToastMsg("Benzakour/Osseni");
    }

}
