// Atividade de Revisão de Modularização
// Algoritmos 2
// Abrantes Araújo Silva Filho

// Imports
import java.util.Scanner;

public class Matrizes {

	public static void main(String[] args) {
		// Variáveis
		int nLinhas1 = 0;
		int nColunas1 = 0;
		int nLinhas2 = 0;
		int nColunas2 = 0;
		boolean ok = true;
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pergunta a ordem da primeira matriz
		while (ok) {
			try {
				System.out.println("Quantas LINHAS a PRIMEIRA matriz tem?");
				nLinhas1 = scan.nextInt();
				if (nLinhas1 <= 0) {
					System.out.println("Erro: o número de linhas precisa ser >= 1. Informe novamente:");
					ok = true;
					nLinhas1 = 0;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Você nao digitou um número válido.");
				ok = true;
				scan.next();
			}
		}
		ok = true;
		while (ok) {
			try {
				System.out.println("Quantas COLULNAS a PRIMEIRA matriz tem?");
				nColunas1 = scan.nextInt();
				if (nColunas1 <= 0) {
					System.out.println("Erro: o número de colunas precisa ser >= 1. Informe novamente:");
					ok = true;
					nColunas1 = 0;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Você nao digitou um número válido.");
				ok = true;
				scan.next();
			}
		}
		
		// Pergunta a ordem da segunda matriz
		ok = true;
		while (ok) {
			try {
				System.out.println("Quantas LINHAS a SEGUNDA matriz tem?");
				nLinhas2 = scan.nextInt();
				if (nLinhas2 <= 0) {
					System.out.println("Erro: o número de linhas precisa ser >= 1. Informe novamente:");
					ok = true;
					nLinhas2 = 0;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Você nao digitou um número válido.");
				ok = true;
				scan.next();
			}
		}
		ok = true;
		while (ok) {
			try {
				System.out.println("Quantas COLULNAS a SEGUNDA matriz tem?");
				nColunas2 = scan.nextInt();
				if (nColunas2 <= 0) {
					System.out.println("Erro: o número de colunas precisa ser >= 1. Informe novamente:");
					ok = true;
					nColunas2 = 0;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Você nao digitou um número válido.");
				ok = true;
				scan.next();
			}
		}		
		
		// Cria as matrizes com as ordens informadas:
		int[][] matriz1 = new int[nLinhas1][nColunas1];
		int[][]	matriz2 = new int[nLinhas2][nColunas2];
		
		System.out.println("\n\nAgora vamos preencher a PRIMEIRA matriz:");
		System.out.println("----------------------------------------");
		
		// Preenche a PRIMEIRA MATRIZ:
		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz1[0].length; j++) {
				ok = true;
				while (ok) {
					try {
						System.out.println("Informe o elemento m" + (i+1)+(j+1) + " da PRIMEIRA matriz:");
						matriz1[i][j] = scan.nextInt();
						ok = false;
					} catch (Exception e) {
						System.out.println("ERRO no input! Tente novamente:");
						scan.next();
						ok = true;
					}
				}
			}
		}
		
		System.out.println("\n\nAgora vamos preencher a SEGUNDA matriz:");
		System.out.println("----------------------------------------");

		// Preenche a SEGUNDA MATRIZ:
		for (int i = 0; i < matriz2.length; i++) {
			for (int j = 0; j < matriz2[0].length; j++) {
				ok = true;
				while (ok) {
					try {
						System.out.println("Informe o elemento m" + (i+1)+(j+1) + " da SEGUNDA matriz:");
						matriz2[i][j] = scan.nextInt();
						ok = false;
					} catch (Exception e) {
						System.out.println("ERRO no input! Tente novamente:");
						scan.next();
						ok = true;
					}
				}
			}
		}
		
		// Mostra as matrizes originais:
		System.out.println("\n\nAgora vamos ver as matrizes originais:");
		System.out.println("---------------------------------------");
		
		System.out.println("\nMatriz 1 (ordem " + matriz1.length + "x" + matriz1[0].length +"):");
		imprimeMatriz(matriz1);
		
		System.out.println("\nMatriz 2 (ordem " + matriz2.length + "x" + matriz2[0].length +"):");
		imprimeMatriz(matriz2);
		
		// Calcula a soma, se possível, e exibe a matriz resultante:
		System.out.println("\nQual a soma das matrizes?");
		System.out.println("-------------------------");
		somaMatrizes(matriz1, matriz2);
		
		// Calcula o produto, se possível, e exebe a matriz resultante:
		System.out.println("\nQual o produto das matrizes?");
		System.out.println("----------------------------");
		multiplicaMatrizes(matriz1, matriz2);
		
		// Fecha scan
		scan.close();
		
		// Morre:
		System.out.println("\nMoriturus te saluto.");
		
	} // fecha main
	
	// Método para somar matrizes:
	static void somaMatrizes(int[][] matriz1, int[][] matriz2) {
		// Verifica se as matrizes podem ser somadas:
		if ((! (matriz1.length == matriz1.length)) || (! (matriz1[0].length == matriz2[0].length))) {
			System.out.println("As matrizes NÃO SÃO da mesma ordem, não podem ser somadas.");
		} else {
			int[][] matriz3 = new int[matriz1.length][matriz1[0].length];
			for (int i = 0; i < matriz3.length; i++) {
				for (int j = 0; j < matriz3[0].length; j++) {
					matriz3[i][j] = matriz1[i][j] + matriz2[i][j];
				}
			}
			// Imprime matriz soma:
			System.out.println("A matriz soma resultante é:");
			imprimeMatriz(matriz3);
		}
	} // fecha método somaMatrizes
	
	
	// Método para pegar coluna do array
	// https://stackoverflow.com/questions/30426909/get-columns-from-two-dimensional-array-in-java
	static int[] pegaColuna(int[][] temp, int indice) {
		int[] coluna = new int[temp[0].length];
		for (int i = 0; i < coluna.length; i++) {
			coluna[i] = temp[i][indice];
		}
		return coluna;
	}
	
	static int[] pegaLinha(int[][] temp, int indice) {
		int[] linha = new int[temp.length];
		for (int i = 0; i < linha.length; i++) {
			linha[i] = temp[indice][i];
		}
		return linha;
	} 
	
	// Método para multiplicar matrizes:
	static void multiplicaMatrizes(int[][] matriz1, int[][] matriz2) {
		// Verifica se as matrizes podem ser multiplicadas
		if (! (matriz1[0].length == matriz2.length) ) {
			System.out.println("As matrizes NÃO PODEM SER MULTIPLICADAS.");
		} else {
			int[][] matriz3 = new int[matriz1.length][matriz2[0].length];
				for (int i = 0; i < matriz3.length; i++) {
					for (int j = 0; j < matriz3[0].length; j++) {
						int [] linha = pegaLinha(matriz1, i);
						int [] coluna = pegaColuna(matriz2, i);
						
					}
				}
			// Imprime matriz produto:
			System.out.println("A matriz produto resultante é:");
			imprimeMatriz(matriz3);
		}
	}
	
	// Método para imprimir a matriz:
	static void imprimeMatriz(int[][] matrizp) {
		for (int i = 0; i < matrizp.length; i++) {
			for (int j = 0; j < matrizp[0].length; j++) {
				System.out.print(matrizp[i][j]+"\t");
			}
			System.out.println("");
		}		
	} // fecha método imprimeMatriz

} // fecha class
