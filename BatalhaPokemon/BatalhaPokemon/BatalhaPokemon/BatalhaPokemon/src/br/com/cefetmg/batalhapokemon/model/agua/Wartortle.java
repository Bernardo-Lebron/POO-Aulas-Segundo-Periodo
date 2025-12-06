package br.com.cefetmg.batalhapokemon.model.agua;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Wartortle extends Squirtle {

    public Wartortle(String apelido) {
        super(apelido); 
        setEspecie("Wartortle"); 
        setNivelEvolucao(2);    
        setVidaMaxima(300);
        setVida(300);         
        setAtaque(80);
        setDefesa(85);
        
        getAtaques().clear();
        adicionarAtaque(new Ataque("Jato de Água", 35, Tipo.AGUA));
        adicionarAtaque(new Ataque("Tiro de Bolha", 30, Tipo.AGUA));
    }

    @Override
    public Pokemon evoluir() {
        if (getNivelEvolucao() == 3) {
            System.out.println(getApelido() + " já está em seu nível máximo!");
            return this;
        }
        return new Blastoise(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Wartortle!'");
    }
}