package br.com.cefetmg.batalhapokemon.model.agua;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Squirtle extends Pokemon {

    public Squirtle(String apelido) {
        super(
            apelido,
            "Squirtle",
            Tipo.AGUA,
            1,
            230,
            60,
            63,
            44
        );

        adicionarAtaque(new Ataque("Jato de Água", 30, Tipo.AGUA));
        adicionarAtaque(new Ataque("Bolha", 25, Tipo.AGUA));
    }

    @Override
    public Pokemon evoluir() {
        return new Wartortle(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Squirtle!'");
    }
}
