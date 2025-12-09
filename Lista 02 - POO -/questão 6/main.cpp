#include <iostream>
#include <vector>
#include <memory>

#include "professor.h"
#include "aluno.h"
#include "funcionario.h"

int main() {
    std::vector<std::unique_ptr<Pessoa>> universidade;

    try {
        universidade.push_back(std::make_unique<Professor>("Carlos", 45, 8500));
        universidade.push_back(std::make_unique<Aluno>("Ana", 19, 9.2));
        universidade.push_back(std::make_unique<Funcionario>("Marcos", 35, "Secretário"));

    }
    catch (const DadoInvalidoException& e) {
        std::cout << "Erro ao criar objeto: " << e.what() << "\n";
    }

    std::cout << "\n=== Pessoas cadastradas ===\n";
    for (const auto& p : universidade) {
        p->exibir();
    }

    return 0;
}
