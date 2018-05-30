package br.com.alura.flappybird.elements;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.flappybird.graphic.Tela;

public class Canos {

    public static final int QUANTIDADE_DE_CANOS = 5;
    public static final int DISTANCIA_ENTRE_CANOS = 400;
    private final List<Cano> canos = new ArrayList<>();

    int posicao = 400;

    public Canos(Tela tela) {
        for(int i = 0; i< QUANTIDADE_DE_CANOS; i++) {
            posicao += DISTANCIA_ENTRE_CANOS;
            canos.add(new Cano(tela, posicao));
        }
    }

    public void desenhaNo(Canvas canvas) {
        for (Cano cano : canos) {
            cano.desenhaNo(canvas);
        }
    }

    public void move() {
        for (Cano cano : canos) {
            cano.move();
        }
    }
}
