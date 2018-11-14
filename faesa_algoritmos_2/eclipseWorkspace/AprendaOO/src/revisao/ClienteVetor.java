package revisao;

public class ClienteVetor {
	// Abributos
	private Cliente[] vetor;
	private int       qtdNoVetor;
	
	// Construtor
	public ClienteVetor(int tamanho) {
		this.vetor = new Cliente[tamanho];
		this.qtdNoVetor = 0;
	}

	// Getters:
	public Cliente getVetor(int i) {
		return this.vetor[i];
	}

	public int getQtdNoVetor() {
		return this.qtdNoVetor;
	}
	
	public int retornaTamanhoDoVetor() {
		return this.vetor.length;
	}
	
	// Pesquisa se o nome do cliente já existe
	private boolean clienteJaExiste(String nome) {
		boolean resposta = false;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vetor[i].getNome().equalsIgnoreCase(nome)) {
				resposta = true;
			}
		}
		return resposta;
	}
	
	// Posição do ciente no vetor: por nome ou por conta
	public int posicaoNoVetor(String nome) {
		int resposta = -1;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vetor[i].getNome().equalsIgnoreCase(nome)) {
				resposta = i;
			}
		}
		return resposta;
	}
	
	public int posicaoNoVetor(int conta) {
		int resposta = -1;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vetor[i].getConta() == conta) {
				resposta = i;
			}
		}
		return resposta;
	}

	// Inserir Cliente:
	public boolean inserirCliente(Cliente novoCliente) {
		
		if (this.qtdNoVetor == this.vetor.length) {
			System.out.println("ERRO! Vetor cheiro.");
			return false;
			
		} else if (clienteJaExiste(novoCliente.getNome())){
			System.out.println("ERRO! Já existe um cliente com esse nome.");
			return false;
			
		} else {
			this.vetor[this.qtdNoVetor] = novoCliente;
			this.qtdNoVetor += 1;
			return true;
		}
	}
	
	// Remover Cliente:
	public boolean removerCliente(int i) {
		if (this.qtdNoVetor == 0) {
			System.out.println("ERRO! Vetor vazio.");
			return false;
		} else {
			this.vetor[i] = this.vetor[this.qtdNoVetor - 1];
			this.qtdNoVetor -= 1;
			return true;
		}
	}
	
	// tem espaço?
	public boolean temEspacoNoVetor() {
		if (this.vetor.length == this.qtdNoVetor) {
			return false;
		} else {
			return true;
		}
	}

	public void setQtdNoVetor(int qtdNoVetor) {
		this.qtdNoVetor = qtdNoVetor;
	}
	
	// toString
	public String toString() {
		String resposta = "";
		for (int i = 0; i < this.qtdNoVetor; i++) {
			resposta += this.vetor[i].toString() + "\n";
		}
		return resposta;
	}

	
}
