package br.com.cefetmg.batalhapokemon.model.fogo;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Quilava extends Cyndaquil {

    public Quilava(String apelido) {
        super(apelido);
        setEspecie("Quilava");
        setNivelEvolucao(2);
        setVidaMaxima(290);
        setVida(290);
        setAtaque(95);
        setDefesa(65);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Bola de Fogo", 70, Tipo.FOGO));
        adicionarAtaque(new Ataque("Lança Chamas", 75, Tipo.FOGO));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println("\nO QUE? " + getApelido() + " ESTÁ EVOLUINDO! ");
        Typhlosion typhlosion = new Typhlosion(getApelido());
        System.out.println(getApelido() + " evoluiu para " + typhlosion.getEspecie() + "!");
        return typhlosion;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Quilava!'");
    }

}
