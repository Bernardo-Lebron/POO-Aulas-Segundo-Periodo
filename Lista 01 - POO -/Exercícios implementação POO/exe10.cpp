#include <iostream>
#include <cmath>
using namespace std;

class Matematica {
public:
    double calcularArea(double lado) {
        return lado * lado;
    }

    double calcularArea(double base, double altura) {
        return base * altura;
    }

    double calcularAreaCirculo(double raio) {
        return M_PI * raio * raio;
    }

    double calcularAreaTriangulo(double base, double altura) {
        return (base * altura) / 2.0;
    }
};

int main() {
    Matematica m;
    cout << "Area quadrado: " << m.calcularArea(4) << endl;
    cout << "Area retangulo: " << m.calcularArea(5, 3) << endl;
    cout << "Area circulo: " << m.calcularAreaCirculo(2) << endl;
    cout << "Area triangulo: " << m.calcularAreaTriangulo(6, 4) << endl;
    return 0;
}
