// Importa Scanner
import java.util.Scanner;

public class Exercicio27 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		double morangoKg = 0;
		double precoMorangoAte5Kg = 2.5;
		double precoMorangoMais5Kg = 2.2;
		double valorMorango = 0;
		double macaKg = 0;
		double precoMacaAte5Kg = 1.8;
		double precoMacaMais5Kg = 1.5;
		double valorMaca = 0;
		double totalKg = 0;
		double valorTotal = 0;
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Morango
		ok = true;
		while (ok) {
			try {
				System.out.print("Quantos Kg de morango você comprou? ");
				morangoKg = scan.nextDouble();
				if (morangoKg > 5) {
					valorMorango = morangoKg * precoMorangoMais5Kg;
				} else {
					valorMorango = morangoKg * precoMorangoAte5Kg;
				}
				totalKg += morangoKg;
				valorTotal += valorMorango;
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! Você não os Kg de morango corretamente. Informe novamente.");
				ok = true;
				scan.next();
			}
		}

		// Maçã
		ok = true;
		while (ok) {
			try {
				System.out.print("Quantos Kg de maçãs você comprou? ");
				macaKg = scan.nextDouble();
				if (macaKg > 5) {
					valorMaca = macaKg * precoMacaMais5Kg;
				} else {
					valorMaca = macaKg * precoMacaAte5Kg;
				}
				totalKg += macaKg;
				valorTotal += valorMaca;
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! Você não digitou os Kg de maçãs corretamente. Informe novamente.");
				ok = true;
				scan.next();
			}
		}

				
		// Fecha Scanner
		scan.close();
		
		// Processamento
		System.out.printf("Você comprou %,.2f Kg de morango (R$ %,.2f) e %,.2f Kg de maçãs (R$ %,.2f), totalizando %,.2f Kg e R$ %,.2f\n", morangoKg, valorMorango, macaKg, valorMaca, totalKg, valorTotal);
		if (totalKg > 8 || valorTotal > 25) {
			valorTotal = valorTotal * 0.9;
			System.out.printf("Você obteve um desconto adicional e pagará somente R$ %,.2f\n", valorTotal);
		}
		System.out.println("\nMoriturus te saluto.");

	}

}
