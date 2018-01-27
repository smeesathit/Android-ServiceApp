package com.example.snru.serviceapp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private Button startButton;
//private  boolean serviceRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         intent = new Intent(getBaseContext(), MyService.class);
        intent.putExtra("song", R.raw.fortune_cookie);
        startButton = findViewById(R.id.startButton);

        if (isMyServiceRunning(MyService.class)){


            startButton.setEnabled(false);
            Toast.makeText(getBaseContext(), "Service is running!", Toast.LENGTH_SHORT).show();
        }

    }

    public void startButtonClick (View view) {

            startService(intent);
            startButton.setEnabled(false);
            Toast.makeText(getBaseContext(), "Start a service!", Toast.LENGTH_SHORT).show();



    //    Toast.makeText(getBaseContext(), "Start service!", Toast.LENGTH_SHORT).show();
        //if (!serviceRunning) {




           // serviceRunning = true;

       // }
        // if not set startButton to be unclickable
        // else {
  //Toast.makeText(getBaseContext(), "Service is running!", Toast.LENGTH_SHORT).show();
    //    }

    }

    public void stopButtonClick (View view) {
      //  Toast.makeText(getBaseContext(), "Stop service!", Toast.LENGTH_SHORT).show();
stopService(intent);
        startButton.setEnabled(true);
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
