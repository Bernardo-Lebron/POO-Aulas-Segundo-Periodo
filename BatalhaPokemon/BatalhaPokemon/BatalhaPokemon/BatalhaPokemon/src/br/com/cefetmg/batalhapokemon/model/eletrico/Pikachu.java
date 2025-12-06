package br.com.cefetmg.batalhapokemon.model.eletrico;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Pikachu extends Pichu {

    public Pikachu(String apelido) {
        super(apelido);
        setEspecie("Pikachu");
        setNivelEvolucao(2);
        setVidaMaxima(250);
        setVida(250);
        setAtaque(90);
        setDefesa(55);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Choque do Trovão", 40, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Investida", 30, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        if (getNivelEvolucao() == 3) {
            System.out.println(getApelido() + " já está em seu nível máximo!");
            return this;
        }
        return new Raichu(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Pika Pika!'");
    }

}
