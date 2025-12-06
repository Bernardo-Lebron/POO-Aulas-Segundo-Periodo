package br.com.cefetmg.batalhapokemon.model.agua;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Croconaw extends Totodile {

    public Croconaw(String apelido) {
        super(apelido); 
        setEspecie("Croconaw"); 
        setNivelEvolucao(2);   
        setVidaMaxima(290);  
        setVida(290);            
        setAtaque(75);
        setDefesa(70);
        
        getAtaques().clear();
        adicionarAtaque(new Ataque("Mordida", 35, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Água Jato", 30, Tipo.AGUA));
    }

    @Override
    public Pokemon evoluir() {
        if (getNivelEvolucao() == 3) {
            System.out.println(getApelido() + " já está em seu nível máximo!");
            return this;
        }
        return new Feraligatr(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Croconaw!'");
    }
}
