package ti2cc;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        JogadorDAO dao = new JogadorDAO();
        
        Scanner leitor = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n--- SISTEMA DE JOGADORES ---");
            System.out.println("1. Inserir Novo");
            System.out.println("2. Listar Todos");
            System.out.println("3. Excluir");
            System.out.println("4. Atualizar");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Número: ");
                    int num = leitor.nextInt();
                    leitor.nextLine(); 
                    System.out.print("Nome: ");
                    String nome = leitor.nextLine();
                    System.out.print("Time: ");
                    String time = leitor.nextLine();
                    System.out.print("Posição: ");
                    String pos = leitor.nextLine();
                    
                    dao.inserir(num, nome, time, pos);
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE JOGADORES ---");
                    dao.listar(); 
                    break;

                case 3:
                    System.out.print("Digite o número do jogador para excluir: ");
                    int numExcluir = leitor.nextInt();
                    dao.excluir(numExcluir);
                    break;
                
                case 4:
                    System.out.print("Número do jogador que quer mudar: ");
                    int numAtu = leitor.nextInt();
                    leitor.nextLine();
                    System.out.print("Novo Nome: ");
                    String nNome = leitor.nextLine();
                    System.out.print("Novo Time: ");
                    String nTime = leitor.nextLine();
                    System.out.print("Nova Posição: ");
                    String nPos = leitor.nextLine();
                    System.out.println("Jogador atualizado!");
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        leitor.close();
    }
}