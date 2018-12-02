package sisBib.principal;

/**
 * <p>A classe VetorDeLivros cria um vetor para armazenar livros.</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-12-01
 */
public class VetorDeLivros {

	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>vLivros</b> (vetor de livros)</p>
	 * <p>É um array para armazenar objetos do tipo <i>Livro</b>.</p>
	 */
	private Livro[] vLivros;
	
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
	 * <p>O construtor para a classe VetorDeLivros recebe, obrigatoriamente,
	 * um número inteiro indicando a quantidade de posições que o vetor terá. O
	 * construtor inicializa o vetor de livros e a variável de controle da quantidade
	 * de objetos que já está no vetor.</p>
	 * 
	 * @param tamanho (int indicando quantas posições o vetor terá)
	 */	
	public VetorDeLivros(int tamanho) {
		this.vLivros = new Livro[tamanho];
		this.qtdNoVetor = 0;
	}
	
	
    ///////////////////////////////////////////////////
	// Getters:
    ///////////////////////////////////////////////////	

	/**
	 * <p><b>getLivro(int i)</b></p>
	 * <p>Retorna o objeto do tipo Livro, na posição "i" do vetor.</p>
	 * 
	 * @param i (int indicando a posição do vetor a ser retornada)
	 * @return Livro (objeto do tipo Livro)
	 */
	public Livro getLivro(int i) {
		return this.vLivros[i];
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
		return this.vLivros.length;
	}
	
	
    ///////////////////////////////////////////////////
	// Setters
    ///////////////////////////////////////////////////
	
	/**
	 * <p><b>inserirLivro(Livro novoLivro)</b></p>
	 * <p>Verifica se o vetor de livros está cheio ou se já existe um livro com o mesmo
	 * número de código e, se tudo está OK, insere um novo livro.</p>
	 * 
	 * @param novoLivro (objeto do tipo Livro)
	 * @return <b>True</b>, se o livro foi inserido<br /><b>False</b>, se o livro não foi inserido
	 */
	public boolean inserirLivro(Livro novoLivro) {
		boolean resposta = false;
		if (this.vetorCheio()) {
			resposta = false;
		} else if (this.codigoExiste(novoLivro.getCodigo())) {
			resposta = false;
		} else {
			this.vLivros[this.qtdNoVetor] = novoLivro;
			this.qtdNoVetor++;
			resposta = true;
		}
		return resposta;
	}
	
	/**
	 * <p><b>removerLivro(int i)</b></p>
	 * <p>Verifica se o vetor de livros está vazio ou se está tentando remover um
	 * livro em um índice maior do que o vetor.
	 * Se tudo OK, remove o aluno.</p>
	 * <p><b>ATENÇÃO!</b> Não foram implementadas checagens de integridade referencial nesses
	 * métodos puramente "vetoriais", ou seja, você pode excluir um livro que tenha registro
	 * de empréstimos. Esses controles serão implementados via banco de dados.</p>
	 * 
	 * @param i (int representando a posição do livro a ser removido do vetor)
	 * @return <b>True</b>, se o livro foi removido<br /><b>False</b>, se o livro não foi removido
	 */
	public boolean removerLivro(int i) {
		boolean resposta = false;
		if (this.vetorVazio()) {
			resposta = false;
		} else if (i > this.qtdNoVetor) {
			resposta = false;
		} else {
			this.vLivros[i] = this.vLivros[this.qtdNoVetor - 1];
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
	 * <p>Verifica se já existe algum livro no vetor com mesmo código informado.</p>
	 * 
	 * @param codigo (int de até 8 dígitos representando o código do livro)
	 * @return <b>True</b>, se já existir um livro com esse código<br /><b>False</b>, se não existir um livro com esse código
	 */
	public boolean codigoExiste(int codigo) {
		boolean resposta = false;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vLivros[i].getCodigo() == codigo) {
				resposta = true;
				break;
			}
		}
		return resposta;
	}
	
	/**
	 * <p><b>posicaoNoVetor(int codigo)</b></p>
	 * <p>Faz a busca por um determinado livro através de seu código e, se encontrar,
	 * retorna a posição no vetor que esse livro está.</p>
	 * 
	 * @param codigo (int de até 8 dígitos representando o códigodo livro)
	 * @return <b>-1</b>, se não existir nenhum livro com código informado<br /><b>int</b> representando a posição do livro com o código informado
	 */
	public int posicaoNoVetor(int codigo) {
		int resposta = -1;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vLivros[i].getCodigo() == codigo) {
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
	 * informações básicas sobre todos os livros. Obs.: a string de retorno, por padrão,
	 * NÃO CONTÉM linhas vazias acima ou abaixo do conteúdo, mas contém 2 quebras de linha
	 * entre cada aluno.</p>
	 * 
	 * @return informacoes (String formatada com dados sobres todos os livros)
	 */
	public String toString() {
		String resposta = "";
		for (int i = 0; i < this.qtdNoVetor; i++) {
			resposta += this.vLivros[i].toString() + "\n\n";
		}
		return resposta;
	}
	
} // Fecha Classe VetorDeLivros
