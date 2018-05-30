package br.com.alura.flappybird.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.alura.flappybird.graphic.Cores;
import br.com.alura.flappybird.graphic.Tela;

public class Cano {

    private static final float ALTURA_DO_CANO = 450;
    private static final float LARGURA_DO_CANO = 450;
    public static final Paint COR = Cores.getCorDoCano();
    private final float alturaDoCanoinferior;
    private Tela tela;
    private int posicao;

    public Cano(Tela tela, int posicao) {
        this.tela = tela;
        this.posicao = posicao;
        alturaDoCanoinferior = tela.getAltura() - ALTURA_DO_CANO;
    }

    public void desenhaNo(Canvas canvas){
        desenhaCanoInferior(canvas);
    }

    private void desenhaCanoInferior(Canvas canvas) {
        canvas.drawRect(posicao, alturaDoCanoinferior, LARGURA_DO_CANO, tela.getAltura(), COR);
    }

}
