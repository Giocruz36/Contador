package com.example.contador;

import android.app.Service;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import android.media.MediaPlayer;
import android.os.IBinder;
import androidx.annotation.Nullable;

public class Servicios extends Service {

    MediaPlayer miReproductor;
    Timer timer;
    MediaPlayer mp;
    ArrayList<Integer> playlist;
    int i=0;

    @Nullable
    public IBinder onBind(Intent intent){
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        playlist = new ArrayList<>();
        playlist.add(R.raw.musica);
        playlist.add(R.raw.pomposo);
        mp = MediaPlayer.create(this,playlist.get(0));
        miReproductor.setLooping(true);
        miReproductor.setVolume(100,100);
    }

    public int onStartCommand (Intent intent, int flags, int startId){
        miReproductor.start();
        timer = new Timer();
        if (playlist.size()>1) playNext();
        return START_STICKY;
    }

    public void onDestroy(){
        super.onDestroy();
        if (mp.isPlaying())
            mp.stop();
        timer.cancel();
        super.onDestroy();
    }

    public void playNext() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mp.reset();
                mp = MediaPlayer.create(Servicios.this,playlist.get(++i));
                mp.start();
                if (playlist.size() > i+1) {
                    playNext();
                }
            }
        },mp.getDuration()+100);
    }
}
