package DesafioIncode.DesafioRU;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe principal SistemaRU que gerencia o cardápio do Restaurante Universitário
public class SistemaRU {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Alimentos> alimentosList = new ArrayList<>();
        List<Menu> cardapioSemanal = new ArrayList<>();
        String[] diasDaSemana = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta"};
        String[] turnos = {"Almoço", "Jantar"};


        // Criar Menu Semanal
        for (String dia : diasDaSemana) {
            System.out.print("\nVocê deseja cadastrar um menu para " + dia + "? (s/n): ");
            String resposta = scanner.nextLine();
            // Pergunta se o usuário deseja cadastrar um menu para o dia atual
            if (resposta.equalsIgnoreCase("s")) {
                // Para cada turno, solicita que o usuário cadastre a refeição
                for (String turno : turnos) {
                    System.out.println("\nDia: " + dia + ", Turno: " + turno);
                    Refeicao refeicao = criarRefeicao(alimentosList, scanner);// Criação da refeição
                    Menu menu = new Menu(dia, turno, refeicao);// Criação do menu
                    cardapioSemanal.add(menu);// Adiciona o menu à lista
                    System.out.println("Menu cadastrado com sucesso para " + dia + " no turno " + turno + "!");
                }
                // Imprimir refeições após cada dia
                imprimirRefeicoesDia(dia, cardapioSemanal);
            } else {
                System.out.println("Menu para " + dia + " não será cadastrado.");
            }
        }

        // Imprimir o cardápio semanal
        System.out.println("\nCardápio Semanal:");
        for (Menu menu : cardapioSemanal) {
            System.out.println(menu);// Exibe cada menu cadastrado
        }

        scanner.close();
    }

    // Metodo para cadastrar alimentos
    private static void cadastrarAlimentos(List<Alimentos> alimentosList, Scanner scanner) {
        System.out.println("Cadastrar Alimentos:");

        while (true) {
            // Solicita o nome do alimento ao usuário
            System.out.print("Digite o nome do alimento (ou 'sair' para finalizar): ");
            String nomeAlimento = scanner.nextLine();
            if (nomeAlimento.equalsIgnoreCase("sair")) {// Se o usuário digitar "sair"
                break;// Encerra o loop de cadastro
            }
            // Cria um novo alimento e adiciona à lista
            alimentosList.add(new Alimentos(nomeAlimento));
            System.out.println("Alimento cadastrado com sucesso!");
        }
    }

    // Metodo para criar refeição
    private static Refeicao criarRefeicao(List<Alimentos> alimentosList, Scanner scanner) {
        System.out.println("\nCriar Refeição:");
        // Solicita o nome do prato principal
        System.out.print("Digite o nome do prato principal: ");
        String pratoPrincipalNome = scanner.nextLine();
        Alimentos pratoPrincipal = new Alimentos(pratoPrincipalNome);// Cria o alimento

        // Solicita o nome do acompanhamento
        System.out.print("Digite o nome do acompanhamento: ");
        String acompanhamentoNome = scanner.nextLine();
        Alimentos acompanhamento = new Alimentos(acompanhamentoNome);

        // Solicita o nome da salada
        System.out.print("Digite o nome da salada: ");
        String saladaNome = scanner.nextLine();
        Alimentos salada = new Alimentos(saladaNome);

        return new Refeicao(pratoPrincipal, acompanhamento, salada);// Retorna a refeição criada
    }

    // Metodo para imprimir as refeições cadastradas de um dia
    private static void imprimirRefeicoesDia(String dia, List<Menu> cardapioSemanal) {
        System.out.println("\nRefeições cadastradas para " + dia + ":");
        for (Menu menu : cardapioSemanal) {
            // Verifica se o menu é do dia atual
            if (menu.diaDaSemana.equalsIgnoreCase(dia)) {
                System.out.println(menu); // Exibe a refeição cadastrada
            }
        }
    }
}