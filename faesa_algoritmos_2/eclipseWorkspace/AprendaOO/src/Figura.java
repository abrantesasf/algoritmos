
public class Figura {
	// Atributos
	private String descricao;

	// Construtores
	public Figura(String descricao) {
		System.out.println("A figura " + descricao + " acaba de ser criada!\n");
		this.descricao = descricao;
	}
	
	public Figura() {
		System.out.println("Uma figura anônima foi criada.\n");
		this.descricao = "Anônimo";
	}

	// Getters
	protected String getDescricao() {
		return descricao;
	}	

}
