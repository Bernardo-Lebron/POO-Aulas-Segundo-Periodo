package br.com.cefetmg.batalhapokemon.model.agua;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Feraligatr extends Croconaw {
    
    public Feraligatr(String apelido) {
        super(apelido);
        setEspecie("Feraligatr");
        setNivelEvolucao(3);
        setVidaMaxima(410);
        setVida(410);
        setAtaque(110);
        setDefesa(90);


        getAtaques().clear();
        adicionarAtaque(new Ataque("Jato de Água Forte", 50, Tipo.AGUA));
        adicionarAtaque(new Ataque("Hidrocanhão", 55, Tipo.AGUA));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println(getApelido() + " já está em seu nível máximo!");
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'FERALIGATR!'");
    }
}
