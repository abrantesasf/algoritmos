// Atividade de Revisão de Modularização
// Algoritmos 2
// Abrantes Araújo Silva Filho

// Imports
import java.util.Scanner;

public class Divisivel {

	public static void main(String[] args) {
		// Cria scanner
		Scanner scan = new Scanner(System.in);
		
		// Variáveis
		int numero1 = 0;
		int numero2 = 0;
		boolean ok = true;
		
		// Pega o primeiro número
		while (ok) {
			try {
				System.out.println("Informe um DIVIDENDO inteiro:");
				numero1 = scan.nextInt();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! Você nao digitou um inteiro válido.");
				ok = true;
				scan.next();
			}
		}
		
		// Pega o segundo número
		ok = true;
		while (ok) {
			try {
				System.out.println("Informe um DIVISOR inteiro:");
				numero2 = scan.nextInt();
				if (numero2 == 0) {
					System.out.println("O divisor não pode ser 0. Por favor, informe novamente.");
					ok = true;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Você nao digitou um inteiro válido.");
				ok = true;
				scan.next();
			}
		}
		
		// Respode:
		if (divisivel(numero1, numero2)) {
			System.out.println(numero1 + " é divisível por " + numero2);
		} else {
			System.out.println(numero1 + " NÃO é divisível por " + numero2);
		}
		
		// Fecha scanner
		scan.close();
		
		// Morre
		System.out.println("\nMoriturus te saluto.");

	}  // fecha main
	
	// Método para saber se é divisível
	static boolean divisivel(int a, int b) {
		return ((a % b) == 0);
	}

} // fecha classe
