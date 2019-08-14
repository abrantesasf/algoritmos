// Disciplina: Algoritmos 2, Ciência da Computação, FAESA
// Aula:       Tutorial de orientação à objetos no Java
// Aluno:      Abrantes Araújo Silva Filho
// Em:         2018-08-21
// Disponível em:
// https://github.com/abrantesasf/algoritmos/blob/master/faesa_algoritmos_2/eclipseWorkspace/Tarefas/src/pacote/tutorial/orientacao/oo/java/Funcoes.java

// Pacote específico para o tutorial de Orientação à Objetos no Java:
package pacote.tutorial.orientacao.oo.java;

// Classe para funcoes legais:
public class Funcoes {
	
	// Método para somar 2 doubles:
	public void somaValor(Double x, Double y) {
		System.out.println(x + " + " + y + " = " + (x + y));
	}
	
	// Método para somar 2 inteiros:
	public void somaValor(int x, int y) {
		System.out.println(x + " + " + y + " = " + (x + y));
	}
	
	// Método para somar reais em vetor de tamanho arbitrário
	public void somaValor(double[] x) {
		double resultado = 0.0;
		for (int i = 0; i < x.length; i++) {
			resultado = resultado + x[i];
		}
		System.out.println(imprimeArray(x, 'h') + (resultado));
	}
	
	// Método simplório para imprimir um array:
	// Imprime array na vertical se c = 'v', ou na horizontal se c != 'v'
	public String imprimeArray (double[] v, char c) {
		String texto = "";		
		if (c == 'v') {
			for (double numero : v) {
				System.out.println(numero);
			}
		} else {
			for (double numero : v) {
				if (texto.equals("")) {
					texto = Double.toString(numero);
				} else {
					texto = texto + " + " + Double.toString(numero);
				}
			}
		}
		texto = texto.substring(0, texto.length()) + " = ";
		return texto;
	}

} // fecha classe
