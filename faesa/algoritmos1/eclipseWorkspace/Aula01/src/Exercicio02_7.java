// Importa Scanner
import java.util.Scanner;

// Declara a classe
public class Exercicio02_7 {

	// Método main
	public static void main(String[] args) {
		
		// Variáveis
		float ponto1X = 0;
		float ponto1Y = 0;
		float ponto2X = 0;
		float ponto2Y = 0;
		boolean ok = true;
		double distancia = 0;
		
		// Cria objeto do Scanner
		Scanner scan = new Scanner(System.in);
		
		// Solicita P1X:
		ok = true;
		while (ok) {
			try {
				System.out.println("Digite a coordenada X do ponto 1:");
				ponto1X = scan.nextFloat();
				ok = false;
			} catch (Exception e) {
				System.out.println("\nERRO, o número digitado não é válido! Entre novamente:");
				scan.next();
				ok = true;
			}
		}
		
		// Solicita P1Y:
		ok = true;
		while (ok) {
			try {
				System.out.println("Digite a coordenada Y do ponto 1:");
				ponto1Y = scan.nextFloat();
				ok = false;
			} catch (Exception e) {
				System.out.println("\nERRO, o número digitado não é válido! Entre novamente:");
				scan.next();
				ok = true;
			}
		}		
		
		// Solicita P2X:
		ok = true;
		while (ok) {
			try {
				System.out.println("Digite a coordenada X do ponto 2:");
				ponto2X = scan.nextFloat();
				ok = false;
			} catch (Exception e) {
				System.out.println("\nERRO, o número digitado não é válido! Entre novamente:");
				scan.next();
				ok = true;
			}
		}

		// Solicita P2Y:
		ok = true;
		while (ok) {
			try {
				System.out.println("Digite a coordenada Y do ponto 2:");
				ponto2Y = scan.nextFloat();
				ok = false;
			} catch (Exception e) {
				System.out.println("\nERRO, o número digitado não é válido! Entre novamente:");
				scan.next();
				ok = true;
			}
		}		
		
		// Fecha o Scanner
		scan.close();
		
		// Calcula a distância entre os pontos
		distancia = Math.sqrt(Math.pow((ponto2X - ponto1X), 2) + Math.pow((ponto2Y - ponto1Y), 2));
		
		// Retorna o resultado
		System.out.printf("\nA distância entre os pontos P1(" + ponto1X + " , " + ponto1Y + ") e P2(" + ponto2X + " , " + ponto2Y + ") é: %.5f.", distancia);
		
		// Adeus
		System.out.println("\n\nMoriturus te saluto.");
		

	} // Fecha método main

} // Fecha classe
