// Importa Scanner
import java.util.Scanner;

public class Exercicio05 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		double num1 = 0;
		double num2 = 0;
		double media = 0;
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega primeiro número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite a primeira nota: ");
				num1 = scan.nextDouble();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! A nota digitada não é válida. Informe novamente.");
				scan.next();
				ok = true;
			}
		}
		
		// Pega segundo número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite a segunda nota: ");
				num2 = scan.nextDouble();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! A nota digitada não é válida. Informe novamente.");
				scan.next();
				ok = true;
			}
		}
		
		// Fecha Scanner
		scan.close();
		
		// Processamento
		media = (num1 + num2)/2;
		System.out.print("Sua média foi de " + media + ", portanto você está: ");
		if (media == 10.0) {
			System.out.println("Aprovado com Distinção!");
		} else if (media >= 7) {
			System.out.println("Aprovado!");
		} else {
			System.out.println("Reprovado!");
		}
		System.out.println("\nMoriturus te saluto.");

	} // Fecha main

} // Fecha classe
