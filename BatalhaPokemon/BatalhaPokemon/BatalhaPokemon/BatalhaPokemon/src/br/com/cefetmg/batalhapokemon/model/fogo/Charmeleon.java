package br.com.cefetmg.batalhapokemon.model.fogo;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo; 
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Charmeleon extends Charmander {

    public Charmeleon(String apelido) {
        super(apelido);
        setEspecie("Charmeleon");
        setNivelEvolucao(2);
        setVidaMaxima(300);
        setVida(300);
        setAtaque(90);
        setDefesa(70);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Brasa", 60, Tipo.FOGO));
        adicionarAtaque(new Ataque("Lança Chamas", 70, Tipo.FOGO));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println("\nO QUE? " + getApelido() + " ESTÁ EVOLUINDO! ");
        Charizard charizard = new Charizard(getApelido());
        System.out.println(getApelido() + " evoluiu para " + charizard.getEspecie() + "!");
        return charizard;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Charmeleon!'");
    }

}
