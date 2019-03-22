package br.faesa.cc.ed.aasf;

/**
 * A classe <b>ListaSimplesmenteEncadeada</b> implementa uma lista linear simplesmente
 * encadeada que, conforme as especificações do projeto, armazenará informações a respeito
 * de carros novos e transferidos. As operações definidas para esta lista são:
 * <ul>
 * <li>Inserir um novo nó após o último nó da lista</li>
 * <li>Inserir um novo nó em uma posição ordenada da lista</li>
 * <li>Remover um nó (carro) através de sua ID</li>
 * <li>Exibir os nós da lista</li>
 * <li>Pesquisar e exibir os nós (carros) de um mesmo modelo</li>
 * </ul>
 * @author Abrantes Araújo Silva Filho
 *         <a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>
 */
public class ListaSimplesmenteEncadeada {
	
	///////////////////////////////////////////////////
	// Atributos
	///////////////////////////////////////////////////
	/**
	 * <b>prim</b>: ponteiro para o primeiro nó da lista
	 */
	private No  prim;
	
	/**
	 * <b>ult</b>: ponteiro para o último nó da lista
	 */
	private No  ult;
	
	/**
	 * <b>qtdNos</b>: contador que mantém o números de nós na lista
	 */
	private int qtdNos;
	
	
	///////////////////////////////////////////////////
	// Construtor
	///////////////////////////////////////////////////
	/**
	 * O construtor da classe <b>ListaSimplesmenteEncadeada</b> não recebe nenhum
	 * parâmetro pois a lista é sempre inicializada vazia, ou seja:
	 * <ul>
	 * <li>A quantidade de nós é 0 (zero)</li>
	 * <li>O ponteiro prim aponta para NULL</li>
	 * <li>O ponteiro ult aponta para NULL</li>
	 * </ul>
	 */
	public ListaSimplesmenteEncadeada() {
		setPrim(null);
		setUlt(null);
		setQtdNos(0);
	}
	

	///////////////////////////////////////////////////
	// Getters
	///////////////////////////////////////////////////
	/**
	 * O método <b>getPrim()</b> retorna o endereço de memória
	 * da localização do primeiro nó na lista (ou null, caso a lista
	 * não contenha num nó).
	 * @return (endereço do primeiro nó) OU (null)
	 */
	public No getPrim() {
		return this.prim;
	}

	/**
	 * O método <b>getUlt()</b> retorna o endereço de memória
	 * da localização do último nó na lista (ou null, caso a lista
	 * não contenha num nó).
	 * @return (endereço do último nó) OU (null)
	 */
	public No getUlt() {
		return this.ult;
	}

	public int getQtdNos() {
		return this.qtdNos;
	}

	
	///////////////////////////////////////////////////
	// Setters
	///////////////////////////////////////////////////
	/**
	 * O método <b>setPrim(No)</b> recebe obrigatoriamente o endereço de
	 * memória de um objeto da classe No e faz com que o ponteiro prim aponte
	 * para esse endereço (efetivamente criando o primeiro elemento da lista
	 * simplesmente encadeada).
	 * @param novoNo (objeto da classe No)
	 */
	public void setPrim(No novoNo) {
		this.prim = novoNo;
	}

	/**
	 * O método <b>setUlt(No)</b> recebe obrigatoriamente o endereço de
	 * memória de um objeto da classe No e faz com que o ponteiro ult aponte
	 * para esse endereço (efetivamente definindo o último elemento da lista
	 * simplesmente encadeada).
	 * @param novoNo (objeto da classe No)
	 */
	public void setUlt(No novoNo) {
		this.ult = novoNo;
	}

	public void setQtdNos(int qtdNos) {
		this.qtdNos = qtdNos;
	}
	
	
	///////////////////////////////////////////////////
	// Outros métodos
	///////////////////////////////////////////////////
	
	
	///////////////////////////////////////////////////
	// toString
    ///////////////////////////////////////////////////
	public String toString() {
		String retorno = "";
		if (estaVazia()) {
			System.out.println("Não há dados para exibir.");
		} else {
			No atual = getPrim();
			do {
				retorno += atual.getCarro().toString() + "\n";
				atual    = atual.getProx();
			} while (atual != null);
		}
		return retorno;
	}
	
	
	///////////////////////////////////////////////////	
	// estaVazia
    ///////////////////////////////////////////////////
	/**
	 * O método <b>estaVazia()</b> checa se a lista simplesmente encadeada
	 * está vazia ou não.
	 * @return TRUE (caso a lista esteja vazia)<br />FALSE (se a lista não está vazia)
	 */
	public boolean estaVazia() {
		if (getPrim() == null) {
			return true;
		} else {
			return false;
		}
	}

	
	///////////////////////////////////////////////////	
	// inserirCarroNoFinal
    ///////////////////////////////////////////////////
	/**
	 * O método <b>inserirCarroNoFinal(Carro)</b> obrigatoriamente recebe um objeto
	 * da classe Carro, cria um objeto da classe Nó para armazenar as informações desse
	 * carro, e insere esse nó no final de uma lista simplesmente encadeada.
	 * @param novoCarro (objeto da classe Carro)
	 * @return TRUE (caso a inserção seja realizada com sucesso)<br />FALSE (se não foi possível inserir)
	 */
	public boolean inserirCarroNoFinal(Carro novoCarro) {
		
		// Controle do retorno:
		boolean retorno = false;
		
		// Recebe um novo carro e cria um novo Nó com as informações
		// do novo carro (prox é setado para null por causa do construtor
		// do No):
		No novoNo = new No(novoCarro);
		
		// Insere o carro no final (depende se a lista está vazia ou não):
		if (estaVazia()) {
			
			// Se a lista está vazia, basta apontar prim para o novo nó,
			// acerter o ult e a quantidade de nós:
			setPrim(novoNo);
			setUlt(novoNo);
			setQtdNos( getQtdNos() + 1 );
			
			// Deu certo:
			retorno = true;
			
		} else {
			
			// Se a lista não está vazia, temos que apontar o prox do ult
			// para o novo nó:
			this.ult.setProx(novoNo);
			
			// E depois mover o ult e acertar a quantidade de nós:
			setUlt(novoNo);
			setQtdNos( getQtdNos() + 1 );
			
			// Deu certo:
			retorno = true;
		}
		
		// Retorno da função:
		return retorno;
	}
	
	
	///////////////////////////////////////////////////	
	// inserirCarroOrdenadoPorID
    ///////////////////////////////////////////////////
	/**
	 * O método <b>inserirCarroOrdenadoPorID(Carro)</b> recebe obrigatoriamente como parâmetro
	 * um objeto da classe Carro e insere esse carro na lista de modo ordenado pelo seu ID.
	 * @param novoCarro (objeto da Classe Carro)
	 * @return TRUE (se a inserção foi OK)<br />FALSE (se a inserção falhou)
	 */
	public boolean inserirCarroOrdenadoPorID(Carro novoCarro) {
		
		// Variável para retorno da função
		boolean retorno = false;
		
		// Recebe um novo carro e cria um novo Nó com as informações
		// do novo carro (prox é setado para null por causa do construtor
		// do No):
		No novoNo = new No(novoCarro);
		
		// Se a lista está vazia, insere na primeira posição, acertando
		// o ult e o quantidade de nós:
		if (this.estaVazia()) {
			setPrim(novoNo);
			setUlt(novoNo);
			setQtdNos( getQtdNos() + 1 );
			retorno = true;
			
		} else {
			// A lista não está vazia, temos que inserir ordenadamente. Para
			// isso vamos criar alguns nós para percorrer a lista:
			No atual    = getPrim();
			No anterior = null;
			
			// Percorrendo a lista
			while ( (novoNo.getCarro().getIdCarro() > atual.getCarro().getIdCarro()) && atual.getProx() != null) {
				anterior = atual;
				atual = atual.getProx();
			}
			
			// O while pode parar no primeiro nó porque o ID é maior OU porque não há mais nós,
			// então, se o while parar no primeiro nó, temos que conferir os valores dos ID para ver
			// qual situação ocorreu:
			
			// Se o while parar no primeiro nó e for menor, o novo carro deve ser inserido ANTES do primeiro nó:
			if ( atual == getPrim() && novoNo.getCarro().getIdCarro() <= atual.getCarro().getIdCarro() ) {
				novoNo.setProx(getPrim());
				setPrim(novoNo);
				setQtdNos( getQtdNos() + 1 );
				retorno = true;
				
			// Mas se o while parar no primeiro nó e for maior, o novo carro deve ser inserido APÓS o primeiro nó:
			} else if ( atual == getPrim() && novoNo.getCarro().getIdCarro() > atual.getCarro().getIdCarro() ) {
				novoNo.setProx(atual.getProx());
				atual.setProx(novoNo);
				setQtdNos( getQtdNos()+ 1 );
				retorno = true;
				
			// O while pode parar no último nó porque o ID é maior OU porque não há mais nós,
			// então, se o while para no último nó, temos que conferir os valores dos ID para ver
			// qual situação ocorreu:
				
			// Se o while parar no último e for maior, o novo carro deve ser inserido APÓS o último nó:
			} else if ( atual == getUlt() && (novoNo.getCarro().getIdCarro() >= atual.getCarro().getIdCarro()) ) {
				atual.setProx(novoNo);
				setUlt(novoNo);
				setQtdNos( getQtdNos() + 1 );
				retorno = true;
				
			// Se o while parar no último e for menor, o novo carro deve ser insediro ANTES do último nó:
			} else if ( atual == getUlt() && (novoNo.getCarro().getIdCarro() < atual.getCarro().getIdCarro()) ) {
				novoNo.setProx(getUlt());
				anterior.setProx(novoNo);
				setQtdNos( getQtdNos() + 1 );
				retorno = true;
				
			// Se o while parar em algum lugar ENTRE o primeiro e o último nó, o novo nó deve ser
			// inserido ANTES desse nó:
			} else {
				novoNo.setProx(atual);
				anterior.setProx(novoNo);
				setQtdNos( getQtdNos() + 1 );
				retorno = true;
			}
		}
		
		// Retorno da função
		return retorno;
	}
	
	
    ///////////////////////////////////////////////////	
	// removerCarro
    ///////////////////////////////////////////////////
	/**
	 * O método <b>removerCarro(int)</b> recebe obrigatoriamente um inteiro que
	 * representa o identificador de um carro, busca esse identificador na lista e,
	 * caso esteja presente, remove o nó (apaga esse carro da lista). O método trata
	 * as diferentes situações que podem ocorrer (lista vazia, remover o primeiro,
	 * remover o último ou remover em posição intermediária).
	 * @param id (int que representa um ID de um carro)
	 * @return TRUE (se conseguiu remover o carro)<br />FALSE (se não conseguiu remover)
	 */
	public boolean removerCarro(int id) {
		
		// Controle do retorno
		boolean retorno = false;
		
		// Checa se a lista está vazia
		if (estaVazia()) {
			System.out.println("A lista está vazia, não é possível remover.");
			
		} else {
			// A lista não está vazia. Agora a busca e remoção dependem da quantidade de nós.

			// 1ª Situação: a lista só tem um único nó:
			if (getQtdNos() == 1) {
				
				// Se o nó único tem a ID procurada:
				if (getPrim().getCarro().getIdCarro() == id) {
					
					// Apagamos o único nó da lista:
					setUlt(null);
					setPrim(null);
					setQtdNos(0);
					
					// Conseguiu apagar!
					retorno = true;

				} else {
					// O único nó da lista não tem a ID procurada:
					System.out.println("Não foi encontrado nenhum carro com a ID informada, não é possível remover.");
				}
				
			} else {
				// 2ª Situação: a lista tem mais de um nó:
				// Vamos criar alguns nós para controlar a busca:
				No atual    = getPrim();
				No anterior = null;
				
				// Agora vamos andar na lista da seguinte forma: ENQUANTO o id do carro atual for
				// diferente do ID pesquisado, E HOUVER um outro nó posterior,
				while (atual.getCarro().getIdCarro() != id && atual.getProx() != null) {
					anterior = atual;
					atual    = atual.getProx();
				}
				
				// Onde paramos? Se chegamos no último nó, temos que verificar se o ID desse nó
				// é o ID que estamos buscando:
				if (atual == getUlt() && atual.getCarro().getIdCarro() == id) {
					// Ôpa, o último nó tem a ID pesquisada. Então temos que apagar esse último nó:
					setUlt(anterior);
					anterior.setProx(null);
					atual = null;
					setQtdNos(getQtdNos()-1);
					
					// Conseguiu apagar!
					retorno = true;
					
				} else if (atual == getUlt() && atual.getCarro().getIdCarro() != id) {
					// Puxa! Chegamos no último e ele não tem a ID pesquisada. Nada a fazer:
					System.out.println("Não foi encontrado nenhum carro com a ID informada, não é possível remover.");
			
				} else if(atual == getPrim()) {
					// Ôpa a ID procurada está no primeiro nó. Temos que apagar esse primeiro nó e fazer
					// o prim apontar para o segundo nó:
					setPrim(atual.getProx());
					atual.setProx(null);
					setQtdNos(getQtdNos()-1);
					
					// Conseguiu apagar!
					retorno = true;
					
				} else {
					// Ôpa, paramos depois do primerio e antes do último nó! Isso é sinal de que encontramos
					// a ID pesquisada entre 2 outros nós. Temos que remover esse nó atual agora:
					anterior.setProx(atual.getProx());
					atual = null;
					setQtdNos(getQtdNos()-1);
					
					// Conseguiu apagar!
					retorno = true;
				}
			}
		}
		
		// Retorno da função:
		return retorno;
	}
	
	
    ///////////////////////////////////////////////////	
	// carroNaLista
    ///////////////////////////////////////////////////
	/**
	 * O método <b>buscaCarroNaListaPorID(int, Carro)</b> recebe obrigatoriamente 2 parâmetros: um inteiro
	 * que representa o ID do carro a ser pesquisado, e uma referência à um objeto do tipo Carro. A função pesquisa
	 * se o carro está na lista e, caso esteja, retorna por referência os dados desse carro. Este
	 * método foi criado para ser utilizado quando fizermos a transferência de um carro de uma lista
	 * para outra lista. 
	 * @param id        (int que representa o ID do carro)
	 * @param novoCarro (objeto da classe Carro)
	 * @return TRUE (se o carro está na lista)<br />FALSE (se o carro não está na lista)
	 */
	public boolean buscaCarroNaListaPorID(int id, Carro novoCarro) {
		
		// Variável de retorno direto da função:
		boolean retorno = false;
		
		// Verifica se a lista está vazia e sai da função caso esteja
		if (estaVazia()) {
			return retorno;
		}
		
		// Se a lista não está vazia, cria nós para caminhar na lista:
		No atual    = getPrim();
		//No anterior = null;
		
		// Enquanto o valor da ID do carro não for o ID procurado, E ainda existirem
		// outrós nós na lista, avança para o próximo nó:
		while (atual.getCarro().getIdCarro() != id && atual.getProx() != null) {
			//anterior = atual;
			atual = atual.getProx();
		}
		
		// Se o while parar no primeiro ou no último nó, e o ID for o pesquisado, o retorno
		// será true e o novo carro recebe o carro atual:
		if ( (atual == getPrim() && atual.getCarro().getIdCarro() == id) || (atual == getUlt() && atual.getCarro().getIdCarro() == id) ) {
			retorno = true;
			
		// Se o while parar no primeiro ou no último nó, e o ID não for o pesquisado, o retorno
		// continua como false, e o novoCarro continua como null:
		} else if ( (atual == getPrim() && atual.getCarro().getIdCarro() != id) || (atual == getUlt() && atual.getCarro().getIdCarro() != id) ) {
			retorno = false;
			
		// Se o while parar em algum lugar entre o primeiro e o último nó, esse nó contém
		// a ID pesquisada. O retorno será true e o novo carro recebe o carro atual:
		} else {
			retorno = true;
		}
		
		// Passa dados do carro, se ele for encontrado:
		if (retorno) {
			novoCarro.setIdCarro(atual.getCarro().getIdCarro());
			novoCarro.setModelo(atual.getCarro().getModelo());
			novoCarro.setCor(atual.getCarro().getCor());
			novoCarro.setAno(atual.getCarro().getAno());
		}
		
		// Retorno da função
		return retorno;
	}
	
    ///////////////////////////////////////////////////	
	// pesquisarModelo
    ///////////////////////////////////////////////////
	public String pesquisarModelo(String modelo) {
		String retorno = "";
		if (estaVazia()) {
			System.out.println("Não há dados para exibir.");
		} else {
			No atual = getPrim();
			do {if (modelo.equalsIgnoreCase(atual.getCarro().getModelo())) {
					retorno += atual.getCarro().toString() + "\n";
			    }
				atual = atual.getProx();
			} while (atual != null);
		}
		return retorno;
	}

}