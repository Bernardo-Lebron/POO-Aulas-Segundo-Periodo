#ifndef FUNCIONARIO_H
#define FUNCIONARIO_H

#include "pessoa.h"
#include <iostream>

class Funcionario : public Pessoa {
    private:
        std::string cargo;

    public:
        Funcionario(std::string nome, int idade, std::string cargo)
            : Pessoa(nome, idade)
        {
            if (cargo.empty()) throw DadoInvalidoException("Cargo vazio");
            this->cargo = cargo;
        }

        void exibir() const override {
            std::cout << "[Funcionário] Nome: " << nome
                    << " | Idade: " << idade
                    << " | Cargo: " << cargo << "\n";
        }
};

#endif
