package br.faesa.cc.ed.aasf;

/**
 * A classe <b>Carro</b> registra as informações de um carro, conforme especificações
 * do projeto. Esta classe será o componente de informações de cada nó de uma lista
 * simplesmente encadeada.
 * @author Abrantes Araújo Silva Filho
 *         <a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>
 */
public class Carro {
	
	///////////////////////////////////////////////////
	// Atributos
	///////////////////////////////////////////////////
	private int    idCarro;
	private String modelo;
	private String cor;
	private int    ano;
	
	
	///////////////////////////////////////////////////
	// Construtor
	///////////////////////////////////////////////////
	public Carro (int idCarro, String modelo, String cor, int ano) {
		setIdCarro(idCarro);
		setModelo(modelo);
		setCor(cor);
		setAno(ano);
	}

	
	///////////////////////////////////////////////////
	// Getters
	///////////////////////////////////////////////////
	public int getIdCarro() {
		return this.idCarro;
	}

	public String getModelo() {
		return this.modelo;
	}

	public String getCor() {
		return this.cor;
	}

	public int getAno() {
		return this.ano;
	}

	
	///////////////////////////////////////////////////
	// Setters
	///////////////////////////////////////////////////
	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	
	///////////////////////////////////////////////////
	// Outros métodos
	///////////////////////////////////////////////////
	public String toString() {
		String resposta = "";
		resposta = "ID do Carro: " + this.idCarro + "\n" +
		           "Modelo:      " + this.modelo  + "\n" +
				   "Cor:         " + this.cor     + "\n" +
		           "Ano:         " + this.ano     + "\n";
		return resposta;
	}
}