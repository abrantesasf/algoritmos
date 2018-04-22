// Importa Scanner
import java.util.Scanner;

public class Exercicio25 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		byte pontuacao = 0;
		String letra = "";
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Telefonou?
		ok = true;
		while (ok) {
			try {
				System.out.print("Você telefonou para a vítima? Sim (S) ou Não (N)? ");
				letra = scan.next();
				if (! (letra.equalsIgnoreCase("s") || letra.equalsIgnoreCase("n")) ) {
					System.out.println("ERRO! Você não digitou 'S', ou 'N'. Informe novamente:");
					ok = true;
				} else {
					if (letra.equalsIgnoreCase("s")) {
						pontuacao += 1;
					}
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Você não digitou uma letra válida. Informe novamente:");
				ok = true;
				scan.next();
			}
		}
		
		// Local?
		ok = true;
		while (ok) {
			try {
				System.out.print("Você esteve no local do crime? Sim (S) ou Não (N)? ");
				letra = scan.next();
				if (! (letra.equalsIgnoreCase("s") || letra.equalsIgnoreCase("n")) ) {
					System.out.println("ERRO! Você não digitou 'S', ou 'N'. Informe novamente:");
					ok = true;
				} else {
					if (letra.equalsIgnoreCase("s")) {
						pontuacao += 1;
					}
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Você não digitou uma letra válida. Informe novamente:");
				ok = true;
				scan.next();
			}
		}
		
		// Mora perto?
		ok = true;
		while (ok) {
			try {
				System.out.print("Você mora perto da vítima? Sim (S) ou Não (N)? ");
				letra = scan.next();
				if (! (letra.equalsIgnoreCase("s") || letra.equalsIgnoreCase("n")) ) {
					System.out.println("ERRO! Você não digitou 'S', ou 'N'. Informe novamente:");
					ok = true;
				} else {
					if (letra.equalsIgnoreCase("s")) {
						pontuacao += 1;
					}
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Você não digitou uma letra válida. Informe novamente:");
				ok = true;
				scan.next();
			}
		}
		
		// Devia para a vítima?
		ok = true;
		while (ok) {
			try {
				System.out.print("Você devia dinheiro para a vítima? Sim (S) ou Não (N)? ");
				letra = scan.next();
				if (! (letra.equalsIgnoreCase("s") || letra.equalsIgnoreCase("n")) ) {
					System.out.println("ERRO! Você não digitou 'S', ou 'N'. Informe novamente:");
					ok = true;
				} else {
					if (letra.equalsIgnoreCase("s")) {
						pontuacao += 1;
					}
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Você não digitou uma letra válida. Informe novamente:");
				ok = true;
				scan.next();
			}
		}

		// Ja trabalho com?
		ok = true;
		while (ok) {
			try {
				System.out.print("Você já trabalhou com a vítima? Sim (S) ou Não (N)? ");
				letra = scan.next();
				if (! (letra.equalsIgnoreCase("s") || letra.equalsIgnoreCase("n")) ) {
					System.out.println("ERRO! Você não digitou 'S', ou 'N'. Informe novamente:");
					ok = true;
				} else {
					if (letra.equalsIgnoreCase("s")) {
						pontuacao += 1;
					}
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
		if (pontuacao == 5) {
			System.out.println("Assassino!");
		} else if (pontuacao >= 3) {
			System.out.println("Cúmplice");
		} else if (pontuacao >= 2) {
			System.out.println("Suspeito");
		} else {
			System.out.println("Inocente");
		}
		
		System.out.println("\nMoriturus te saluto.");

	}

}
