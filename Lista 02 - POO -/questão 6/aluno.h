#ifndef ALUNO_H
#define ALUNO_H

#include "pessoa.h"
#include <iostream>

class Aluno : public Pessoa {
    private:
        double nota;

    public:
        Aluno(std::string nome, int idade, double nota)
            : Pessoa(nome, idade)
        {
            if (nota < 0 || nota > 10)
                throw DadoInvalidoException("Nota fora do intervalo 0-10");
            this->nota = nota;
        }

        void exibir() const override {
            std::cout << "[Aluno] Nome: " << nome
                    << " | Idade: " << idade
                    << " | Nota: " << nota << "\n";
        }
};

#endif
