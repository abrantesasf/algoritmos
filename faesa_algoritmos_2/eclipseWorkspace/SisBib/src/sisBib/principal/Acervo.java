package sisBib.principal;

/**
 * <p>A classe Acervo é uma classe genérica geral para armazenar as características comuns
 * a diversos itens do acervo de uma biblioteca.</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-11-17
 */
public class Acervo {
	
	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////	
	
	/**
	 * <p><b>codigo (código do item)</b></p>
	 * <p>É uma variável do tipo <i>int</b> que representa o "ID" deste item na biblioteca,
	 * sendo um inteiro com até 8 dígitos. Não pode haver códigos duplicados.</p>
	 */
	private int codigo;
	
	/**
	 * <p><b>autores (autor(es) do item)</b></p>
	 * <p>É uma variável do tipo <i>String</i> que armazena o autor (ou autores)
	 * do item. Se houver mais de um autor, serão simplesmente separados por vírgula.</p>
	 */
	private String autores;
	
	/**
	 * <p><b>titulo (título do item)</b></p>
	 * <p>É uma variável do tipo <i>String</i> que armazena o título do item.</p>
	 */
	private String titulo;
	
	/**
	 * <p><b>tipo (tipo do item)</b></p>
	 * <p>É uma variável do tipo <i>char</i> que armazena um código de 1 letra,
	 * indicando o tipo do item. Atualmente são permitidos os seguintes tipos:</p>
	 * <ul>
	 * <li>L = livro</li>
	 * <li>P = periódico</li>
	 * </ul> 
	 */
	private char tipo;
	
	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////	
	
	/**
	 * <p><b>Acervo(int codigo, String autores, String titulo, char tipo)</b></p>
	 * <p>O construtor da Classe Acervo recebe 4 parâmetros obrigatórios: código,
	 * autores, título e tipo.</p>
	 * @param codigo (int com até 8 dígitos representando o código do item)
	 * @param autores (String com o autor - ou autores - do item)
	 * @param titulo (String com o título do item)
	 * @param tipo (char com o tipo do item)
	 */
	public Acervo(int codigo, String autores, String titulo, char tipo) {
		setCodigo(codigo);
		setAutores(autores);
		setTitulo(titulo);
		setTipo(tipo);
	}
	
	
    ///////////////////////////////////////////////////
	// Getters:
    ///////////////////////////////////////////////////	

	/**
	 * <p><b>getCodigo()</b></p>
	 * <p>Retorna o código do item.</p>
	 * @return <b>codigo</b> (int representando o código do item)
	 */
	public int getCodigo() {
		return this.codigo;
	}

	/**
	 * <p><b>getAutores()</b></p>
	 * <p>Retorna o autor(es) do item.</p>
	 * @return <b>autores</b> (String com o autor(es) do item)
	 */
	public String getAutores() {
		return this.autores;
	}

	/**
	 * <p><b>getTitulo()</b></p>
	 * <p>Retorna o título do item.</p>
	 * @return <b>titulo</b> (String com o título do item)
	 */
	public String getTitulo() {
		return this.titulo;
	}

	/**
	 * <p><b>getTipo()</b></p>
	 * <p>Retorna o tipo do item.</p>
	 * @return <b>tipo</b> (char com o tipo do item)
	 */
	public char getTipo() {
		return this.tipo;
	}
	
	
    ///////////////////////////////////////////////////
	// Setters:
    ///////////////////////////////////////////////////

	/**
	 * <p><b>setCodigo(int codigo)</b></p>
	 * <p>Recebe um inteiro, valida e atribui o código ao item.</p>
	 * @param codigo (int com até 8 dígitos)
	 */
	public void setCodigo(int codigo) {
		if (validaCodigo(codigo)) {
			this.codigo = codigo;
		} else {
			System.out.println("ERRO! Código fora dos limites permitidos (1 até 99999999).");
		}
	}

	/**
	 * <p><b>setAutores(int codigo)</b></p>
	 * <p>Recebe uma String com o autor (ou autores) do item, e atribui o valor.</p>
	 * @param autores (String com o autor (ou autores) do item)
	 */
	public void setAutores(String autores) {
		this.autores = autores;
	}

	/**
	 * <p><b>setTitulo(String titulo)</b></p>
	 * <p>Recebe uma String com o título do item e atribui o valor.</p>
	 * @param autores (String com o autor (ou autores) do item)
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * <p><b>setTipo(char tipo)</b></p>
	 * <p>Recebe um char com o tipo do item e atribui o valor.</p>
	 * @param tipo (char com o tipo do item)
	 */
	public void setTipo(char tipo) {
		if (validaTipo(tipo)) {
			this.tipo = tipo;
		} else {
			System.out.println("ERRO! Tipo de publicação não permitida.");
		}
	}	
	
	
	///////////////////////////////////////////////////
	// Outros Métodos
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>validaCodigo(int codigo)</b></p>
	 * <p>Checa se o valor do código de um item do acervo está entre o mínimo (1)
	 * e o máximo permitido (99999999), conforme especificação do sistema.</p>
	 * 
	 * @param codigo (int entre 1 e 99999999)
	 * @return <b>True</b>, se o código está dentro dos limites<br /><b>False</b>, se o código está fora dos limites
	 */
	private boolean validaCodigo(int codigo) {
		if ((codigo >= 1) & (codigo <= 99999999)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * <p><b>validaTipo(char tipo)</b></p>
	 * <p>Checa se o código do tipo da publicação está entre os tipos
	 * permitidos.</p>
	 * @param tipo (char)
	 * @return <b>True</b>, se o tipo for válido<br /><b>False</b>, se o tipo for inválido
	 */
	private boolean validaTipo(char tipo) {
		boolean resposta;
		switch (tipo) {
		case 'L':
			// O item é um Livro
			resposta = true;
			break;
		case 'P':
			// O item é um periódico
			resposta = true;
			break;
		default:
			// O item é outra coisa não permitida
			resposta = false;
			break;
		}
		return resposta;
	}
	
	/**
	 * <p><b>toString()</b></p>
	 * <p>Retorna uma String com as informações básicas do item do acervo.</p>
	 */
	public String toString() {
		String resposta = "";
		resposta += "Código:    " + getCodigo()  + "\n" +
		            "Título:    " + getTitulo()  + "\n" +
		            "Autor(es): " + getAutores() + "\n" +
				    "Tipo:      " + getTipo();
		return resposta;
	}
}
