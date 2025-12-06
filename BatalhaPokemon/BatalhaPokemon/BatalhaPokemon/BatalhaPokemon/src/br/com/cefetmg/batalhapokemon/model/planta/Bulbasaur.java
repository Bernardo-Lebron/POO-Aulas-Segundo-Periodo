package br.com.cefetmg.batalhapokemon.model.planta;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Bulbasaur extends Pokemon {

    public Bulbasaur(String apelido) {
        super(
            apelido,
            "Bulbasaur",
            Tipo.PLANTA,
            1,
            245,
            49,
            49,
            45
        );

        adicionarAtaque(new Ataque("Investida", 30, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Folha Navalha", 35, Tipo.PLANTA));
    }

    @Override
    public Pokemon evoluir() {
        return new Ivysaur(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Bulba... Bulba...'");
    }
    
}
