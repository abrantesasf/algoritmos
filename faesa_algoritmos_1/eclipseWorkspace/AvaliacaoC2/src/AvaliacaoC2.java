// Algoritmo 1: avaliação C2
//   Professor: Howard Roatti
//       Aluno: Abrantes Araújo Silva Filho
//        Data: 2018-06-06

// Imports:
import java.util.Scanner;

// Classe Avaliacao_C2
public class AvaliacaoC2 {

	public static void main(String[] args) {
		
		///////////////////////////////////////////////////////////
		// Pergunta 1a:
		// Declaração de Variáveis
        ///////////////////////////////////////////////////////////
		int[] vetor = new int[100];
		int vInicial = 0;
		int vFinal = 0;
		int max = 0;
		int min = 0;
		double media = 0;
		
		
        ///////////////////////////////////////////////////////////
		// Pergunta 1b:
		// Solicita valores do usuário e preenche vetor
        ///////////////////////////////////////////////////////////
		
		// Declara Scanner para obter input do usuário
		Scanner scan = new Scanner(System.in);
		
		// Cria variável booleana para controle de loop com try-catch
		boolean ok = true;
		
		// Solicita o vInicial:
		while (ok) {
			System.out.println("Entre com um número INTEIRO inicial (1 ou mais): ");
			try {
				vInicial = scan.nextInt();
				if (vInicial < 1) {
					System.out.println("O número deve ser 1 ou mais. Digite novamente.\n");
					ok = true;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO: você não digitou um valor válido. Digite novamente.\n");
				ok = true;
				scan.next();
			}
		}
		
		// Solicita o vFinal:
		ok = true;
		while (ok) {
			System.out.println("Entre com um número INTEIRO final (maior do que o inicial): ");
			try {
				vFinal = scan.nextInt();
				if (vFinal <= vInicial) {
					System.out.println("O número final deve ser maior do que o inicial. Digite novamente.\n");
					ok = true;
				} else {
					ok = false;
				}				
			} catch (Exception e) {
				System.out.println("ERRO: você não digitou um valor válido. Digite novamente.\n");
				ok = true;
				scan.next();
			}
		}
		
		// Fecha o scan:
		scan.close();
		
		// Preenche vetor com a fórmula especificada
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) ((Math.random() * (vFinal - vInicial)) + vInicial);
		}
		
		
        ///////////////////////////////////////////////////////////
        // Pergunta 1c:
        // Encontra o maior e o menor valor armazenado no vetor
        ///////////////////////////////////////////////////////////
		
		// Acha o maior valor:
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] > max) {
				max = vetor[i];
			}
		}
			
		// Acha o menor valor:
		min = Integer.MAX_VALUE;
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] < min) {
				min = vetor[i];
			}			
		}
		
		
        ///////////////////////////////////////////////////////////
        // Pergunta 1d:
        // Calcula a média dos valores do vetor
        ///////////////////////////////////////////////////////////
		
		// Declara variável long para armazenar a soma, calcula a soma e a média:
		long soma = 0;
		for (int j = 0; j < vetor.length; j++) {
			soma = soma + (long) vetor[j];
		}
		media = (double) soma / vetor.length;
		
		
        ///////////////////////////////////////////////////////////
        // Pergunta 1e:
        // Imprime a média, min e max
        ///////////////////////////////////////////////////////////		
		System.out.printf("\n\nA média é: %.2f.\n", media);
		System.out.println("O maior valor é: " + max);
		System.out.println("O menor valor é: " + min);
		
		
        ///////////////////////////////////////////////////////////
        // Pergunta 1f:
        // Imprime os valores entre a média e max, em ordem inversa:
        ///////////////////////////////////////////////////////////
		System.out.println("\n\nValores entre a média e o maior valor (em ordem reversa - o número entre parênteses indica a posição no vetor):");
		for (int i = vetor.length - 1; i >= 0; i--) {
			if ((vetor[i] >= media) & (vetor[i] <= max)) {
				System.out.println(vetor[i] + "\t (" + i + ")");
			}
		}
		
		
        ///////////////////////////////////////////////////////////
        // Pergunta 1g:
        // Imprime os valores entre min e a média, em ordem normal
        ///////////////////////////////////////////////////////////		
		System.out.println("\n\nValores entre o menor valor e a média (em ordem normal - o número entre parênteses indica a posição no vetor):");
		for (int i = 0; i < vetor.length; i++) {
			if ((vetor[i] >= min) & (vetor[i] <= media)) {
				System.out.println(vetor[i] + "\t (" + i + ")");
			}
		}
		
		
		// Termina script
		System.out.println("\n\n\nMoriturus te saluto.");
		
	} // Fecha método main

} // Fecha classe Avaliacao_C2
