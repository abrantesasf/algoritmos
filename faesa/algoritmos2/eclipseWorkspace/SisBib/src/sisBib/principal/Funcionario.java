package sisBib.principal;

/**
 * <p>A classe Funcionario herda da Classe Usuario e acrescenta informações
 * pertinentes aos funcionários.</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-12-02
 */
public class Funcionario extends Usuario {
	
	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	private String setor;
	private String senha;
	private String login;
	
	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////
	
	public Funcionario(int matricula, String nome, String endereco, String dataString, String setor, String senha, String login) {
		super(matricula, nome, endereco, dataString);
		this.setor = setor;
		this.senha = senha;
		this.login = login;
	}
	
	
    ///////////////////////////////////////////////////
	// Getters:
    ///////////////////////////////////////////////////
	
	public String getSetor() {
		return setor;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String getLogin() {
		return login;
	}
	
	
    ///////////////////////////////////////////////////
	// Setters
    ///////////////////////////////////////////////////
	
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	
    ///////////////////////////////////////////////////
	// Outros métodos
    ///////////////////////////////////////////////////	
	
	public String toString() {
		String resposta = "";
		resposta += super.toString()                  + "\n" +
				    "Setor:            " + this.setor + "\n" +
				    "Login:			   " + this.login + "\n" +
				    "Senha:            " + this.senha;	   
		return resposta;
	}

}
