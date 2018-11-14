package sisBib.classes;

// Importação de bibliotecas:
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * <p>A classe Usuario representa um usuário geral no Sistema de Biblioteca (SisBib).</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-11-10
 */
public class Usuario {
	
	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>matricula</b>:</p>
	 * <ul>
	 * <li>Código de matrícula de um usuário no sistema</li>
	 * <li>Tipo: inteiro (int)</li>
	 * <li>Tamanho: 1 a 99999999 (checado via método)</li>
	 * </ul>
	 */
	private int matricula;
	
	/**
	 * <p><b>nome</b>:</p>
	 * <ul>
	 * <li>Armazena o nome do usuário</li>
	 * <li>Tipo: String</li>
	 * <li>Tamanho: não definido</li>
	 * </ul>
	 */
	private String nome;
	
	/**
	 * <p><b>endereco</b>:</p>
	 * <ul>
	 * <li>Armazena o endereço completo do usuário</li>
	 * <li>Tipo: String</li>
	 * <li>Tamanho: não definido</li>
	 * </ul>
	 */
	private String endereco;
	
	/**
	 * <p><b>dataString</b>:</p>
	 * <ul>
	 * <li>Armazena a data de ingresso do usuário, em formato String</li>
	 * <li>Tipo: String</li>
	 * <li>Tamanho: não definido</li>
	 * <li>Formato: a data DEVE SER INFORMADA no formato DD/MM/AAAA</li>
	 * </ul>
	 */
	private String dataString;
	
	/**
	 * <p><b>data</b>:</p>
	 * <ul>
	 * <li>Armazena a data de ingresso do usuário, em um objeto da classe Date</li>
	 * <li>Tipo: Date</li>
	 * <li>Tamanho: não definido</li>
	 * </ul>
	 */
	private Date data = null;
	
	/**
	 * <p><b>sdf</b>:</p>
	 * <ul>
	 * <li>Armazena um formato de data (DD/MM/AAAA) em um objeto da classe SimpleDateFormat</li>
	 * <li>Tipo: SimpleDateFormat</li>
	 * <li>Tamanho: não definido</li>
	 * <li>Formato: DD/MM/AAAA</li>
	 * <li>Restrição: este atributo NÃO É UTILIZADO externamente fora desta classe.</li>
	 * </ul>
	 */
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////
	
	/**
	 * <p>O construtor para a classe Usuario necessita, obrigatoriamente, de receber
	 * 4 parâmetros básicos (matrícula, nome do usuário, endereço e data de ingresso no formato string).
	 * A partir desses parâmetros a variável data é calculada e preenchida.</p>
	 * 
	 * @param matricula (int entre 1 e 99999999)
	 * @param nome (String)
	 * @param endereco (String)
	 * @param dataString (String no formato DD/MM/AAAA)
	 */
	public Usuario(int matricula, String nome, String endereco, String dataString) {
		// Configura SimpleDateFormat
		this.sdf.setLenient(false);
		
		// Atribuição de valores:
		setMatricula(matricula);
		this.nome       = nome;
		this.endereco   = endereco;
		setDataString(dataString);
	}

	
    ///////////////////////////////////////////////////
	// Getters:
    ///////////////////////////////////////////////////
	
	/**
	 * <p><b>getMatricula()</b></p>
	 * <p>Retorna um inteiro com a matrícula do usuário.</p>
	 * @return matricula (int)
	 */
	public int getMatricula() {
		return this.matricula;
	}

	/**
	 * <p><b>getNome()</b></p>
	 * <p>Retorna uma String com o nome do usuário.</p>
	 * @return nome (String)
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * <p><b>getEndereco()</b></p>
	 * <p>Retorna uma String com o endereço completo do usuário.</p>
	 * @return endereco (String)
	 */
	public String getEndereco() {
		return this.endereco;
	}

	/**
	 * <p><b>getDataString()</b></p>
	 * <p>Retorna uma String com a data de ingresso do usuário, no formato DD/MM/AAAA.</p>
	 * @return dataString (String no formato DD/MM/AAAA)
	 */
	public String getDataString() {
		return this.dataString;
	}

	/**
	 * <p><b>getData()</b></p>
	 * <p>Retorna um objeto da classe Date, com a data de ingresso do usuário.</p>
	 * @return data (Date)
	 */
	public Date getData() {
		return this.data;
	}

	
    ///////////////////////////////////////////////////
	// Setters e outros métodos
    ///////////////////////////////////////////////////
	
	/**
	 * <p><b>checaLimitesMatricula(int matricula)</b></p>
	 * <p>Checa se o valor da matrícula está entre o mínimo (1)
	 * e o máximo permitido (99999999), conforme especificação do sistema.</p>
	 * <p>Este método NÃO É DE USO direto nas outras classes do sistema.</p>
	 * 
	 * @param matricula (int entre 1 e 99999999)
	 * @return True, se a matrícula está dentro dos limites<br />False, se a matrícula está fora dos limites
	 */
	private boolean checaLimitesMatricula(int matricula) {
		if ((matricula >= 1) & (matricula <= 99999999)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * <p><b>setMatricula(int matricula)</b></p>
	 * <p>Recebe um inteiro representando o número de matrícula de um usuário,
	 * checa se o número está dentro dos limites e atribui o valor à variável matrícula.</p>
	 * 
	 * @param matricula (int entre 1 e 99999999)
	 */
	public void setMatricula(int matricula) {
		if (checaLimitesMatricula(matricula)) {
			this.matricula = matricula;
		} else {
			System.out.println("ERRO! Matrícula fora dos limites permitidos (1 até 99999999).");
		}
	}

	/**
	 * <p><b>setNome(String nome)</b></p>
	 * <p>Recebe uma String representando o nome de um usuário e atribui o valor
	 * à variável nome.</p>
	 * 
	 * @param nome (String)
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * <p><b>setEndereco(String endereco)</b></p>
	 * <p>Recebe uma String representando o endereço completo de um usuário e atribui o valor
	 * à variável endereco.</p>
	 * 
	 * @param endereco (String)
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * <p><b>setDataString(String dataString)</b></p>
	 * <p>Recebe uma String representando uma data, OBRIGATORIAMENTE no formato
	 * DD/MM/AAAA, chama um método privado para testar se o formato da String
	 * representa corretamente uma data e, se tudo estiver OK, atribui a data
	 * à variável dataString.</p>
	 * 
	 * @param dataString (String no formato DD/MM/AAAA)
	 */
	public void setDataString(String dataString) {
		if (setData(dataString)) {
			this.dataString = dataString;
		} else {
			System.out.println("ERRO! Data em formato inválido.");
		}
	}

	/**
	 * <p><b>setData(String dataString)</b></p>
	 * <p>Checa se a String representa corretamente uma data, ou seja,
	 * se a String está no formato DD/MM/AAAA. Se estiver, atribui valor à
	 * variável data.</p>
	 * 
	 * @param dataString (String no formato DD/MM/AAAA)
	 * @return True, se a data estiver corretamente no formato DD/MM/AAAA<br />False, se a data NÃO estiver no formato DD/MM/AAAA
	 */
	private boolean setData(String dataString) {
		try {
			this.data = sdf.parse(dataString);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
    ///////////////////////////////////////////////////
	// Outros métodos auxiliares
    ///////////////////////////////////////////////////
	
	/**
	 * <p><b>toString()</b></p>
	 * <p>Sobrescreve o método padrão toString() do Java, retornando todas as
	 * informações básicas sobre o usuário. Obs.: a string de retorno, por padrão,
	 * NÃO CONTÉM linhas vazias acima ou abaixo do conteúdo.</p>
	 * 
	 * @return infoUser (String formatada com dados sobre o usuário)
	 */
	public String toString() {
		String infoUser = "";
		infoUser += "Matrícula:        " + this.matricula   + "\n" +
		            "Nome:             " + this.nome        + "\n" +
				    "Endereço:         " + this.endereco    + "\n" +
		            "Data de ingresso: " + this.dataString;
		return infoUser;
	}

} // Fecha Classe Usuario
