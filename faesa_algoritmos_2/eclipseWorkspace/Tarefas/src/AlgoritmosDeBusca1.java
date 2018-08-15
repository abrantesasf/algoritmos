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
		
		// Variáveis para marcar o tempo (serão atualizadas através do
		// método pegarTempo():
		long inicio;
		long tempoGasto;
		
		// Criação de listas de números aleatórios, com 11, 21 e 42 elementos
		// Na lista11, buscar pelos números: 33, 2 e 99
		int[] lista11 = {48, 33, 24, 36, 41, 2, 23, 32, 50, 34, 28};
		// Na lista21, buscar pelos números: 3, 5 e 99
		int[] lista21 = {32, 3, 41, 2, 22, 42, 33, 17, 7, 39, 5, 35, 10, 45, 30, 9, 49, 36, 29, 43, 47};
		// Na lista42, buscar pelos números: 36, 19 e 99
		int[] lista42 = {44, 36, 14, 3, 2, 15, 23, 8, 31, 9, 43, 24, 16, 50, 27, 17, 18, 21, 1, 22, 19, 5, 30, 38, 37, 42, 20, 32, 7, 49, 28, 25, 35, 34, 29, 47, 10, 39, 12, 4, 13, 41};
		
		// Teste inicial do método buscaSequencial():
		inicio = pegarTempo();
		System.out.println(buscaSequencial(lista42, 99));
		tempoGasto = pegarTempo() - inicio;
		System.out.println(tempoGasto);

	} // fecha o método Main
	
	// Método para realizar a busca sequencial
	// Retorna (indice+1) se x existe em v, ou -1 caso contrário
	public static int buscaSequencial (int[] v, int x) {
		int indice = -1;
		for (int i = 0; i < v.length; i++) {
			if (v[i] == x) {
				indice = (i + 1);
				break;
			}
		} 
		return (indice);
	}
	
	// Método para pegar o tempo
	public static long pegarTempo() {
		return System.currentTimeMillis();
	}

} // Fecha a classe
