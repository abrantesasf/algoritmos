
public class Filme {
	// Atributos
	private int    codigo;
	private String titulo;
	private GeneroFilme genero = new GeneroFilme();
	
	// Construtores
	public Filme() {
	}
	
	public Filme(int codigo, String titulo, GeneroFilme genero) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.genero = genero;
	}

	// Getters
	protected int getCodigo() {
		return codigo;
	}

	protected String getTitulo() {
		return titulo;
	}

	protected char getGenero() {
		return genero.getGenero();
	}

	// Setters
	protected void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	protected void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	protected void setGenero(char genero) {
		this.genero.setGenero(genero);
	}

}
