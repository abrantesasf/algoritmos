// Imports
import java.util.Scanner;

public class Exercicio19 {

	public static void main(String[] args) {
		// Variáveis
		boolean ok = true;
		int numero = 0;
		int centenas = 0;
		int dezenas = 0;
		int unidades = 0;
		int resto = 0;
		String centenasString = "";
		String dezenasString = "";
		String unidadesString = "";
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega o número (1 a 999)
		ok = true;
		while (ok) {
			try {
				System.out.print("Digite um número inteiro de 1 a 999: ");
				numero = scan.nextInt();
				if (numero < 1 || numero > 999) {
					System.out.println("Você não digitou um numero entre 1 a 999. Informe novamente.");
					ok = true;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Você não digitou um número inteiro válido. Informe novamente.");
				ok = true;
				scan.next();
			}
		}
		
		// Fecha Scanner
		scan.close();
		
		// Processamento
		// Identifica a quantidade de centenas, dezenas e unidades
		if (numero >= 100) {
			centenas = numero / 100;
			resto = numero % 100;
			dezenas = resto / 10;
			resto = resto % 10;
			unidades = resto;
		} else if (numero >= 10) {
			dezenas = numero / 10;
			resto = numero % 10;
			unidades = resto;
		} else {
			unidades = numero;
		}
		
		// Gera as strings corretas
		if (numero >= 100) {
			if (centenas == 1) {
				centenasString = "centena";
			} else {
				centenasString = "centenas";
			}
			if (dezenas == 1) {
				dezenasString = "dezena";
			} else {
				dezenasString = "dezenas";
			}
			if (unidades == 1) {
				unidadesString = "unidade";
			} else {
				unidadesString = "unidades";
			}
		} else if (numero >= 10) {
			if (dezenas == 1) {
				dezenasString = "dezena";
			} else {
				dezenasString = "dezenas";
			}
			if (unidades == 1) {
				unidadesString = "unidade";
			} else {
				unidadesString = "unidades";
			}
		} else {
			if (unidades == 1) {
				unidadesString = "unidade";
			} else {
				unidadesString = "unidades";
			}
		}
		
		// Imprime o resultado
		if (numero >= 100) {
			System.out.println(centenas + " " + centenasString + ", " + dezenas + " " + dezenasString + ", " + unidades + " " + unidadesString);
		} else if (numero >= 10) {
			System.out.println(dezenas + " " + dezenasString + ", " + unidades + " " + unidadesString);
		} else {
			System.out.println(unidades + " " + unidadesString);
		}
		
		System.out.println("\nMoriturus te saluto.");

	} // Fecha main

} // Fecha classe
