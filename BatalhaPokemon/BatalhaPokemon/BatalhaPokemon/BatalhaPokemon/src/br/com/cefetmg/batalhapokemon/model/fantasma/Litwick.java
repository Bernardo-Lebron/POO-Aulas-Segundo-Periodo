package br.com.cefetmg.batalhapokemon.model.fantasma;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Litwick extends Pokemon {

    public Litwick(String apelido) {
        super(
            apelido,
            "Litwick",
            Tipo.FANTASMA,
            1,
            250,
            30,
            55,
            20
        );

        adicionarAtaque(new Ataque("Sombra Vil", 40, Tipo.FANTASMA));
        adicionarAtaque(new Ataque("Luz da Vela", 30, Tipo.FANTASMA));
    }

    @Override
    public Pokemon evoluir() {
        return new Lampent(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Litwick...'");
    }
    
}
