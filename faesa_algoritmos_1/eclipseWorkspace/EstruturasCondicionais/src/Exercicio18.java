// Imports
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Exercicio18 {

	public static void main(String[] args) {
		// Variáveis
		String stringData = "";
		Date data = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Pega data
		try {
			System.out.println("Digite uma data no formato DD/MM/YYYY:");
			stringData = scan.next();
			data = sdf.parse(stringData);
			System.out.println("Data válida!");
		} catch (Exception e) {
			System.out.println("Data inválida!");
		}
		
		// Fecha scanner:
		scan.close();
		
		System.out.println("\nMoriturus te saluto.");

	}

}
