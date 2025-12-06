package br.com.cefetmg.batalhapokemon.model.fantasma;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Lampent extends Litwick {

    public Lampent(String apelido) {
        super(apelido);
        setEspecie("Lampent");
        setNivelEvolucao(2);
        setVidaMaxima(300);
        setVida(300);
        setAtaque(80);
        setDefesa(60);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Chama Sombria", 70, Tipo.FANTASMA));
        adicionarAtaque(new Ataque("Luz Fantasma", 60, Tipo.FANTASMA));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println("\nO QUE? " + getApelido() + " ESTÁ EVOLUINDO! ");
        Gengar gengar = new Gengar(getApelido());
        System.out.println(getApelido() + " evoluiu para " + gengar.getEspecie() + "!");
        return gengar;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Lampent!'");
    }
    
}
