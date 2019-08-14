// Imports
import java.util.Scanner;

public class Exercicio17 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		boolean bissexto = false;
		int ano = 0;
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega primeiro número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite um ano no formato AAAA: ");
				ano = scan.nextInt();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! O ano digitado não é válido. Informe novamente.");
				scan.next();
				ok = true;
			}
		}
		
		// Fecha Scanner
		scan.close();
		
		// Processamento
		if (ano % 400 == 0) {
			bissexto = true;
		} else if (ano % 4 == 0 && ano % 100 != 0) {
			bissexto = true;
		}
		
		if (bissexto) {
			System.out.printf("\nO ano %d é bissexto.\n", ano);
		} else {
			System.out.printf("\nO ano %d NÃO é bissexto.\n", ano);
		}
		
		System.out.println("\nMoriturus te saluto.");

	} // Fecha main

} // Fecha classe
