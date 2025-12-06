package br.com.cefetmg.batalhapokemon.model.fogo;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Charmander extends Pokemon {

    public Charmander(String apelido) {
        super(
            apelido,
            "Charmander",
            Tipo.FOGO,
            1,
            240,
            52,
            43,
            65
        );

        adicionarAtaque(new Ataque("Brasa", 40, Tipo.FOGO));
        adicionarAtaque(new Ataque("Arranhão", 30, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Charmeleon(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Char... Char!'");
    }
    
}
