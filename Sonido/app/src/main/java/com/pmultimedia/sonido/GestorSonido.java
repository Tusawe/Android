package com.pmultimedia.sonido;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class GestorSonido {

    SoundPool sndPool;
    Context context;

    public GestorSonido(Context appContext) {
        sndPool = new SoundPool(16, AudioManager.STREAM_MUSIC,  100);
        context = appContext;
    }

    public void unloadAll() {
        sndPool.release();
    }

    public int carga(int soundId){
        return sndPool.load(context, soundId, 1);
    }

}
