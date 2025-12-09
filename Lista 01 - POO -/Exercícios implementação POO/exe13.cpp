#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Pessoa {
protected:
    string nome;
public:
    Pessoa(string n) : nome(n) {}
    string getNome() { return nome; }
};

class Aluno : public Pessoa {
private:
    double nota1, nota2;
public:
    Aluno(string n, double n1, double n2) : Pessoa(n), nota1(n1), nota2(n2) {}
    double calcularMedia() { return (nota1 + nota2) / 2.0; }
};

class Professor : public Pessoa {
private:
    string disciplina;
public:
    Professor(string n, string d) : Pessoa(n), disciplina(d) {}
    void ministrarAula() { cout << "Professor " << nome << " ministra " << disciplina << "." << endl; }
};

class Disciplina {
private:
    string nome;
    Professor* professor;
    vector<Aluno*> alunos;
public:
    Disciplina(string n, Professor* p) : nome(n), professor(p) {}

    void adicionarAluno(Aluno* a) { alunos.push_back(a); }

    void listarAlunos() {
        cout << "\nAlunos da disciplina " << nome << ":" << endl;
        for (Aluno* a : alunos)
            cout << "- " << a->getNome() << " | Media: " << a->calcularMedia() << endl;
    }

    void mostrarProfessor() {
        cout << "Professor responsavel: " << professor->getNome() << endl;
    }
};

int main() {
    Professor prof("Eduardo", "POO");
    Aluno a1("Bernardo", 8.5, 9.0);
    Aluno a2("Rafaela", 7.0, 6.5);

    Disciplina poo("Programacao Orientada a Objetos", &prof);
    poo.adicionarAluno(&a1);
    poo.adicionarAluno(&a2);

    prof.ministrarAula();
    poo.mostrarProfessor();
    poo.listarAlunos();

    return 0;
}
