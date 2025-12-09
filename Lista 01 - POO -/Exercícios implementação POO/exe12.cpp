#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Animal {
protected:
    string nome;
public:
    Animal(string n) : nome(n) {}
    virtual void fazerSom() { cout << nome << " faz um som genérico." << endl; }
    virtual void mover() { cout << nome << " está se movendo." << endl; }
};

class Cachorro : public Animal {
public:
    Cachorro(string n) : Animal(n) {}
    void fazerSom() override { cout << nome << " late: Au au!" << endl; }
    void mover() override { cout << nome << " corre feliz." << endl; }
};

class Gato : public Animal {
public:
    Gato(string n) : Animal(n) {}
    void fazerSom() override { cout << nome << " mia: Miau!" << endl; }
    void mover() override { cout << nome << " anda silenciosamente." << endl; }
};

class Passaro : public Animal {
public:
    Passaro(string n) : Animal(n) {}
    void fazerSom() override { cout << nome << " canta: Piu piu!" << endl; }
    void mover() override { cout << nome << " voa alto." << endl; }
};

int main() {
    vector<Animal*> animais;

    animais.push_back(new Cachorro("Nick"));
    animais.push_back(new Gato("Ninita"));
    animais.push_back(new Passaro("Dexter"));

    for (Animal* a : animais) {
        a->fazerSom();
        a->mover();
        cout << endl;
    }

    return 0;
}
