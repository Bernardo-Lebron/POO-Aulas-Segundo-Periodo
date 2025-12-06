package br.com.cefetmg.batalhapokemon.model.normal;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Slaking extends Vigoroth {

    public Slaking(String apelido) {
        super(apelido);
        setEspecie("Slaking");
        setNivelEvolucao(3);
        setVidaMaxima(500);
        setVida(500);
        setAtaque(130);
        setDefesa(100);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Golpe de Corpo", 90, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Soco Forte", 80, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println(getApelido() + " já está em seu nível máximo!");
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Slaking!'");
    }

}
