// Importa Scanner
import java.util.Scanner;

public class Exercicio15 {

	public static void main(String[] args) {
		// Variáveis:
		boolean ok = true;
		double ladoA = 0;
		double ladoB = 0;
		double ladoC = 0;
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega primeiro número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite o tamanho do Lado A do triângulo: ");
				ladoA = scan.nextDouble();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! O número digitado não é válido. Informe novamente.");
				scan.next();
				ok = true;
			}
		}
		
		// Pega segundo número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite o tamanho do Lado B do triângulo: ");
				ladoB = scan.nextDouble();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO! O número digitado não é válido. Informe novamente.");
				scan.next();
				ok = true;
			}
		}
		
		// Pega terceiro número
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite o tamanho do Lado C do triângulo: ");
				ladoC = scan.nextDouble();
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
		// Verifica se é triângulo mesmo e identifica:
		if (!(ladoA + ladoB > ladoC && ladoA + ladoC > ladoB && ladoB + ladoC > ladoA)) {
			System.out.println("Os lados informados não definem um triângulo. Encerrando...");			
		} else if (ladoA == ladoB & ladoB == ladoC) {
			System.out.println("O triângulo informado é equilátero.");
		} else if (ladoA != ladoB & ladoA != ladoC & ladoB != ladoC) {
			System.out.println("O trigângulo informado é escaleno.");
		} else {
			System.out.println("O triângulo informado é isósceles.");
		}
		
		System.out.println("\nMoriturus te saluto.");

	} // Fecha main

} // Fecha classe
