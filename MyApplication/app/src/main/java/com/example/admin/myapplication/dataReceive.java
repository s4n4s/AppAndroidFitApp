package com.example.admin.myapplication;

/**
 * Created by admin on 12/04/2018.
 */

public class dataReceive {
    private static String URL ="https://wger.de/api/v2/exercise/"+"&Authorization=fd15d8309edbaa1f794c956c5b0c5ef6582bf31f";


    public static String getData() throws Exception
    {
        String response = OkHttpTools.sendGetOkHttpRequest(URL);
        return response;
    }
}

