// Importar Scanner
import java.util.Scanner;

public class Exercicio02_5 {

	public static void main(String[] args) {
		// Cria Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega grau Celsius
		double grausC = 0;
		
		// Pega o primeiro número:
		boolean ok = true;
		while (ok) {
			try {
				System.out.print("\nEntre com a temperatura em graus Celsius: ");
				grausC = scan.nextDouble();
				ok = false;
			}
			catch (Exception e) {
				System.err.print("ERRO NA NOTA. \n");
				scan.next();
				ok = true;
			}
		}
		
		// Fecha o Scanner
		scan.close();
		
		// Calcula Fahrenheit
		double grausF = 0;
		grausF = (9 * grausC)/5 + 32;
		
		System.out.printf("A temperatura em Fahrenheit é de %.2f", grausF);
		System.out.println("\n\nMoriturus te saluto.\n");

	}

}
