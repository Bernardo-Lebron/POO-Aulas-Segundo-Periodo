package br.com.cefetmg.batalhapokemon.model.eletrico;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Luxio extends Shinx {

    public Luxio(String apelido) {
        super(apelido);
        setEspecie("Luxio");
        setNivelEvolucao(2);
        setVidaMaxima(300);
        setVida(300);
        setAtaque(110);
        setDefesa(65);

        getAtaques().clear();
        adicionarAtaque(new Ataque("Raio X", 55, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Investida", 35, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        if (getNivelEvolucao() == 3) {
            System.out.println(getApelido() + " já está em seu nível máximo!");
            return this;
        }
        return new Luxray(getApelido());
    }

    @Override
    public void realizarSom() {
        System.out.println(getApelido() + ": 'LUXIO!'");
    }

}
