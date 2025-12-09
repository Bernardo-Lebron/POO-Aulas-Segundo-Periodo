#ifndef EXCECOES_H
#define EXCECOES_H

#include <stdexcept>
#include <string>

class DadoInvalidoException : public std::runtime_error {
    public:
        DadoInvalidoException(const std::string& msg)
            : std::runtime_error("Dado inválido: " + msg) {}
};

#endif
