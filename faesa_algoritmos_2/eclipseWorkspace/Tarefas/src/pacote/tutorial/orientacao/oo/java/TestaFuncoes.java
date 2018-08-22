// Disciplina: Algoritmos 2, Ciência da Computação, FAESA
// Aula:       Tutorial de orientação à objetos no Java
// Aluno:      Abrantes Araújo Silva Filho
// Em:         2018-08-21
// Disponível em:
// https://github.com/abrantesasf/algoritmos/blob/master/faesa_algoritmos_2/eclipseWorkspace/Tarefas/src/pacote/tutorial/orientacao/oo/java/TestaFuncoes.java

// Pacote específico para o tutorial de Orientação à Objetos no Java:
package pacote.tutorial.orientacao.oo.java;

// Imports:
import java.util.Scanner;

// Classe para testes:
public class TestaFuncoes {

	// Método Main da classe:
	public static void main(String[] args) {
		// Instancia classe de funções:
		Funcoes funcoes = new Funcoes();
		
		// Instancia scanner:
		Scanner scan = new Scanner(System.in);
		
		// Variáveis para teste:
		double doubleX = 0;
		double doubleY = 0;
		int intX = 0;
		int intY = 0;
		
		// Variáveis para controle e contagem de loops:
		boolean ok = true;
		int contador = 1;
		
		// Pega números inteiros:
		while ((ok) && (contador <= 2)) {
			try {
				System.out.println("Digite o " + contador + "º número inteiro: ");
				if (contador == 1) {
					intX = scan.nextInt();
					contador = contador + 1;
				} else {
					intY = scan.nextInt();
					contador = contador + 1;
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ENTRADA INVÁLIDA! Tente novamente:");
				scan.next();
				ok = true;
			}
		}
		
		// Pega números reais:
		ok = true;
		contador = 1;
		while ((ok) && (contador <= 2)) {
			try {
				System.out.println("Digite o " + contador + "º número real: ");
				if (contador == 1) {
					doubleX = scan.nextDouble();
					contador = contador + 1;
				} else {
					doubleY = scan.nextDouble();
					contador = contador + 1;
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("\nENTRADA INVÁLIDA! Tente novamente:");
				scan.next();
				ok = true;
			}
		}
		
		// Imprime os resultados:
		System.out.println("\nSoma de inteiros:");
		funcoes.somaValor(intX, intY);
		
		System.out.println("\nSoma de reais:");
		funcoes.somaValor(doubleX, doubleY);
		
		// Fecha scanner:
		scan.close();
		
		// Morre:
		System.out.println("\n\nMoriturus te saluto.");

	} // fecha método main

} // fecha classe TestaFuncoes
