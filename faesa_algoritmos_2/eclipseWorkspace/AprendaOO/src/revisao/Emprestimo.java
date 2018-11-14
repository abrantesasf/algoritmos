package revisao;

public class Emprestimo {
	// Atributos
	double valor;
	double taxa;
	int    prazo;
	
	// Construtor
	public Emprestimo(double valor, double taxa, int prazo) {
		this.valor = valor;
		this.taxa  = taxa;
		this.prazo = prazo;
	}

	// Getters:
	public double getValor() {
		return this.valor;
	}

	public double getTaxa() {
		return this.taxa;
	}

	public int getPrazo() {
		return this.prazo;
	}

	// Setters:
	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
	
	// toString
	public String toString() {
		String resposta = "";
		resposta = "    Valor: " + this.valor  + "\n" +
		           "    Taxa:  " + this.taxa   + "\n" +
				   "    Prazo: " + this.prazo  + "\n";
		return resposta;
	}
}
