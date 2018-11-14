package revisao;

public class Programa {
	// Atributos
	static private Calculadora2 calc2;
	static private Calculadora3 calc3;

	public static void main(String[] args) {
		System.out.println("\nInstancia a Calculadora2 com os números 2 e 3:");
		calc2 = new Calculadora2(2, 3);
		
		System.out.println(calc2.toString());
		
		System.out.print("Soma: ");
		System.out.println(calc2.retornaSoma());
		
		System.out.print("Multiplicação: ");
		System.out.println(calc2.retornaMultiplicacao());
		
		System.out.println("\nInstancia a Calculadora3 com os números 2, 3 e 4:");
		calc3 = new Calculadora3(2, 3, 4);
		
		System.out.println(calc3.toString());
		
		System.out.print("Soma: ");
		System.out.println(calc3.retornaSoma());
		
		System.out.print("Multiplicação: ");
		System.out.println(calc3.retornaMultiplicacao());
		
	}

}
