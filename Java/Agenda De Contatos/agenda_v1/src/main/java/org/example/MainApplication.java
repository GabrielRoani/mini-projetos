package org.example;
import org.example.Model.Contatos;
import org.example.Service.CadastraContato;
import java.util.List;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastraContato agenda = new CadastraContato();
        boolean sair = false;

        while (!sair) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar um novo contato");
            System.out.println("2 - Listar todos os contatos");
            System.out.println("3 - Atualizar um contato existente");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o número

            switch (opcao) {
                case 1:
                    cadastrarContato(scanner, agenda);
                    break;
                case 2:
                    listarContatos(agenda);
                    break;
                case 3:
                    atualizarContato(scanner, agenda);
                    break;
                case 4:
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    // Metodo para cadastrar um novo contato
    private static void cadastrarContato(Scanner scanner, CadastraContato agenda) {
        System.out.print("Digite o nome do contato: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o número do contato: ");
        String numero = scanner.nextLine();

        System.out.print("Digite o e-mail do contato: ");
        String gmail = scanner.nextLine();

        agenda.cadastrarUsuario(nome, numero, gmail);
        System.out.println("Contato cadastrado com sucesso!");
    }

    // Metodo para listar todos os contatos
    private static void listarContatos(CadastraContato agenda) {
        List<Contatos> contatos = agenda.listarUsuarios();
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            System.out.println("Contatos cadastrados:");
            for (Contatos contato : contatos) {
                System.out.println("Nome: " + contato.getNome() + ", Número: " + contato.getNumero() + ", E-mail: " + contato.getGmail());
            }
        }
    }

    // Metodo para atualizar um contato existente
    private static void atualizarContato(Scanner scanner, CadastraContato agenda) {
        System.out.print("Digite o nome do contato a ser atualizado: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o novo número do contato: ");
        String novoNumero = scanner.nextLine();

        System.out.print("Digite o novo e-mail do contato: ");
        String novoGmail = scanner.nextLine();

        boolean atualizado = agenda.atualizarUsuario(nome, novoNumero, novoGmail);
        if (atualizado) {
            System.out.println("Contato atualizado com sucesso!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
}
