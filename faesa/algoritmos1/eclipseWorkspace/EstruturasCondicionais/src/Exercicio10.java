// Importa Scanner
import java.util.Scanner;

public class Exercicio10 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		String letra = "";
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega primeiro número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite 'M' (matutino), 'V' (vespertino) ou 'N' (noturno): ");
				letra = scan.next();
				if (! (letra.equalsIgnoreCase("m") || letra.equalsIgnoreCase("v") || letra.equalsIgnoreCase("n")) ) {
					System.out.println("ERRO! Você não digitou 'M', 'V' ou 'N'. Informe novamente:");
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
		if (letra.equalsIgnoreCase("m")) {
			System.out.println("Bom dia!");
		} else if (letra.equalsIgnoreCase("v")) {
			System.out.println("Boa tarde!");
		} else {
			System.out.println("Boa noite!");
		}
		System.out.println("\nMoriturus te saluto.");

	}

}
