#include <iostream>
#include <string>
#include <vector>
using namespace std;

class ContaCorrente {
private:
    string titular;
    double saldo;
    int saquesHoje;
    vector<string> historico;

public:
    ContaCorrente(string t, double saldoInicial) {
        titular = t;
        saldo = saldoInicial;
        saquesHoje = 0;
        historico.push_back("Conta criada com saldo inicial de R$" + to_string(saldoInicial));
    }

    double getSaldo() { return saldo; }

    void depositar(double valor) {
        saldo += valor;
        historico.push_back("Deposito: +R$" + to_string(valor));
    }

    void sacar(double valor) {
        if (valor > saldo) {
            cout << "Erro: Saldo insuficiente!" << endl;
        } else if (saquesHoje >= 3) {
            cout << "Erro: Limite de 3 saques diarios atingido!" << endl;
        } else {
            saldo -= valor;
            saquesHoje++;
            historico.push_back("Saque: -R$" + to_string(valor));
        }
    }

    void imprimirHistorico() {
        cout << "Historico da conta de " << titular << ":" << endl;
        for (string transacao : historico) {
            cout << transacao << endl;
        }
    }
};

int main() {
    ContaCorrente conta("Bernardo", 1000.0);
    conta.depositar(200);
    conta.sacar(300);
    conta.sacar(400);
    conta.sacar(100);
    conta.sacar(50);
    conta.imprimirHistorico();
    return 0;
}
