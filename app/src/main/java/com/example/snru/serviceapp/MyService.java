package com.example.snru.serviceapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    private MediaPlayer mPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public MyService() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

            int song = intent.getIntExtra("song", 0);
            mPlayer = MediaPlayer.create(getBaseContext(), song);
            mPlayer.start();

        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        mPlayer.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
      throw new UnsupportedOperationException("Not yet implemented");
    // or
         //return null;
    }
}
