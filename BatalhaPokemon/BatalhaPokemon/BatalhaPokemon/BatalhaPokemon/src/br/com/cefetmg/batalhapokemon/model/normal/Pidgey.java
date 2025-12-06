package br.com.cefetmg.batalhapokemon.model.normal;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Pidgey extends Pokemon {

    public Pidgey(String apelido) {
        super(
            apelido,
            "Pidgey",
            Tipo.NORMAL,
            1,
            240,
            45,
            40,
            35
        );

        adicionarAtaque(new Ataque("Rajada de Vento", 30, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Garra Cortante", 35, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Pidgeotto(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Pidgey! Pidgey!'");
    }
    
}
