package sisBib.principal;

/**
 * <p>A classe VetorDeProfessores cria um vetor para armazenar professores.</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-11-10
 */
public class VetorDeProfessores {

	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>vProfessores</b>:</p>
	 * <ul>
	 * <li>Define um vetor do tipo Professor</li>
	 * <li>Tipo: Professor</li>
	 * </ul>
	 */
	private Professor[] vProfessores;
	
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
	 * <p>O construtor para a classe VetorDeProfessores recebe, obrigatoriamente,
	 * um número inteiro indicando a quantidade de posições que o vetor terá. O
	 * construtor inicializa o vetor de professores e a variável de controle da quantidade
	 * de objetos que já estã no vetor.</p>
	 * 
	 * @param tamanho (int indicando quantas posições o vetor de professores terá)
	 */	
	public VetorDeProfessores(int tamanho) {
		this.vProfessores = new Professor[tamanho];
		this.qtdNoVetor = 0;
	}
	
	
    ///////////////////////////////////////////////////
	// Getters:
    ///////////////////////////////////////////////////	

	/**
	 * <p><b>getProfessor(int i)</b></p>
	 * <p>Retorna o objeto do tipo Professor, na posição "i" do vetor.</p>
	 * 
	 * @param i (int indicando a posição do vetor a ser retornada)
	 * @return Professor (Professor)
	 */
	public Usuario getUsuario(int i) {
		return this.vProfessores[i];
	}

	/**
	 * <p><b>getQtdNoVetor()</b></p>
	 * <p>Retorna um inteiro indicando quantos objetivos estão armazenados
	 * dentro do vetor de professores.</p>
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
		return this.vProfessores.length;
	}
	
	
    ///////////////////////////////////////////////////
	// Métodos auxiliares
    ///////////////////////////////////////////////////	

	/**
	 * <p><b>matriculaExiste(int matricula)</b></p>
	 * <p>Verifica se já existe algum professor no vetor com a matrícula informada.</p>
	 * @param matricula (int representando um número de matrícula)
	 * @return True, se já existir um registro com essa matrícula<br />False, se não existir um registro com essa matrícula
	 */
	public boolean matriculaExiste(int matricula) {
		boolean resposta = false;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vProfessores[i].getMatricula() == matricula) {
				resposta = true;
				break;
			}
		}
		return resposta;
	}
	
	/**
	 * <p><b>posicaoNoVetor(int matricula)</b></p>
	 * <p>Verifica se já existe algum professor no vetor com a matrícula informada.</p>
	 * 
	 * @param matricula (int representando um número de matrícula)
	 * @return -1, se não existir nenhum professor com a matrícula informada<br />int representando a posição do professor com a matrícula informada
	 */
	public int posicaoNoVetor(int matricula) {
		int resposta = -1;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vProfessores[i].getMatricula() == matricula) {
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
	 * informações básicas sobre todos os professores (agregando as informações obtidas
	 * com o toString() da classe pai, Usuario). Obs.: a string de retorno, por padrão,
	 * NÃO CONTÉM linhas vazias acima ou abaixo do conteúdo.</p>
	 * 
	 * @return informacoes (String formatada com dados sobre o professor)
	 */
	public String toString() {
		String resposta = "";
		for (int i = 0; i < this.qtdNoVetor; i++) {
			resposta += this.vProfessores[i].toString();
		}
		return resposta;
	}
	
	
    ///////////////////////////////////////////////////
	// Setters e outros métodos relacionados
    ///////////////////////////////////////////////////
	
	/**
	 * <p><b>inserirProfessor(Professor novoProfessor)</b></p>
	 * <p>Verifica se o vetor de professores está cheio ou se já existe um professor com o mesmo
	 * número de matrícula e, se tudo OK, insere um novo professor.</p>
	 * 
	 * @return True, se o professor foi inserido<br />False, se o professor não foi inserido
	 */
	public boolean inserirProfessor(Professor novoProfessor) {
		boolean resposta = false;
		if (this.vetorCheio()) {
			resposta = false;
		} else if (this.matriculaExiste(novoProfessor.getMatricula())) {
			resposta = false;
		} else {
			this.vProfessores[this.qtdNoVetor] = novoProfessor;
			this.qtdNoVetor++;
			resposta = true;
		}
		return resposta;
	}
	
	/**
	 * <p><b>removerProfessor(int i)</b></p>
	 * <p>Verifica se o vetor de professores está vazio ou se está tentando remover um
	 * professor em um índice maior do que o vetor.
	 * Se tudo OK, remove o professor.</p>
	 * 
	 * @param i (int representando a posição do professor a ser removido do vetor)
	 * @return True, se o professor foi removido<br />False, se o professor não foi removido
	 */
	public boolean removerProfessor(int i) {
		boolean resposta = false;
		if (this.vetorVazio()) {
			resposta = false;
		} else if (i > this.qtdNoVetor) {
			resposta = false;
		} else {
			this.vProfessores[i] = this.vProfessores[this.qtdNoVetor - 1];
			this.qtdNoVetor -= 1;
			resposta = true;
		}
		return resposta;
	}

}
