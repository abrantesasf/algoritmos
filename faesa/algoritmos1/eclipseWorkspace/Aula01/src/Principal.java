// Importa o Scanner
import java.util.Scanner;


public class Principal {

	public static void main(String[] args) {
		// Declara Scanner
		Scanner scan = new Scanner(System.in);
		String nome;
		
		// Pega nome
		System.out.print("Informe seu nome: ");
		nome = scan.nextLine();
		scan.close();
		
		// Mostra nome
		System.out.println("\nOlá, " + nome + "!");
		System.out.println("Eu sou o Java, seu pior pesadelo!");
		System.out.println("Você achava R, C, Lisp ou Python complicados? Espere só para ver, kkkkkkk!");
	}

}
