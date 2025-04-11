import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        ArrayList<String> nomes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Gerenciador de Nomes ===");
            System.out.println("1. Adicionar nome");
            System.out.println("2. Remover nome");
            System.out.println("3. Exibir todos os nomes");
            System.out.println("4. Ordenar nomes");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
            } catch (Exception e) {
                System.out.println("Erro: Digite um número entre 1 e 5.");
                scanner.nextLine(); // Limpar entrada inválida
                continue;
            }

            switch (opcao) {
                case 1: // Adicionar nome
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine().trim();
                    if (nome.isEmpty()) {
                        System.out.println("Erro: O nome não pode estar vazio.");
                    } else {
                        // Verificar duplicata (ignorando maiúsculas/minúsculas)
                        boolean duplicado = false;
                        for (String n : nomes) {
                            if (n.equalsIgnoreCase(nome)) {
                                duplicado = true;
                                break;
                            }
                        }
                        if (duplicado) {
                            System.out.println("Erro: O nome '" + nome + "' já existe na lista.");
                        } else {
                            nomes.add(nome);
                            System.out.println("Nome '" + nome + "' adicionado com sucesso.");
                        }
                    }
                    break;

                case 2: // Remover nome
                    System.out.print("Digite o nome a remover: ");
                    String nomeRemover = scanner.nextLine().trim();
                    if (nomeRemover.isEmpty()) {
                        System.out.println("Erro: O nome não pode estar vazio.");
                    } else {
                        boolean removido = false;
                        // Buscar e remover (ignorando maiúsculas/minúsculas)
                        for (int i = 0; i < nomes.size(); i++) {
                            if (nomes.get(i).equalsIgnoreCase(nomeRemover)) {
                                String nomeRemovido = nomes.remove(i);
                                System.out.println("Nome '" + nomeRemovido + "' removido com sucesso.");
                                removido = true;
                                break;
                            }
                        }
                        if (!removido) {
                            System.out.println("Nome '" + nomeRemover + "' não encontrado na lista.");
                        }
                    }
                    break;

                case 3: // Exibir todos os nomes
                    if (nomes.isEmpty()) {
                        System.out.println("A lista de nomes está vazia.");
                    } else {
                        System.out.println("\nLista de nomes:");
                        for (int i = 0; i < nomes.size(); i++) {
                            System.out.println((i + 1) + ". " + nomes.get(i));
                        }
                    }
                    break;

                case 4: // Ordenar nomes
                    if (nomes.isEmpty()) {
                        System.out.println("A lista de nomes está vazia. Não há nada para ordenar.");
                    } else {
                        Collections.sort(nomes, String.CASE_INSENSITIVE_ORDER);
                        System.out.println("\nNomes ordenados alfabeticamente:");
                        for (int i = 0; i < nomes.size(); i++) {
                            System.out.println((i + 1) + ". " + nomes.get(i));
                        }
                    }
                    break;

                case 5: // Sair
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Erro: Opção inválida. Escolha entre 1 e 5.");
            }
        }





    }
}
