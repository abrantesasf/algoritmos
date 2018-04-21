// Importa Scanner
import java.util.Scanner;

public class Exercicio04 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		String letra = " ";
		String alfabeto = "aáàãâäbcçdeéèẽêëfghiíìĩîïjklmnñoóòõôöpqrstuúùũûüvwxyz";
		String vogais = "aáàãâäeéèẽêëiíìĩîïoóòõôöuúùũûü";
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega primeiro número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite uma LETRA qualquer do alfabeto: ");
				letra = scan.next();
				if ( letra.isEmpty() ) {
					System.out.println("ERRO! Você não informou nenhuma letra. Informe novamente.");
					ok = true;
				} else if (letra.length() > 1){
					System.out.println("ERRO! Digite apenas 1 letra. Informe novamente");
					ok = true;
				} else if ( ! alfabeto.toUpperCase().contains(letra.toUpperCase()) ) {
					System.out.println("ERRO! Você não informou uma letra valida. Informe novamente.");
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
		if (vogais.toUpperCase().contains(letra.toUpperCase())) {
			System.out.println("Vogal");
		} else {
			System.out.println("Consoante");
		}
		System.out.println("\nMoriturus te saluto.");

	}

}
