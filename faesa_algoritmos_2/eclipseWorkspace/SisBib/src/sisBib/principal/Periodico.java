package sisBib.principal;

/**
 * <p>A classe Periodico herda da Classe Acervo e acrescenta informações
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
public class Periodico extends Acervo {
	
	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>impacto</b> (fator de impacto do periódico)</p>
	 * <p>É uma variável do tipo <i>double</b> que representa o fator de 
	 * impacto do periódico.</p>
	 */
	private double impacto;
	
	/**
	 * <p><b>issn</b> (International Standard Serial Number)</p>
	 * <p>É uma variável do tipo <i>String</b> que representa o ISSN
	 * do periódico.</p>
	 */
	private String issn;
	
	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////		

	/**
	 * <p><b>Periodico(int codigo, String autores, String titulo, char tipo, double impacto, String issn)</b></p>
	 * <p>O construtor da Classe Periodico recebe 6 parâmetros obrigatórios: código,
	 * autores, título, tipo, impacto e issn.</p>
	 * @param codigo (int com até 8 dígitos representando o código do item)
	 * @param autores (String com o autor - ou autores - do item)
	 * @param titulo (String com o título do item)
	 * @param tipo (char com o tipo do item)
	 * @param impacto (double com o fator de impacto do periódico)
	 * @param issn (String com o ISSN do periódico)
	 */
	public Periodico(int codigo, String autores, String titulo, char tipo, double impacto, String issn) {
		// Usa o construtor da classe Acervo:
		super(codigo, autores, titulo, tipo);
		
		// Complementa com informações da classe Periodico:
		setImpacto(impacto);
		setISSN(issn);
	}
	
	
    ///////////////////////////////////////////////////
	// Getters:
    ///////////////////////////////////////////////////		

	/**
	 * <p><b>getImpacto()</b></p>
	 * <p>Retorna o fator de impacto do periódico.</p>
	 * @return <b>impacto</b> (double com o fator de impacto do periódico)
	 */
	public double getImpacto() {
		return this.impacto;
	}

	/**
	 * <p><b>getISSN()</b></p>
	 * <p>Retorna o ISSN do periódico.</p>
	 * @return <b>issn</b> (String com o ISSN do periódico)
	 */
	public String getISSN() {
		return this.issn;
	}
	
	
    ///////////////////////////////////////////////////
	// Setters:
    ///////////////////////////////////////////////////	

	/**
	 * <p><b>setImpacto(double impacto)</b></p>
	 * <p>Recebe um <i>double</i> com o fator de impacto do periódico,
	 * e atribui à variável correta.</p>
	 * @param impacto (double com o fator de impacto do periódico)
	 */
	public void setImpacto(double impacto) {
		if (validaImpacto(impacto)) {
			this.impacto = impacto;
		} else {
			System.out.println("ERRO! Fator de impacto fora dos limites.");
		}		
	}

	/**
	 * <p><b>setISSN(String issn)</b></p>
	 * <p>Recebe uma <i>String</i> que representa o ISSN do periódico,
	 * e atribui à variável correta.</p>
	 * @param issn (String com o ISSN do periódico)
	 */
	public void setISSN(String issn) {
		this.issn = issn;
	}
	
	
	///////////////////////////////////////////////////
	// Outros Métodos
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>validaImpacto(double impacto)</b></p>
	 * <p>Recebe um <i>double</i> que representa o fator de impacto do periódico e
	 * verifica se está dentro de parâmetros aceitáveis (>= 0).</p>
	 * @param impacto (double representando o fator de impacto do periódico)
	 * @return <b>True</b>, se dentro dos limites<br /><b>False</b>, se fora dos limites
	 */
	private boolean validaImpacto(double impacto) {
		if (impacto >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * <p><b>toString()</b></p>
	 * <p>Retorna uma String com as informações básicas do periódico.</p>
	 */
	public String toString() {
		String resposta = "";
		resposta += super.toString() + "\n" +
		            "Impacto:   " + getImpacto() + "\n" +
		            "ISSN:      " + getISSN();
		return resposta;
	}

}