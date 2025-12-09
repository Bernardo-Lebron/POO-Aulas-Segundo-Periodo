#include <iostream>
#include <string>
using namespace std;

class Pessoa {
private:
    string nome;
    int idade;
    string cpf;

public:
    Pessoa() {}

    Pessoa(string n, int i, string c) {
        nome = n;
        idade = i;
        cpf = c;
    }

    void setNome(string n) { nome = n; }
    string getNome() { return nome; }

    void setIdade(int i) { idade = i; }
    int getIdade() { return idade; }

    void setCpf(string c) { cpf = c; }
    string getCpf() { return cpf; }

    void imprimirDados() {
        cout << "Nome: " << nome << endl;
        cout << "Idade: " << idade << endl;
        cout << "CPF: " << cpf << endl;
    }
};

int main() {
    Pessoa p1("Bernardo", 21, "000.000.000-00");
    p1.imprimirDados();
    return 0;
}
