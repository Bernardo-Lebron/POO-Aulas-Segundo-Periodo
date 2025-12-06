package br.com.cefetmg.batalhapokemon.model.veneno;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Nidoran extends Pokemon {

    public Nidoran(String apelido) {
        super(
            apelido,
            "Nidoran",
            Tipo.VENENO,
            1,
            270,   
            35,   
            25,   
            40   
        );

        adicionarAtaque(new Ataque("Chifrada", 25, Tipo.VENENO));
        adicionarAtaque(new Ataque("Arranhão", 20, Tipo.VENENO));
    }

    @Override
    public Pokemon evoluir() {
        return new Nidorino(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Nidooo!'");
    }
}
