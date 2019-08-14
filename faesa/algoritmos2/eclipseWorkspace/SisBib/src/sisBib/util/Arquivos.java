package sisBib.util;

// Imports
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <p>Classe que implementa vários métodos utilitários para operações com arquivos diversos, de
 * importação e exportação. Já que essa classe trabalho com aquivos de dados, foi colocada
 * no pacote sisBib.db.</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 *  
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-11-16
 */
public class Arquivos {
	
	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>path</b>:</p>
	 * <ul>
	 * <li>Armazena um caminho (path) de diretório ou arquivo</li>
	 * <li>Tipo: Path</li>
	 * <li>Tamanho: não definido</li>
	 * </ul>
	 */
	private Path path;
	
	/**
	 * <p><b>separadorDeArquivos<String|Char></b></p>
	 * <ul>
	 * <li>Variáveis que armazenam o separador de arquivos padrão do sistema operacional.</li>
	 * <li>Tipo: String ou char</li>
	 * </ul>
	 */
	private String separadorDeArquivosString = File.separator;
	private char   separadorDeArquivosChar   = File.separatorChar;
	
	/**
	 * <p><b>separadorDeDiretorios<String|Char></b></p>
	 * <ul>
	 * <li>Variáveis que armazenam o separador de diretórios padrão do sistema operacional.</li>
	 * <li>Tipo: String ou char</li>
	 * </ul>
	 */
	private String separadorDeDiretoriosString = File.pathSeparator;
	private char   separadorDeDiretoriosChar   = File.separatorChar;
	
	
	///////////////////////////////////////////////////
	// Construtor(es)
	///////////////////////////////////////////////////
	
	/**
	 * <p>O construtor para a classe Arquivos não necessita de nenhum 
	 * parâmetros. As variáveis serão inicializadas na chamada de métodos.</p>
	 */
	public Arquivos() {
		// Construtor padrão.
	}
	
	
	///////////////////////////////////////////////////
	// Métodos
	///////////////////////////////////////////////////
	
	/**
	 * <p><b>arquivoExiste(String path)</b></p>
	 * <p>Checa se um determinado PATH (que deve ser um arquivo)
	 * existe, verificando também algumas exceptions comuns.</p>
	 * 
	 * @param path (String que representa um PATH para um arquivo)
	 * @return True, se o PATH for um arquivo<br />False, se o PATH não for um arquivo
	 */
	public boolean arquivoExiste(String path) {
		boolean retorno = false;

		this.path = Paths.get(path);

		if (Files.exists(this.path) && (Files.isRegularFile(this.path))) {
				retorno = true;
		};
		
		return retorno;
	}
	
	/**
	 * <p><b>diretorioExiste(String path)</b></p>
	 * <p>Checa se um determinado PATH (que deve ser um diretório)
	 * existe, verificando também algumas exceptions comuns.</p>
	 * 
	 * @param path (String que representa um PATH para um diretório)
	 * @return True, se o PATH for um diretório<br />False, se o PATH não for um diretório
	 */
	public boolean diretorioExiste(String path) {
		boolean retorno = false;

		this.path = Paths.get(path);
		
		if (Files.exists(this.path) && (Files.isDirectory(this.path))) {
				retorno = true;
		};

		return retorno;
	}
	
	/**
	 * <p><b>contarLinhas(String arquivo)</b></p>
	 * <p>Método que retorna um inteiro contendo a quantidade de linhas
	 * em um arquivo texto. Esse método foi retirado diretamente de uma
	 * publicação no <a href="https://stackoverflow.com/a/453067/6850077">Stack Overflow</a>,
	 * e ligeiramente adaptado para nossas
	 * necessidades. Todos os créditos vão para o autor original.</p>
	 * 
	 * @author martinus <a href="https://stackoverflow.com/users/48181/martinus">Martinus's Stack Overflow page</a>
	 * @see <a href="https://stackoverflow.com/a/453067/6850077">https://stackoverflow.com/a/453067/6850077</a>
	 * @param arquivo (String que representa o PATH completo até um arquivo)
	 * @return int
	 * @throws IOException
	 */
	public int contarLinhas(String arquivo) throws IOException {
		// Cria um stream de input:
	    InputStream is = new BufferedInputStream(new FileInputStream(arquivo));
	    
	    try {
	        byte[] c = new byte[1024];
	        int contador = 0;
	        int caracteresLidos = 0;
	        boolean arquivoVazio = true;
	        
	        // Enquanto existem caracteres
	        while ((caracteresLidos = is.read(c)) != -1) {
	        	// O arquivo não está vazio
	            arquivoVazio = false;
	            
	            // Se tem nova linha, aumenta o contador de linhas
	            for (int i = 0; i < caracteresLidos; ++i) {
	                if (c[i] == '\n') {
	                    ++contador;
	                }
	            }
	        }
	        return (contador == 0 && !arquivoVazio) ? 1 : contador;
	    } finally {
	    	// Fecha o stream de input:
	        is.close();
	    }
	}
	
	/**
	 * <p><b>separadorDeArquivosS()</b></p>
	 * <p>Retorna o separador de arquivos padrão do sistema operacional, como String.
	 * @return String que representa o separador de arquivos padrão do sistema operacional.
	 */
	public String separadorDeArquivosS() {
		return this.separadorDeArquivosString;
	}
	
	/**
	 * <p><b>separadorDeArquivosC()</b></p>
	 * <p>Retorna o separador de arquivos padrão do sistema operacional, como char.
	 * @return char que representa o separador de arquivos padrão do sistema operacional.
	 */
	public char separadorDeArquivosC() {
		return this.separadorDeArquivosChar;
	}
	
	/**
	 * <p><b>separadorDeDiretoriosS()</b></p>
	 * <p>Retorna o separador de diretórios padrão do sistema operacional, como String.
	 * @return String que representa o separador de diretórios padrão do sistema operacional.
	 */
	public String separadorDeDiretoriosS() {
		return this.separadorDeDiretoriosString;
	}
	
	/**
	 * <p><b>separadorDeDiretoriosC()</b></p>
	 * <p>Retorna o separador de diretórios padrão do sistema operacional, como char.
	 * @return char que representa o separador de diretórios padrão do sistema operacional.
	 */
	public char separadorDeDiretoriosC() {
		return this.separadorDeDiretoriosChar;
	}
	
} // Fecha Classe Arquivos