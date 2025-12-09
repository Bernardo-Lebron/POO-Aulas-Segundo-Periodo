#include <iostream>
#include <string>
#include <limits>

using namespace std;

int main() {

    string nome;
    int idade;
    string cpf;

    cout << "\nCADASTRO:\nDigite seu nome: ";
    getline(cin, nome);

    cin.exceptions(ios::failbit | ios::badbit);

    try {

        cout << "\nDigite sua idade: ";
        cin >> idade;

        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        cout << "\nDigite seu CPF: ";
        getline(cin, cpf);

    }
    catch (exception& e) {
        cout << "\nERRO ao ler os dados!\n";
        cout << "Mensagem: " << e.what() << "\n";
        return 1;
    }

    cout << "\nCadastro concluido!\n";
    cout << "Nome: " << nome << "\n";
    cout << "Idade: " << idade << "\n";
    cout << "CPF: " << cpf << "\n";

    return 0;
}