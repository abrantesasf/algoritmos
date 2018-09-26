
public class Programa2 {

	public static void main(String[] args) {
		// Objetos
		Dado d1 = new Dado();
		Dado d2 = new Dado();
		
		// Resultado
		d1.rolar();
		d2.rolar();
		
		System.out.println(d1.retornarValor());
		System.out.println(d2.retornarValor());
		System.out.println(d1.retornarValor() + d2.retornarValor());

	}

}
