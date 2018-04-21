// Importa Scanner
import java.util.Scanner;

public class Exercicio14 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		double num1 = 0;
		double num2 = 0;
		double media = 0;
		char conceito = ' ';
		String resultado = "Aprovado";
		
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
		
		if (media >= 9) {
			conceito = 'A';
		} else if (media >= 7.5) {
			conceito = 'B';
		} else if (media >= 6) {
			conceito = 'C';
		} else if (media >= 4) {
			conceito = 'D';
			resultado = "Reprovado";
		} else {
			conceito = 'E';
			resultado = "Reprovado";
		}
		
		System.out.println("");
		System.out.printf("Suas notas foram %,.2f e %,.2f\n", num1, num2);
		System.out.printf("Sua média foi de %,.2f, portanto conceito " + conceito + "\n", media);
		System.out.println("Você foi: " + resultado);
		System.out.println("\nMoriturus te saluto.");

	} // Fecha main

} // Fecha classe
