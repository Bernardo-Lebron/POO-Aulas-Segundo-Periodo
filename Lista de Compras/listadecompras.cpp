#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Produto {
private:
    int id;
    string nome;
    string unidade;
    float peso;
    float preco;
    int quantidade;

public:
    Produto(int _id, string _nome, string _unidade, float _peso, float _preco, int _quantidade) {
        id = _id;
        nome = _nome;
        unidade = _unidade;
        peso = _peso;
        preco = _preco;
        quantidade = _quantidade;
    }

    int getId() const { return id; }
    string getNome() const { return nome; }
    float getPreco() const { return preco; }
    int getQuantidade() const { return quantidade; }

    void addQuantidade(int qtd) { quantidade += qtd; }

    bool removerQuantidade(int qtd) {
        if (qtd > quantidade) return false;
        quantidade -= qtd;
        return true;
    }

    void exibir() const {
        cout << "-----------------------------\n";
        cout << "ID: " << id << endl;
        cout << "Nome: " << nome << endl;
        cout << "Unidade: " << unidade << endl;
        cout << "Peso: " << peso << endl;
        cout << "Preco: R$" << preco << endl;
        cout << "Quantidade em estoque: " << quantidade << endl;
        cout << "-----------------------------\n";
    }
};

struct CarrinhoItem {
    int id;
    string nome;
    float preco;
    int quantidade;

    CarrinhoItem(int _id, string _nome, float _preco, int _qtd)
        : id(_id), nome(_nome), preco(_preco), quantidade(_qtd) {}
};

vector<Produto> lista;
vector<CarrinhoItem> carrinho;
int ultimoID = 1;


int buscarID(int id) {
    for (size_t i = 0; i < lista.size(); i++)
        if (lista[i].getId() == id)
            return static_cast<int>(i);

    return -1;
}


void adicionarProduto() {
    string nome, unidade;
    float peso, preco;
    int quantidade;

    cin.ignore();
    cout << "Nome: ";
    getline(cin, nome);

    cout << "Unidade: ";
    cin >> unidade;

    cout << "Peso: ";
    cin >> peso;

    cout << "Preco: ";
    cin >> preco;

    cout << "Quantidade inicial: ";
    cin >> quantidade;

    lista.emplace_back(ultimoID++, nome, unidade, peso, preco, quantidade);
    cout << "Produto adicionado com sucesso!\n";
}


void adicionarQuantidade() {
    int id, qtd;
    cout << "Digite o ID: ";
    cin >> id;

    int pos = buscarID(id);
    if (pos == -1) {
        cout << "Produto nao encontrado!\n";
        return;
    }

    cout << "Quantidade a adicionar: ";
    cin >> qtd;

    lista[pos].addQuantidade(qtd);
    cout << "Quantidade atualizada!\n";
}


void listarProdutos() {
    if (lista.empty()) {
        cout << "Nenhum produto cadastrado!\n";
        return;
    }
    for (auto &p : lista) p.exibir();
}


void addCarrinho() {
    int id, qtd;
    cout << "ID do produto: ";
    cin >> id;

    int pos = buscarID(id);
    if (pos == -1) {
        cout << "Produto nao encontrado!\n";
        return;
    }

    cout << "Quantidade: ";
    cin >> qtd;

    if (!lista[pos].removerQuantidade(qtd)) {
        cout << "Estoque insuficiente!\n";
        return;
    }

    carrinho.emplace_back(id, lista[pos].getNome(), lista[pos].getPreco(), qtd);
    cout << "Produto adicionado ao carrinho!\n";
}

void exibirCarrinho() {
    if (carrinho.empty()) {
        cout << "Carrinho vazio!\n";
        return;
    }

    float total = 0;

    cout << "\n======= CARRINHO =======\n";
    for (auto &c : carrinho) {
        cout << "ID: " << c.id << " - " << c.nome
             << " | Quantidade: " << c.quantidade
             << " | Preço unitário: R$" << c.preco << endl;

        total += c.preco * c.quantidade;
    }
    cout << "========================\n";
}

void totalCarrinho() {
    float total = 0;
    for (auto &c : carrinho)
        total += c.preco * c.quantidade;

    cout << "TOTAL: R$" << total << "\n";
}


void menuCarrinho() {
    int opc;

    do {
        cout << "\n\tMENU DO CARRINHO \n";
        cout << "1 - Adicionar produto ao carrinho\n";
        cout << "2 - Exibir carrinho\n";
        cout << "3 - Informar total\n";
        cout << "0 - Voltar\n";
        cout << "Escolha: ";
        cin >> opc;

        switch (opc) {
            case 1: 
                addCarrinho(); 
                break;
            case 2: 
                exibirCarrinho(); 
                break;
            case 3: 
                totalCarrinho(); 
            break;
            case 0: 
                break;
            default: 
                cout << "Opção inválida!\n";
        }

    } while (opc != 0);
}

int main() {
    int opcao;

    do {
        cout << "\n\t   MENU \n";
        cout << "1 - Adicionar produto novo\n";
        cout << "2 - Adicionar quantidade a produto\n";
        cout << "3 - Listar produtos\n";
        cout << "4 - Fazer carrinho\n";
        cout << "5 - Sair\n";
        cout << "Escolha: ";
        cin >> opcao;

        switch (opcao) {
            case 1: 
                adicionarProduto(); 
                break;
            case 2: 
                adicionarQuantidade(); 
                break;
            case 3: 
                listarProdutos(); 
                break;
            case 4: 
                menuCarrinho(); 
                break;
            case 5: 
                cout << "Saindo...\n"; 
                break;
            default: 
                cout << "Opcao invalida!\n";
        }

    } while (opcao != 5);

    return 0;
}
