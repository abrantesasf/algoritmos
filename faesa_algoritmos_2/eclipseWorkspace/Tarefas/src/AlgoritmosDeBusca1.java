import java.util.Arrays;

// Tarefa da disciplina de Algoritmo 2, Ciência da Computação, FAESA
// Alunos: Abrantes Araújo Silva Filho
//         Renata Fanzeres
// Em: 2018-08-14
// Disponível em:
// https://github.com/abrantesasf/algoritmos/blob/master/faesa_algoritmos_2/eclipseWorkspace/Tarefas/src/AlgoritmosDeBusca1.java


// Classe
public class AlgoritmosDeBusca1 {

	// Método Main
	public static void main(String[] args) {
		
		// Criação de listas de números com 11, 21 e 42 elementos. Listas com final
		// "a" são aleatórias, e listas com final "o" são ordenadas.
		int[] lista11a = new int[]{48, 33, 24, 36, 41, 2, 23, 32, 50, 34, 28};
		int[] lista11o = new int[11];
		System.arraycopy(lista11a, 0, lista11o, 0, lista11a.length);
		Arrays.sort(lista11o);
		
		int[] lista21a = new int[]{32, 3, 41, 2, 22, 42, 33, 17, 7, 39, 5, 35, 10, 45, 30, 9, 49, 36, 29, 43, 47};
		int[] lista21o = new int[21];
		System.arraycopy(lista21a, 0, lista21o, 0, lista21a.length);
		Arrays.sort(lista21o);
		
		int[] lista42a = new int[]{44, 36, 14, 3, 2, 15, 23, 8, 31, 9, 43, 24, 16, 50, 27, 17, 18, 21, 1, 22, 19, 5, 30, 38, 37, 42, 20, 32, 7, 49, 28, 25, 35, 34, 29, 47, 10, 39, 12, 4, 13, 41};
		int[] lista42o = new int[42];
		System.arraycopy(lista42a, 0, lista42o, 0, lista42a.length);
		Arrays.sort(lista42o);
		
		System.out.println("Estudo sobre algoritmos de busca: comparação de busca linear e binária.");
		System.out.println("\nArrays para testes: ");
		System.out.print("Array de 11 elementos, aleatório: ");
		imprimeArray(lista11a, 'h');
		System.out.print("Array de 11 elementos, ordenado:  ");
		imprimeArray(lista11o, 'h');
		System.out.print("\nArray de 21 elementos, aleatório: ");
		imprimeArray(lista21a, 'h');
		System.out.print("Array de 21 elementos, ordenado:  ");
		imprimeArray(lista21o, 'h');
		System.out.print("\nArray de 42 elementos, aleatório: ");
		imprimeArray(lista42a, 'h');
		System.out.print("Array de 42 elementos, ordenado:  ");
		imprimeArray(lista42o, 'h');
		
		// Vetores de resultado para buscaBinariaComContador:
		int[] resultadoBusca = new int[3];
		
		// BUSCA BINÁRIA COM CONTADOR, ARRAYS com 11 posições:
		System.out.println("\n\nBusca Binária com Contador em array ordenado de 11 elementos, posição 2 (n.º 23):");
		resultadoBusca = buscaBinariaComContador(lista11o, 23);
		System.out.print("{Posição, Contador While, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Binária com Contador em array ordenado de 11 elementos, posição 6 (n.º 33):");
		resultadoBusca = buscaBinariaComContador(lista11o, 33);
		System.out.print("{Posição, Contador While, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Binária com Contador em array ordenado de 11 elementos, posição inexistente (n.º 99):");
		resultadoBusca = buscaBinariaComContador(lista11o, 99);
		System.out.print("{Posição, Contador While, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
		
		// BUSCA BINÁRIA COM CONTADOR, ARRAYS com 21 posições:
		System.out.println("\nBusca Binária com Contador em array ordenado de 21 elementos, posição 2 (n.º 3):");
		resultadoBusca = buscaBinariaComContador(lista21o, 3);
		System.out.print("{Posição, Contador While, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Binária com Contador em array ordenado de 21 elementos, posição 11 (n.º 32):");
		resultadoBusca = buscaBinariaComContador(lista21o, 32);
		System.out.print("{Posição, Contador While, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Binária com Contador em array ordenado de 21 elementos, posição inexistente (n.º 99):");
		resultadoBusca = buscaBinariaComContador(lista21o, 99);
		System.out.print("{Posição, Contador While, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
		
		// BUSCA BINÁRIA COM CONTADOR, ARRAYS com 42 posições:
		System.out.println("\nBusca Binária com Contador em array ordenado de 42 elementos, posição 2 (n.º 2):");
		resultadoBusca = buscaBinariaComContador(lista42o, 2);
		System.out.print("{Posição, Contador While, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
				
		System.out.println("\nBusca Binária com Contador em array ordenado de 42 elementos, posição 21 (n.º 23):");
		resultadoBusca = buscaBinariaComContador(lista42o, 23);
		System.out.print("{Posição, Contador While, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
				
		System.out.println("\nBusca Binária com Contador em array ordenado de 42 elementos, posição inexistente (n.º 99):");
		resultadoBusca = buscaBinariaComContador(lista42o, 99);
		System.out.print("{Posição, Contador While, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
		
		// BUSCA SEQUENCIAL COM CONTADOR, ARRAYS com 11 posições:
		System.out.println("\n\nBusca Sequencial com Contador em array aleatório de 11 elementos, posição 2 (n.º 33):");
		resultadoBusca = buscaSequencialComContador(lista11a, 33);
		System.out.print("{Posição, Contador For, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Sequencial com Contador em array aleatório de 11 elementos, posição 6 (n.º 2):");
		resultadoBusca = buscaSequencialComContador(lista11a, 2);
		System.out.print("{Posição, Contador For, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Sequencial com Contador em array aleatório de 11 elementos, posição inexistente (n.º 99):");
		resultadoBusca = buscaSequencialComContador(lista11a, 99);
		System.out.print("{Posição, Contador For, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
		
		// BUSCA SEQUENCIAL COM CONTADOR, ARRAYS com 21 posições:
		System.out.println("\nBusca Sequencial com Contador em array aleatório de 21 elementos, posição 2 (n.º 3):");
		resultadoBusca = buscaSequencialComContador(lista21a, 3);
		System.out.print("{Posição, Contador For, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Sequencial com Contador em array aleatório de 21 elementos, posição 11 (n.º 5):");
		resultadoBusca = buscaSequencialComContador(lista21a, 5);
		System.out.print("{Posição, Contador For, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Sequencial com Contador em array aleatório de 21 elementos, posição inexistente (n.º 99):");
		resultadoBusca = buscaSequencialComContador(lista21a, 99);
		System.out.print("{Posição, Contador For, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
		
		// BUSCA SEQUENCIAL COM CONTADOR, ARRAYS com 42 posições:
		System.out.println("\nBusca Sequencial com Contador em array aleatório de 42 elementos, posição 2 (n.º 36):");
		resultadoBusca = buscaSequencialComContador(lista42a, 36);
		System.out.print("{Posição, Contador For, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Sequencial com Contador em array aleatório de 42 elementos, posição 21 (n.º 19):");
		resultadoBusca = buscaSequencialComContador(lista42a, 19);
		System.out.print("{Posição, Contador For, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Sequencial com Contador em array aleatório de 42 elementos, posição inexistente (n.º 99):");
		resultadoBusca = buscaSequencialComContador(lista42a, 99);
		System.out.print("{Posição, Contador For, Contador IF} = ");
		imprimeArray(resultadoBusca, 'h');		
		
		// BUSCA BINÁRIA COM TEMPORIZADOR, ARRAYS com 11 posições:
		System.out.println("\n\nBusca Binária com Temporizador em array ordenado de 11 elementos, posição 2 (n.º 23):");
		resultadoBusca = buscaBinariaComTemporizador(lista11o, 23);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Binária com Temporizador em array ordenado de 11 elementos, posição 6 (n.º 33):");
		resultadoBusca = buscaBinariaComTemporizador(lista11o, 33);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Binária com Temporizador em array ordenado de 11 elementos, posição inexistente (n.º 99):");
		resultadoBusca = buscaBinariaComTemporizador(lista11o, 99);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
		
		// BUSCA BINÁRIA COM TEMPORIZADOR, ARRAYS com 21 posições:
		System.out.println("\nBusca Binária com Temporizador em array ordenado de 21 elementos, posição 2 (n.º 3):");
		resultadoBusca = buscaBinariaComTemporizador(lista21o, 3);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Binária com Temporizador em array ordenado de 21 elementos, posição 11 (n.º 32):");
		resultadoBusca = buscaBinariaComTemporizador(lista21o, 32);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Binária com Temporizador em array ordenado de 21 elementos, posição inexistente (n.º 99):");
		resultadoBusca = buscaBinariaComTemporizador(lista21o, 99);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
		
		// BUSCA BINÁRIA COM TEMPORIZADOR, ARRAYS com 42 posições:
		System.out.println("\nBusca Binária com Temporizador em array ordenado de 42 elementos, posição 2 (n.º 2):");
		resultadoBusca = buscaBinariaComTemporizador(lista42o, 2);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
				
		System.out.println("\nBusca Binária com Temporizador em array ordenado de 42 elementos, posição 21 (n.º 23):");
		resultadoBusca = buscaBinariaComTemporizador(lista42o, 23);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
				
		System.out.println("\nBusca Binária com Temporizador em array ordenado de 42 elementos, posição inexistente (n.º 99):");
		resultadoBusca = buscaBinariaComTemporizador(lista42o, 99);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
		
		// BUSCA SEQUENCIAL COM TEMPORIZADOR, ARRAYS com 11 posições:
		System.out.println("\n\nBusca Sequencial com Temporizador em array aleatório de 11 elementos, posição 2 (n.º 33):");
		resultadoBusca = buscaSequencialComTemporizador(lista11a, 33);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Sequencial com Temporizador em array aleatório de 11 elementos, posição 6 (n.º 2):");
		resultadoBusca = buscaSequencialComTemporizador(lista11a, 2);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Sequencial com Temporizador em array aleatório de 11 elementos, posição inexistente (n.º 99):");
		resultadoBusca = buscaSequencialComTemporizador(lista11a, 99);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
		
		// BUSCA SEQUENCIAL COM TEMPORIZADOR, ARRAYS com 21 posições:
		System.out.println("\nBusca Sequencial com Temporizador em array aleatório de 21 elementos, posição 2 (n.º 3):");
		resultadoBusca = buscaSequencialComTemporizador(lista21a, 3);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Sequencial com Temporizador em array aleatório de 21 elementos, posição 11 (n.º 5):");
		resultadoBusca = buscaSequencialComTemporizador(lista21a, 5);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Sequencial com Temporizador em array aleatório de 21 elementos, posição inexistente (n.º 99):");
		resultadoBusca = buscaSequencialComTemporizador(lista21a, 99);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
		
		// BUSCA SEQUENCIAL COM TEMPORIZADOR, ARRAYS com 42 posições:
		System.out.println("\nBusca Sequencial com Temporizador em array aleatório de 42 elementos, posição 2 (n.º 36):");
		resultadoBusca = buscaSequencialComTemporizador(lista42a, 36);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Sequencial com Temporizador em array aleatório de 42 elementos, posição 21 (n.º 19):");
		resultadoBusca = buscaSequencialComTemporizador(lista42a, 19);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');
		
		System.out.println("\nBusca Sequencial com Temporizador em array aleatório de 42 elementos, posição inexistente (n.º 99):");
		resultadoBusca = buscaSequencialComTemporizador(lista42a, 99);
		System.out.print("{Posição, Tempo Gasto, <zero>} = ");
		imprimeArray(resultadoBusca, 'h');		

		// Morre
		morre();

	} // fecha o método Main
	
	// Método para realizar a busca sequencial
	// Retorna (indice+1) se x existe em v, ou -1 caso contrário
	public static int[] buscaSequencialComContador (int[] v, int x) {
		// Contadores
		int contadorFor = 0;
		int contadorIf = 0;
				
		// Vetor retorno
		int[] vetorRetorno = new int[3];
		
		for (int i = 0; i < v.length; i++) {
			contadorFor = contadorFor + 1;
			contadorIf = contadorIf + 1;
			if (v[i] == x) {
				vetorRetorno[0] = i + 1;
				vetorRetorno[1] = contadorFor;
				vetorRetorno[2] = contadorIf;
				return vetorRetorno;
			}
		}
		vetorRetorno[0] = -1;
		vetorRetorno[1] = contadorFor;
		vetorRetorno[2] = contadorIf;
		return vetorRetorno;
	}
	
	// Método para realizar a busca sequencial com temporizador
	// Retorna (indice+1) se x existe em v, ou -1 caso contrário
	public static int[] buscaSequencialComTemporizador (int[] v, int x) {
		// Pega time inicial
		long timeInicio = 0;
		timeInicio = pegaTempo();
		long timeFinal = 0;
		long tempoGasto = 0;
		// Delay de 1 segundo
		//pausa(1);
				
		// Vetor retorno
		int[] vetorRetorno = new int[3];
		
		for (int i = 0; i < v.length; i++) {
			if (v[i] == x) {
				vetorRetorno[0] = i + 1;
				timeFinal = pegaTempo();
				tempoGasto = timeFinal - timeInicio;
				vetorRetorno[1] = (int)tempoGasto;
				vetorRetorno[2] = 0;
				return vetorRetorno;
			}
		}
		vetorRetorno[0] = -1;
		timeFinal = pegaTempo();
		tempoGasto = timeFinal - timeInicio;
		vetorRetorno[1] = (int)tempoGasto;
		vetorRetorno[2] = 0;
		return vetorRetorno;
	}
	
	// Método para binary search, implementada 
	// conforme "Algorithms Unlocked", de Thomas H. Cormen, páginas 28-31. 
	// Retorna array com 3 elementos:
	//    1º elemento = (indice + 1), se x existe em v, ou -1 caso contrário
	//    2º elemento = contadorWhile
	//    3º elemento = contadorIf
	public static int[] buscaBinariaComContador (int[] v, int x) {
		// Contadores
		int contadorWhile = 0;
		int contadorIf = 0;
		
		// Vetor retorno
		int[] vetorRetorno = new int[3];
		
		// Índices de controle para a binary search:
		int p = 0;
		int r = v.length - 1;
		int q = 0;
		
		while (p <= r) {
			contadorWhile = contadorWhile + 1;
			
			q = (p + r)/2;
			
			contadorIf = contadorIf + 1;
			if (v[q] == x) {
				vetorRetorno[0] = (q + 1);
				vetorRetorno[1] = contadorWhile;
				vetorRetorno[2] = contadorIf;
				return vetorRetorno;
			} else {
				if (v[q] > x) {
					r = (q - 1);
				} else {
					p = q + 1;
				}
			}
		}
		vetorRetorno[0] = -1;
		vetorRetorno[1] = contadorWhile;
		vetorRetorno[2] = contadorIf;
		return vetorRetorno;
	}
	
	// Método para binary search com temporizador, implementada 
	// conforme "Algorithms Unlocked", de Thomas H. Cormen, páginas 28-31. 
	// Retorna array com 3 elementos:
	//    1º elemento = (indice + 1), se x existe em v, ou -1 caso contrário
	//    2º elemento = contadorWhile
	//    3º elemento = contadorIf
	public static int[] buscaBinariaComTemporizador (int[] v, int x) {
		// Pega time inicial
		long timeInicio = 0;
		timeInicio = pegaTempo();
		long timeFinal = 0;
		long tempoGasto = 0;
		// Delay de 1 segundo
		//pausa(1);
		
		// Vetor retorno
		int[] vetorRetorno = new int[3];
		
		// Índices de controle para a binary search:
		int p = 0;
		int r = v.length - 1;
		int q = 0;
		
		while (p <= r) {
			q = (p + r)/2;
			
			if (v[q] == x) {
				vetorRetorno[0] = (q + 1);
				timeFinal = pegaTempo();
				tempoGasto = timeFinal - timeInicio;
				vetorRetorno[1] = (int)tempoGasto;
				vetorRetorno[2] = 0;
				return vetorRetorno;
			} else {
				if (v[q] > x) {
					r = (q - 1);
				} else {
					p = q + 1;
				}
			}
		}
		vetorRetorno[0] = -1;
		timeFinal = pegaTempo();
		tempoGasto = timeFinal - timeInicio;
		vetorRetorno[1] = (int)tempoGasto;
		vetorRetorno[2] = 0;
		return vetorRetorno;
	}	
	
	// Método para pegar o tempo
	public static long pegaTempo() {
		return System.nanoTime();
	}
	
	// Método simplório para imprimir um array de inteiros.
	// Imprime array na vertical se c = 'v', ou na horizontal se c != 'v'
	public static void imprimeArray (int[] v, char c) {
		String texto = "";		
		if (c == 'v') {
			for (int numero : v) {
				System.out.println(numero);
			}
		} else {
			for (int numero : v) {
				if (texto.equals("")) {
					texto = Integer.toString(numero);
				} else {
					texto = texto + ", " + Integer.toString(numero);
				}
			}
			System.out.println("{" + texto + "}");
		}
	}
	
	// Morre
	public static void morre() {
		System.out.println("\nMoriturus te saluto.\n");
	}
	
	// Função para delay (input = qtd de segundos para delay):
	public static void pausa(int s) {
		try {
			Thread.sleep(s * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

} // Fecha a classe
