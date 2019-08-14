// Importa Scanner
import java.util.Scanner;

public class Exercicio22 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		int num1 = 0;
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega primeiro número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite um número INTEIRO: ");
				num1 = scan.nextInt();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! O número digitado não é válido. Informe novamente.");
				scan.next();
				ok = true;
			}
		}
				
		// Fecha Scanner
		scan.close();
		
		// Processamento
		if (num1 % 2 == 0) {
			System.out.println("O número é par!");
		} else {
			System.out.println("O número é ímpar!");
		}
		System.out.println("\nMoriturus te saluto.");

	} // Fecha main

} // Fecha classe
