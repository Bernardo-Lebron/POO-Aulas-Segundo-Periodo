package br.com.cefetmg.batalhapokemon.model.eletrico;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Luxray extends Luxio {

    public Luxray(String apelido) {
        super(apelido);
        setEspecie("Luxray");
        setNivelEvolucao(3);
        setVidaMaxima(400);
        setVida(400);
        setAtaque(130);
        setDefesa(80);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Raio X", 70, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Investida", 40, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println(getApelido() + " já está em seu nível máximo!");
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'LUXRAY!'");
    }

}
