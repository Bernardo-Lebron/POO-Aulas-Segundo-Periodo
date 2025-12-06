package br.com.cefetmg.batalhapokemon.model.fantasma;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Gengar extends Haunter {

    public Gengar(String apelido) {
        super(apelido);
        setEspecie("Gengar");
        setNivelEvolucao(3);
        setVidaMaxima(350);
        setVida(350);
        setAtaque(110);
        setDefesa(75);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Explosão Sombria", 100, Tipo.FANTASMA));
        adicionarAtaque(new Ataque("Chicote de Sombras", 80, Tipo.FANTASMA));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println(getApelido() + " já está em seu nível máximo!");
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Gengar!'");
    }
}
