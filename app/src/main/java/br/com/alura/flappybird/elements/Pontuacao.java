package br.com.alura.flappybird.elements;

import android.graphics.Canvas;

import br.com.alura.flappybird.engine.Som;
import br.com.alura.flappybird.graphic.Cores;

import static br.com.alura.flappybird.engine.Som.PONTOS;
import static br.com.alura.flappybird.graphic.Cores.getCorDaPontuacao;

public class Pontuacao {

    private int pontos = 0;
    private Som som;

    public void desenhaNo(Canvas canvas, Som som) {
        this.som = som;
        canvas.drawText(String.valueOf(pontos), 50, 150, getCorDaPontuacao());
    }

    public void aumenta() {
        som.toca(PONTOS);
        pontos++;
    }
}
