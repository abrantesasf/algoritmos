// Atividade de Revisão de Modularização
// Algoritmos 2
// Abrantes Araújo Silva Filho

// Imports
import java.util.Scanner;

public class AreaRetangulo {

	public static void main(String[] args) {
		// Cria scanner
		Scanner scan = new Scanner(System.in);
		
		// Variáveis
		double base = 0;
		double altura = 0;
		boolean ok = true;
		
		// Pega a base
		while (ok) {
			try {
				System.out.println("Informe a BASE do retângulo:");
				base = scan.nextDouble();
				if (base <= 0) {
					System.out.println("A BASE não pode ser <= 0. Por favor, informe novamente.");
					ok = true;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Você nao digitou um número válido.");
				ok = true;
				scan.next();
			}
		}
		
		// Pega a altura
		ok = true;
		while (ok) {
			try {
				System.out.println("Informe a ALTURA do retângulo:");
				altura = scan.nextDouble();
				if (altura <= 0) {
					System.out.println("A ALTURA não pode ser <= 0. Por favor, informe novamente.");
					ok = true;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Você nao digitou um número válido.");
				ok = true;
				scan.next();
			}
		}
		
		// Verifica se é QUADRADO e mostra a área
		if (isSquare(base, altura)) {
			System.out.println("A área do QUADRADO é de: " + (float)calcularArea(base, altura));
		} else {
			System.out.println("A área do RETÂNGULO é de: " + (float)calcularArea(base, altura));
		}
		
		// Fecha scanner
		scan.close();
		
		// Morre
		System.out.println("\nMoriturus te saluto.");
		
	} // fecha main
	
	// Método para cálculo da área
	static double calcularArea(double base, double altura) {
		return (base * altura);
	}
	
	// Método para verificar se é quadrado
	static boolean isSquare(double base, double altura) {
		return (base == altura);
	}

} // fecha classe
