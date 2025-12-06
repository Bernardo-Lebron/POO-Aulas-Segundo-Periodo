package br.com.cefetmg.batalhapokemon.model.veneno;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Nidoking extends Nidorino {

    public Nidoking(String apelido) {
        super(apelido);
        setEspecie("Nidoking");
        setNivelEvolucao(3);
        setVidaMaxima(435);
        setVida(435);
        setAtaque(102);
        setDefesa(77);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Chicote de Veneno Forte", 85, Tipo.VENENO));
        adicionarAtaque(new Ataque("Investida Venenosa Forte", 90, Tipo.VENENO));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println(getApelido() + " já está em seu nível máximo!");
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Nidoking!'");
    }

}
