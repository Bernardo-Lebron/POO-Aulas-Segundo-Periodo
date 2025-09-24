package br.com.pagamentos.pagamentos.acoes;

import br.com.pagamentos.pagamentos.modelo.DetalhesCartaoCredito;
import br.com.pagamentos.pagamentos.modelo.DetalhesPagamento;

import java.util.Scanner;

/**
 * @brief Implementacao de DetalhesPagamentoFactory para Cartao de Credito.
 * Coleta os detalhes especificos de um pagamento com cartao de credito do usuario.
 */
public class DetalhesCartaoCreditoPagamentoFactory implements DetalhesPagamentoFactory {
    @Override
    public DetalhesPagamento criar(Scanner scanner) throws IllegalArgumentException {
        System.out.print("Digite o número do cartão (16 dígitos): ");
        String numeroCartao = scanner.nextLine();
        System.out.print("Digite o nome do titular: ");
        String nomeTitularCartao = scanner.nextLine();
        System.out.print("Digite a data de expiração (MM/AA): ");
        String dataVencimento = scanner.nextLine();
        System.out.print("Digite o CVV (3 dígitos): ");
        String cvv = scanner.nextLine();
        System.out.print("Digite o valor: ");
        // Lanca NumberFormatException se não for numero
        double valor = Double.parseDouble(scanner.nextLine());

        // O construtor de DetalhesCartaoCredito valida os dados
        return new DetalhesCartaoCredito(numeroCartao, nomeTitularCartao, dataVencimento, cvv, valor);
    }
}
