package br.com.cefetmg.batalhapokemon.model.fogo;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Charizard  extends Charmeleon {

    public Charizard(String apelido) {
        super(apelido);
        setEspecie("Charizard");
        setNivelEvolucao(3);
        setVidaMaxima(360);
        setVida(360);
        setAtaque(130);
        setDefesa(85);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Explosão de Fogo", 90, Tipo.FOGO));
        adicionarAtaque(new Ataque("Lança Chamas Máximo", 100, Tipo.FOGO));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println(getApelido() + " já está em seu nível máximo!");
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Charizard!'");
    }
    
}
