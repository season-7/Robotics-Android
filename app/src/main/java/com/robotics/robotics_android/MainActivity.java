package com.robotics.robotics_android;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    Button forward, back, turnLeft, turnRight;
    TextView serverResponse;

    String forwardUrl, backUrl, leftUrl, rightUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forward = (Button) findViewById(R.id.forward);
        back = (Button) findViewById(R.id.back);
        turnLeft = (Button) findViewById(R.id.turnLeft);
        turnRight = (Button) findViewById(R.id.turnRight);

        serverResponse = (TextView) findViewById(R.id.serverResponse);

        //Onclick event for going forward
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Moving Forward", Toast.LENGTH_SHORT).show();
            }
        });

        //Onclick event for going back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Moving Backwards", Toast.LENGTH_SHORT).show();
            }
        });

        //Onclick event for goint turn right
        turnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Turning Right", Toast.LENGTH_SHORT).show();

                rightUrl = "http://192.168.1.4:5000/api/right";
                getResponse(rightUrl);
            }
        });

        //Onclick event for going turn left
        turnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Turning Left", Toast.LENGTH_SHORT).show();
                leftUrl = "http://192.168.1.4:5000/api";

                getResponse(leftUrl);
            }
        });

    }

    /*OKHttp okHttp = new OKHttp();
    String result = null;

    try{
        result = okHttp.execute(leftUrl).get();
        JSONObject jsonObject = new JSONObject(result);
        String commandName = (String) jsonObject.get("name");

        serverResponse.setText(commandName);

    }catch (ExecutionException e){
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    } catch (JSONException e) {
        e.printStackTrace();
    }*/

    //OKHttp method to make get requests to flask api server
    public String getResponse(String url) {
        String commandName = null;

        OKHttp okHttp = new OKHttp();
        String result = null;

        try{
            result = okHttp.execute(url).get();
            JSONObject jsonObject = new JSONObject(result);
            commandName = (String) jsonObject.get("name");

            serverResponse.setText(commandName);

        }catch (ExecutionException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return commandName;
    }
}
