package br.com.cefetmg.batalhapokemon.model.planta;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Ivysaur extends Bulbasaur {

    public Ivysaur(String apelido) {
        super(apelido);
        setEspecie("Ivysaur");
        setNivelEvolucao(2);
        setVidaMaxima(300);
        setVida(300);
        setAtaque(90);
        setDefesa(80);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Folha Navalha", 55, Tipo.PLANTA));
        adicionarAtaque(new Ataque("Chicote de Vinha", 45, Tipo.PLANTA));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println("\nO QUE? " + getApelido() + " ESTÁ EVOLUINDO! ");
        Venusaur venusaur = new Venusaur(getApelido());
        System.out.println(getApelido() + " evoluiu para " + venusaur.getEspecie() + "!");
        return venusaur;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Ivysaur!'");
    }

}
