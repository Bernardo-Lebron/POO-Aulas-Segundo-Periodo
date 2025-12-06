package br.com.cefetmg.batalhapokemon.model.normal;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Slakoth extends Pokemon {

    public Slakoth(String apelido) {
        super(
            apelido,
            "Slakoth",
            Tipo.NORMAL,
            1,
            260,
            60,
            35,
            30
        );

        adicionarAtaque(new Ataque("Arranhão", 30, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Sonífero", 20, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Vigoroth(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Slakoth... Slakoth...'");
    }
    
}
