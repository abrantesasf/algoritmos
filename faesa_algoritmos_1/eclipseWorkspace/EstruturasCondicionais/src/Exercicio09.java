// Importa Scanner
import java.util.Scanner;

public class Exercicio09 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		double num1 = 0;
		double num2 = 0;
		double num3 = 0;
		double maior = 0;
		double menor = 0;
		double meio = 0;
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega primeiro número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite o primeiro número: ");
				num1 = scan.nextDouble();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! O número digitado não é válido. Informe novamente.");
				scan.next();
				ok = true;
			}
		}
		
		// Pega segundo número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite o segundo número: ");
				num2 = scan.nextDouble();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! O número digitado não é válido. Informe novamente.");
				scan.next();
				ok = true;
			}
		}
		
		// Pega terceiro número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite o terceiro número: ");
				num3 = scan.nextDouble();
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
		if (num1 >= num2) {
			maior = num1;
			menor = num2;
		} else {
			maior = num2;
			menor = num1;
		}
		if (num3 >= maior) {
			meio = maior;
			maior = num3;
		} else if (num3 > menor & num3 < maior) {
			meio = num3;
		} else {
			meio = menor;
			menor = num3;
		}
		
		System.out.println("Ordem decrescente: " + maior + ", " + meio + ", " + menor);		
		System.out.println("\nMoriturus te saluto.");

	} // Fecha main

} // Fecha classe
