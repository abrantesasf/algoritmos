import java.util.Random;

public class Dado {
	// Atributos
	private int valorFace = 0;
	Random gerador = new Random();
	
	// Métodos
	void rolar() {
		// Usando Math.Random:
		//int resultado = (int)(Math.random() * 6);
		//valorFace = resultado + 1;
		
		// Usando a classe Random:
		valorFace = gerador.nextInt(6) + 1;
	}
	
	// Retornar valor
	int retornarValor() {
		return valorFace;
	}

}
