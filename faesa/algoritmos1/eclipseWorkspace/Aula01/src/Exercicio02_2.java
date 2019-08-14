// Importa Scanner
import java.util.Scanner;

public class Exercicio02_2 {

	public static void main(String[] args) {
		// Declara Scanner
		Scanner scan = new Scanner(System.in);
		
		// Variáveis
		double kmInicial = 0;
		double kmFinal = 0;
		double gasolina = 0;
		double kmPorLitro = 0;
		
		// Pega Km inicial
		boolean ok = true;
		while (ok) {
			try {
				System.out.print("Entre com a kilometragem inicial: ");
				kmInicial = scan.nextDouble();
				ok = false;
			} catch (Exception e) {
				System.err.print("\nERRO NA KILOMETRAGEM INICIAL.\n");
				scan.next();
				ok = true;
			}
		}
		
		// Pega Km final
		ok = true;
		while (ok) {
			try {
				System.out.print("Entre com a kilometragem final: ");
				kmFinal = scan.nextDouble();
				ok = false;
			} catch (Exception e) {
				System.err.print("\nERRO NA KILOMETRAGEM FINAL.\n");
				scan.next();
				ok = true;
			}
		}
		
		// Pega gasolina
		ok = true;
		while (ok) {
			try {
				System.out.print("Entre com a gasolina consumida: ");
				gasolina = scan.nextDouble();
				ok = false;
			} catch (Exception e) {
				System.err.print("\nERRO NA GASOLINA CONSUMIDA.\n");
				scan.next();
				ok = true;
			}
		}
		
		// Fecha scanner
		scan.close();
		
		// Verificação de erros básicos
		if (kmInicial >= kmFinal) {
			System.out.println("\nA kilometragem inicial foi IGUAL OU MENOR do que a final.");
			System.out.println("Isso é um erro e o programa será fechado (preste atenção da próxima vez).");
			System.out.println("\nMoriturus te saluto.");
			//return;
			System.exit(0);
		}
		else if (kmInicial < 0 || kmFinal < 0) {
			System.out.println("\nAlguma kilometragem está menor do zero.");
			System.out.println("Isso é um erro e o programa será fechado (preste atenção da próxima vez).");
			System.out.println("\nMoriturus te saluto.");
			//return;
			System.exit(0);
		}
		else if (gasolina <= 0) {
			System.out.println("\nVocê não informou a gasolina consumida (ou informou zero).");
			System.out.println("Isso é um erro e o programa será fechado (preste atenção da próxima vez).");
			System.out.println("\nMoriturus te saluto.\n");
			//return;
			System.exit(0);
		}
		
		// Cálculo
		kmPorLitro = (kmFinal - kmInicial) / gasolina;
		
		// Mostra o consumo:
		System.out.printf("\nVocê percorreu %.2f quilômetros, com %.2f litros de gasolina, totalizando "
				+ "%.2f Km/l.", (kmFinal - kmInicial), gasolina, kmPorLitro);

	} // static main

} // fecha classe
