package br.com.pagamentos.pagamentos.acoes;

import br.com.pagamentos.pagamentos.modelo.DetalhesPagamento;
import br.com.pagamentos.pagamentos.modelo.DetalhesTransferenciaBancaria;

import java.util.Scanner;

/**
 * @brief Implementacao de DetalhesPagamentoFactory para Transferencia Bancaria.
 * Coleta os detalhes especificos de um pagamento com Transferencia Bancaria do usuario.
 */
public class DetalhesTransferenciaBancariaPagamentoFactory implements DetalhesPagamentoFactory {
    @Override
    public DetalhesPagamento criar(Scanner scanner) throws IllegalArgumentException {
        System.out.print("Digite o nome do banco: ");
        String nomeBanco = scanner.nextLine();
        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.print("Digite o nome do beneficiário: ");
        String nomeBeneficiario = scanner.nextLine();
        System.out.print("Digite o valor: ");
        double valor = Double.parseDouble(scanner.nextLine());

        // O construtor de DetalhesTransferenciaBancaria valida os dados
        return new DetalhesTransferenciaBancaria(nomeBanco, numeroConta, nomeBeneficiario, valor);
    }
}
