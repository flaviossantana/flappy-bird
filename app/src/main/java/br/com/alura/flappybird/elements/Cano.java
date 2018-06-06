package br.com.alura.flappybird.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import javax.security.auth.login.LoginException;

import br.com.alura.flappybird.graphic.Cores;
import br.com.alura.flappybird.graphic.Tela;

public class Cano {

    private static final float ALTURA_DO_CANO = 450;
    private static final float LARGURA_DO_CANO = 200;
    public static final Paint COR = Cores.getCorDoCano();
    private final float alturaDoCanoinferior;
    private float alturaDoCanoSuperior;
    private Tela tela;
    private int posicao;

    public Cano(Tela tela, int posicao) {
        this.tela = tela;
        this.posicao = posicao;
        alturaDoCanoinferior = tela.getAltura() - ALTURA_DO_CANO - valorAleatorio();
        alturaDoCanoSuperior = 0 + ALTURA_DO_CANO + valorAleatorio();
    }

    public void desenhaNo(Canvas canvas){
        desenhaCanoInferior(canvas);
        desenhaCanoSuperior(canvas);
    }

    public int valorAleatorio(){
        return (int) (Math.random() * 300);
    }

    private void desenhaCanoInferior(Canvas canvas) {
        canvas.drawRect(posicao, alturaDoCanoinferior, posicao + LARGURA_DO_CANO, tela.getAltura(), COR);
    }

    private void desenhaCanoSuperior(Canvas canvas) {
        canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO, alturaDoCanoSuperior, COR);
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
        Log.i("####HORIZDADOS", String.valueOf(posicao) +", "+ String.valueOf(passaro.X) +", " + String.valueOf(passaro.RAIO));
        Log.i("####HORIZONTAL", String.valueOf(posicao - passaro.X) +" < "+ passaro.RAIO +" = "+ String.valueOf(posicao - passaro.X < passaro.RAIO));
        return this.posicao - passaro.X < passaro.RAIO;
    }

    public boolean temColisaoVerticalCom(Passaro passaro) {
        Log.i("#####DADOSVER", String.valueOf(passaro.getAltura()) +" - "+ String.valueOf(passaro.RAIO)+ " < " +String.valueOf(alturaDoCanoSuperior) + " || " + String.valueOf(passaro.getAltura()) + " + " + String.valueOf(passaro.RAIO) +" > "+ String.valueOf(alturaDoCanoinferior));
        Log.i("#####VERTICAL", String.valueOf(passaro.getAltura() - passaro.RAIO < alturaDoCanoSuperior) +" || "+ String.valueOf(passaro.getAltura() + passaro.RAIO > alturaDoCanoinferior));
        return ((passaro.getAltura() - passaro.RAIO) < this.alturaDoCanoSuperior) || ((passaro.getAltura() + passaro.RAIO) > this.alturaDoCanoinferior);
    }
}
