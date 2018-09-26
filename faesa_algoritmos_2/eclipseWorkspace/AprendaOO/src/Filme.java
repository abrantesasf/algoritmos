
public class Filme {
	// Atributos
	private int    codigo;
	private String titulo;
	private char   genero;
	
	// Construtor
	public Filme(int codigo, String titulo, char genero) {
		super();
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
		return genero;
	}

	// Setters
	protected void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	protected void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	protected void setGenero(char genero) {
		this.genero = genero;
	}

}
