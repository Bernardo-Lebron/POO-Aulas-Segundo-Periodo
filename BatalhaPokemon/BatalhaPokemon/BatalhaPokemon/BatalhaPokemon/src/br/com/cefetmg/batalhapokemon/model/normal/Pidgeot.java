package br.com.cefetmg.batalhapokemon.model.normal;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Pidgeot extends Pidgeotto {

    public Pidgeot(String apelido) {
        super(apelido);
        setEspecie("Pidgeot");
        setNivelEvolucao(3);
        setVidaMaxima(400);
        setVida(400);
        setAtaque(120);
        setDefesa(80);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Furacão", 80, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Garra Afiada", 60, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println(getApelido() + " já está em seu nível máximo!");
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Pidgeot!'");
    }

}
