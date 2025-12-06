package br.com.cefetmg.batalhapokemon.model.normal;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo; 
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Vigoroth extends Slakoth {

    public Vigoroth(String apelido) {
        super(apelido);
        setEspecie("Vigoroth");
        setNivelEvolucao(2);
        setVidaMaxima(280);
        setVida(280);
        setAtaque(80);
        setDefesa(70);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Arranhão", 50, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Investida", 60, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println("\nO QUE? " + getApelido() + " ESTÁ EVOLUINDO! ");
        Slaking slaking = new Slaking(getApelido());
        System.out.println(getApelido() + " evoluiu para " + slaking.getEspecie() + "!");
        return slaking;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Vigoroth!'");
    }

}
