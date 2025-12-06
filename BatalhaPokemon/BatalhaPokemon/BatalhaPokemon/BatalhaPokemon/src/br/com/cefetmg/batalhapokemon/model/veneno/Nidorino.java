package br.com.cefetmg.batalhapokemon.model.veneno;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Nidorino extends Nidoran {

    public Nidorino(String apelido) {
        super(apelido);
        setEspecie("Nidorino");
        setNivelEvolucao(2);
        setVidaMaxima(250);
        setVida(250);
        setAtaque(72);
        setDefesa(57);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Chicote de Veneno", 65, Tipo.VENENO));
        adicionarAtaque(new Ataque("Investida Venenosa", 80, Tipo.VENENO));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println("\nO QUE? " + getApelido() + " ESTÁ EVOLUINDO! ");
        Nidoking nidoking = new Nidoking(getApelido());
        System.out.println(getApelido() + " evoluiu para " + nidoking.getEspecie() + "!");
        return nidoking;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Nidorino!'");
    }

}
