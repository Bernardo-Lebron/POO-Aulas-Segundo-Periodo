#ifndef PROFESSOR_H
#define PROFESSOR_H

#include "pessoa.h"
#include <iostream>

class Professor : public Pessoa {
    private:
        double salario;

    public:
        Professor(std::string nome, int idade, double salario)
            : Pessoa(nome, idade)
        {
            if (salario < 0) throw DadoInvalidoException("Salário negativo");
            this->salario = salario;
        }

        void exibir() const override {
            std::cout << "[Professor] Nome: " << nome
                    << " | Idade: " << idade
                    << " | Salário: " << salario << "\n";
        }
};

#endif
