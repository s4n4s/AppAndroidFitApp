package com.example.admin.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentServiceFit extends IntentService {
    private String result;

    public MyIntentServiceFit() {
        super("MyIntentServiceFit");
    }


    @Override
    protected void onHandleIntent(Intent intent)
    {
        try {
            dataReceive getdataexe = new dataReceive();
            result = getdataexe.getData();
            Log.d("test",""+result);
            writeToFile("exe.txt",result);
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(FitappActivity.Fitapp_API));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToFile( String filename, String str) {
        try {
            FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(str.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
