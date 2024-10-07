package DesafioIncode.DesafioRU;


// Classe Refeicao representa uma refeição composta por três alimentos
public class Refeicao{

    Alimentos pratoPrincipal;
    Alimentos acompanhamento;
    Alimentos salada;

    // Construtor para inicializar a refeição
    public Refeicao(Alimentos pratoPrincipal, Alimentos acompanhamento, Alimentos salada) {
        this.pratoPrincipal = pratoPrincipal;
        this.acompanhamento = acompanhamento;
        this.salada = salada;
    }

    // Metodo para retornar a descrição da refeição
    public String toString() {
        return "Prato Principal: " + pratoPrincipal + ", Acompanhamento: " + acompanhamento + ", Salada: " + salada;
    }
}

