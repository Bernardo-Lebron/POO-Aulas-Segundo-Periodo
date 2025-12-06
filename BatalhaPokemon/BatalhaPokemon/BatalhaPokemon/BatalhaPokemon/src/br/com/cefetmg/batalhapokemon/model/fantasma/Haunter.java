package br.com.cefetmg.batalhapokemon.model.fantasma;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Haunter extends Gastly {

    public Haunter(String apelido) {
        super(apelido);
        setEspecie("Haunter");
        setNivelEvolucao(2);
        setVidaMaxima(270);
        setVida(270);
        setAtaque(90);
        setDefesa(65);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Sombra Noturna", 60, Tipo.FANTASMA));
        adicionarAtaque(new Ataque("Bola Sombria", 70, Tipo.FANTASMA));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println("\nO QUE? " + getApelido() + " ESTÁ EVOLUINDO! ");
        Gengar gengar = new Gengar(getApelido());
        System.out.println(getApelido() + " evoluiu para " + gengar.getEspecie() + "!");
        return gengar;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Haunter!'");
    }
}
