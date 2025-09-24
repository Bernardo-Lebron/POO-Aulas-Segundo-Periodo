package br.com.pagamentos.menu;

import java.util.Objects;

/**
 * @brief Classe Folha do Padrao Composite.
 * Representa uma opcao de menu individual que executa uma acao.
 * Encapsula a acao como um Runnable (Padrao Command).
 * Segue o Principio da Responsabilidade Unica (SRP) ao ter a responsabilidade de executar uma acao especifica.
 */
public class MenuItem implements MenuOpcao {
    private final String titulo;
    private final Runnable acao;

    /**
     * @brief Construtor para MenuItem.
     * @param titulo O titulo da opcao de menu.
     * @param acao A acao a ser executada quando esta opcao for selecionada.
     * @throws NullPointerException se o titulo ou a acao forem nulos.
     */
    public MenuItem(String titulo, Runnable acao) {
        this.titulo = Objects.requireNonNull(titulo, "O titulo do menu nao pode ser nulo");
        this.acao = Objects.requireNonNull(acao, "A acao do menu nao pode ser nula");
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public void executar() {
        this.acao.run();
    }
}