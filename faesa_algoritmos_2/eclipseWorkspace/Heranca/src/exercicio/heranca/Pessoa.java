package exercicio.heranca;

public class Pessoa {
	// Atributos
	private String nome;
	private String telefone;
	private String endereco;
	private char   sexo;
	private String nascimento;
	
	// Construtores
	public Pessoa() {
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}

	// Getters
	public String getNome() {
		return this.nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public char getSexo() {
		return this.sexo;
	}

	public String getNascimento() {
		return this.nascimento;
	}

	// Setters
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public boolean setSexo(char sexo) {
		if (sexo == 'M' || sexo == 'F') {
			this.sexo = sexo;
			return true;
		} else {
			System.out.println("ERRO na inclusão do sexo (deve ser M ou F).");
			return false;
		}
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	// toString
	public String toString() {
		String resposta = "";
		resposta = "Nome: " + this.nome + "\n" +
		           "Sexo: " + this.sexo + "\n" +
				   "Nascimento: " + this.nascimento + "\n" +
		           "Telefone: " + this.telefone + "\n" +
				   "Endereço: " + this.endereco + "\n\n";
		return resposta;
	}

}
