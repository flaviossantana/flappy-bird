package br.com.alura.flappybird.graphic;

import android.graphics.Paint;
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

}
