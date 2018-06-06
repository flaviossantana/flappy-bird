package br.com.alura.flappybird.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import br.com.alura.flappy_bird.R;
import br.com.alura.flappybird.elements.Cano;
import br.com.alura.flappybird.elements.Canos;
import br.com.alura.flappybird.elements.GameOver;
import br.com.alura.flappybird.elements.Passaro;
import br.com.alura.flappybird.elements.Pontuacao;
import br.com.alura.flappybird.graphic.Tela;

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private final Context context;
    private boolean isRunning = true;
    private final SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Bitmap background;
    private Tela tela;
    private Canos canos;
    private Pontuacao pontuacao;


    public Game(Context context) {
        super(context);
        this.context = context;
        tela = new Tela(this.context);
        inicializaElementos();
        setOnTouchListener(this);
    }

    private void inicializaElementos() {
        pontuacao = new Pontuacao();
        passaro = new Passaro(tela, context);
        canos = new Canos(tela, pontuacao);
        criarBackground();
    }

    private void criarBackground() {
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
            canos.desenhaNo(canvas);
            canos.move();
            passaro.desenhaNo(canvas);
            passaro.cai();
            pontuacao.desenhaNo(canvas);

            if(new VerificadorDeColisao(passaro, canos).temColisao()){
                new GameOver(tela).desenhaNo(canvas);
                pausa();
            }

            holder.unlockCanvasAndPost(canvas);

        }
    }

    public void pausa() {
        isRunning = false;
    }

    public void inicia() {
        isRunning = true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        passaro.pula();
        return false;
    }
}
