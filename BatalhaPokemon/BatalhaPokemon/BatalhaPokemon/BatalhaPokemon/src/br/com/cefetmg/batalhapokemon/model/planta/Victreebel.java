package br.com.cefetmg.batalhapokemon.model.planta;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Victreebel extends Weenpinbell {

    public Victreebel(String apelido) {
        super(apelido);
        setEspecie("Victreebel");
        setNivelEvolucao(3);
        setVidaMaxima(500);
        setVida(500);
        setAtaque(140);
        setDefesa(110);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Chicote de Vinha", 85, Tipo.PLANTA));
        adicionarAtaque(new Ataque("Lança de Espinhos", 75, Tipo.PLANTA));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println(getApelido() + " já está em seu nível máximo!");
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Victreebel!'");
    }
  
}
