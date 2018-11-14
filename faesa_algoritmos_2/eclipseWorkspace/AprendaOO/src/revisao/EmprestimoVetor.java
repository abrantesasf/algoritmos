package revisao;

public class EmprestimoVetor {
	// Atributos
	private Emprestimo[] vetor;
	private int          qtdNoVetor;
	
	// Construtor
	public EmprestimoVetor(int tamanho) {
		this.vetor = new Emprestimo[tamanho];
		this.qtdNoVetor = 0;
	}

	// Getters:
	public Emprestimo getEmprestimo(int i) {
		return this.vetor[i];
	}

	public int getQtdNoVetor() {
		return this.qtdNoVetor;
	}

	// Setters:
	public boolean inserirEmprestimo(Emprestimo novoEmprestimo) {
		boolean resposta = false;
		if (this.qtdNoVetor == this.vetor.length) {
			System.out.println("ERRO! Você não pode pegar mais empréstimos.");
		} else {
			this.vetor[this.qtdNoVetor] = novoEmprestimo;
			this.qtdNoVetor += 1;
			resposta = true;
		}
		return resposta;
	}
	
	public boolean removerEmprestimo(int i) {
		boolean resposta = false;
		if (this.qtdNoVetor == 0) {
			System.out.println("ERRO, não existe empréstimo em seu nome.");
		} else {
			this.vetor[i] = this.vetor[this.qtdNoVetor - 1];
			this.qtdNoVetor -= 1;
			resposta = true;
		}
		return resposta;
	}

	public void setQtdNoVetor(int qtdNoVetor) {
		this.qtdNoVetor = qtdNoVetor;
	}
	
	// toString
	public String toString() {
		String resposta = "";
		for (int i = 0; i < this.qtdNoVetor; i++) {
			resposta += "Empréstimo " + (i + 1) +": \n" + 
		                this.vetor[i].toString() + "\n";
		}
		return resposta;
	}
	
}
