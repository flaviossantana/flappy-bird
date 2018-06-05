package br.com.alura.flappybird.elements;

import android.graphics.Canvas;

import br.com.alura.flappybird.graphic.Cores;

import static br.com.alura.flappybird.graphic.Cores.getCorDaPontuacao;

public class Pontuacao {

    private int pontos = 0;

    public void desenhaNo(Canvas canvas) {
        canvas.drawText(String.valueOf(pontos), 100, 150, getCorDaPontuacao());
    }

    public void aumenta() {
        pontos++;
    }
}
