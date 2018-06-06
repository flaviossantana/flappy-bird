package br.com.alura.flappybird.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import br.com.alura.flappy_bird.R;

public class Som {

    public static int PULO;
    public static int COLISAO;
    public static int PONTOS;
    private final Context context;
    private final SoundPool soundPool;


    public Som(Context context) {
        this.context = context;
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        PULO = loadSound(R.raw.pulo);
        COLISAO = loadSound(R.raw.colisao);
        PONTOS = loadSound(R.raw.pontos);
    }

    private int loadSound(int colisao) {
        return soundPool.load(this.context, colisao, 1);
    }

    public void toca(int som) {
        soundPool.play(som, 1, 1, 1, 0, 1);
    }

}
