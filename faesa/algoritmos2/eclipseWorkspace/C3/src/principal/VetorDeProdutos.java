package principal;
public class VetorDeProdutos {

	private Produto[] vProdutos;
	private int       qtdNoVetor;
		
	public VetorDeProdutos(int tamanho) {
		this.vProdutos  = new Produto[tamanho];
		this.qtdNoVetor = 0;
	}
	
	public Produto getProduto(int i) {
		return this.vProdutos[i];
	}

	public int getQtdNoVetor() {
		return this.qtdNoVetor;
	}
	
	public int getTamanhoDoVetor() {
		return this.vProdutos.length;
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
			resposta += this.vProdutos[i].toString() + "\n\n";
		}
		return resposta;
	}
	
	public boolean inserirProduto(Produto novoProduto) {
		boolean resposta = false;
		if (this.vetorCheio()) {
			resposta = false;
		} else {
			this.vProdutos[this.qtdNoVetor] = novoProduto;
			this.qtdNoVetor++;
			resposta = true;
		}
		return resposta;
	}
	
	public boolean removerProduto(int i) {
		boolean resposta = false;
		if (this.vetorVazio()) {
			resposta = false;
		} else if (i > this.qtdNoVetor) {
			
		} else {
			this.vProdutos[i] = this.vProdutos[this.qtdNoVetor - 1];
			this.qtdNoVetor -= 1;
			resposta = true;
		}
		return resposta;
	}
	
}
