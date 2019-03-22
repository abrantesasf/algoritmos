package br.faesa.cc.ed.aasf;

/**
 * A classe <b>No</b> define um nó (elemento) de uma lista simplesmente encadeada, conforme
 * as especificações do projeto. Cada nó tem 2 atributos: um Carro e um ponteiro para um
 * outro nó.
 * @author Abrantes Araújo Silva Filho
 *         <a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>
 */
public class No {
	
	///////////////////////////////////////////////////
	// Atributos
	///////////////////////////////////////////////////
	private Carro carro;
	private No    prox;
	
	
	///////////////////////////////////////////////////
	// Construtor
	///////////////////////////////////////////////////
	/**
	 * O construtor da classe <b>No</b> recebe, obrigatoriamente, um
	 * objeto que representa um carro. O ponteiro para o próximo nó
	 * é inicializado como NULL.
	 * @param novoCarro
	 */
	public No (Carro novoCarro) {
		setCarro(novoCarro);
		setProx(null);
	}

	
	///////////////////////////////////////////////////
	// Getters
	///////////////////////////////////////////////////
	/**
	 * O método <b>getCarro()</b> retorna o endereço de memória onde
	 * o objeto carro está armazenado.
	 * @return Carro (endereço de memória)
	 */
	public Carro getCarro() {
		return this.carro;
	}

	/**
	 * O método <b>getProx()</b> retorna o endereço de memória do próximo
	 * nó em uma lista simplesmente encadeada. Se não existir um próximo nó,
	 * retorna NULL
	 * @return (endereço do próximo nó) OU (null)
	 */
	public No getProx() {
		return this.prox;
	}
	

	///////////////////////////////////////////////////
	// Setters
	///////////////////////////////////////////////////
	public void setCarro(Carro novoCarro) {
		this.carro = novoCarro;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}
}
