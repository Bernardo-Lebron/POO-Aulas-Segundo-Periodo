package br.com.cefetmg.batalhapokemon.model;

import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon {
    // Atributos fixos
    private String apelido;
    protected String especie;
    protected Tipo tipo;
    protected int nivelEvolucao; // 1 (Base), 2, 3 (Max)

    // Status dinâmicos
    protected double vida;
    protected double vidaMaxima;
    protected double ataque;
    protected double defesa;
    protected double velocidade;

    // Lógica do Trabalho
    protected int experiencia = 0;
    protected int pocoes = 0; // Começa com 0
    protected int contadorAtaquesBemSucedidos = 0;

    private List<Ataque> ataques = new ArrayList<>();

    public Pokemon(String apelido, String especie, Tipo tipo, int nivelEvolucao, double vidaMaxima, double ataque, double defesa, double velocidade) {
        this.apelido = apelido;
        this.especie = especie;
        this.tipo = tipo;
        this.nivelEvolucao = nivelEvolucao;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.ataque = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
    }

    // --- Lógica de Batalha ---

    public void atacar(Pokemon oponente, Ataque golpe) {
        System.out.printf(" %s usou %s!%n", this.apelido, golpe.nome());

        double multiplicador = Tipo.obterMultiplicador(golpe.tipo(), oponente.getTipo());

        // Feedback visual e Cálculo de XP
        int xpGanho = 20; // XP Neutro padrão
        if (multiplicador > 1.0) {
            System.out.println("Foi super efetivo!");
            xpGanho = 30;
        } else if (multiplicador < 1.0 && multiplicador > 0) {
            System.out.println("Não foi muito efetivo...");
            xpGanho = 10;
        } else if (multiplicador == 0.0) { // Adicionando feedback para Imune
            System.out.println("Não teve efeito!");
            xpGanho = 5;
        } else {
            System.out.println("Dano normal.");
        }
        
        // --- CÁLCULO DE DANO CORRIGIDO ---
        // Fórmula: (Atk * Poder / 20) * Multiplicador - (Def / 3) 
        double danoBase = (this.ataque * (double) golpe.poder() / 20);
        
        // Aplica o multiplicador ao dano base antes de descontar a defesa
        double danoComMultiplicador = danoBase * multiplicador; 

        // Desconta a defesa, garantindo que o dano mínimo seja 1 (a menos que seja imune)
        double danoReal;
        if (multiplicador == 0.0) {
            danoReal = 0.0;
        } else {
            danoReal = Math.max(1, danoComMultiplicador - (oponente.getDefesa() / 3));
        }

        oponente.receberDano(danoReal);

        // Lógica de Recompensa (Poção e XP)
        this.contadorAtaquesBemSucedidos++;
        if (this.contadorAtaquesBemSucedidos % 2 == 0) {
            this.pocoes++;
            System.out.println("" + this.apelido + " ganhou uma Poção de Cura por bons ataques!");
        }

        ganharExperiencia(xpGanho);
    }

    
    public void receberDano(double dano) {
        this.vida -= dano;
        System.out.printf("%s recebeu %.1f de dano. (VIDA: %.1f/%.1f)%n", this.apelido, dano, Math.max(0, this.vida), this.vidaMaxima);
    }

    public boolean usarPocao() {
        if (this.pocoes > 0) {
            this.pocoes--;
            double cura = 20.0;
            this.vida += cura;
            if (this.vida > this.vidaMaxima) this.vida = this.vidaMaxima;
            System.out.printf(" %s usou uma poção! Recuperou %.1f VIDA. (Restam %d poções)%n", this.apelido, cura, this.pocoes);
            return true;
        } else {
            System.out.println("Você não tem poções!");
            return false;
        }
    }

    // --- Lógica de Evolução ---

    private void ganharExperiencia(int xp) {
        this.experiencia += xp;
        System.out.printf("%s ganhou %d XP. (Total: %d/50)%n", this.apelido, xp, this.experiencia);
    }

    /**
     * Verifica se deve evoluir. Se sim, retorna a NOVA instância.
     * Se não, retorna 'this' (a própria instância atual).
     */
    public Pokemon tentarEvoluir() {
        if (this.experiencia >= 50 && this.nivelEvolucao < 3) {
            System.out.println("\nO QUE? " + this.apelido + " ESTÁ EVOLUINDO! ");
            Pokemon evoluido = evoluir(); // Método abstrato implementado pelos filhos

            // Transfere o estado importante
            evoluido.pocoes = this.pocoes;
            // Reseta XP ou transfere excedente (opcional, aqui reseta para o novo nível)
            evoluido.experiencia = 0;

            // Mantém a porcentagem de vida atual ou cura? Vamos curar na evolução (bônus)
            System.out.println(" " + this.apelido + " se tornou um " + evoluido.especie + "!\n");
            return evoluido;
        }
        return this;
    }

    // Métodos abstratos e auxiliares
    public abstract Pokemon evoluir();
    public abstract void realizarSom();

    public void adicionarAtaque(Ataque a) { ataques.add(a); }

    // Getters
    public boolean estaVivo() { return vida > 0; }
    public double getVelocidade() { return velocidade; }
    public String getApelido() { return apelido; }
    public String getEspecie() { return especie; }
    public List<Ataque> getAtaques() { return ataques; }
    public double getDefesa() { return defesa; }
    public Tipo getTipo() { return tipo; }
    public int getNivelEvolucao() { return nivelEvolucao; }
    public int getPocoes() { return pocoes; }
    public double getVida() { return vida; }
    public double getVidaMaxima() { return this.vidaMaxima; }
    public void setVidaMaxima(double vidaMaxima) { 
        this.vidaMaxima = vidaMaxima; 
    }
    public void setEspecie(String especie) { 
        this.especie = especie; 
    }

    public void setNivelEvolucao(int nivelEvolucao) { 
        this.nivelEvolucao = nivelEvolucao; 
    }

    public void setVida(double vida) { 
        this.vida = vida; 
    }

    public void setAtaque(double ataque) { 
        this.ataque = ataque; 
    }

    public void setDefesa(double defesa) { 
        this.defesa = defesa; 
    }


    // Construtor protegido para cópia de dados na evolução
    protected void copiarDados(Pokemon antigo) {
        this.pocoes = antigo.pocoes;
        // Vida enche na evolução
    }

    @Override
    public String toString() {
        return "Pokemon: " + apelido + " (" + especie + ") | VIDA: " + vida + "/" + vidaMaxima;
    }

}