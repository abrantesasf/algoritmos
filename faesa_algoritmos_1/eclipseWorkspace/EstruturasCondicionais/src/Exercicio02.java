// Importa Scanner
import java.util.Scanner;

public class Exercicio02 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		double num1 = 0;
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega primeiro número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite um número real qualquer: ");
				num1 = scan.nextDouble();
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
		if (num1 < 0) {
			System.out.println("O número digitado (" + num1 + ") é negativo.");
		} else {
			System.out.println("O número digitado (" + num1 + ") é positivo.");
		}
		System.out.println("\nMoriturus te saluto.");

	}

}
