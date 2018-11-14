package sisBib.db;

//Importação de bibliotecas:
import java.sql.*;

/**
 * <p>A classe PostgreSQL contém os métodos para realizar a conexão com um banco de dados
 * PostgreSQL onde as informações serão armazenadas. Observações:</p>
 * 
 * <ul>
 * <li>A conexão pode ser local ou remota</li>
 * <li>O método de conexão que estabelecimos EXIGE um usuário e senha com permissão de acesso ao banco
 * de dados e aos objetos do banco de dados. Se esse usuário não existir ou não tiver
 * acesso aos objetos do banco de dados, o programa irá falhar.</li>
 * <li>Conexões SSL não foram implementadas, ainda, nesta classe.</li>
 * </ul>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-11-13
 */
public class PostgreSQL {
	
	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>driver</b>:</p>
	 * <ul>
	 * <li>Driver JDBC a ser utilizado</li>
	 * <li>Tipo: String</li>
	 * </ul>
	 */
	private String driver = "";
	
	/**
	 * <p><b>caminho</b>:</p>
	 * <ul>
	 * <li>Path do driver JDBC a ser utilizado</li>
	 * <li>Tipo: String</li>
	 * </ul>
	 */
	@SuppressWarnings("unused")
	private String caminho = "";
	
	/**
	 * <p><b>url</b>:</p>
	 * <ul>
	 * <li>URL (uniform resourse locator) para a conexão do banco de dados</li>
	 * <li>Tipo: String</li>
	 * </ul>
	 */
	private String url = "";
	
	/**
	 * <p><b>conexao</b>:</p>
	 * <ul>
	 * <li>Objeto Connection que armazena a conexão ao banco de dados</li>
	 * <li>Tipo: Connection</li>
	 * </ul>
	 */
	private Connection conexao;
	
	/**
	 * <p><b>query</b></p>
	 * <ul>
	 * <li>Objeto do tipo PreparedStatement, para armazenar as queries SQL do usuário</li>
	 * <li>Tipo: PreparedStatement</li>
	 * </ul>
	 */
	
	private PreparedStatement query;
	
	/**
	 * <p><b>rs</b></p>
	 * <ul>
	 * <li>Objeto do tipo ResultSet, para armazenar o resultado de uma query SQL</li>
	 * <li>Tipo: ResultSet</li>
	 * </ul>
	 */
	private ResultSet rs;
	
	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////
	
	/**
	 * <p>O construtor para a classe PostgreSQL não recebe nenhum argumento, apenas
	 * atribui valores previamente estabelecidos às variáveis da classe.</p>
	 * 
	 * TODO: ler esses valores a partir de arquivo "ini" (não sei fazer isso)
	 */
	public PostgreSQL() {
		this.caminho = "/home/abrantesasf/repositoriosGit/algoritmos/faesa_algoritmos_2/eclipseWorkspace/SisBib/lib/";
		this.driver = "org.postgresql.Driver";
		this.url = "jdbc:postgresql://localhost:5432/vdiesel";
	}
	
	
	///////////////////////////////////////////////////
	// Métodos
	///////////////////////////////////////////////////	
	
	/**
	 * <p><b>abrirConexao(String usuario, String senha)</b></p>
	 * <p>Recebe duas strings (nome/login de usuário, senha) para abrir uma conexão
	 * ao banco de dados.</p>
	 * 
	 * @param usuario (String)
	 * @param senha (String)
	 * @return True, se a conexão foi realizada<br />False, se a conexão não foi realizada
	 */
	public boolean abrirConexao(String usuario, String senha) {
		boolean resposta = false;
		try {
			Class.forName(driver);
			this.conexao = DriverManager.getConnection(this.url, usuario, senha);
			resposta = true;
		} catch (ClassNotFoundException e) {
			System.out.println("ERRO! Driver do banco de dados não encontrado.\n" +
		                       e.toString());
		} catch (SQLException e) {
			System.out.println("ERRO! Problemas na conexão ao banco de dados.\n" +
		                       e.toString());
		}
		return resposta;
	}
	
	/**
	 * <p><b>usarConexao()</b></p>
	 * <p>Retorna o objeto contendo a conexão ao banco de dados, para uso
	 * em queries, etc.</p>
	 * 
	 * @return conexao (Connection)
	 */
	@SuppressWarnings("unused")
	private Connection usarConexao() {
		return this.conexao;
	}
	
	/**
	 * <p><b>conexaoExiste()</b></p>
	 * <p>Verifica se o objeto Connection foi criado, ou seja, se ele existe.</p>
	 * 
	 * @return True, se a conexão foi criada<br />False, se a conexão não foi criada
	 */
	public boolean conexaoExiste() {
		boolean resposta = false;
		try {
			if (this.conexao != null) {
				resposta = true;
			}
		} catch (Exception e) {
			System.out.println("ERRO: " + e.toString());
		}
		return resposta;
	}
	
	/**
	 * <p><b>conexaoEstaAtiva()</b></p>
	 * <p>Checa se a conexão ao banco de dados está ativa e válida.</p>
	 * 
	 * @return True, se a conexão ao banco de dados estiver ativa<br />False, se a conexão ao banco de dados estiver fechada
	 */
	public boolean conexaoEstaAtiva() {
		boolean resposta = false;
		try {
			if (conexaoExiste() && this.conexao.isValid(300)) {
				resposta = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}
	
	/**
	 * <p><b>fecharConexao()</b></p>
	 * <p>Fecha a conexão ao banco de dados.</p>
	 * 
	 * @return True, se a conexão foi fechada<br />False, se a conexão não foi fechada
	 */
	public boolean fecharConexao() {
		boolean resposta = false;
		try {
			this.conexao.close();
			resposta = true;
		} catch (Exception e) {
			System.out.println("ERRO: " + e.toString());
		}
		return resposta;
	}
	
	/**
	 * <p><b>conexaoEstaFechada()</b></p>
	 * <p>Checa se a conexão ao banco de dados está fechada.</p>
	 * 
	 * @return True, se a conexão ao banco de dados estiver fechada<br />False, se a conexão ao banco de dados estiver aberta
	 */
	public boolean conexaoEstaFechada() {
		boolean resposta = false;
		try {
			if (this.conexao.isClosed()) {
				resposta = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}

	/**
	 * <p><b>preparaQuery(String sql)</b></p>
	 * <p>Pega uma String representando uma query SQL preparada pelo usuário
	 * e cria um objeto do tipo PreparedQuery.</p>
	 * 
	 * @param sql (String representando uma query SQL)
	 */
	public void prepararQuery(String sql) {
		try {
			this.query = this.conexao.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p><b>usarQuery()</b></p>
	 * <p>Retorna o objeto query (do tipo PreparedStatement) para o usuário. É uma forma
	 * de abstrair a criação e uso desse objeto para facilitar a programação em outras
	 * classes.</p>
	 * 
	 * @return query (PreparedStatement)
	 */
	public PreparedStatement usarQuery() {
		return this.query;
	}
	
	/**
	 * <p><b>executarQuery()</b></p>
	 * <p>Executa uma query e coloca os resultados em um ResultSet.</p>
	 */
	public void executarQuery() {
		try {
			this.rs = this.query.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p><b>resultadosDaQuery()</b></p>
	 * <p>Retorna os resultados de uma query SQL que estão armazenados em
	 * um objeto ResultSet.
	 * 
	 * @return rs (ResultSet)
	 */
	public ResultSet resultadosDaQuery() {
		return this.rs;
	}

	/**
	 * <p><b>terminaQuery()</b></p>
	 * <p>Abstração para rechar um ResultSet e
	 * fechar uma PreparedStatement.</p>
	 */
	public void terminaQuery() {
		try {
			if (!this.rs.isClosed()) {
				this.rs.close();
			}
			if (!this.query.isClosed()) {
				this.query.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

} // Fecha Classe PostgreSQL
