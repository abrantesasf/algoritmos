package revisao;

public class Calculadora3 extends Calculadora2 {
	// Atributos
	private int numero3;
	
	// Construtores
	public Calculadora3() {
		super();
		this.numero3 = 0;
	}
	
	public Calculadora3(int numero1, int numero2, int numero3) {
		super(numero1, numero2);
		this.numero3 = numero3;
	}
	
	// toString
	public String toString() {
		String resposta = "";
		resposta = super.toString() +
				   "\nNúmero 3: " + this.numero3;
		return resposta;
	}
	
	// retornaSoma
	public int retornaSoma() {
		return super.retornaSoma() + this.numero3;
	}
	
	// retornaMultiplicacao
	public int retornaMultiplicacao() {
		return super.retornaMultiplicacao() * this.numero3;
	}

}
