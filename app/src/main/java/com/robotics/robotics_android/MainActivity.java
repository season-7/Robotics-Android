package com.robotics.robotics_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button forward, back, turnLeft, turnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forward = (Button) findViewById(R.id.forward);
        back = (Button) findViewById(R.id.back);
        turnLeft = (Button) findViewById(R.id.turnLeft);
        turnRight = (Button) findViewById(R.id.turnRight);

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
            }
        });

        //Onclick event for going turn left
        turnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Turning Left", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
