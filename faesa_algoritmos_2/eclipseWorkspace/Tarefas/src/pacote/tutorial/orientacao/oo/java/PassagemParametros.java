package pacote.tutorial.orientacao.oo.java;

public class PassagemParametros {
	
	// Variável da classe
	static int classeVar = 0;

	public static void main(String[] args) {
		// Variáveis para teste
		int a = 1;
		int b = 2;
		
		int[] vet = new int[2];
		vet[0] = 1;
		vet[1] = 2;
		
		System.out.println("Print FORA do método:   a = " + a + "; b = " + b);
		soma(a, b);		
		System.out.println("Print FORA do método:   a = " + a + "; b = " + b);
		
		System.out.println("\n\n");
		
		System.out.println("Print FORA do método:   a = " + vet[0] + "; b = " + vet[1]);
		soma(vet);
		System.out.println("Print FORA do método:   a = " + vet[0] + "; b = " + vet[1]);
		
		System.out.println(classeVar);
		classeVar = 9;
		System.out.println(classeVar);
		PassagemParametros.classeVar = 10;
		
	}
	
	// Método soma
	static void soma (int a, int b) {
		int temp = a;
		a = b;
		b = temp;
		System.out.println("Print DENTRO do método: a = " + a + "; b = " + b);
	}
	
	static void soma (int[] vet) {
		int temp = vet[0];
		vet[0] = vet[1];
		vet[1] = temp;
		System.out.println("Print DENTRO do método: a = " + vet[0] + "; b = " + vet[1]);
	}

}
