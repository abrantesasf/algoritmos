// Importa Scanner
import java.util.Scanner;

public class Exercicio26 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		double litros = 0;
		double precoGasolina = 2.5;
		double precoAlcool = 1.9;
		double precoAPagar = 0;
		double desconto = 0;
		String combustivel = "";
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Combustível?
		ok = true;
		while (ok) {
			try {
				System.out.print("Você abasteceu com gasolina (G) ou álcool (A)? ");
				combustivel = scan.next();
				if (! (combustivel.equalsIgnoreCase("g") || combustivel.equalsIgnoreCase("a")) ) {
					System.out.println("ERRO! Você não digitou 'G', ou 'A'. Informe novamente:");
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
		
		// Litros?
		ok = true;
		while (ok) {
			try {
				System.out.print("Quantos litros você abasteceu? ");
				litros = scan.nextDouble();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! Você não digitou uma quantidade de litros válida. Informe novamente.");
				ok = true;
				scan.next();
			}
		}
				
		// Fecha Scanner
		scan.close();
		
		// Processamento
		if (combustivel.equalsIgnoreCase("g")) {
			if (litros > 20) {
				desconto = (litros * precoGasolina) * 0.06;
				precoAPagar = (litros * precoGasolina) - desconto;
			} else {
				desconto = (litros * precoGasolina) * 0.04;
				precoAPagar = (litros * precoGasolina) - desconto;
			}
		} else {
			if (litros > 20) {
				desconto = (litros * precoAlcool) * 0.05;
				precoAPagar = (litros * precoAlcool) - desconto;
			} else {
				desconto = (litros * precoAlcool) * 0.03;
				precoAPagar = (litros * precoAlcool) - desconto;
			}
		}
		
		System.out.printf("Você abasteceu com %,.2f litros (" + combustivel.toUpperCase() + ") e o preço foi de R$ %,.2f\n", litros, precoAPagar);
		
		System.out.println("\nMoriturus te saluto.");

	}

}
