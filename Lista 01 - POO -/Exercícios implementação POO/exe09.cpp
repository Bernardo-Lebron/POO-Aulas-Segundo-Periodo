#include <iostream>
#include <string>
#include <vector>
#include <ctime>
using namespace std;


class Livro {
private:
    string isbn;
    string titulo;
    string autor;
    bool disponivel;

public:
    Livro(string i, string t, string a) {
        isbn = i;
        titulo = t;
        autor = a;
        disponivel = true;
    }

    bool isDisponivel() { return disponivel; }

    void emprestar() { disponivel = false; }
    void devolver() { disponivel = true; }

    string getTitulo() { return titulo; }
    string getAutor() { return autor; }
    string getISBN() { return isbn; }
};


class Usuario {
private:
    string nome;
    string matricula;
    vector<Livro*> livrosEmprestados;

public:
    Usuario(string n, string m) {
        nome = n;
        matricula = m;
    }

    void adicionarLivro(Livro* livro) {
        livrosEmprestados.push_back(livro);
    }

    void removerLivro(Livro* livro) {
        for (auto it = livrosEmprestados.begin(); it != livrosEmprestados.end(); ++it) {
            if (*it == livro) {
                livrosEmprestados.erase(it);
                break;
            }
        }
    }

    void listarLivros() {
        cout << "Livros emprestados por " << nome << ":" << endl;
        if (livrosEmprestados.empty()) {
            cout << "Nenhum livro emprestado." << endl;
        } else {
            for (Livro* l : livrosEmprestados) {
                cout << "- " << l->getTitulo() << " (" << l->getAutor() << ")" << endl;
            }
        }
    }

    string getNome() { return nome; }
    string getMatricula() { return matricula; }
};


class Emprestimo {
private:
    Livro* livro;
    Usuario* usuario;
    time_t dataEmprestimo;
    time_t dataDevolucao;

public:
    Emprestimo(Livro* l, Usuario* u) {
        livro = l;
        usuario = u;
        dataEmprestimo = time(0);
        dataDevolucao = 0;

        if (livro->isDisponivel()) {
            livro->emprestar();
            usuario->adicionarLivro(livro);
            cout << " Livro '" << livro->getTitulo() << "' emprestado para " << usuario->getNome() << "." << endl;
        } else {
            cout << " Livro '" << livro->getTitulo() << "' nao esta disponivel!" << endl;
        }
    }

    void devolver() {
        if (dataDevolucao != 0) {
            cout << "  Este livro já foi devolvido!" << endl;
            return;
        }
        dataDevolucao = time(0);
        livro->devolver();
        usuario->removerLivro(livro);

        cout << " Livro '" << livro->getTitulo() << "' devolvido por " << usuario->getNome() << "." << endl;
    }

    void mostrarInfo() {
        cout << "Livro: " << livro->getTitulo() << " | Usuario: " << usuario->getNome() << endl;
        cout << "Data do emprestimo: " << ctime(&dataEmprestimo);
        if (dataDevolucao != 0)
            cout << "Data da devolucao: " << ctime(&dataDevolucao);
        else
            cout << "Ainda nao devolvido." << endl;
    }
};


int main() {
    
    Livro livro1("001", "O Cortico", "Aluisio Azevedo");
    Livro livro2("002", "Dom Casmurro", "Machado de Assis");
    Livro livro3("003", "Vidas Secas", "Graciliano Ramos");

    
    Usuario usuario1("Bernardo", "131313");
    Usuario usuario2("Rafaela", "012345");

    
    Emprestimo emp1(&livro1, &usuario1);
    Emprestimo emp2(&livro2, &usuario2);
    Emprestimo emp3(&livro1, &usuario2); 

    cout << endl;
    usuario1.listarLivros();
    usuario2.listarLivros();

    cout << endl;
    emp1.mostrarInfo();

    cout << "\n--- Devolucao ---\n";
    emp1.devolver();

    cout << endl;
    usuario1.listarLivros();

    cout << endl;
    emp1.mostrarInfo();

    return 0;
}
