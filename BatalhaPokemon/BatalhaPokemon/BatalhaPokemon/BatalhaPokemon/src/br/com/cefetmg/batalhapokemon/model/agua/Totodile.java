package br.com.cefetmg.batalhapokemon.model.agua;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Totodile extends Pokemon {
    
    public Totodile(String apelido) {
        super(
            apelido,
            "Totodile",
            Tipo.AGUA,
            1,
            280,
            65,
            64,
            43
        );

        adicionarAtaque(new Ataque("Mordida", 30, Tipo.AGUA));
        adicionarAtaque(new Ataque("Jato de Água", 35, Tipo.AGUA));
    }

    @Override
    public Pokemon evoluir() {
        return new Croconaw(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Totodile!'");
    }
}
