
public class Programa {

	public static void main(String[] args) {
		// Cria novo aluno
		Aluno a = new Aluno();
		Aluno b = new Aluno();
		Aluno c = a;
		
		// Entra informações do aluno a
		a.setNome("Abrantes Aráujo Silva Filho");
		a.setMatricula(18110052);
		a.setTelefone("(27) 9-9891-4393");
		
		// Entra informações do aluno b
		b.setNome("Flávia Cristina Souza Cardoso Silva");
		b.setMatricula(52001118);
		b.setTelefone("(27) 9-8827-7813");
		
		// Muda telefone do c:
		c.setTelefone("(27) 9-9917-4393");
		
		// Mostra informações
		System.out.println(a.getNome() + "\t\t" + a.getMatricula() + "\t\t" + a.getTelefone());
		System.out.println(b.getNome() + "\t" + b.getMatricula() + "\t\t" + b.getTelefone());
		System.out.println(c.getNome() + "\t\t" + c.getMatricula() + "\t\t" + c.getTelefone());

	}

}
