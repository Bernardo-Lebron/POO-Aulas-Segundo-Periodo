package br.com.cefetmg.batalhapokemon.model.veneno;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;  
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Weedle extends Pokemon {

    public Weedle(String apelido) {
        super(
            apelido,
            "Weedle",
            Tipo.VENENO,
            1,
            260,
            35,
            20,
            25
        );

        adicionarAtaque(new Ataque("Ferrão", 15, Tipo.VENENO));
        adicionarAtaque(new Ataque("Toxina", 10, Tipo.VENENO));
    }

    @Override
    public Pokemon evoluir() {
        return new Kakuna(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Weedleee!'");
    }
    
}
