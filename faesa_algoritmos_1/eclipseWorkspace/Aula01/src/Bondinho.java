// Importa o scanner
import java.util.Scanner;

public class Bondinho {

	public static void main(String[] args) {
		// Cria novo Scanner
		Scanner scan = new Scanner(System.in);
		
		// Variáveis par ao programa
		int a = 0;
		int m = 0;
		
		// Variável encerrar loop
		boolean ok = true;
		
		// Pega alunos:
		while (ok) {
			try {
				System.out.print("Digite o número de ALUNOS: ");
				a = scan.nextInt();
				if (a < 1 || a > 50) {
					System.out.println("\nO número de ALUNOS deve ser de 1 a 50.");
					ok = true;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Número não reconhecido! Digite novamente.\n");
				scan.next();
				ok = true;
			}
		}
		
		// Pula linha
		System.out.println("");
		
		// Pega monitores:
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite o número de MONITORES: ");
				m = scan.nextInt();
				if (m < 1 || m > 50) {
					System.out.println("\nO número de MONITORES deve ser de 1 a 50.");
					ok = true;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Número não reconhecido! Digite novamente.\n");
				scan.next();
				ok = true;
			}
		}
		
		// Pegou tudo, fecha o Scanner:
		scan.close();
		
		// Verifica se o bondinho pode levar todo mundo e imprime S ou N:
		System.out.print("\nBondinho leva " + Integer.toString(a + m) + " pessoas? ");
		if (a + m <= 50) {
			System.out.print("S");
		} else {
			System.out.print("N");
		}
		
		// Adeus
		System.out.println("\n\nMoriturus te saluto.\n");

	} // Fecha método main

} // Fecha classe
