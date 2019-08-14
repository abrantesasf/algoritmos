// Importa Scanner
import java.util.Scanner;

public class Exercicio13 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		int num = 0;
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega o número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite um número inteiro de 1 (domingo) a 7 (sábado): ");
				num = scan.nextInt();
				if (num >= 1 & num <= 7) {
					ok = false;
				} else {
					System.out.println("ERRO! O número digitado não é válido. Informe novamente.");
					ok = true;
				}
			} catch (Exception e) {
				System.out.println("ERRO! O número digitado não é válido. Informe novamente.");
				scan.next();
				ok = true;
			}
		}
		
		// Fecha Scanner
		scan.close();
		
		// Processamento
		if (num == 1) {
			System.out.println("1 = Domingo");
		} else if (num == 2) {
			System.out.println("2 = Segunda");
		} else if (num == 3) {
			System.out.println("3 = Terça");
		} else if (num == 4) {
			System.out.println("4 = Quarta");
		} else if (num == 5) {
			System.out.println("5 = Quinta");
		} else if (num == 6) {
			System.out.println("6 = Sexta");
		} else {
			System.out.println("7 = Sábado");
		}
		System.out.println("\nMoriturus te saluto.");

	} // Fecha main

} // Fecha classe
