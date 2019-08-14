// Atividade de Revisão de Modularização
// Algoritmos 2
// Abrantes Araújo Silva Filho

// Imports
import java.util.Scanner;

public class PreencheVetor {

	public static void main(String[] args) {
		// Variáveis
		int qtdNumeros = 0;
		boolean ok = true;
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pergunta quantas posições terá o vetor
		while (ok) {
			try {
				System.out.println("Você quer um vetor de inteiros com quantas posições?:");
				qtdNumeros = scan.nextInt();
				if (qtdNumeros <= 0) {
					System.out.println("Erro: vetor 0 ou negativo. Informe um número INTEIRO >= 1:");
					ok = true;
					qtdNumeros = 0;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Você nao digitou um número válido.");
				ok = true;
				scan.next();
			}
		}
		
		// Cria vetor com a quantidade de posições informadas pelo usuário:
		int[] vetor = new int[qtdNumeros];
		
		// Preenche vetor:
		preencheVetor(vetor);
		
		// Mostra soma:
		System.out.println("A soma de todos os números do vetor é: " + somaVetor(vetor));
		
		// Fecha scanner
		scan.close();
		
		// Morre
		System.out.println("\nMoriturus te saluto.");

	} // fecha main
	
	// Método para preencher o vetor
	static void preencheVetor(int[] vetor) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < vetor.length; i++) {
			boolean ok = true;
			while (ok) {
				try {
					System.out.println("Informe o " + (i+1) + "º número:");
					vetor[i] = scan.nextInt();
					ok = false;
				} catch (Exception e) {
					System.out.println("Erro! Você não digitou um número válido. Informe novamente.");
					scan.next();
					ok = true;
				} // fecha try-catch
			} // fecha while
		} // fecha for
		
		// fecha scanner
		scan.close();
	} // fecha preencheVetor
	
	// Método para somar os valores do vetor
	static long somaVetor(int[] vetor) {
		long resultado = 0;
		for (int i = 0; i < vetor.length; i++) {
			resultado = resultado + vetor[i];
		}
		return resultado;
	}

} // fecha classe
