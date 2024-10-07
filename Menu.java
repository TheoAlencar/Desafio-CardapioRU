package DesafioIncode.DesafioRU;

public class Menu {
    // Classe Menu representa um menu para um dia e turno específico
    String diaDaSemana;
    String turno;
    Refeicao refeicao;

    // Construtor para inicializar o menu
    public Menu(String diaDaSemana, String turno, Refeicao refeicao) {
        this.diaDaSemana = diaDaSemana;
        this.turno = turno;
        this.refeicao = refeicao;
    }

    // Metodo para retornar a descrição do menu
    public String toString() {
        return "Dia: " + diaDaSemana + ", Turno: " + turno + ", Refeição: [" + refeicao + "]";
    }
}

