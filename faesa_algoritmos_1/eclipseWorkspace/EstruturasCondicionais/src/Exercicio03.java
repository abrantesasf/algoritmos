// Importa Scanner
import java.util.Scanner;

public class Exercicio03 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		String letra = "m";
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega primeiro número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite 'F' ou 'M': ");
				letra = scan.next();
				if (! (letra.equalsIgnoreCase("F") || letra.equalsIgnoreCase("M")) ) {
					System.out.println("ERRO! Você não digitou 'F' ou 'M'. Informe novamente:");
					ok = true;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Você não digitou uma letra válida. Informe novamente:");
				ok = true;
				scan.next();
			}
		}
		
		// Fecha Scanner
		scan.close();
		
		// Processamento
		if (letra.equalsIgnoreCase("f")) {
			System.out.println("F - Feminino");
		} else {
			System.out.println("M - Masculino");
		}
		System.out.println("\nMoriturus te saluto.");

	}

}
