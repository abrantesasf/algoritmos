package sisBib.util;

// Importação de bibliotecas
import java.text.SimpleDateFormat;
import java.util.Locale;
import sisBib.util.Config;

/**
 * <p>A classe Validações contém métodos para a realização de validações específicas das regras
 * de negócio do SisBib.</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-11-29
 */
public class Validacoes {
	
	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>config</b></p>
	 * <ul>
	 * <li>Objeto para obter as configurações a partir de um arquivo.</li>
	 * <li>Tipo: Config</li>
	 * </ul>
	 */
	private Config config;
	
	/**
	 * <p><b>lingua, pais</b></p>
	 * <p>Variáveis que recebem as configurações de linguagem a partir do arquivo
	 * de configurações.</p>
	 */
	private String lingua = "";
	private String pais   = "";
	
	/**
	 * <p><b>local</b></p>
	 * <p>Objeto do tipo Locale para configurar e formatar dadas conforme as configurações
	 * de i10n/i18n do arquivod e configurações.</p>
	 */
	private Locale local;
	
	/**
	 * <p><b>sdfDDMMAAAA</b></p>
	 * <p>Variáveis para formatação de data, de diversas maneiras.</p>
	 */
	private SimpleDateFormat sdfDDMMAAAA = null;

	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////
	
	/**
	 * <p>O construtor para a classe CSV não recebe nada, apenas iniciliza
	 * a classe e algumas variáveis importantes para os métodos de validação.</p>
	 */
	public Validacoes() {
		// Lê o arquivo de configuração, pega as configurações de língua e país
		// e gera um Locale adequado
		this.config = new Config();
		this.lingua = config.getLingua();
		this.pais   = config.getPais();
		this.local  = new Locale(this.lingua, this.pais);
		
		// Formato para datas conforme especificação do SisBib:
		this.sdfDDMMAAAA = new SimpleDateFormat("dd/MM/yyyy", local);
		this.sdfDDMMAAAA.setLenient(false);
	}
	
	///////////////////////////////////////////////////
	// Métodos
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>validaMatricula(int matricula)</b></p>
	 * <p>Checa se o valor da matrícula está entre o mínimo (1)
	 * e o máximo permitido (99999999), conforme especificação do sistema.</p>
	 * 
	 * @param matricula (int entre 1 e 99999999)
	 * @return True, se a matrícula está dentro dos limites<br />False, se a matrícula está fora dos limites
	 */
	public boolean validaMatricula(int matricula) {
		if ((matricula >= 1) & (matricula <= 99999999)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * <p><b>validaData(String data)</b></p>
	 * <p>Checa se uma String no formato "DD/MM/AAAA" pode ser corretamente
	 * interpretada como uma data. A String passada como argumento deve
	 * estar no formato "DD/MM/AAAA" e corresponder a uma data válida para
	 * que o método retorne true.</p>
	 * 
	 * @param data (String no formato "DD/MM/AAAA")
	 * @return <b>True</b>, se a String corresponder a uma data válida<br /><b>False</b>, se a String não corresponder a uma data válida
	 */
	public boolean validaData(String data) {
		try {
			this.sdfDDMMAAAA.parse(data);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * <p><b>removeCaractereDeString(String texto, String caractere)</b></p>
	 * <p>Este método pega uma String qualquer de texto e remove ocorrências do caractere passado
	 * como parâmetro. Esse método foi pensado para ser utilizado
	 * durante a gravação de um arquivo CSV, para a remoção de caracteres que podem
	 * ser confundidos com o delimitador do CSV.</p>
	 */
	public String removeCaractereDeString(String texto, String caractere) {
		String resposta = texto;
		resposta = resposta.replace(caractere, "");
		return resposta;
	}
	
	/**
	 * <p><b>checaMulta(double multa)</b></p>
	 * <p>Verifica se o valor da multa está dentro do estabelecido pelo SisBib.</p>
	 * @param multa (double)
	 * @return <b>True</b>, se a multa está OK<br /><b>False</b>, se a multa está fora dos parâmetros
	 */
	public boolean checaMulta(double multa) {
		if (multa < 0) {
			return false;
		} else {
			return true;
		}
	}

} // Fecha Classe Validacoes
