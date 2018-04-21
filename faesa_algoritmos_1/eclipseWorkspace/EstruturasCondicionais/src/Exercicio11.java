// Importa Scanner
import java.util.Scanner;

public class Exercicio11 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		double salario = 0;
		double percentual = 0;
		double reajusteBruto = 0;
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega primeiro número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite o salário: ");
				salario = scan.nextDouble();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! O número digitado não é válido. Informe novamente:");
				scan.next();
				ok = true;
			}
		}
		
		// Fecha Scanner
		scan.close();
		
		// Processamento
		if (salario >= 1500) {
			percentual = 0.05;
		} else if (salario >= 700) {
			percentual = 0.10;
		} else if (salario >= 280) {
			percentual = 0.15;
		} else {
			percentual = 0.20;
		}
		
		reajusteBruto = salario * percentual;
		
		System.out.println("\nSalário anterior: " + salario);
		System.out.println("Percentual aplicado: " + percentual);
		System.out.println("Valor do aumento: " + reajusteBruto);
		System.out.println("Salário final: " + (salario + reajusteBruto));

		System.out.println("\nMoriturus te saluto.");

	} // Fecha main

} // Fecha classe
