package br.com.cefetmg.batalhapokemon.model.fogo;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Cyndaquil extends Pokemon {

    public Cyndaquil(String apelido) {
        super(
            apelido,
            "Cyndaquil",
            Tipo.FOGO,
            1,
            230,
            52,
            43,
            65
        );

        adicionarAtaque(new Ataque("Brasa", 40, Tipo.FOGO));
        adicionarAtaque(new Ataque("Arranhão", 30, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Quilava(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Cynda! Cynda!'");
    }
    
}
