// Importa Scanner
import java.util.Scanner;

public class Exercicio28 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		
		String codigoTipoCarne = "";
		String tipoCarne = "";
		double quantidadeCarne = 0;
		
		String codigoPagamento = "";
		String formaPagamento = "";
		
		double precoFileAte5Kg = 5.8;
		double precoFileMais5KG = 4.9;
		double precoAlcatraAte5Kg = 6.8;
		double precoAlcatraMais5Kg = 5.9;
		double precoPicanhaAte5Kg = 7.8;
		double precoPicanhaMais5Kg = 6.9;
		
		double valorCarne = 0;
		double valorDesconto = 0;
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Quantidade:
		ok = true;
		while (ok) {
			try {
				System.out.print("Quantos Kg de carne você comprou? ");
				quantidadeCarne = scan.nextDouble();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! Você não digitou uma quantidade válida. Informe novamente.");
				ok = true;
				scan.next();
			}
		}
		
		// Tipo de carne:
		ok = true;
		while (ok) {
			try {
				System.out.print("Você comprou filé (F), alcatra (A) ou picanha (P)? ");
				codigoTipoCarne = scan.next();
				if (! (codigoTipoCarne.equalsIgnoreCase("f") || codigoTipoCarne.equalsIgnoreCase("a") || codigoTipoCarne.equalsIgnoreCase("p")) ) {
					System.out.println("ERRO! Você não digitou 'F', 'A' ou 'P'. Informe novamente:");
					ok = true;
				} else {
					if (codigoTipoCarne.equalsIgnoreCase("f")) {
						tipoCarne = "Filé Duplo";
						if (quantidadeCarne > 5) {
							valorCarne = quantidadeCarne * precoFileMais5KG;
						} else {
							valorCarne = quantidadeCarne * precoFileAte5Kg;
						}
					} else if (codigoTipoCarne.equalsIgnoreCase("a")) {
						tipoCarne = "Alcatra   ";
						if (quantidadeCarne > 5) {
							valorCarne = quantidadeCarne * precoAlcatraMais5Kg;
						} else {
							valorCarne = quantidadeCarne * precoAlcatraAte5Kg;
						}
					} else {
						tipoCarne = "Picanha   ";
						if (quantidadeCarne > 5) {
							valorCarne = quantidadeCarne * precoPicanhaMais5Kg;
						} else {
							valorCarne = quantidadeCarne * precoPicanhaAte5Kg;
						}
					}
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Você não digitou o código da carne corretamente. Informe novamente:");
				ok = true;
				scan.next();
			}
		}
		
		// Forma de pagamento?
		ok = true;
		while (ok) {
			try {
				System.out.print("Você pagará com o Cartão Tabajara (S) ou usará outra forma de pagamento (N)? ");
				codigoPagamento = scan.next();
				if (! (codigoPagamento.equalsIgnoreCase("s") || codigoPagamento.equalsIgnoreCase("n")) ) {
					System.out.println("ERRO! Você não digitou 'S', ou 'N'. Informe novamente:");
					ok = true;
				} else {
					if (codigoPagamento.equalsIgnoreCase("s")) {
						formaPagamento = "Cartão Tabajara com 5% de desconto!";
						valorDesconto = valorCarne * 0.05;
					} else {
						formaPagamento = "Outro Método";
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
		System.out.println("------------------------------------------------------------------");
		System.out.println("              Cupom Fiscal - Hipermercados Tabajara");
		System.out.println("------------------------------------------------------------------");
		System.out.println("Item                          Qtd.                           Preço");
		System.out.printf(tipoCarne +"\t\t%,10.2f\t\t\t%,10.2f\n", quantidadeCarne, valorCarne);
		System.out.println("------------------------------------------------------------------");
		System.out.println("Pagamento: " + formaPagamento);
		if (codigoPagamento.equalsIgnoreCase("s")) {
			System.out.printf("Desconto: \t\t\t\t\t\t%,10.2f\n", valorDesconto);
			valorCarne -= valorDesconto;
		}
		System.out.println("------------------------------------------------------------------");
		System.out.printf("Valor final:\t\t\t\t\t\t%,10.2f\n", valorCarne);
		System.out.println("------------------------------------------------------------------");
		
		System.out.println("\nMoriturus te saluto.");

	}

}
