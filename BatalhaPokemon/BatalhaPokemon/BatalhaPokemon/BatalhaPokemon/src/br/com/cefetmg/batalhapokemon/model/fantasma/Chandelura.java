package br.com.cefetmg.batalhapokemon.model.fantasma;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Chandelura extends Lampent {

    public Chandelura(String apelido) {
        super(apelido);
        setEspecie("Chandelura");
        setNivelEvolucao(3);
        setVidaMaxima(400);
        setVida(400);
        setAtaque(100);
        setDefesa(80);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Inferno Fantasma", 90, Tipo.FANTASMA));
        adicionarAtaque(new Ataque("Luz Sombria", 80, Tipo.FANTASMA));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println(getApelido() + " já está em seu nível máximo!");
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Chandelura!'");
    }
}
