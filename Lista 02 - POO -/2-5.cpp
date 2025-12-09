#include <iostream>
#include <string>
using namespace std;

class Pessoa {

private:
    int idade;
    string nome;
    float altura;
    float peso;
    string cor_cabelo;

public:

    Pessoa()
        : idade(0), nome(""), altura(0), peso(0), cor_cabelo("") {}

    Pessoa(int idade)
        : idade(idade), nome(""), altura(0), peso(0), cor_cabelo("") {}

    Pessoa(string nome)
        : idade(0), nome(nome), altura(0), peso(0), cor_cabelo("") {}

    Pessoa(float altura)
        : idade(0), nome(""), altura(altura), peso(0), cor_cabelo("") {}

    Pessoa(double peso)
        : idade(0), nome(""), altura(0), peso(peso), cor_cabelo("") {}

    Pessoa(string cor, bool ehCorDeCabelo)
        : idade(0), nome(""), altura(0), peso(0), cor_cabelo(ehCorDeCabelo ? cor : "") {}

    Pessoa(string nome, int idade, float altura, float peso, string cor_cabelo)
        : idade(idade), nome(nome), altura(altura), peso(peso), cor_cabelo(cor_cabelo) {}

    void exibir() const {
        cout << "Nome: " << nome << endl;
        cout << "Idade: " << idade << endl;
        cout << "Altura: " << altura << endl;
        cout << "Peso: " << peso << endl;
        cout << "Cor do cabelo: " << cor_cabelo << endl;
    }
};

int main() {

    Pessoa p1;                     
    Pessoa p2(21);                 
    Pessoa p3("Bernardo");              
    Pessoa p4(1.75);              
    Pessoa p5(68.0);               
    Pessoa p6("Loiro", true);      
    Pessoa p7("Rafaela", 21, 1.62, 51, "Castanho"); 

    p7.exibir();
}
