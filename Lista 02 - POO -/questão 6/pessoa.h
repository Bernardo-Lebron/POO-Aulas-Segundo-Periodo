#ifndef PESSOA_H
#define PESSOA_H

#include <string>
#include "excecoes.h"

class Pessoa {
    protected:
        std::string nome;
        int idade;

    public:
        Pessoa(std::string nome, int idade) {
            if (nome.empty()) throw DadoInvalidoException("Nome vazio");
            if (idade < 0) throw DadoInvalidoException("Idade negativa");

            this->nome = nome;
            this->idade = idade;
        }

        virtual ~Pessoa() {} 
        virtual void exibir() const = 0;
};

#endif
