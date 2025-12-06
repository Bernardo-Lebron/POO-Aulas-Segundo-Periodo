package br.com.cefetmg.batalhapokemon.model.veneno;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Beedrill extends Kakuna {

    public Beedrill(String apelido) {
        super(apelido);
        setEspecie("Beedrill");
        setNivelEvolucao(3);
        setVidaMaxima(290);
        setVida(290);
        setAtaque(90);
        setDefesa(85);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Furacão de Agulhas", 90, Tipo.VENENO));
        adicionarAtaque(new Ataque("Investida Venenosa", 70, Tipo.VENENO));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println(getApelido() + " já está em seu nível máximo!");
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Beedrill!'");
    }

}
