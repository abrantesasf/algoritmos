package revisao;

public class Pessoa {
	// Atributos
	private String nome;
	private String cpf;
	
	// Construtores
	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Pessoa() {
	}

	// Getters:
	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	// Setters:
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	// toString
	public String toString() {
		String resposta = "\n";
		resposta += "Nome:          " + this.nome + "\n" +
		            "CPF:           " + this.cpf + "\n";
		return resposta;
	}
	
}
