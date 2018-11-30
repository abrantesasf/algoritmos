package sisBib.principal;

public class VetorDeUsuarios {

	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>vUsuarios</b>:</p>
	 * <ul>
	 * <li>Define um vetor do tipo Usuario</li>
	 * <li>Tipo: Usuario</li>
	 * </ul>
	 */
	private Usuario[] vUsuarios;
	
	/**
	 * <p><b>qtdNoVetor</b>:</p>
	 * <ul>
	 * <li>Controla a quantidade de objetos do tipo Usuario que estão dentro do vetor</li>
	 * <li>Tipo: int</li>
	 * </ul>
	 */
	private int qtdNoVetor;
	
	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////
	
	/**
	 * <p>O construtor para a classe VetorDeUsuarios recebe, obrigatoriamente,
	 * um número inteiro indicando a quantidade de posições que o vetor terá. O
	 * construtor inicializa o vetor de usuários e a variável de controle da quantidade
	 * de objetos que já estã no vetor.</p>
	 * 
	 * @param tamanho (int indicando quantas posições o vetor de usuário terá)
	 */	
	public VetorDeUsuarios(int tamanho) {
		this.vUsuarios = new Usuario[tamanho];
		this.qtdNoVetor = 0;
	}
	
	
    ///////////////////////////////////////////////////
	// Getters:
    ///////////////////////////////////////////////////	

	/**
	 * <p><b>getUsuario(int i)</b></p>
	 * <p>Retorna o objeto do tipo Usuario, na posição "i" do vetor.</p>
	 * 
	 * @param i (int indicando a posição do vetor a ser retornada)
	 * @return Usuario (Usuario)
	 */
	public Usuario getUsuario(int i) {
		return this.vUsuarios[i];
	}

	/**
	 * <p><b>getQtdNoVetor()</b></p>
	 * <p>Retorna um inteiro indicando quantos objetivos estão armazenados
	 * dentro do vetor de usuários.</p>
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
		return this.vUsuarios.length;
	}
	
	
    ///////////////////////////////////////////////////
	// Métodos auxiliares
    ///////////////////////////////////////////////////	

	/**
	 * <p><b>matriculaExiste(int matricula)</b></p>
	 * <p>Verifica se já existe algum usuário no vetor com a matrícula informada.</p>
	 * @param matricula (int representando um número de matrícula)
	 * @return True, se já existir um registro com essa matrícula<br />False, se não existir um registro com essa matrícula
	 */
	public boolean matriculaExiste(int matricula) {
		boolean resposta = false;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vUsuarios[i].getMatricula() == matricula) {
				resposta = true;
				break;
			}
		}
		return resposta;
	}
	
	/**
	 * <p><b>posicaoNoVetor(int matricula)</b></p>
	 * <p>Verifica se já existe algum usuário no vetor com a matrícula informada.</p>
	 * 
	 * @param matricula (int representando um número de matrícula)
	 * @return -1, se não existir nenhum usuário com a matrícula informada<br />int representando a posição do usuário com a matrícula informada
	 */
	public int posicaoNoVetor(int matricula) {
		int resposta = -1;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vUsuarios[i].getMatricula() == matricula) {
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
	 * informações básicas sobre todos os usuários (agregando as informações obtidas
	 * com o toString() da classe pai, Usuario). Obs.: a string de retorno, por padrão,
	 * NÃO CONTÉM linhas vazias acima ou abaixo do conteúdo.</p>
	 * 
	 * @return infoProf (String formatada com dados sobre o usuário)
	 */
	public String toString() {
		String resposta = "";
		for (int i = 0; i < this.qtdNoVetor; i++) {
			resposta += this.vUsuarios[i].toString();
		}
		return resposta;
	}
	
	
    ///////////////////////////////////////////////////
	// Setters e outros métodos relacionados
    ///////////////////////////////////////////////////
	
	/**
	 * <p><b>inserirUsuario(Usuario novoUsuario)</b></p>
	 * <p>Verifica se o vetor de usuários está cheio ou se já existe um usuário com o mesmo
	 * número de matrícula e, se tudo OK, insere um novo usuário.</p>
	 * 
	 * @return True, se o usuário foi inserido<br />False, se o usuário não foi inserido
	 */
	public boolean inserirUsuario(Usuario novoUsuario) {
		boolean resposta = false;
		if (this.vetorCheio()) {
			resposta = false;
		} else if (this.matriculaExiste(novoUsuario.getMatricula())) {
			resposta = false;
		} else {
			this.vUsuarios[this.qtdNoVetor] = novoUsuario;
			this.qtdNoVetor++;
			resposta = true;
		}
		return resposta;
	}
	
	/**
	 * <p><b>removerUsuario(int i)</b></p>
	 * <p>Verifica se o vetor de usuários está cheio ou se já existe um usuário com o mesmo
	 * número de matrícula e, se tudo OK, insere um novo usuário.</p>
	 * 
	 * @param i (int representando a posição do Usuário a ser removido do vetor)
	 * @return True, se o usuário foi inserido<br />False, se o usuário não foi inserido
	 */
	public boolean removerUsuario(int i) {
		boolean resposta = false;
		if (this.vetorVazio()) {
			resposta = false;
		} else if (i > this.qtdNoVetor) {
			
		} else {
			this.vUsuarios[i] = this.vUsuarios[this.qtdNoVetor - 1];
			this.qtdNoVetor -= 1;
			resposta = true;
		}
		return resposta;
	}

}
