// Imports
import java.util.Scanner;

public class Exercicio21 {

	public static void main(String[] args) {
		// Variáveis
		boolean ok = true;
		int valorSaque = 0;
		int notas100 = 0;
		int notas50 = 0;
		int notas10 = 0;
		int notas5 = 0;
		int notas1 = 0;
		int valorRestante = 0;
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pergunta valor do saque:
		ok = true;
		while (ok) {
			try {
				System.out.print("Qual o valor do saque (valor inteiro entre 10 e 600): ");
				valorSaque = scan.nextInt();
				if (valorSaque < 10 || valorSaque > 600) {
					System.out.println("Você digitou um valor fora da faixa entre 10 e 600. Informe novamente.");
					ok = true;
				} else {
					ok = false;
				} // fecha if-else
			} catch (Exception e) {
				System.out.println("ERRO! Você não digitou um número válido. Informe novamente.");
				ok = true;
				scan.next();
			} // fecha try-catch
		} // fecha while
		
		// Fecha o Scanner
		scan.close();
		
		// Processamento:
		valorRestante = valorSaque;
		while (valorRestante >= 100) {
			notas100 += 1;
			valorRestante -= 100;
		}
		while (valorRestante >= 50) {
			notas50 += 1;
			valorRestante -= 50;
		}
		while (valorRestante >= 10) {
			notas10 += 1;
			valorRestante -= 10;
		}
		while (valorRestante >= 5) {
			notas5 += 1;
			valorRestante -= 5;
		}
		while (valorRestante >= 1) {
			notas1 += 1;
			valorRestante -= 1;
		}
		
		System.out.printf("\nVocê receberá R$ %3d com as seguintes notas:\n", valorSaque);
		if (notas100 > 0) {
			System.out.println(notas100 + " notas de R$ 100,00");
		}
		if (notas50 > 0) {
			System.out.println(notas50 + " notas de R$ 50,00");
		}
		if (notas10 > 0) {
			System.out.println(notas10 + " notas de R$ 10,00");
		}
		if (notas5 > 0) {
			System.out.println(notas5 + " notas de R$ 5,00");
		}
		if (notas1 > 0) {
			System.out.println(notas1 + " notas de R$ 1,00");
		}
		
		System.out.println("\nMoriturus te saluto.");

	} // fecha main

} // fecha classe
