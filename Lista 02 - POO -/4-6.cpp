#include <iostream>
#include <stack>
#include <string>

bool ehPalindromo(const std::string& s) {
    std::stack<char> pilha;

    for (char c : s)
        pilha.push(c);

    for (char c : s) {
        if (c != pilha.top())
            return false;
        pilha.pop();
    }
    return true;
}

int main() {
    std::string palavra = "arara";
    std::cout << (ehPalindromo(palavra) ? "Palindromo" : "Não é") << "\n";
}
