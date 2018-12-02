package sisBib.principal;

/**
 * <p>A classe VetorDePeriodicos cria um vetor para armazenar periódicos.</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-12-01
 */
public class VetorDePeriodicos {

	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>vPeriodicos</b> (vetor de periódicos)</p>
	 * <p>É um array para armazenar objetos do tipo <i>Periodico</b>.</p>
	 */
	private Periodico[] vPeriodicos;
	
	/**
	 * <p><b>qtdNoVetor</b> (quantidadade de livros armazenadas no vetor)</p>
	 * <p>É uma variável do tipo <i>int</i>, que controla a quantidade de objetos
	 * do tipo Livro que estão dentro do vetor</p>
	 */
	private int qtdNoVetor;
	
	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////
	
	/**
	 * <p>O construtor para a classe VetorDePeriodicos recebe, obrigatoriamente,
	 * um número inteiro indicando a quantidade de posições que o vetor terá. O
	 * construtor inicializa o vetor de livros e a variável de controle da quantidade
	 * de objetos que já está no vetor.</p>
	 * 
	 * @param tamanho (int indicando quantas posições o vetor terá)
	 */	
	public VetorDePeriodicos(int tamanho) {
		this.vPeriodicos = new Periodico[tamanho];
		this.qtdNoVetor = 0;
	}
	
	
    ///////////////////////////////////////////////////
	// Getters:
    ///////////////////////////////////////////////////	

	/**
	 * <p><b>getPeriodico(int i)</b></p>
	 * <p>Retorna o objeto do tipo Periodico, na posição "i" do vetor.</p>
	 * 
	 * @param i (int indicando a posição do vetor a ser retornada)
	 * @return Periodico (objeto do tipo Periodico)
	 */
	public Periodico getPeriodico(int i) {
		return this.vPeriodicos[i];
	}

	/**
	 * <p><b>getQtdNoVetor()</b></p>
	 * <p>Retorna um inteiro indicando quantos objetivos estão armazenados
	 * dentro do vetor de alunos.</p>
	 * 
	 * @return int (inteiro que representa a quantidade de objetos atualmente no vetor)
	 */
	public int getQtdNoVetor() {
		return this.qtdNoVetor;
	}
	
	/**
	 * <p><b>getTamanhoDoVetor()</b></p>
	 * <p>Retorna um inteiro indicando quantas posições o vetor tem (definido no momento
	 * da inicialização do vetor, na chamada do construtor).</p>
	 * 
	 * @return int (inteiro que representa a quantidade de posições que o vetor tem)
	 */
	public int getTamanhoDoVetor() {
		return this.vPeriodicos.length;
	}
	
	
    ///////////////////////////////////////////////////
	// Setters
    ///////////////////////////////////////////////////
	
	/**
	 * <p><b>inserirPeriodico(Periodico novoPeriodico)</b></p>
	 * <p>Verifica se o vetor de periódicos está cheio ou se já existe um periódico com o mesmo
	 * número de código e, se tudo está OK, insere um novo periódico.</p>
	 * 
	 * @param novoPeriodico (objeto do tipo Periodico)
	 * @return <b>True</b>, se o periodico foi inserido<br /><b>False</b>, se o periodico não foi inserido
	 */
	public boolean inserirPeriodico(Periodico novoPeriodico) {
		boolean resposta = false;
		if (this.vetorCheio()) {
			resposta = false;
		} else if (this.codigoExiste(novoPeriodico.getCodigo())) {
			resposta = false;
		} else {
			this.vPeriodicos[this.qtdNoVetor] = novoPeriodico;
			this.qtdNoVetor++;
			resposta = true;
		}
		return resposta;
	}
	
	/**
	 * <p><b>removerPeriodico(int i)</b></p>
	 * <p>Verifica se o vetor de periódicos está vazio ou se está tentando remover um
	 * periódico em um índice maior do que o vetor.
	 * Se tudo OK, remove o periódico.</p>
	 * <p><b>ATENÇÃO!</b> Não foram implementadas checagens de integridade referencial nesses
	 * métodos puramente "vetoriais", ou seja, você pode excluir um periódico que tenha registro
	 * de empréstimos. Esses controles serão implementados via banco de dados.</p>
	 * 
	 * @param i (int representando a posição do periódico a ser removido do vetor)
	 * @return <b>True</b>, se o periódico foi removido<br /><b>False</b>, se o periódico não foi removido
	 */
	public boolean removerPeriodico(int i) {
		boolean resposta = false;
		if (this.vetorVazio()) {
			resposta = false;
		} else if (i > this.qtdNoVetor) {
			resposta = false;
		} else {
			this.vPeriodicos[i] = this.vPeriodicos[this.qtdNoVetor - 1];
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
	 * <p>Verifica se já existe algum periódico no vetor com mesmo código informado.</p>
	 * 
	 * @param codigo (int de até 8 dígitos representando o código do periódico)
	 * @return <b>True</b>, se já existir um periódico com esse código<br /><b>False</b>, se não existir um periódico com esse código
	 */
	public boolean codigoExiste(int codigo) {
		boolean resposta = false;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vPeriodicos[i].getCodigo() == codigo) {
				resposta = true;
				break;
			}
		}
		return resposta;
	}
	
	/**
	 * <p><b>posicaoNoVetor(int codigo)</b></p>
	 * <p>Faz a busca por um determinado periódico através de seu código e, se encontrar,
	 * retorna a posição no vetor que esse periódico está.</p>
	 * 
	 * @param codigo (int de até 8 dígitos representando o códigodo periódico)
	 * @return <b>-1</b>, se não existir nenhum periódico com código informado<br /><b>int</b> representando a posição do periódico com o código informado
	 */
	public int posicaoNoVetor(int codigo) {
		int resposta = -1;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vPeriodicos[i].getCodigo() == codigo) {
				resposta = i;
			}
		}
		return resposta;
	}
	
	/**
	 * <p><b>vetorVazio()</b></p>
	 * <p>Verifica se o vetor está vazio.</p>
	 * 
	 * @return <b>True</b>, se o vetor estiver vazio<br /><b>False</b>, se o vetor não estiver vazio
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
	 * @return <b>True</b>, se o vetor estiver cheio<br /><b>False</b>, se o vetor não estiver cheio
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
	 * informações básicas sobre todos os periódicos. Obs.: a string de retorno, por padrão,
	 * NÃO CONTÉM linhas vazias acima ou abaixo do conteúdo, mas contém 2 quebras de linha
	 * entre cada aluno.</p>
	 * 
	 * @return informacoes (String formatada com dados sobres todos os livros)
	 */
	public String toString() {
		String resposta = "";
		for (int i = 0; i < this.qtdNoVetor; i++) {
			resposta += this.vPeriodicos[i].toString() + "\n\n";
		}
		return resposta;
	}
	
}