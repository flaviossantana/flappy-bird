package br.com.alura.flappybird.elements;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import br.com.alura.flappybird.graphic.Tela;

public class Canos {

    public static final int QUANTIDADE_DE_CANOS = 5;
    public static final int DISTANCIA_ENTRE_CANOS = 400;
    private final List<Cano> canos = new ArrayList<>();
    private Tela tela;

    int posicao = 400;
    private Pontuacao pontuacao;

    public Canos(Tela tela, Pontuacao pontuacao) {
        this.pontuacao = pontuacao;
        for(int i = 0; i< QUANTIDADE_DE_CANOS; i++) {
            posicao += DISTANCIA_ENTRE_CANOS;
            this.tela = tela;
            canos.add(new Cano(this.tela, posicao));
        }
    }

    public void desenhaNo(Canvas canvas) {
        for (Cano cano : canos) {
            cano.desenhaNo(canvas);
        }
    }

    public void move() {

        ListIterator<Cano> iterator = canos.listIterator();

        while (iterator.hasNext()){
            Cano cano = iterator.next();
            cano.move();

            if(cano.saiuDaTela()){
                pontuacao.aumenta();
                iterator.remove();
                iterator.add(new Cano(tela, getMaximo() + DISTANCIA_ENTRE_CANOS));
            }
        }
    }

    private int getMaximo() {
        int maximo = 0;
        for (Cano cano: canos) {
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }

    public boolean temColisaoCom(Passaro passaro) {
        for (Cano cano: canos) {
            return cano.temColisaoHorizontalCom(passaro) && cano.temColisaoVerticalCom(passaro);
        }
        return false;
    }
}
