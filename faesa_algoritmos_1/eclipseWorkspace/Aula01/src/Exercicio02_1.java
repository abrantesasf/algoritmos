// Importar Scanner
import java.util.Scanner;

// Classe principal
public class Exercicio02_1 {

	public static void main(String[] args) {
		// Declara Scanner
		Scanner scan = new Scanner(System.in);
		
		// Variáveis para receber as notas e pesos:
		double n1 = 0;
		double n2 = 0;
		double n3 = 0;
		double p1 = 2;
		double p2 = 3;
		double p3 = 5;
		
		// Pega o primeiro número:
		boolean ok = true;
		while (ok) {
			try {
				System.out.print("\nEntre com a PRIMEIRA nota: ");
				n1 = scan.nextDouble();
				ok = false;
			}
			catch (Exception e) {
				System.err.print("ERRO NA NOTA. \n");
				scan.next();
				ok = true;
			}
		}
				
		// Pega o segundo número:
		ok = true;
		while (ok) {
			try {
				System.out.print("\nEntre com a SEGUNDA nota: ");
				n2 = scan.nextDouble();
				ok = false;
			}
			catch (Exception e) {
				System.err.print("ERRO NA NOTA. \n");
				scan.next();
				ok = true;
			}
		}
		
		// Pega o terceiro número:
		ok = true;
		while (ok) {
			try {
				System.out.print("\nEntre com a TERCEIRA nota: ");
				n3 = scan.nextDouble();
				ok = false;
			}
			catch (Exception e) {
				System.err.print("ERRO NA NOTA. \n");
				scan.next();
				ok = true;
			}
		}
		
		// Fecha o scanner
		scan.close();
		
		// Calcula média
		double ponderada = (n1*p1 + n2*p2 + n3*p3)/(p1+p2+p3);
		
		// Imprime resultado:
		System.out.printf("\nSuas notas foram %.2f, %.2f e %.2f. Sua média final foi de %.2f!", n1, n2, n3, ponderada);
		System.out.println("\n\nMoriturus te saluto.\n");

	} // fecha public static void main

} // fecha class
