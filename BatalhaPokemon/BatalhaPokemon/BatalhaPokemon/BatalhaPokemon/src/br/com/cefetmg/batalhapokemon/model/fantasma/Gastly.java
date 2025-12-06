package br.com.cefetmg.batalhapokemon.model.fantasma;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Gastly extends Pokemon {

    public Gastly(String apelido) {
        super(
            apelido,
            "Gastly",
            Tipo.FANTASMA,
            1,    
            260,   
            35,   
            20,   
            60    
        );

        adicionarAtaque(new Ataque("Lambida Sombria", 25, Tipo.FANTASMA));
        adicionarAtaque(new Ataque("Gás Mortal", 20, Tipo.FANTASMA));
    }

    @Override
    public Pokemon evoluir() {
        return new Haunter(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Gaaastlyyy...'");
    }
}
