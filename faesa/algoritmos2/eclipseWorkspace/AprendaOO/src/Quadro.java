
public class Quadro {
	// Atributos
	private int    altura;
	private int    largura;
	private Figura figura;

	// Construtores
	public Quadro(String descricao) {
		figura  = new Figura(descricao);
		altura  = 0;
		largura = 0;
	}
	
	public Quadro() {
		figura  = new Figura();
		altura  = 0;
		largura = 0;
	}

	// Getters
	protected int getAltura() {
		return altura;
	}

	protected int getLargura() {
		return largura;
	}
	
	protected String getDescricaoDaFigura() {
		return figura.getDescricao();
	}

	// Setters
	protected void setAltura(int altura) {
		this.altura = altura;
	}

	protected void setLargura(int largura) {
		this.largura = largura;
	}

}
