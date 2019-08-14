package principal;

public class Produto {
	
	private int    codigo;
	private String descricao;
	private double valor;
	private int    qtdNoEstoque;
	
	public Produto(int codigo, String descricao, double valor, int qtdNoEstoque) {
		setCodigo(codigo);
		setDescricao(descricao);
		setValor(valor);
		setQtdNoEstoque(qtdNoEstoque);
	}

	public int getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public double getValor() {
		return this.valor;
	}

	public int getQtdNoEstoque() {
		return this.qtdNoEstoque;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setQtdNoEstoque(int qtdNoEstoque) {
		this.qtdNoEstoque = qtdNoEstoque;
	}

	public String toString() {
		String resposta = "";
		resposta += "Código:          " + getCodigo()    + "\n" +
		            "Descrição:       " + getDescricao() + "\n" +
				    "Valor:           " + getValor()     + "\n" +
		            "Qtd. em Estoque: " + getQtdNoEstoque();
		return resposta;
	}

}
