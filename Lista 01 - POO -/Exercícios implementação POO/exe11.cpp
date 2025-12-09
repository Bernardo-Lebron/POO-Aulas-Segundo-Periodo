#include <iostream>
#include <string>
using namespace std;

class Animal {
protected:
    string nome;
    int idade;

public:
    Animal(string n, int i) : nome(n), idade(i) {}

    virtual void fazerSom() {
        cout << nome << " faz um som genérico." << endl;
    }
};

class Cachorro : public Animal {
private:
    string raca;

public:
    Cachorro(string n, int i, string r) : Animal(n, i), raca(r) {}

    void fazerSom() override {
        cout << nome << " (Cachorro) late: Au au!" << endl;
    }
};

class Gato : public Animal {
private:
    string corPelo;

public:
    Gato(string n, int i, string c) : Animal(n, i), corPelo(c) {}

    void fazerSom() override {
        cout << nome << " (Gato) mia: Miau!" << endl;
    }
};

class Passaro : public Animal {
private:
    double envergaduraAsa;

public:
    Passaro(string n, int i, double e) : Animal(n, i), envergaduraAsa(e) {}

    void fazerSom() override {
        cout << nome << " (Passaro) canta: Piu piu!" << endl;
    }
};

int main() {
    Cachorro c("Nick", 4, "Labrador");
    Gato g("Ninita", 3, "Branco");
    Passaro p("Dexter", 2, 0.25);

    c.fazerSom();
    g.fazerSom();
    p.fazerSom();

    return 0;
}
