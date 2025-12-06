package br.com.cefetmg.batalhapokemon.model.fogo;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Typhlosion extends Quilava {

    public Typhlosion(String apelido) {
        super(apelido);
        setEspecie("Typhlosion");
        setNivelEvolucao(3);
        setVidaMaxima(350);
        setVida(350);
        setAtaque(125);
        setDefesa(90);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Erupção", 85, Tipo.FOGO));
        adicionarAtaque(new Ataque("Explosão de Fogo Máxima", 110, Tipo.FOGO));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println(getApelido() + " já está em seu nível máximo!");
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Typhlosion!'");
    }
 
}
