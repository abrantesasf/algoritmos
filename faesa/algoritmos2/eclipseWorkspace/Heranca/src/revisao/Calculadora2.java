package revisao;

public class Calculadora2 {
	// Atributos
	private int numero1;
	private int numero2;
	
	// Construtores
	public Calculadora2() {
		this.numero1 = 0;
		this.numero2 = 0;
	}
	
	public Calculadora2(int numero1, int numero2) {
		this.numero1 = numero1;
		this.numero2 = numero2;
	}
	
	// toString
	public String toString() {
		String resposta = "";
		resposta = "Número 1: " + this.numero1 + "\n" +
		           "Número 2: " + this.numero2;
		return resposta;
	}
	
	// retornaSoma
	public int retornaSoma() {
		return this.numero1 + this.numero2;
	}
	
	// retornaMultiplicacao
	public int retornaMultiplicacao() {
		return this.numero1 * this.numero2;
	}

}
