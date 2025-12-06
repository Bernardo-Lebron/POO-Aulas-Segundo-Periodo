package br.com.cefetmg.batalhapokemon.model.eletrico;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;  
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Raichu extends Pikachu {

    public Raichu(String apelido) {
        super(apelido);
        setEspecie("Raichu");
        setNivelEvolucao(3);
        setVidaMaxima(320);
        setVida(320);
        setAtaque(110);
        setDefesa(75);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Trovão", 60, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Cauda de Ferro", 50, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println(getApelido() + " já está em seu nível máximo!");
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Raichu!'");
    }
    
}
