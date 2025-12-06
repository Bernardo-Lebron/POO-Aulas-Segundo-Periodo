package br.com.cefetmg.batalhapokemon.model.eletrico;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Shinx extends Pokemon {

    public Shinx(String apelido) {
        super(
            apelido,
            "Shinx",
            Tipo.ELETRICO,
            1,
            245,
            30,
            20,
            40
        );

        adicionarAtaque(new Ataque("Faísca", 30, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Arranhão", 20, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Luxio(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Shinx!'");
    }
    
}
