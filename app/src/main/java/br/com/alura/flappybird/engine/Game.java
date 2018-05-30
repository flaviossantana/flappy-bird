package br.com.alura.flappybird.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import br.com.alura.flappy_bird.R;
import br.com.alura.flappybird.elements.Passaro;
import br.com.alura.flappybird.graphic.Tela;

public class Game extends SurfaceView implements Runnable {

    private boolean isRunning = true;
    private final SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Bitmap background;
    private Tela tela;


    public Game(Context context) {
        super(context);
        tela = new Tela(context);
        inicializaElementos();
    }

    private void inicializaElementos() {
        passaro = new Passaro();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bk_frame);
        background = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), tela.getAltura(), false);
    }

    @Override
    public void run() {
        while (isRunning) {

            if (!holder.getSurface().isValid()) {
                continue;
            }

            Canvas canvas = holder.lockCanvas();
            canvas.drawBitmap(background, 0,0, null);
            passaro.desenhaNo(canvas);
            passaro.cai();
            holder.unlockCanvasAndPost(canvas);

        }
    }

    public void pausa() {
        isRunning = false;
    }

    public void inicia() {
        isRunning = true;
    }
}
