package br.com.cefetmg.batalhapokemon.model.planta;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Bellsprout extends Pokemon {

    public Bellsprout(String apelido) {
        super(
            apelido,
            "Bellsprout",
            Tipo.PLANTA,
            1,
            250,
            75,
            35,
            40
        );

        adicionarAtaque(new Ataque("Investida", 30, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Folha Navalha", 35, Tipo.PLANTA));
    }

    @Override
    public Pokemon evoluir() {
        return new Weenpinbell(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Bell... Sprout...'");
    }
    
}
