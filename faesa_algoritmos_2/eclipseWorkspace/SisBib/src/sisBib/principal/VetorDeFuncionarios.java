package sisBib.principal;

public class VetorDeFuncionarios {
	
	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	private Funcionario[] vFuncionario;
	private int           qtdNoVetor;
	
	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////
	
	public VetorDeFuncionarios(int tamanho) {
		this.vFuncionario = new Funcionario[tamanho];
		this.qtdNoVetor = 0;
	}
	
	
    ///////////////////////////////////////////////////
	// Getters:
    ///////////////////////////////////////////////////	
	
	public Funcionario getFuncionario(int i) {
		return this.vFuncionario[i];
	}
	
	public int getQtdNoVetor() {
		return this.qtdNoVetor;
	}
	
	public int getTamanhoDoVetor() {
		return this.vFuncionario.length;
	}
	
	
    ///////////////////////////////////////////////////
	// Setters
    ///////////////////////////////////////////////////
	
	public boolean inserirFuncionario(Funcionario novoFuncionario) {
		boolean resposta = false;
		if (this.vetorCheio()) {
			resposta = false;
		} else if (this.matriculaExiste(novoFuncionario.getMatricula())) {
			resposta = false;
		} else {
			this.vFuncionario[this.qtdNoVetor] = novoFuncionario;
			this.qtdNoVetor++;
			resposta = true;
		}
		return resposta;
	}

	public boolean removerFuncionario(int i) {
		boolean resposta = false;
		if (this.vetorVazio()) {
			resposta = false;
		} else if (i > this.qtdNoVetor) {
			resposta = false;
		} else {
			this.vFuncionario[i] = this.vFuncionario[this.qtdNoVetor - 1];
			this.qtdNoVetor -= 1;
			resposta = true;
		}
		return resposta;
	}
	
	
    ///////////////////////////////////////////////////
	// Outros métodos
    ///////////////////////////////////////////////////
	
	public boolean matriculaExiste(int matricula) {
		boolean resposta = false;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vFuncionario[i].getMatricula() == matricula) {
				resposta = true;
				break;
			}
		}
		return resposta;
	}

	public int posicaoNoVetor(int matricula) {
		int resposta = -1;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vFuncionario[i].getMatricula() == matricula) {
				resposta = i;
			}
		}
		return resposta;
	}

	private boolean vetorVazio() {
		if (this.qtdNoVetor == 0) {
			return true;
		} else {
			return false;
		}
	}

	private boolean vetorCheio() {
		if (this.getQtdNoVetor() == this.getTamanhoDoVetor()) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		String resposta = "";
		for (int i = 0; i < this.qtdNoVetor; i++) {
			resposta += this.vFuncionario[i].toString() + "\n\n";
		}
		return resposta;
	}

	
	public int procuraIndice(int matricula) {
		int indice = 0;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vFuncionario[i].getMatricula() == matricula) {
				indice = i;
				return indice;
			}

		}
		return indice;
	}
	
	public boolean procuraLogin(String login) {
		boolean resposta = false;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vFuncionario[i].getLogin().equalsIgnoreCase(login)) {
				resposta = true;
			}
		}
		return resposta;
	}
	
	public boolean procuraSenha(String senha) {
		boolean resposta = false;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vFuncionario[i].getSenha().equalsIgnoreCase(senha)) {
				resposta = true;
			}
		}
		return resposta;
	}

}
