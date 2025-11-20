#include <iostream> // Para std::cout (equivalente ao System.out.println)
#include <string>   // Para std::string
#include <vector>   // Para std::vector (equivalente ao ArrayList)
#include <memory>   // Para std::unique_ptr e std::make_unique (gerenciamento de memória)

/**
 * CONCEITO: Interface (em C++)
 * Em C++, uma interface é uma classe abstrata sem atributos
 * e apenas com "funções virtuais puras" (marcadas com = 0).
 *
 * NOTA: Ela PRECISA de um destrutor virtual.
 */
class IDestruivel {
public:
    // Destrutor virtual é essencial em classes base polimórficas
    // para garantir que o destrutor correto (da classe filha) seja chamado.
    virtual ~IDestruivel() = default;

    // Funções virtuais puras (obrigam as filhas a implementar)
    virtual void receberDano(int quantidade) = 0;
    virtual bool estaDestruido() const = 0; // 'const' indica que o método não altera o objeto
    virtual std::string getNome() const = 0;
};

// ---

/**
 * CONCEITOS: Classe Abstrata, Herança (Base), Encapsulamento
 * * : public IDestruivel significa que NaveEspacial "implementa" a interface.
 * * A classe se torna abstrata automaticamente por não implementar
 * todos os métodos puros da base, ou por ter seus próprios.
 */
class NaveEspacial : public IDestruivel {
protected:
    /**
     * CONCEITO: Encapsulamento
     * 'protected' permite que classes filhas acessem, 'private' não.
     * Vamos usar 'protected' para 'nome' e 'energia' para simplificar os construtores filhos.
     */
    std::string nome;
    int energia;
    static int totalNavesCriadas;

private:
    int escudos;

protected:
    void setEscudos(int valor) {
        escudos = valor;
    }

public:
    // Construtor (usa lista de inicialização)
    NaveEspacial(const std::string& nome, int energiaInicial)
        : nome(nome), energia(energiaInicial), escudos(50){
            totalNavesCriadas++; 
        }

    // Destrutor virtual (herdado de IDestruivel, mas é boa prática repetir)
    virtual ~NaveEspacial() = default;

    // --- Métodos Abstratos (Virtuais Puros) ---
    // Devem ser implementados pelas filhas
    virtual void mover() = 0;
    virtual void disparar() = 0;

    // --- Implementação da Interface IDestruivel ---
    // 'override' é a palavra-chave que garante que estamos sobrescrevendo
    // um método virtual da classe base. (Equivalente ao @Override do Java)

    std::string getNome() const override {
        return this->nome;
    }

    static int getTotalNavesCriadas() {
        return totalNavesCriadas;
    }

    void receberDano(int quantidade) override {
        std::cout << nome << " recebeu " << quantidade << " de dano!" << std::endl;

        // Dano primeiro nos escudos
        if (escudos > 0) {
            int danoNosEscudos = std::min(escudos, quantidade);
            escudos -= danoNosEscudos;
            quantidade -= danoNosEscudos;

            std::cout << "Escudos absorveram " << danoNosEscudos
                    << ". Escudos restantes: " << escudos << std::endl;
        }

        // Dano restante na energia
        if (quantidade > 0) {
            energia -= quantidade;
            if (energia < 0) energia = 0;

            std::cout << "Energia reduzida em " << quantidade
                    << ". Energia restante: " << energia << std::endl;
        }
    }

    bool estaDestruido() const override {
        return this->energia <= 0;
    }

    // --- Métodos de Acesso ---
    int getEnergia() const {
        return this->energia;
    }
};

int NaveEspacial::totalNavesCriadas = 0;

class IHiperdrive {
public:
    virtual void saltarParaHiperespaco() = 0; 
    virtual ~IHiperdrive() = default;
};

class DroideAstromech {
private:
    std::string nome;

public:
    DroideAstromech(const std::string& nome) : nome(nome) {}

    void reparar(NaveEspacial* naveAlvo) {
        std::cout << nome << " reparando " << naveAlvo->getNome() << "!\n";
    }
};


// ---

/**
 * CONCEITOS: Herança (Especialização) e Sobrescrita (Override)
 * * XWing 'é uma' NaveEspacial.
 * * : public NaveEspacial (Equivalente ao 'extends' do Java)
 */
class XWing : public NaveEspacial, public IHiperdrive {
private:
    DroideAstromech droide; 

public:
    // O construtor da XWing chama o construtor da classe mãe (NaveEspacial)
    // na lista de inicialização.
    XWing(const std::string& nomePiloto)
        : NaveEspacial("X-Wing de " + nomePiloto, 80), 
        droide("R2-D2") 
    {}

    void iniciarReparos() {
        droide.reparar(this);
    }

    void saltarParaHiperespaco() override {
        std::cout << nome << " entrando no hiperespaco!" << std::endl;
    }

    /**
     * CONCEITO: Sobrescrita (Override)
     * Implementação específica de 'mover'.
     */
    void mover() override {
        std::cout << getNome() << " avanca pela trincheira em velocidade de ataque!" << std::endl;
    }

    /**
     * CONCEITO: Sobrescrita (Override)
     * Implementação específica de 'disparar'.
     */
    void disparar() override {
        std::cout << getNome() << " dispara 4 lasers vermelhos interligados!" << std::endl;
    }

    /**
     * CONCEITO: Sobrecarga (Overload)
     * Mesmo nome ('disparar'), mas assinatura (parâmetros) diferente.
     * Nota: Em C++, passamos objetos polimórficos por referência (&) ou ponteiro (*).
     */
    void disparar(IDestruivel& alvo) { // Passando por referência
        std::cout << getNome() << " mira e dispara lasers em " << alvo.getNome() << "!" << std::endl;
        alvo.receberDano(10);
        alvo.receberDano(10);
        alvo.receberDano(10);
        alvo.receberDano(10);
    }

    // Método específico da XWing
    void ativarEscudosDefletores() {
        std::cout << getNome() << " ativa escudos defletores!" << std::endl;
    }
};


class YWing : public NaveEspacial, public IHiperdrive {
public:
    // O construtor da YWing chama o construtor da classe mãe (NaveEspacial)
    // na lista de inicialização.
    YWing(const std::string& nomePiloto)
        : NaveEspacial("Y-Wing de " + nomePiloto, 100) {}

    void saltarParaHiperespaco() override {
        std::cout << nome << " ativando hiperespaco!" << std::endl;
    }
    /**
     * CONCEITO: Sobrescrita (Override)
     * Implementação específica de 'mover'.
     */
    void mover() override {
        std::cout << getNome() << " lentamente, focada no bombardeio!" << std::endl;
    }

    /**
     * CONCEITO: Sobrescrita (Override)
     * Implementação específica de 'disparar'.
     */
    void disparar() override {
        std::cout << getNome() << " dispara um torpedo de protons!" << std::endl;
    }

    /**
     * CONCEITO: Sobrecarga (Overload)
     * Mesmo nome ('disparar'), mas assinatura (parâmetros) diferente.
     * Nota: Em C++, passamos objetos polimórficos por referência (&) ou ponteiro (*).
     */
    void disparar(IDestruivel& alvo) { // Passando por referência
        std::cout << getNome() << " mira e dispara lasers em " << alvo.getNome() << "!" << std::endl;
        alvo.receberDano(10);
        alvo.receberDano(10);
        alvo.receberDano(10);
        alvo.receberDano(10);
    }

    // Método específico da YWing
    void ativarEscudosDefletores() {
        std::cout << getNome() << " ativa escudos defletores!" << std::endl;
    }
};

// ---

/**
 * CONCEITOS: Herança e Sobrescrita
 * * TIEFighter também 'é uma' NaveEspacial.
 */
class TIEFighter : public NaveEspacial {
public:
    TIEFighter(const std::string& idPiloto)
        : NaveEspacial("TIE Fighter " + idPiloto, 60)
    {
        setEscudos(0);
    }

    TIEFighter(const std::string& idPiloto, int energiaCustomizada)
        : NaveEspacial("TIE Fighter " + idPiloto, energiaCustomizada) 
    {
        setEscudos(0);
    }

    void mover() override {
        std::cout << getNome() << " manobra rapidamente! (Som: *TIEeeee*)" << std::endl;
    }

    void disparar() override {
        std::cout << getNome() << " dispara 2 lasers verdes!" << std::endl;
    }
};

// ---

/**
 * CONCEITO: Implementação de Interface (sem Herança)
 * * Uma TorreTurbolaser NÃO É UMA NaveEspacial.
 * * Mas ela 'é um' IDestruivel.
 */
class TorreTurbolaser : public IDestruivel {
private:
    std::string id;
    int energia;

public:
    TorreTurbolaser(const std::string& id)
        : id("Torre " + id), energia(250) {}

    // Destrutor virtual (boa prática)
    virtual ~TorreTurbolaser() = default;

    std::string getNome() const override {
        return this->id;
    }

    void receberDano(int quantidade) override {
        this->energia -= quantidade;
        if (this->energia < 0) this->energia = 0;
        std::cout << this->id << " sofre dano pesado! Energia: " << this->energia << std::endl;
    }

    bool estaDestruido() const override {
        return this->energia <= 0;
    }

    // Método próprio (recebe por referência constante)
    void rastrearAlvo(const NaveEspacial& nave) {
        std::cout << this->id << " esta rastreando " << nave.getNome() << "!" << std::endl;
    }
};

// ---

/**
 * Ponto de entrada da simulação.
 * Aqui demonstramos o POLIMORFISMO e a SOBRECARGA.
 */
int main() {
    std::cout << "--- PARTE 1: DEMONSTRACAO DE POLIMORFISMO (HERANCA) ---" << std::endl;
    std::cout << "Criando um vetor de ponteiros inteligentes (std::unique_ptr) para NaveEspacial..." << std::endl;

    // Em C++, polimorfismo exige ponteiros.
    // std::unique_ptr é um "ponteiro inteligente" que gerencia a memória
    // (equivalente ao Garbage Collector do Java para este objeto).
    std::vector<std::unique_ptr<NaveEspacial>> esquadrao;

    // std::make_unique é o "novo new" seguro em C++.
    esquadrao.push_back(std::make_unique<XWing>("Luke Skywalker"));
    esquadrao.push_back(std::make_unique<TIEFighter>("Piloto Imperial 001"));
    esquadrao.push_back(std::make_unique<XWing>("Wedge Antilles"));
    esquadrao.push_back(std::make_unique<TIEFighter>("Darth Vader", 150));
    esquadrao.push_back(std::make_unique<YWing>("Anakin Skywalker"));
    esquadrao.push_back(std::make_unique<TIEFighter>("Poderoso Jedi "));
    esquadrao.push_back(std::make_unique<YWing>("Ahsoka Tano"));
    esquadrao.push_back(std::make_unique<TIEFighter>("Padawan"));

    // O "Loop Polimórfico"
    // 'const auto& navePtr' itera sobre os unique_ptr no vetor.
    // Usamos '->' para acessar métodos via ponteiro.
    for (const auto& navePtr : esquadrao) {
        navePtr->mover();
        navePtr->disparar();
        std::cout << "---" << std::endl;
    }

    // -----------------------------------------------------------------

    std::cout << "\n--- PARTE 2: DEMONSTRACAO DE SOBRECARGA (OVERLOAD) ---" << std::endl;
    
    // Para usar métodos específicos (como a sobrecarga da XWing), precisamos
    // fazer um "cast" (conversão) seguro.
    // .get() obtém o ponteiro "cru" de dentro do unique_ptr.
    // dynamic_cast é o "cast" polimórfico seguro do C++.
    XWing* luke = dynamic_cast<XWing*>(esquadrao[0].get());
    TIEFighter* vader = dynamic_cast<TIEFighter*>(esquadrao[3].get());

    // É crucial checar se o cast funcionou (retorna nullptr se falhar)
    if (luke && vader) {
        // Chamando o método 1 (sem parâmetros)
        luke->disparar();
        
        // Chamando o método 2 (SOBRECARGA, com parâmetro)
        std::cout << "\n(Luke ataca Vader...)" << std::endl;
        // O método 'disparar' espera uma REFERÊNCIA (IDestruivel&),
        // então "desreferenciamos" o ponteiro 'vader' usando o operador '*'
        luke->disparar(*vader);
    }

    // -----------------------------------------------------------------

    std::cout << "\n--- PARTE 3: DEMONSTRACAO DE POLIMORFISMO (INTERFACES) ---" << std::endl;
    std::cout << "Criando uma lista de ponteiros 'crus' para IDestruivel..." << std::endl;

    // Para misturar tipos diferentes (Naves e Torres), usamos a interface base.
    // Criamos as torres na "stack" (memória automática)
    TorreTurbolaser torre1("Alfa-01");
    TorreTurbolaser torre2("Beta-02");

    // Vamos criar um vetor de ponteiros "crus" (IDestruivel*)
    // apenas para demonstração, pois os objetos já "têm donos"
    // (o 'esquadrao' ou a 'stack').
    std::vector<IDestruivel*> alvosNaTrincheira;
    alvosNaTrincheira.push_back(esquadrao[1].get()); // TIE (ponteiro de unique_ptr)
    alvosNaTrincheira.push_back(&torre1);           // Torre 1 (endereço de objeto da stack)
    alvosNaTrincheira.push_back(esquadrao[0].get()); // XWing (ponteiro de unique_ptr)
    alvosNaTrincheira.push_back(&torre2);           // Torre 2 (endereço de objeto da stack)

    std::cout << "\n(Um ataque coordenado atinge todos os alvos...)" << std::endl;

    // Loop Polimórfico (baseado na Interface)
    for (IDestruivel* alvoPtr : alvosNaTrincheira) {
        std::cout << "Atacando " << alvoPtr->getNome() << "..." << std::endl;
        alvoPtr->receberDano(70);
        if (alvoPtr->estaDestruido()) {
            std::cout << alvoPtr->getNome() << " foi destruido!" << std::endl;
        }
        std::cout << "---" << std::endl;
    }

    // Não precisamos de 'delete'.
    // 'torre1' e 'torre2' são destruídas automaticamente ao saírem do escopo.
    // Os objetos em 'esquadrao' são destruídos pelos 'unique_ptr'
    // quando o vetor 'esquadrao' sai do escopo.
    // -----------------------------------------------------------------

    std::cout << "\n--- PARTE 4: HIPERESPACO (INTERFACES DA MISSAO 3) ---\n";

    std::cout << "\nVerificando quais naves podem saltar para o hiperespaco...\n";

    // Loop sobre todas as naves
    for (const auto& navePtr : esquadrao) {

        // Teste de interface (dynamic_cast)
        IHiperdrive* hip = dynamic_cast<IHiperdrive*>(navePtr.get());

        if (hip != nullptr) {
            // Se NÃO for null, significa que a nave IMPLEMENTA a interface
            hip->saltarParaHiperespaco();
        }
    }

    std::cout << "\n--- PARTE 5: REPAROS DA MISSAO 4 ---\n";

    for (const auto& navePtr : esquadrao) {
        XWing* x = dynamic_cast<XWing*>(navePtr.get());
        if (x != nullptr) {
            x->iniciarReparos();
        }
    }

    std::cout << "\nTotal de naves na batalha: "
          << NaveEspacial::getTotalNavesCriadas()
          << std::endl;

    std::cout << "\nSimulacao terminada. Destrutores automaticos sendo chamados." << std::endl;
    return 0; // Fim do programa
}