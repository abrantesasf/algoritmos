
public class TestaAluno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aluno a, b, c;
		
		a = new Aluno();
		b = new Aluno();
		c =a;
		
		a.setTelefone("2122-4107");
/*		a.matricula=11111;
		a.nome="Joao";
		
		b.telefone="2122-4107";
		b.matricula=11111;
		b.nome="Joao";
*/		
		if(a==b)
		{
			System.out.println("OK 1");
		}
		
		if(a==c)
		{
			System.out.println("OK 2");
		}
			
		System.out.println(a.getTelefone());
//		System.out.println(b.telefone);
//		System.out.println(c.telefone);
	}

}
