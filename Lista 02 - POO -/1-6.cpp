#include <iostream>
#include <string>
#include <memory>
#include <vector>

using namespace std;


class Material {
protected:
    string titulo;
    int ano;
    int id;

public:
    Material(string t, int a, int i)
        : titulo(t), ano(a), id(i) {}

    virtual void mostrar() const = 0; 

    virtual ~Material() = default;
};


class Livro : public Material {
public:
    Livro(string t, int a, int i)
        : Material(t, a, i) {}

    void mostrar() const override {
        cout << "\nLivro\nTitulo: " << titulo
             << "\nAno: " << ano
             << "\nID: " << id << "\n";
    }
};


class DVD : public Material {
public:
    DVD(string t, int a, int i)
        : Material(t, a, i) {}

    void mostrar() const override {
        cout << "\nDVD\nTitulo: " << titulo
             << "\nAno: " << ano
             << "\nID: " << id << "\n";
    }
};


class AudioLivro : public Material {
public:
    AudioLivro(string t, int a, int i)
        : Material(t, a, i) {}

    void mostrar() const override {
        cout << "\nAudioLivro\nTitulo: " << titulo
             << "\nAno: " << ano
             << "\nID: " << id << "\n";
    }
};


int main() {

    vector<shared_ptr<Material>> biblioteca;

    biblioteca.push_back(make_shared<Livro>("Dom Casmurro", 1899, 1));
    biblioteca.push_back(make_shared<DVD>("Ainda estou aqui", 2024, 2));
    biblioteca.push_back(make_shared<AudioLivro>("1984", 1949, 3));

    for (auto &m : biblioteca) {
        m->mostrar(); 
    }

    return 0;
}