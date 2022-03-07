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
        playlist.add(R.raw.cancion1);
        playlist.add(R.raw.cancion2);
        miReproductor = MediaPlayer.create(this,playlist.get(1));
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
        if (miReproductor.isPlaying())
            miReproductor.stop();
        timer.cancel();
        super.onDestroy();
    }

    public void playNext() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                miReproductor.reset();
                miReproductor = MediaPlayer.create(Servicios.this,playlist.get(++i));
                miReproductor.start();
                if (playlist.size() > i+1) {
                    playNext();
                }
            }
        },miReproductor.getDuration()+100);
    }
}
