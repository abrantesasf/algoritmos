// Importa Scanner
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Exercicio16 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		double numA = 0;
		double numB = 0;
		double numC = 0;
		double delta = 0;
		double raiz1 = 0;
		double raiz2 = 0;
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega primeiro número
		ok = true;
		while (ok) {
			try {
				System.out.print("Para a equação 'ax^2 + bx + c', informe o valor do coeficiente 'a': ");
				numA = scan.nextDouble();
				if (numA == 0) {
					System.out.println("Como o coeficiante 'a' foi 0, o programa será encerrado.");
					System.out.println("\nMoriturus te saluto.");
					System.exit(0);
				}
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
				System.out.print("Para a equação 'ax^2 + bx + c', informe o valor do coeficiente 'b': ");
				numB = scan.nextDouble();
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
				System.out.print("Para a equação 'ax^2 + bx + c', informe o valor do coeficiente 'c': ");
				numC = scan.nextDouble();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! O número digitado não é válido. Informe novamente.");
				scan.next();
				ok = true;
			}
		}
		
		// Processamento
		delta = Math.pow(numB, 2) - 4 * numA * numC;
		if (delta < 0) {
			System.out.println("A equação informada, " + numA + "x^2 + " + numB + "x + " + numC + ", não tem raízes reais. Encerrando o programa...");
		} else if (delta == 0) {
			raiz1 = (-numB)/(2*numA);
			System.out.printf("A equação informada, " + numA + "x^2 + " + numB + "x + " + numC + ", tem 1 raiz real: %,.2f", raiz1);
		} else {
			raiz1 = (-numB + Math.sqrt(delta))/(2*numA);
			raiz2 = (-numB - Math.sqrt(delta))/(2*numA);
			System.out.printf("A equação informada, " + numA + "x^2 + " + numB + "x + " + numC + ", tem 2 raízes reais: %,.2f e %,.2f", raiz1, raiz2);
		}
		System.out.println("\n\nMoriturus te saluto.");

	} // Fecha main

} // Fecha classe
