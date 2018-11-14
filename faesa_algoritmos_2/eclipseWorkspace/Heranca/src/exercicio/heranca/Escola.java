package exercicio.heranca;

import java.util.Scanner;

public class Escola {
	static Scanner scan = new Scanner(System.in);
	static Aluno[] turma;

	public static void main(String[] args) {
		int opcao = 0;
		do {
			System.out.println("\n------------------------ MENU DE OPÇÕES ------------------------\n" +
		                       "1. Cadastrar alunos na turma\n" +
					           "9. Sair\n" +
		                       "----------------------------------------------------------------\n" +
					           "Digite sua opção: ");
			opcao = scan.nextInt();
			scan.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("A implementar...");
				break;
			case 9:
				System.out.println("\n\nFim do programa.\nMoriturus te saluto!");
				break;
			default:
				System.out.println("Opção inválida, informe novamente:");
				break;
			}
		} while (opcao != 9);

	}

}
