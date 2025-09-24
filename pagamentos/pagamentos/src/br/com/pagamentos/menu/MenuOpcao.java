package br.com.pagamentos.menu;

/**
 * @brief Interface Componente do Padrao Composite.
 * Define o contrato comum para todos os elementos que podem ser adicionados a um menu.
 * Adere ao Principio da Inversao de Dependencia (DIP) e facilita o Polimorfismo.
 */
public interface MenuOpcao {
    String getTitulo();
    void executar();
}
