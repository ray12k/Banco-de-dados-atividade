import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BancoDeDados banco = new BancoDeDados();

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Listar todos");
            System.out.println("2 - Buscar por ID");
            System.out.println("3 - Buscar por nome");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                List<Pessoa> pessoas = banco.obterTodos();
                pessoas.forEach(p -> System.out.println(p));

            } else if (opcao == 2) {
                System.out.print("Digite o ID: ");
                Integer id = scanner.nextInt();
                scanner.nextLine();

                Pessoa pessoa = banco.obterPorId(id);
                if (pessoa != null) {
                    System.out.println(pessoa);
                } else {
                    System.out.println("Pessoa não encontrada.");
                }

            } else if (opcao == 3) {
                System.out.print("Digite o nome ou parte do nome: ");
                String nome = scanner.nextLine();

                List<Pessoa> pessoasFiltradas = banco.obterPorNome(nome);

                if (pessoasFiltradas.isEmpty()) {
                    System.out.println("Nenhum resultado encontrado.");
                } else {
                    pessoasFiltradas.forEach(p -> System.out.println(p));
                }

            } else if (opcao != 0) {
                System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
