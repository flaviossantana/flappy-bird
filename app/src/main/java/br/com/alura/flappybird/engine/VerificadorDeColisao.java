package br.com.alura.flappybird.engine;

import br.com.alura.flappybird.elements.Canos;
import br.com.alura.flappybird.elements.Passaro;

public class VerificadorDeColisao {

    private Passaro passaro;
    private Canos canos;

    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao(){
        return canos.temColisaoCom(passaro);
    }

}
