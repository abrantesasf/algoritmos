package sisBib.principal;

/**
 * <p>A classe Professor herda da Classe Usuario e acrescenta informações
 * pertinentes aos professores.</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-11-10
 */
public class Professor extends Usuario {

	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>setor</b>:</p>
	 * <ul>
	 * <li>Armazena o setor de trabalho do professor</li>
	 * <li>Tipo: String</li>
	 * <li>Tamanho: não definido</li>
	 * </ul>
	 */
	private String setor;

	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////
	
	/**
	 * <p>O construtor para a classe Professor necessita, obrigatoriamente, de receber
	 * 5 parâmetros básicos (matrícula, nome do usuário, endereço, data de ingresso no
	 * formato string, e setor de trabalho do professor).</p>
	 * 
	 * <p>É feita uma chamada ao construtor da classe Usuario e o setor
	 * é atribuído à variável pertinente.
	 * 
	 * @param matricula (int entre 1 e 99999999)
	 * @param nome (String)
	 * @param endereco (String)
	 * @param dataString (String no formato DD/MM/AAAA)
	 * @param setor (String)
	 */
	public Professor(int matricula, String nome, String endereco, String dataString, String setor) {
		// Chama construtor da classe Usuario:
		super(matricula, nome, endereco, dataString);
		
		// Atribui valor à variável setor:
		this.setor = setor;
	}

    ///////////////////////////////////////////////////
	// Getters:
    ///////////////////////////////////////////////////
	
	/**
	 * <p><b>getSetor()</b></p>
	 * <p>Retorna uma String com o setor de trabalho do professor.</p>
	 * @return setor (String)
	 */
	public String getSetor() {
		return this.setor;
	}
	

    ///////////////////////////////////////////////////
	// Setters e outros métodos
    ///////////////////////////////////////////////////
	
	/**
	 * <p><b>setSetor(String setor)</b></p>
	 * <p>Atribui o setor de trabalho de um professor à variável
	 * correspondente.
	 * @param setor (String)
	 */
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	
    ///////////////////////////////////////////////////
	// Outros métodos auxiliares
    ///////////////////////////////////////////////////
	
	/**
	 * <p><b>toString()</b></p>
	 * <p>Sobrescreve o método padrão toString() do Java, retornando todas as
	 * informações básicas sobre o professor (agregando as informações obtidas
	 * com o toString() da classe pai, Usuario). Obs.: a string de retorno, por padrão,
	 * NÃO CONTÉM linhas vazias acima ou abaixo do conteúdo.</p>
	 * 
	 * @return infoProf (String formatada com dados sobre o usuário)
	 */
	public String toString() {
		String infoProf = "";
		infoProf += super.toString()     + "\n" +
				    "Setor:            " + this.setor;
		return infoProf;
	}
	
} // Fecha Classe Professor
