// Imports
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Exercicio23 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		int escala = 0;
		BigDecimal diferenca = new BigDecimal("0");
		BigDecimal tolerancia = new BigDecimal("1E-100");
		BigDecimal num1 = new BigDecimal("0");
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega primeiro número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite um número: ");
				num1 = scan.nextBigDecimal();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! O número digitado não é válido. Informe novamente.");
				scan.next();
				ok = true;
			}
		}
				
		// Fecha Scanner
		scan.close();
		
		// Processamento
		diferenca = num1.setScale(escala, RoundingMode.DOWN).subtract(num1).abs();
		//System.out.println(diferenca.toString());
		if (diferenca.compareTo(tolerancia) < 0) {
			System.out.println("O número é inteiro.");
		} else {
			System.out.println("O número é decimal");
		}
		
		System.out.println("\nMoriturus te saluto.");

	} // Fecha main

} // Fecha classe
