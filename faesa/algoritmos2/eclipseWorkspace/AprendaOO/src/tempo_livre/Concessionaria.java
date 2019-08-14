package tempo_livre;

public class Concessionaria {
	// Atributos
	private Caminhao[] vetor;
	private int        qtdDeCaminhoes;
	
	// Construtor
	public Concessionaria(int tamanho) {
		this.vetor = new Caminhao[tamanho];
		this.qtdDeCaminhoes = 0;
	}

	// Getters:
	public Caminhao getVetor(int i) {
		return this.vetor[i];
	}

	public int getQtdDeCaminhoes() {
		return this.qtdDeCaminhoes;
	}

	// Setters:
	public boolean inserirCaminhao(Caminhao novoCaminhao) {
		if (this.qtdDeCaminhoes == this.vetor.length) {
			System.out.println("Não é possível inserir, vetor cheiro.");
			return false;
		} else {
			this.vetor[this.qtdDeCaminhoes] = novoCaminhao;
			this.qtdDeCaminhoes += 1;
			return true;
		}
	}
	
	public boolean removerCaminhao(int i) {
		if (this.qtdDeCaminhoes == 0) {
			System.out.println("Concessionária vazia, não é possível remover caminhão.");
			return false;
		} else {
			this.vetor[i] = this.vetor[this.qtdDeCaminhoes - 1];
			this.qtdDeCaminhoes -= 1;
			return true;
		}
	}

	public void setQtdDeCaminhoes(int qtdDeCaminhoes) {
		this.qtdDeCaminhoes = qtdDeCaminhoes;
	}
	
	// toString
	public String toString() {
		String resposta = "";
		for (int i = 0; i < this.qtdDeCaminhoes; i++) {
			resposta += this.vetor[i].toString();
		}
		return resposta;
	}

}
