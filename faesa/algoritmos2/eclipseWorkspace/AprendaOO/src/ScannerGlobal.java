// Imports:
import java.util.Scanner;

/**
 * <p>Classe que implementa uma <i>instância única</i> de um objeto Scanner
 * para auxiliar nas operações de obtenção de dados dos usuários, via console, quando é necessário
 * usar vários Scanners em um programa (por exemplo, Scanners em diferentes classes e/ou métodos).</p>
 * 
 * <p>Atenção: apenas <i>uma única instância</i> de um objeto Scanner será criada e <i>compartilhada</i>
 * por todas as outras classes e/ou métodos do programa. Isso facilitará, e muito!, a complexidade
 * de trabalhar com inputs dos usuários em diversas classes e métodos do programa, evitando erros como
 * a perda do stream de input (por fechamento errado de um Scanner, por exemplo).</p>
 * 
 * <p>Motivação: cansei de apanhar ao usar a classe Scanner diretamente, principalmente quando o
 * programa precisava chamar vários Scanners: sempre ocorria algum problema devido à complexidade
 * inerente da classe Scanner. Após quebrar a cabeça durante um bom tempo procurando uma solução
 * encontrei, no StackOverflow, uma <a href="https://stackoverflow.com/a/29323215">sugestão para
 * usar uma <i>Singleton Class</i></a> para solucionar problemas desse tipo. A sugestão foi feita
 * por <a href="https://stackoverflow.com/users/2455432/remo-liechti"><i>Remo Liechti</i></a>, a
 * quem agradeço!</p>
 * 
 * @author  Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @version 1.0
 * @since   2018-09-29 
 * @see <a href="https://stackoverflow.com/a/29323215">Sugestão de Remo Liechti</a>
 * @see <a href="http://www.tutorialspoint.com/design_pattern/singleton_pattern.htm">Design Pattern - Singleton Pattern</a>
 * @see <a href="http://elearning.algonquincollege.com/coursemat/woollar/Courses/Common/OOP-Java/Input/InputCode-Singleton.pdf">Design Pattern: Singleton Class: Input.java</a>
 * @see <a href="https://www.oracle.com/technetwork/articles/java/singleton-1577166.html">When is a Singleton not a Singleton?</a>
 * @see <a href="https://dzone.com/articles/singleton-anti-pattern">When Singleton Becomes an Anti-Pattern</a>
 * @see <a href="http://www.javapractices.com/topic/TopicAction.do?Id=46">Singleton</a> 
 * 
 */
public final class ScannerGlobal {
	// Atributos:	
	/**
	 * <p>A variável <i>instancia</i> é uma "variável orientada à classe" e não uma "variável orientada ao
	 * objeto", por isso o uso da keyword "static". Apenas <i>uma única instância</i> do objeto
	 * ScannerGlobal existirá, e essa instância será rastreada por esta variável de referência.</p>
	 */
	private static ScannerGlobal instancia = null;
	
	/**
	 * <p>A variável <i>scan</i> é uma "variável orientada ao objeto" mas, já que apenas um, e apenas um,
	 * ScannerGlobal pode ser criado, apenas um único objeto Scanner poderá ser criado.</p>
	 */
	@SuppressWarnings("unused")
	private Scanner teclado;
	
	// Construtor(es):
	/**
	 * <p>Construtor privado para garantir que esta classe não possa ser instanciada novamente fora
	 * da própria ScannerGlobal. Inicialização do único Scanner.</p>
	 */
	private ScannerGlobal() {
		this.teclado = new Scanner(System.in);
	}
	
	// Getters:
	/**
	 * <p>Este método usa o modificador <i>static</i> para garantir que ele possa ser chamado a partir
	 * de outras classes, SEM A EXISTÊNCIA PRÉVIA de um objeto ScannerGlobal. Se nenhuma instância
	 * do objeto ScannerGlobal existir, ela será criada; se existir, será reutilizada.</p>
	 * 
	 * @return A única instância existente da classe ScannerGlobal, para ser reutilizada.
	 */
	public static synchronized ScannerGlobal getInstancia() {
		if (instancia == null) {
			instancia = new ScannerGlobal();
		}
		return instancia;
	}
	
	// Métodos do ScannerGlobal:
	/**
	 * Implementa o método nextByte() para o ScannerGlobal.
	 * @return ScannerGlobal.nextByte();
	 */
	public byte getNextByte() {
		return teclado.nextByte();
	}
	
	/**
	 * Implementa o método nextInt() para o ScannerGlobal.
	 * @return ScannerGlobal.nextInt()
	 */
	public int getNextInt() {
		return teclado.nextInt();
	}
	
	/**
	 * Implementa o método nextFloat() para o ScannerGlobal.
	 * @return ScannerGlobal.nextFloat()
	 */
	public float getNextFloat() {
		return teclado.nextFloat();
	}
	
	/**
	 * Implementa o método nextDouble() para o ScannerGlobal.
	 * @return ScannerGlobal.nextDouble()
	 */
	public double getNextDouble() {
		return teclado.nextDouble();
	}
	
	/**
	 * Implementa o método next() para o ScannerGlobal.
	 * @return ScannerGlobal.next()
	 */
	public String getNext() {
		return teclado.next();
	}
	
	/**
	 * Implementa o método nextLine() para o ScannerGlobal.
	 * @return ScannerGlobal.nextLine()
	 */
	public String getNextLine() {
		return teclado.nextLine();
	}
	
} // final da classe ScannerGlobal()
