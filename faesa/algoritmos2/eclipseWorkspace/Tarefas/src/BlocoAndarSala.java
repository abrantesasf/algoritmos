// Tarefa da disciplina de Algoritmo 2, Ciência da Computação, FAESA
// Aluno: Abrantes Araújo Silva Filho
// Em: 2018-08-07
// Disponível em:
// https://github.com/abrantesasf/algoritmos/blob/master/faesa_algoritmos_2/eclipseWorkspace/Tarefas/src/BlocoAndarSala.java

// Imports
import java.util.Scanner;

// Classe
public class BlocoAndarSala {

	public static void main(String[] args) {
		// Para receber input do usuário
		int numero = 0;
		Scanner scan = new Scanner(System.in);
		
		// Cotrole de loops
		boolean ok = true;
		
		// Pega input do usuário
		while (ok) {
			try {
				System.out.print("\nDigite um número INTEIRO entre 111 e 999, cujo algarismo\nda dezena e o algarismo da unidade sejam diferentes de 0: ");
				numero = scan.nextInt();				
				if (checaNumero(numero)) {
					ok = false;
				} else {
					System.out.print("\nVocê não digitou um número válido. Por favor, informe novamente.");
					ok = true;
				}				
			} catch (Exception e) {
				System.out.print("\nERRO! Você não digitou um INTEIRO entre 111 e 999.");
				scan.next();
				ok = true;
			}
		}
		
		// Fecha scan:
		scan.close();
		
		// Retorna
		System.out.println("\nInstruções de localização:");
		System.out.println("Bloco: " + Integer.toString(numero).substring(0, 1));
		System.out.println("Andar: " + Integer.toString(numero).substring(1, 2));
		System.out.println("Sala:  " + Integer.toString(numero).substring(2, 3));
		
		// Morre
		System.out.println("\n\nMoriturus te saluto.");

	} // fecha main
	
	// Método para checagem básica do número
	public static boolean checaNumero(int n) {
		boolean retorno = true;
		if ((n < 111) || (n > 999)) {
			retorno = false;
		} else if (Integer.toString(n).substring(1, 2).equals("0")
				  ||
				   Integer.toString(n).substring(2, 3).equals("0")) {
			retorno = false;
		} else {
			retorno = true;
		}
		return retorno;
	}

} // fecha classe
