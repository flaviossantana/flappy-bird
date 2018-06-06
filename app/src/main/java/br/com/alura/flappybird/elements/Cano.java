package br.com.alura.flappybird.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import javax.security.auth.login.LoginException;

import br.com.alura.flappy_bird.R;
import br.com.alura.flappybird.graphic.Cores;
import br.com.alura.flappybird.graphic.Tela;

public class Cano {

    private static final int ALTURA_DO_CANO = 450;
    private static final int LARGURA_DO_CANO = 200;
    public static final Paint COR = Cores.getCorDoCano();
    private final int alturaDoCanoinferior;
    private final Bitmap canoSuperior;
    private int alturaDoCanoSuperior;
    private Tela tela;
    private int posicao;
    private final Bitmap canoInferior;

    public Cano(Tela tela, int posicao, Context context) {
        this.tela = tela;
        this.posicao = posicao;
        alturaDoCanoinferior = tela.getAltura() - ALTURA_DO_CANO - valorAleatorio();
        alturaDoCanoSuperior = 0 + ALTURA_DO_CANO + valorAleatorio();

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        canoInferior = Bitmap.createScaledBitmap(bitmap, LARGURA_DO_CANO, this.alturaDoCanoinferior, false);
        canoSuperior = Bitmap.createScaledBitmap(bitmap, LARGURA_DO_CANO, this.alturaDoCanoSuperior, false);

    }

    public void desenhaNo(Canvas canvas){
        desenhaCanoInferior(canvas);
        desenhaCanoSuperior(canvas);
    }

    public int valorAleatorio(){
        return (int) (Math.random() * 300);
    }

    private void desenhaCanoInferior(Canvas canvas) {
        canvas.drawBitmap(canoInferior, posicao, alturaDoCanoinferior, null);
    }

    private void desenhaCanoSuperior(Canvas canvas) {
        canvas.drawBitmap(canoSuperior, posicao, 0, null);
    }

    public void move() {
        this.posicao -= 3;
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean temColisaoHorizontalCom(Passaro passaro) {
        return this.posicao - passaro.X < passaro.RAIO;
    }

    public boolean temColisaoVerticalCom(Passaro passaro) {
        return ((passaro.getAltura() - passaro.RAIO) < this.alturaDoCanoSuperior) || ((passaro.getAltura() + passaro.RAIO) > this.alturaDoCanoinferior);
    }
}
