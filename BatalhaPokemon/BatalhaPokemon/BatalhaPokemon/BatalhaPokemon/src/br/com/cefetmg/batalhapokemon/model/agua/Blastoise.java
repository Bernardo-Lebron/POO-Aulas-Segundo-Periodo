package br.com.cefetmg.batalhapokemon.model.agua;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Blastoise extends Wartortle {

    public Blastoise(String apelido) {
        super(apelido);
        setEspecie("Blastoise");
        setNivelEvolucao(3);
        setVidaMaxima(360);
        setVida(360);
        setAtaque(100);
        setDefesa(100);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Canhão de Água", 50, Tipo.AGUA));
        adicionarAtaque(new Ataque("Hidro Bomba", 60, Tipo.AGUA));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println(getApelido() + " já está em seu nível máximo!");
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Blastoise!'");
    }
}