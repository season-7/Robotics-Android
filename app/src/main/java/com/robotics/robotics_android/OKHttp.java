package com.robotics.robotics_android;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by EduhG on 9/22/2016.
 */
public class OKHttp extends AsyncTask<String, Void, String> {
    OkHttpClient client = new OkHttpClient();
    String url;

    public OKHttp(){

    }

    protected String doInBackground(String... params) {
        Request request = new Request.Builder()
                .url(params[0])
                .build();

        try{
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful())
                throw new IOException("Unexpected code" + response.toString());
            return response.body().string();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
