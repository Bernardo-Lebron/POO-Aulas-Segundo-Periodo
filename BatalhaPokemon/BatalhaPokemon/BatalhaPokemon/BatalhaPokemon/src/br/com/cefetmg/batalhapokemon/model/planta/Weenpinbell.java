package br.com.cefetmg.batalhapokemon.model.planta;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Weenpinbell extends Bellsprout {

    public Weenpinbell(String apelido) {
        super(apelido);
        setEspecie("Weenpinbell");
        setNivelEvolucao(2);
        setVidaMaxima(350);
        setVida(350);
        setAtaque(110);
        setDefesa(90);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Lança de Espinhos", 75, Tipo.PLANTA));
        adicionarAtaque(new Ataque("Vinha Cortante", 65, Tipo.PLANTA));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println("\nO QUE? " + getApelido() + " ESTÁ EVOLUINDO! ");
        Victreebel victreebel = new Victreebel(getApelido());
        System.out.println(getApelido() + " evoluiu para " + victreebel.getEspecie() + "!");
        return victreebel;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Weenpinbell!'");
    }

}
