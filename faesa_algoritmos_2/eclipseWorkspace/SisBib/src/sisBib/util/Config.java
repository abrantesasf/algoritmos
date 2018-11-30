package sisBib.util;

// Importação de bibliotecas
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import sisBib.util.Arquivos;

/**
 * <p>A classe Config contém métodos para realizar a leitura de um arquivo de configurações
 * (no formato "Properties Files" do Java, para a configuração de parâmetros básicos iniciais
 * do SisBib).</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-11-29
 */
public class Config {
	
	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>config</b>:</p>
	 * <ul>
	 * <li>Objeto para acesso às propriedades no Propertie File</li>
	 * <li>Tipo: Properties</li>
	 * </ul>
	 */
	private Properties config = new Properties();
	
	/**
	 * <p><b>input</b>:</p>
	 * <ul>
	 * <li>Stream de input do arquivo de configuração</li>
	 * <li>Tipo: InputStream</li>
	 * </ul>
	 */
	private InputStream input = null;
	
	/**
	 * <p><b>arq</b>:</p>
	 * <ul>
	 * <li>Objeto para trabalhar com arquivos</li>
	 * <li>Tipo: Arquivos</li>
	 * </ul>
	 */
	private Arquivos arq = new Arquivos();
	
	/**
	 * <p><b>sepDir</b>:</p>
	 * <ul>
	 * <li>Armazena o separador de diretórios e/ou arquivos do sistema operacional</li>
	 * <li>Tipo: String</li>
	 * </ul>
	 */
	private String sepDir = arq.separadorDeArquivosS();
	
	/**
	 * <p><b>configPath</b>:</p>
	 * <ul>
	 * <li>Caminho padrão do arquivo de configuração do SisBib</li>
	 * <li>Tipo: String</li>
	 * </ul>
	 */
	private String configPath = "config" + sepDir + "config.ini";
	
	/**
	 * <p><b>dbLibPath, dbDriver, dbUrl, dbLingua, dbPais</b>:</p>
	 * <ul>
	 * <li>Variáveis que armazenam configurações relativas ao banco de dados,
	 *     conforme o arquivo de configuração.</li>
	 * <li>Tipo: String</li>
	 * </ul>
	 */
	private String dbLibPath = "";
	private String dbDriver  = "";
	private String dbUrl     = "";
	private String dbLingua  = "";
	private String dbPais    = "";
	
	/**
	 * <p><b>lingua, pais</b>:</p>
	 * <ul>
	 * <li>Variáveis que armazenam configurações relativas à internacionalização e nacionalização,
	 *     da linguagem do SisBib.</li>
	 * <li>Tipo: String</li>
	 * </ul>
	 */
	private String lingua = "";
	private String pais   = "";
	
	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////
	
	/**
	 * <p>O construtor para a classe Config não recebe nenhum argumento, apenas
	 * lê o arquivo de configuração e pega os parâmetros.</p>
	 */
	public Config() {
		try {
			// Inicializa stream para acessar o arquivo de configuração
			input = new FileInputStream(configPath);
			
			// Carrega as configurações
			config.load(input);
			
			// Pega configurações do banco de dados
			this.dbLibPath = config.getProperty("dbLibPath");
			this.dbDriver  = config.getProperty("dbDriver");
			this.dbUrl     = config.getProperty("dbUrl");
			this.dbLingua  = config.getProperty("dbLingua");
			this.dbPais    = config.getProperty("dbPais");
			
			// Pega configuraçẽos de i10n e i18n
			this.lingua = config.getProperty("lingua");
			this.pais   = config.getProperty("pais");
			
		} catch (Exception e) {
			// Se erro, imprime stack:
			e.printStackTrace();
			
		} finally {
			// Se o stream de input está aberto,
			if (input != null) {
				try {
					// Fecha o stream de input
					input.close();
				} catch (IOException e2) {
					// Se erro, imprime stack
					e2.printStackTrace();
				}
			}
		}
	} // Fecha construtor
	
	
	///////////////////////////////////////////////////
	// Métodos
	///////////////////////////////////////////////////	
	
	/**
	 * <p><b>getDbLibPath()</b></p>
	 * <p>Retorna o parâmetro com o path da biblioteca do banco de dados.</p>
	 * @return dbLibPath (String)
	 */
	public String getDbLibPath() {
		return this.dbLibPath;
	}
	
	/**
	 * <p><b>getDbDriver()</b></p>
	 * <p>Retorna o parâmetro com o driver JDBC do banco de dados.</p>
	 * @return dbDriver (String)
	 */
	public String getDbDriver() {
		return this.dbDriver;
	}
	
	/**
	 * <p><b>getDbUrl()</b></p>
	 * <p>Retorna o parâmetro com a URI de acesso ao banco de dados, através de JDBC.</p>
	 * @return dbUrl (String)
	 */
	public String getDbUrl() {
		return this.dbUrl;
	}
	
	/**
	 * <p><b>getDbLingua()</b></p>
	 * <p>Retorna o parâmetro de configuração da linguagem do banco de dados.</p>
	 * @return dbLingua (String)
	 */
	public String getDbLingua() {
		return this.dbLingua;
	}
	
	/**
	 * <p><b>getDbPais()</b></p>
	 * <p>Retorna o parâmetro de configuração do país do banco de dados.</p>
	 * @return dbPais (String)
	 */
	public String getDbPais() {
		return this.dbPais;
	}
	
	/**
	 * <p><b>getLingua()</b></p>
	 * <p>Retorna o parâmetro de i10n/i18n para a linguagem do SisBib.</p>
	 * @return lingua (String)
	 */
	public String getLingua() {
		return this.lingua;
	}
	
	/**
	 * <p><b>getPais()</b></p>
	 * <p>Retorna o parâmetro de i10n/i18n para o país do SisBib.</p>
	 * @return pais (String)
	 */
	public String getPais() {
		return this.pais;
	}

} // Fecha Classe Config
