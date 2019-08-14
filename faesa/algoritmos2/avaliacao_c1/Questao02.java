import java.util.*;

public class MediaPonderada {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao;
		double[] notas = new double[3];

		System.out.println("Informe a nota 1");
		notas[0] = scan.nextDouble();
		System.out.println("Informe a nota 2");
		notas[1] = scan.nextDouble();
		System.out.println("Informe a nota 3");
		notas[2] = scan.nextDouble();

		opcao = menu();
		do {
			switch (opcao) {
			case 1:
				System.out.println("A maior nota foi " + maiorNota(notas));
				break;
			case 2:
				System.out.println("A menor nota foi " + menorNota(notas));
				break;
			case 3:
				System.out.println("Média: " +mediaAluno(notas));
				break;
			case 4:
				imprimirMedia(notas);
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
			opcao = menu();
		} while (opcao != 0);

	}

	public static int menu() {
		System.out.println("Escolha uma das opções: " + 
				"\n1 - Obter maior nota" + 
				"\n2 - Obter menor nota"+ 
				"\n3 - Calcular média do aluno" + 
				"\n4 - Mostrar média" + 
				"\n0 - Sair" + 
				"Opcão: ");
		return scan.nextInt();
	}

	public static double maiorNota(double[] notas) {
		double maior = notas[0];
		for (int i = 1; i < notas.length; i++) {
			if (notas[i] > maior) {
				maior = notas[i];
			}
		}
		return maior;
	}

	public static double menorNota(double[] notas) {
		double menor = notas[0];
		for (int i = 1; i < notas.length; i++) {
			if (notas[i] < menor) {
				menor = notas[i];
			}
		}
		return menor;
	}

	public static double mediaAluno(double notas[]) {
		double media;
		
		media = ((menorNota(notas) * 3) + (maiorNota(notas) * 7)) / 10;
		return media;
	}

	public static void imprimirMedia(double notas[]) {
		System.out.println("A média do aluno é " + mediaAluno(notas));
	}

}
