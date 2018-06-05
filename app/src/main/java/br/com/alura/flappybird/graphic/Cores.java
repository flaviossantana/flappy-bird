package br.com.alura.flappybird.graphic;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.NonNull;

public class Cores {

    @NonNull
    private static Paint getPaint(int cor) {
        Paint paint = new Paint();
        paint.setColor(cor);
        return paint;
    }

    public static Paint getCorDoPassaro() {
        return getPaint(0xFFF1C232);
    }

    public static Paint getCorDoCano() {
        return getPaint(0xFF80b3ff);
    }

    public static Paint getCorDaPontuacao() {
        Paint pontuacao = getPaint(0xFFffffff);
        pontuacao.setTextSize(100);
        pontuacao.setTypeface(Typeface.DEFAULT_BOLD);
        pontuacao.setShadowLayer(3,5,5,0xFF000000);
        return pontuacao;
    }

    public static Paint getCorGameOver() {
        Paint gameOver = getPaint(0xFFFF0000);
        gameOver.setTextSize(100);
        gameOver.setTypeface(Typeface.DEFAULT_BOLD);
        gameOver.setShadowLayer(2,3,3,0xFF000000);
        return gameOver;
    }
}
