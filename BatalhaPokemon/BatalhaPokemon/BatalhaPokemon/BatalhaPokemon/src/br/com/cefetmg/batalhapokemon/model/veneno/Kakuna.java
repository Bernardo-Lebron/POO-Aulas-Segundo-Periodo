package br.com.cefetmg.batalhapokemon.model.veneno;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo; 
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Kakuna extends Weedle {

    public Kakuna(String apelido) {
        super(apelido);
        setEspecie("Kakuna");
        setNivelEvolucao(2);
        setVidaMaxima(205);
        setVida(205);
        setAtaque(45);
        setDefesa(80);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Coice", 40, Tipo.VENENO));
        adicionarAtaque(new Ataque("Investida", 30, Tipo.VENENO));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println("\nO QUE? " + getApelido() + " ESTÁ EVOLUINDO! ");
        Beedrill beedrill = new Beedrill(getApelido());
        System.out.println(getApelido() + " evoluiu para " + beedrill.getEspecie() + "!");
        return beedrill;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Kakuna!'");
    }

}
