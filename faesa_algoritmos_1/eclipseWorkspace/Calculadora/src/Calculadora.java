// Importa Scanner
import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		// Declara Scanner
		Scanner scan = new Scanner(System.in);
		
		// Variáveis para receber os números
		double a = 0;
		double b = 0;
		
		// Pega o primeiro número:
		boolean ok = true;
		while (ok) {
			try {
				System.out.print("Entre com o PRIMEIRO número: ");
				a = scan.nextDouble();
				ok = false;
			}
			catch (Exception e) {
				System.err.print("ERRO NO NÚMERO. \n");
				scan.next();
				ok = true;
			}
		}
				
		// Pega o segundo número:
		ok = true;
		while (ok) {
			try {
				System.out.print("Entre com o SEGUNDO número: ");
				b = scan.nextDouble();
				ok = false;
			}
			catch (Exception e) {
				System.err.print("ERRO NO NÚMERO. \n");
				scan.next();
				ok = true;
			}
		}
		
		// Fecha o scanner
		scan.close();
		
		// Realiza cálculos
		double soma = a + b;
		double subt = a - b;
		double mult = a * b;
		double divi = 0;
		if (b != 0) {
			divi = a / b;
		}
		
		// Imprime resultados
		System.out.printf("\nVocê entrou com os números: %.2f e %.2f.%n", a, b);
		System.out.printf("A soma é %.2f%n", soma);
		System.out.printf("A subtração é %.2f%n", subt);
		System.out.printf("A multiplicação é %.2f%n", mult);
		if (b != 0) {
			System.out.printf("A divisão é %.2f%n", divi);
		}
		else {
			System.out.printf("Não há divisão pois o divisor é 0.");
		}
		System.out.println("Moriturus te Saluto!");

	}

}
