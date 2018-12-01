package sisBib.principal;

/**
 * <p>A classe VetorDeAlunos cria um vetor para armazenar alunos.</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-11-10
 */
public class VetorDeAlunos {

	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>vAlunos</b>:</p>
	 * <ul>
	 * <li>Define um vetor do tipo Aluno</li>
	 * <li>Tipo: Aluno</li>
	 * </ul>
	 */
	private Aluno[] vAlunos;
	
	/**
	 * <p><b>qtdNoVetor</b>:</p>
	 * <ul>
	 * <li>Controla a quantidade de objetos do tipo Professor que estão dentro do vetor</li>
	 * <li>Tipo: int</li>
	 * </ul>
	 */
	private int qtdNoVetor;
	
	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////
	
	/**
	 * <p>O construtor para a classe VetorDeAlunos recebe, obrigatoriamente,
	 * um número inteiro indicando a quantidade de posições que o vetor terá. O
	 * construtor inicializa o vetor de alunos e a variável de controle da quantidade
	 * de objetos que já está no vetor.</p>
	 * 
	 * @param tamanho (int indicando quantas posições o vetor de alunos terá)
	 */	
	public VetorDeAlunos(int tamanho) {
		this.vAlunos = new Aluno[tamanho];
		this.qtdNoVetor = 0;
	}
	
	
    ///////////////////////////////////////////////////
	// Getters:
    ///////////////////////////////////////////////////	

	/**
	 * <p><b>getAluno(int i)</b></p>
	 * <p>Retorna o objeto do tipo Aluno, na posição "i" do vetor.</p>
	 * 
	 * @param i (int indicando a posição do vetor a ser retornada)
	 * @return Aluno (Aluno)
	 */
	public Aluno getAluno(int i) {
		return this.vAlunos[i];
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
		return this.vAlunos.length;
	}
	
	
    ///////////////////////////////////////////////////
	// Métodos auxiliares
    ///////////////////////////////////////////////////	

	/**
	 * <p><b>matriculaExiste(int matricula)</b></p>
	 * <p>Verifica se já existe algum aluno no vetor com a matrícula informada.</p>
	 * @param matricula (int representando um número de matrícula)
	 * @return True, se já existir um registro com essa matrícula<br />False, se não existir um registro com essa matrícula
	 */
	public boolean matriculaExiste(int matricula) {
		boolean resposta = false;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vAlunos[i].getMatricula() == matricula) {
				resposta = true;
				break;
			}
		}
		return resposta;
	}
	
	/**
	 * <p><b>posicaoNoVetor(int matricula)</b></p>
	 * <p>Faz a busca por um determinado aluno através de seu número de matrícula e, se encontrar,
	 * retorna a posição no vetor que esse aluno está.</p>
	 * 
	 * @param matricula (int representando um número de matrícula)
	 * @return <b>-1</b>, se não existir nenhum aluno com a matrícula informada<br /><b>int</b> representando a posição do aluno com a matrícula informada
	 */
	public int posicaoNoVetor(int matricula) {
		int resposta = -1;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vAlunos[i].getMatricula() == matricula) {
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
	 * informações básicas sobre todos os alunos (agregando as informações obtidas
	 * com o toString() da classe pai, Usuario). Obs.: a string de retorno, por padrão,
	 * NÃO CONTÉM linhas vazias acima ou abaixo do conteúdo, mas contém 2 quebras de linha
	 * entre cada aluno.</p>
	 * 
	 * @return informacoes (String formatada com dados sobres todos os alunos)
	 */
	public String toString() {
		String resposta = "";
		for (int i = 0; i < this.qtdNoVetor; i++) {
			resposta += this.vAlunos[i].toString() + "\n\n";
		}
		return resposta;
	}
	
	
    ///////////////////////////////////////////////////
	// Setters e outros métodos relacionados
    ///////////////////////////////////////////////////
	
	/**
	 * <p><b>inserirAluno(Aluno novoAluno)</b></p>
	 * <p>Verifica se o vetor de alunos está cheio ou se já existe um aluno com o mesmo
	 * número de matrícula e, se tudo está OK, insere um novo aluno.</p>
	 * 
	 * @return <b>True</b>, se o aluno foi inserido<br /><b>False</b>, se o aluno não foi inserido
	 */
	public boolean inserirAluno(Aluno novoAluno) {
		boolean resposta = false;
		if (this.vetorCheio()) {
			resposta = false;
		} else if (this.matriculaExiste(novoAluno.getMatricula())) {
			resposta = false;
		} else {
			this.vAlunos[this.qtdNoVetor] = novoAluno;
			this.qtdNoVetor++;
			resposta = true;
		}
		return resposta;
	}
	
	/**
	 * <p><b>removerAluno(int i)</b></p>
	 * <p>Verifica se o vetor de alunos está vazio ou se está tentando remover um
	 * aluno em um índice maior do que o vetor.
	 * Se tudo OK, remove o aluno.</p>
	 * <p><b>ATENÇÃO!</b> Não foram implementadas checagens de integridade referencial nesses
	 * métodos puramente "vetoriais", ou seja, você pode excluir um aluno que tenha registro
	 * de empréstimos. Esses controles serão implementados via banco de dados.</p>
	 * 
	 * @param i (int representando a posição do aluno a ser removido do vetor)
	 * @return <b>True</b>, se o aluno foi removido<br /><b>False</b>, se o aluno não foi removido
	 */
	public boolean removerAluno(int i) {
		boolean resposta = false;
		if (this.vetorVazio()) {
			resposta = false;
		} else if (i > this.qtdNoVetor) {
			resposta = false;
		} else {
			this.vAlunos[i] = this.vAlunos[this.qtdNoVetor - 1];
			this.qtdNoVetor -= 1;
			resposta = true;
		}
		return resposta;
	}

}
