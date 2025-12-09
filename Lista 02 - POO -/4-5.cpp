#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main(){

    vector<int> vetor;
    for(int i = 0; i <10; i++){
        vetor.push_back(i);
    }

    cout << "O tamanho eh: " << vetor.size();
    cout << "\nRemovendo o numero: " << vetor.back();
    vetor.pop_back();
    cout << "\nO tamanho agora eh: " << vetor.size();
    cout << "\nO primeiro termo do vetor eh: " << vetor.front();
    vetor.erase(vetor.begin());
    cout << "\nO primeiro termo do vetor agora eh: " << vetor.front();
    vetor.erase(vetor.begin()+2);
    cout << "\nO tamanho eh: " << vetor.size();

    return 0;
}