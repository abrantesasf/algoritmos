package sisBib.principal;

/**
 * <p>A classe Aluno herda da Classe Usuario e acrescenta informações
 * pertinentes aos alunos.</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-11-10
 */
public class Aluno extends Usuario {

	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>curso</b>:</p>
	 * <ul>
	 * <li>Armazena o curso do aluno</li>
	 * <li>Tipo: String</li>
	 * <li>Tamanho: não definido</li>
	 * </ul>
	 */
	private String curso;
	
	/**
	 * <p><b>multa</b>:</p>
	 * <ul>
	 * <li>Armazena o valor da multa a pagar por atraso na devolução de itens do acervo</li>
	 * <li>Tipo: Double</li>
	 * <li>Tamanho: não definido</li>
	 * <li>Restrição: não pode ser valor negativo (mesmo se o aluno tiver crédito)</li>
	 * </ul>
	 */
	private Double multa;

	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////
	
	/**
	 * <p>O construtor para a classe Aluno necessita, obrigatoriamente, de receber
	 * 5 parâmetros básicos (matrícula, nome do aluno, endereço, data de ingresso no
	 * formato string, e curso.).</p>
	 * 
	 * <p>É feita uma chamada ao construtor da classe Usuario e o curso
	 * é atribuído à variável pertinente. O valor da multa é inicialmente 0.
	 * 
	 * @param matricula (int entre 1 e 99999999)
	 * @param nome (String)
	 * @param endereco (String)
	 * @param dataString (String no formato DD/MM/AAAA)
	 * @param curso (String)
	 */
	public Aluno(int matricula, String nome, String endereco, String dataString, String curso) {
		// Chama construtor da classe Usuario:
		super(matricula, nome, endereco, dataString);
		
		// Atribui o valor às variáveis curso e multa:
		this.curso = curso;
		this.multa = 0.0;
	}


    ///////////////////////////////////////////////////
	// Getters:
    ///////////////////////////////////////////////////
	
	/**
	 * <p><b>getCurso()</b></p>
	 * <p>Retorna uma String com o curso do aluno.</p>
	 * @return curso (String)
	 */
	public String getCurso() {
		return this.curso;
	}

	/**
	 * <p><b>getMulta()</b></p>
	 * <p>Retorna um Double com o valor das multas por atraso do aluno.</p>
	 * @return multa (Double)
	 */
	public Double getMulta() {
		return this.multa;
	}
	

    ///////////////////////////////////////////////////
	// Setters e outros métodos
    ///////////////////////////////////////////////////
	
	/**
	 * <p><b>setCurso(String curso)</b></p>
	 * <p>Atribui o curso de um aluno à variável correspondente.</b>
	 * @param curso (String)
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * <p><b>checaMultaNegativa(Double multa)</b></p>
	 * <p>Checa se multa a ser atribuída à variável, é >= 0.</p>
	 * 
	 * @param multa (Double)
	 * @return True, se a multa for >= a 0<br />False, se multa for < 0
	 */
	private boolean checaMultaNegativa(Double multa) {
		if (multa < 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * <p><b>setMulta(Double multa)</b></p>
	 * <p>Recebe o valor de uma multa, chama um método privado para testar se
	 * a multa é >= 0 e, se tudo estiver OK, atribui a multa à variável correta.</p>
	 * @param multa (Double)
	 */
	public void setMulta(Double multa) {
		if (checaMultaNegativa(multa)) {
			this.multa = multa;
		} else {
			System.out.println("ERRO! O valor da multa não pode ser negativo.");
		}
	}

	
    ///////////////////////////////////////////////////
	// Outros métodos auxiliares
    ///////////////////////////////////////////////////
	
	/**
	 * <p><b>toString()</b></p>
	 * <p>Sobrescreve o método padrão toString() do Java, retornando todas as
	 * informações básicas sobre o aluno (agregando as informações obtidas
	 * com o toString() da classe pai, Usuario). Obs.: a string de retorno, por padrão,
	 * NÃO CONTÉM linhas vazias acima ou abaixo do conteúdo.</p>
	 * 
	 * @return infoStud (String formatada com dados sobre o aluno)
	 */
	public String toString() {
		String infoStud = "";
		infoStud += super.toString()     + "\n" +
		            "Curso:            " + "\n" +
				    "Multa:            " + this.multa;
		return infoStud;
	}	
	
} // Fecha Classe Alunos
