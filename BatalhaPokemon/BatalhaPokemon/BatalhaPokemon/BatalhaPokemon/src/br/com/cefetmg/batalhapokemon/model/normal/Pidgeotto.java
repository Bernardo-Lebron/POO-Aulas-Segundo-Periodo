package br.com.cefetmg.batalhapokemon.model.normal;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Pidgeotto extends Pidgey {

    public Pidgeotto(String apelido) {
        super(apelido);
        setEspecie("Pidgeotto");
        setNivelEvolucao(2);
        setVidaMaxima(250);
        setVida(250);
        setAtaque(90);
        setDefesa(70);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Rajada de Vento", 55, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Garra", 45, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println("\nO QUE? " + getApelido() + " ESTÁ EVOLUINDO! ");
        Pidgeot pidgeot = new Pidgeot(getApelido());
        System.out.println(getApelido() + " evoluiu para " + pidgeot.getEspecie() + "!");
        return pidgeot;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Pidgeotto!'");
    }
}
