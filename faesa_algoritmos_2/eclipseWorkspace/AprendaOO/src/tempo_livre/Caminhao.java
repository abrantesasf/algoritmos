package tempo_livre;

public class Caminhao {
	// Atributos
	private int    anoFabricacao;
	private String modelo;
	private int    capacidadeCarga;
	private char   combustivel;
	private String placa;
	
	// Construtores
	public Caminhao(String placa) {
		this.placa = placa;
	}
	
	public Caminhao() {
	}

	// Getters:
	public int getAnoFabricacao() {
		return this.anoFabricacao;
	}

	public String getModelo() {
		return this.modelo;
	}

	public int getCapacidadeCarga() {
		return this.capacidadeCarga;
	}

	public char getCombustivel() {
		return this.combustivel;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setCapacidadeCarga(int capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}

	public void setCombustivel(char combustivel) {
		this.combustivel = combustivel;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	// toString
	public String toString() {
		String resposta ="";
		resposta = "Placa:          " + this.placa + "\n" +
		           "Modelo:         " + this.modelo + "\n" +
				   "Ano:            " + this.anoFabricacao + "\n" +
		           "Combustível:    " + this.combustivel + "\n" +
				   "Carga (em TON): " + this.capacidadeCarga + "\n\n";
		return resposta;
	}

}
