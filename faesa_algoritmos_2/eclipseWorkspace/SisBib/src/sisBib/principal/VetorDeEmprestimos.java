package sisBib.principal;

public class VetorDeEmprestimos {
	
	private Emprestimo[] vEmprestimos;
	private int qtdNoVetor;
	
	public VetorDeEmprestimos(int tamanho) {
		this.vEmprestimos = new Emprestimo[tamanho];
		this.qtdNoVetor = 0;
	}

	public Emprestimo getEmprestimo(int i) {
		return this.vEmprestimos[i];
	}


	public int getQtdNoVetor() {
		return this.qtdNoVetor;
	}
	

	public int getTamanhoDoVetor() {
		return this.vEmprestimos.length;
	}
	
	

	public boolean codigoExiste(int codigo) {
		boolean resposta = false;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vEmprestimos[i].getCodigo() == codigo) {
				resposta = true;
				break;
			}
		}
		return resposta;
	}
	

	public int posicaoNoVetor(int codigo) {
		int resposta = -1;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vEmprestimos[i].getCodigo() == codigo) {
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
			resposta += this.vEmprestimos[i].toString();
		}
		return resposta;
	}
	
	
    	
	public boolean inserirEmprestimo(Emprestimo novoEmprestimo) {
		boolean resposta = false;
		if (this.vetorCheio()) {
			resposta = false;
		} else if (this.codigoExiste(novoEmprestimo.getCodigo())) {
			resposta = false;
		} else {
			this.vEmprestimos[this.qtdNoVetor] = novoEmprestimo;
			this.qtdNoVetor++;
			resposta = true;
		}
		return resposta;
	}
	
	
	public boolean removerEmprestimo(int i) {
		boolean resposta = false;
		if (this.vetorVazio()) {
			resposta = false;
		} else if (i > this.qtdNoVetor) {
			
		} else {
			this.vEmprestimos[i] = this.vEmprestimos[this.qtdNoVetor - 1];
			this.qtdNoVetor -= 1;
			resposta = true;
		}
		return resposta;
	}
}
