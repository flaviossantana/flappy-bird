package br.com.alura.flappybird.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import br.com.alura.flappybird.engine.Som;
import br.com.alura.flappybird.graphic.Cores;
import br.com.alura.flappybird.graphic.Tela;

import static br.com.alura.flappybird.engine.Som.COLISAO;

public class GameOver {

    private Tela tela;
    private Som som;
    private Paint corGameOver = Cores.getCorGameOver();;
    private String TEXTO_GAME_OVER = "Você Perdeu!";

    public GameOver(Tela tela, Som som) {
        this.tela = tela;
        this.som = som;
    }

    public void desenhaNo(Canvas canvas){
        int centroHorizontal = centralizaTexto(TEXTO_GAME_OVER);
        canvas.drawText(TEXTO_GAME_OVER, centroHorizontal, tela.getAltura()/2, corGameOver);
        som.toca(COLISAO);
    }

    private int centralizaTexto(String texto) {
        Rect limiteDoTexto = new Rect();
        corGameOver.getTextBounds(texto, 0, texto.length(), limiteDoTexto);
        return tela.getLargura() /2 - (limiteDoTexto.right - limiteDoTexto.left)/2;
    }

}
