
public class GeneroFilme {
	// Atributos
	private char genero;
	char[] generosPermitidos = {'A', 'T', 'D'};

	// Construtor padrão
	public GeneroFilme() {
	}

	// Getters
	public char getGenero() {
		return genero;
	}

	// Setters
	public void setGenero(char genero) {
		if (checaGenero(genero)) {
			this.genero = genero;
		} else {
			System.out.println("Gênero não permitido, não foi possível informar!");
		}
		
	}
	
	// Checa gêneros
	protected boolean checaGenero(char genero) {
		for (int i = 0; i < generosPermitidos.length; i++) {
			if (generosPermitidos[i] == genero) {
				return true;
			}
		}
		return false;
	}
}
