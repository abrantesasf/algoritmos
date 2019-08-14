package exercicio.heranca;

public class Aluno extends Pessoa {
	// Atributos
	private String       matricula;
	private int          periodo;
	private Disciplina[] disciplinas;
	private int          qtdDisciplinas;
	
	// Construtor
	public Aluno(String nome, String matricula, int periodo, int quantidade) {
		super(nome);
		this.matricula = matricula;
		this.periodo = periodo;
		if (quantidade > 5) {
			System.out.println("Atenção: o aluno não pode ter mais de 5 disciplinas.");
			System.out.println("O cadastro do aluno será limitado a 5 disciplinas.");
			this.disciplinas = new Disciplina[5];
		} else {
			this.disciplinas = new Disciplina[quantidade];
		}
		this.qtdDisciplinas = 0;
	}

	// Getters:
	public String getMatricula() {
		return this.matricula;
	}

	public int getPeriodo() {
		return this.periodo;
	}

	public Disciplina getDisciplinas(int i) {
		return this.disciplinas[i];
	}

	public int getQtdDisciplinas() {
		return this.qtdDisciplinas;
	}

	// Setters:
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public boolean setDisciplinas(Disciplina novaDisciplina) {
		if (this.qtdDisciplinas == this.disciplinas.length) {
			System.out.println("ERRO! O aluno já tem toda a grade de disciplinas preenchida.");
			return false;
		} else {
			this.disciplinas[this.qtdDisciplinas] = novaDisciplina;
			this.qtdDisciplinas += 1;
			return true;
		}
	}

	public void setQtdDisciplinas(int qtdDisciplinas) {
		this.qtdDisciplinas = qtdDisciplinas;
	}
	
	// Listar disciplinas do aluno
	public String listaDisciplinas() {
		String resposta = "";
		resposta = "O aluno " + this.getNascimento() + " está matriculado nas seguintes disciplinas:\n";
		for (int i = 0; i < this.qtdDisciplinas; i++) {
			resposta += "Disciplina:  " + this.disciplinas[i].getDisciplina() + "\n" +
		                "Dificuldade: " + this.disciplinas[i].getDificuldade() + "\n\n";
		}
		return resposta;
	}

}
