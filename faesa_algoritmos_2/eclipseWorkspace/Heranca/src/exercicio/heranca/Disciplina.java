package exercicio.heranca;

public class Disciplina {
	// Atributos
	private String disciplina;
	private char   dificuldade;
	
	// Construtor
	public Disciplina() {
	}

	// Getters
	public String getDisciplina() {
		return this.disciplina;
	}

	public char getDificuldade() {
		return this.dificuldade;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public boolean setDificuldade(char dificuldade) {
		if (dificuldade == 'F' || dificuldade == 'M' || dificuldade == 'D') {
			this.dificuldade = dificuldade;
			return true;
		} else {
			System.out.println("ERRO na inclusão da dificuldade (deve ser F, M ou D).");
			return false;
		}
	}
	
	// toString:
	public String toString() {
		String resposta = "";
		resposta = "Disciplina: " + this.disciplina + "\n" +
		           "Dificuldade: " + this.dificuldade + "\n\n";
		return resposta;
	}

}
