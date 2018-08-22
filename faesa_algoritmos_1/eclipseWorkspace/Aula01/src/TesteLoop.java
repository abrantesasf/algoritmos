import java.util.Iterator;
import java.util.Scanner;

public class TesteLoop {

	public static void main(String[] args) {
		
		double[] vet = new double[100];
		Scanner scan = new Scanner(System.in);
		int qtd = 0;
		
		
		
		for (int i = 0; i < vet.length; i++) {
			System.out.println("Informe o " + (i+1) + "º número: ");
			vet[i] = scan.nextDouble();
			qtd = i + 1;
			if (vet[i] == 0) {
				break;
			}
		}
		
		System.out.println("Você digitou " + qtd + " número(s).");
		System.out.println("Os número digitados foram:");
		for (int i = 0; i < qtd; i++) {
			System.out.println(vet[i]);
		}


	} // fecha main

} // fecha class
