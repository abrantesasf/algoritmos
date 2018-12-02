package sisBib.principal;

import java.util.Calendar;

/**
 * <p>A classe Livro herda da Classe Acervo e acrescenta informações
 * pertinentes.</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-12-01
 */
public class Livro extends Acervo {
	
	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>editora</b> (nome da editora do livro)</p>
	 * <p>É uma variável do tipo <i>String</b> que representa o nome da Editora que publicou o livro.</p>
	 */
	private String editora;
	
	/**
	 * <p><b>anoString</b> (ano da publicação do livro)</p>
	 * <p>É uma variável do tipo <i>String</b> que representa o ano de publicação
	 * do livro.</p>
	 */
	private int ano;
	
	/**
	 * <p><b>isbn</b> (International Standard Book Numeration)</p>
	 * <p>É uma variável do tipo <i>String</b> que representa o ISBN
	 * do livro.</p>
	 */
	private String isbn;
	
	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////		

	/**
	 * <p><b>Livro(int codigo, String autores, String titulo, char tipo, String editora, String anoString, String isbn)</b></p>
	 * <p>O construtor da Classe Livro recebe 7 parâmetros obrigatórios: código,
	 * autores, título, tipo, editora, anoString e isbn.</p>
	 * @param codigo (int com até 8 dígitos representando o código do item)
	 * @param autores (String com o autor - ou autores - do item)
	 * @param titulo (String com o título do item)
	 * @param tipo (char com o tipo do item)
	 * @param editora (String com o nome da editora que publicou o livro)
	 * @param ano (int que representa um ano, com 4 dígitos)
	 * @param isbn (String com o ISBN do livro)
	 */
	public Livro(int codigo, String autores, String titulo, char tipo, String editora, int ano, String isbn) {
		// Usa o construtor da classe Acervo:
		super(codigo, autores, titulo, tipo);
		
		// Complementa com informações da classe Livro:
		setEditora(editora);
		setAno(ano);
		setISBN(isbn);
	}
	
	
    ///////////////////////////////////////////////////
	// Getters:
    ///////////////////////////////////////////////////		

	/**
	 * <p><b>getEditora()</b></p>
	 * <p>Retorna a editora que publicou o livro.</p>
	 * @return <b>editora</b> (String com a editora que publicou o livro)
	 */
	public String getEditora() {
		return this.editora;
	}

	/**
	 * <p><b>getAno()</b></p>
	 * <p>Retorna o ano de publicação do livro.</p>
	 * @return <b>ano</b> (int com o ano de publicação do livro)
	 */
	public int getAno() {
		return this.ano;
	}

	/**
	 * <p><b>getISBN()</b></p>
	 * <p>Retorna o ISBN do livro.</p>
	 * @return <b>isbn</b> (String com o ISBN do livro)
	 */
	public String getIsbn() {
		return this.isbn;
	}
	
	
    ///////////////////////////////////////////////////
	// Setters:
    ///////////////////////////////////////////////////	

	/**
	 * <p><b>setEditora(String editora)</b></p>
	 * <p>Recebe uma <i>String</i> com o nome da editora que publicou o livro,
	 * e atribui à variável correta.</p>
	 * @param editora (String com o nome da editora que publicou o livro)
	 */
	public void setEditora(String editora) {
		this.editora = editora;
	}

	/**
	 * <p><b>setAno(int ano)</b></p>
	 * <p>Recebe um <i>int</i> com 4 dígitos representando o ano de publicação do livro,
	 * valida de acordo com os limites estabelecidos, e atribui à variável correta.</p>
	 * @param ano (int de 4 dígitos representando o ano de publicação do livro)
	 */
	public void setAno(int ano) {
		if (validaAno(ano)) {
			this.ano = ano;
		} else {
			System.out.println("ERRO! Ano de publicação fora dos limites estabelecidos.");
		}
	}

	/**
	 * <p><b>setIsbn(String isbn)</b></p>
	 * <p>Recebe uma <i>String</i> que representa o ISBN do livro,
	 * e atribui à variável correta.</p>
	 * @param isbn (String com o ISBN do livro)
	 */
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
	
	
	///////////////////////////////////////////////////
	// Outros Métodos
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>validaAno(int ano)</b></p>
	 * <p>Recebe um inteiro de 4 dígitos representando o ano de publicação do livro e
	 * verifica se está dentro de parâmetros aceitáveis (no momento, entre 1800 e o ano atual).</p>
	 * @param ano (int representando o ano de publicação)
	 * @return <b>True</b>, se ano dentro dos limites<br /><b>False</b>, se ano fora dos limites
	 */
	private boolean validaAno(int ano) {
		if ((ano >= 1800) & (ano <= Calendar.getInstance().get(Calendar.YEAR))) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * <p><b>toString()</b></p>
	 * <p>Retorna uma String com as informações básicas do livro.</p>
	 */
	public String toString() {
		String resposta = "";
		resposta += super.toString() + "\n" +
		            "Editora:   " + getEditora() + "\n" +
				    "Ano:       " + getAno()     + "\n" +
		            "ISBN:      " + getIsbn();
		return resposta;
	}

}
