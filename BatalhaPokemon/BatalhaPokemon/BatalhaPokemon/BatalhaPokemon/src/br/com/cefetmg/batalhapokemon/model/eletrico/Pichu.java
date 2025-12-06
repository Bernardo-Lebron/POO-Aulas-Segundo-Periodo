package br.com.cefetmg.batalhapokemon.model.eletrico;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Pichu extends Pokemon {

    public Pichu(String apelido) {
        super(
            apelido,
            "Pichu",
            Tipo.ELETRICO,
            1,
            240,
            20,
            15,
            30
        );

        adicionarAtaque(new Ataque("Choque do Trovão", 20, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Cauda de Ferro", 15, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Pikachu(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Pichuuu!'");
    }
    
}
