package sisBib.principal;

/**
 * <p>A classe VetorDeAcervo cria um vetor para armazenar itens do acervo. Como Acervo é 
 * classe pai das classes Livro e Periodico, pode armazenar também objetos desses tipos.</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-12-01
 */
public class VetorDeAcervo {

	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>vAcervo</b> (vetor de acervo)</p>
	 * <p>É um array para armazenar objetos do tipo <i>Acervo</b>.</p>
	 */
	private Acervo[] vAcervo;
	
	/**
	 * <p><b>qtdNoVetor</b> (quantidadade de itens de acervo armazenados no vetor)</p>
	 * <p>É uma variável do tipo <i>int</i>, que controla a quantidade de objetos
	 * do tipo Acervo (e Tipos filhos) que estão dentro do vetor</p>
	 */
	private int qtdNoVetor;
	
	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////
	
	/**
	 * <p>O construtor para a classe VetorDeAcervo recebe, obrigatoriamente,
	 * um número inteiro indicando a quantidade de posições que o vetor terá. O
	 * construtor inicializa o vetor de Acervo e a variável de controle da quantidade
	 * de objetos que já estã no vetor.</p>
	 * 
	 * @param tamanho (int indicando quantas posições o vetor de itens do acervo terá)
	 */	
	public VetorDeAcervo(int tamanho) {
		this.vAcervo = new Acervo[tamanho];
		this.qtdNoVetor = 0;
	}
	
	
    ///////////////////////////////////////////////////
	// Getters:
    ///////////////////////////////////////////////////	

	/**
	 * <p><b>getAcervo(int i)</b></p>
	 * <p>Retorna o objeto do tipo Acervo (ou tipos filhos), na posição "i" do vetor.</p>
	 * 
	 * @param i (int indicando a posição do vetor a ser retornada)
	 * @return Acervo (objeto do tipo Acervo)
	 */
	public Acervo getAcervo(int i) {
		return this.vAcervo[i];
	}

	/**
	 * <p><b>getQtdNoVetor()</b></p>
	 * <p>Retorna um inteiro indicando quantos objetivos estão armazenados
	 * dentro do vetor.</p>
	 * 
	 * @return int (inteiro que representa a quantidade de objetos atualmente no vetor)
	 */
	private int getQtdNoVetor() {
		return this.qtdNoVetor;
	}
	
	/**
	 * <p><b>getTamanhoDoVetor()</b></p>
	 * <p>Retorna um inteiro indicando quantas posições o vetor tem (definido no momento
	 * da inicialização do vetor, na chamada do construtor).</p>
	 * 
	 * @return int (inteiro que representa a quantidade de posições que o vetor tem)
	 */
	private int getTamanhoDoVetor() {
		return this.vAcervo.length;
	}
	
	
    ///////////////////////////////////////////////////
	// Setters
    ///////////////////////////////////////////////////
	
	/**
	 * <p><b>inserirAcervo(Acervo novoAcervo)</b></p>
	 * <p>Verifica se o vetor de itens do acervo está cheio ou se já existe um item com o mesmo
	 * código e, se tudo OK, insere um novo item no acervo.</p>
	 * 
	 * @return True, se o item do acervo foi inserido<br />False, se o item do acervo não foi inserido
	 */
	public boolean inserirAcervo(Acervo novoAcervo) {
		boolean resposta = false;
		if (this.vetorCheio()) {
			resposta = false;
		} else if (this.codigoExiste(novoAcervo.getCodigo())) {
			resposta = false;
		} else {
			this.vAcervo[this.qtdNoVetor] = novoAcervo;
			this.qtdNoVetor++;
			resposta = true;
		}
		return resposta;
	}
	
	/**
	 * <p><b>removerAcervo(int i)</b></p>
	 * <p>Verifica se o vetor de itens do acervo está vazio ou se está tentando remover um
	 * item em um índice maior do que o vetor.
	 * Se tudo OK, remove o item do acervo.</p>
	 * <p><b>ATENÇÃO!</b> Não foram implementadas checagens de integridade referencial nesses
	 * métodos puramente "vetoriais", ou seja, você pode excluir um item do acervo que tenha registro
	 * de empréstimos. Esses controles serão implementados via banco de dados.</p>
	 * 
	 * @param i (int representando a posição do acervo a ser removido do vetor)
	 * @return <b>True</b>, se o acervo foi removido<br /><b>False</b>, se o acervo não foi removido
	 */
	public boolean removerAcervo(int i) {
		boolean resposta = false;
		if (this.vetorVazio()) {
			resposta = false;
		} else if (i > this.qtdNoVetor) {
			
		} else {
			this.vAcervo[i] = this.vAcervo[this.qtdNoVetor - 1];
			this.qtdNoVetor -= 1;
			resposta = true;
		}
		return resposta;
	}
	
	
    ///////////////////////////////////////////////////
	// Outros métodos
    ///////////////////////////////////////////////////	

	/**
	 * <p><b>codigoExiste(int codigo)</b></p>
	 * <p>Verifica se já existe algum item do acervo no vetor com mesmo código informado.</p>
	 * 
	 * @param codigo (int de até 8 dígitos representando o código do livro)
	 * @return <b>True</b>, se já existir um item no vetor de acervo com esse código<br /><b>False</b>, se não existir um item no vetor de acervo com esse código
	 */
	public boolean codigoExiste(int codigo) {
		boolean resposta = false;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vAcervo[i].getCodigo() == codigo) {
				resposta = true;
				break;
			}
		}
		return resposta;
	}
	
	/**
	 * <p><b>posicaoNoVetor(int codigo)</b></p>
	 * <p>Faz a busca por um determinado item no vetor de acervo através de seu código e, se encontrar,
	 * retorna a posição no vetor que esse item está.</p>
	 * 
	 * @param codigo (int de até 8 dígitos representando o código do item do acervo)
	 * @return <b>-1</b>, se não existir nenhum item com código informado<br /><b>int</b> representando a posição do item com o código informado
	 */
	public int posicaoNoVetor(int codigo) {
		int resposta = -1;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vAcervo[i].getCodigo() == codigo) {
				resposta = i;
			}
		}
		return resposta;
	}
	
	/**
	 * <p><b>vetorVazio()</b></p>
	 * <p>Verifica se o vetor está vazio.</p>
	 * 
	 * @return True, se o vetor estiver vazio<br />False, se o vetor não estiver vazio
	 */
	private boolean vetorVazio() {
		if (this.qtdNoVetor == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * <p><b>vetorCheio()</b></p>
	 * <p>Verifica se o vetor está cheio.</p>
	 * 
	 * @return True, se o vetor estiver cheio<br />False, se o vetor não estiver cheio
	 */
	private boolean vetorCheio() {
		if (this.getQtdNoVetor() == this.getTamanhoDoVetor()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * <p><b>toString()</b></p>
	 * <p>Sobrescreve o método padrão toString(), retornando todas as
	 * informações básicas sobre todos os itens do acervo (agregando as informações obtidas.
	 * Obs.: a string de retorno, por padrão,
	 * NÃO CONTÉM linhas vazias acima ou abaixo do conteúdo.</p>
	 * 
	 * @return informacoes (String formatada com dados sobre os itens do acervo)
	 */
	public String toString() {
		String resposta = "";
		for (int i = 0; i < this.qtdNoVetor; i++) {
			resposta += this.vAcervo[i].toString();
		}
		return resposta;
	}

}
