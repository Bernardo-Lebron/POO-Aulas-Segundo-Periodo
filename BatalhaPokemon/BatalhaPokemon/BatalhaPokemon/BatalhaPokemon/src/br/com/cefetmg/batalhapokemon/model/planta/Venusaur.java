package br.com.cefetmg.batalhapokemon.model.planta;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Venusaur extends Ivysaur {

    public Venusaur(String apelido) {
        super(apelido);
        setEspecie("Venusaur");
        setNivelEvolucao(3);
        setVidaMaxima(425);
        setVida(425);
        setAtaque(130);
        setDefesa(100);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Raio Solar", 90, Tipo.PLANTA));
        adicionarAtaque(new Ataque("Folha Navalha", 70, Tipo.PLANTA));
    }

    @Override
    public Pokemon evoluir() {
        System.out.println(getApelido() + " já está em seu nível máximo!");
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'Venusaur!'");
    }

}
