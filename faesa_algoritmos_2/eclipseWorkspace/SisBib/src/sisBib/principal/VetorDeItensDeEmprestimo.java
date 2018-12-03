package sisBib.principal;

public class VetorDeItensDeEmprestimo {

	private ItemDeEmprestimo[] vItens;
	private int qtdNoVetor;
	
	public VetorDeItensDeEmprestimo(int tamanho) {
		this.vItens = new ItemDeEmprestimo[tamanho];
		this.qtdNoVetor = 0;
	}

	public ItemDeEmprestimo getItemDeEmprestimo(int i) {
		return this.vItens[i];
	}


	private int getQtdNoVetor() {
		return this.qtdNoVetor;
	}
	

	private int getTamanhoDoVetor() {
		return this.vItens.length;
	}

	public boolean codigoExiste(int codigo) {
		boolean resposta = false;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vItens[i].getCodigoItem() == codigo) {
				resposta = true;
				break;
			}
		}
		return resposta;
	}
	

	public int posicaoNoVetor(int codigo) {
		int resposta = -1;
		for (int i = 0; i < this.qtdNoVetor; i++) {
			if (this.vItens[i].getCodigoItem() == codigo) {
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
			resposta += this.vItens[i].toString();
		}
		return resposta;
	}
	
	
    	
	public boolean inserirItemDeEmprestimo(ItemDeEmprestimo novoItemDeEmprestimo) {
		boolean resposta = false;
		if (this.vetorCheio()) {
			resposta = false;
		} else if (this.codigoExiste(novoItemDeEmprestimo.getCodigoItem())) {
			resposta = false;
		} else {
			this.vItens[this.qtdNoVetor] = novoItemDeEmprestimo;
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
			this.vItens[i] = this.vItens[this.qtdNoVetor - 1];
			this.qtdNoVetor -= 1;
			resposta = true;
		}
		return resposta;
	}
}
