import java.util.*;
public class Questao01_B {
	static Scanner ler = new Scanner(System.in);

	public static void main(String[] args) {
		int mAlunos, nAvaliacoes, opcao;
		String nome;
		double notas[][];
		String nomeAlunos[];

		System.out.println("Informe o numero de alunos da turma: ");
		mAlunos = ler.nextInt();
		System.out.println("Informe o numero de avaliações da turma: ");
		nAvaliacoes = ler.nextInt();

		nomeAlunos = new String[mAlunos];
		notas = new double[mAlunos][nAvaliacoes];
		
		do {
			opcao = menu();
			switch (opcao) {
			case 1:
				cadastra(nomeAlunos, notas);
				break;
			case 2:
				double media;
				System.out.println("Informe o nome do aluno: ");
				nome = ler.next();
				media = mediaAluno(nome, nomeAlunos, notas);
				if (media != -1)
				{
					System.out.println("Media de " + nome + ": " + media);					
				}
				else
					System.out.println("Aluno "+nome+" não pertence à turma!");
				break;
			case 3:
				System.out.println("Media da turma: " + mediaTurma(notas));
				break;
			case 4:
				System.out.println("Alunos aprovados: ");
				listaAlunosAprovados(nomeAlunos, notas);
				break;
			case 5:
				System.out.println("Alunos aprovados com média acima da média da turma: ");
				alunosAprovadosAcimaMediaTurma(nomeAlunos, notas);
				break;
			case 0:
				break;
			default:
					System.out.println("Opção Inválida");
			}
		} while (opcao != 0);
		System.out.println("Fim do programa");
		ler.close();
	}

	static void cadastra(String nomes[], double notas[][]) {
		System.out.println("Informe o nome dos alunos e suas respectivas notas: ");
		for (int i = 0; i < nomes.length; i++) {
			System.out.println("Nome do aluno " + (i+1) + ": ");
			nomes[i] = ler.next();
			System.out.println("Informe as "+notas[0].length+" notas do aluno " + nomes[i]);
			for (int j = 0; j < notas[0].length; j++) {
				System.out.println((j+1)+".a nota: ");
				notas[i][j] = ler.nextDouble();
			}
		}
	}

	static double mediaAluno(String nome, String nomes[], double notas[][]) {
		boolean encontrou = false;
		int i = -1;
		double soma = 0;

		while (!encontrou && i<(nomes.length-1)) {
			i++;
			if (nomes[i].equals(nome)) {
				encontrou = true;
			}
		}

		if (encontrou) {
			for (int j = 0; j < notas[0].length; j++) {
				soma = soma + notas[i][j];
			}
			return (soma / notas[0].length);
		}
		return -1;
	}
	
	static double mediaTurma(double notas[][]) {
		double soma = 0;

		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[0].length; j++) {
			soma += notas[i][j];
			}
		}
		return (soma/(notas[0].length*notas.length));
	}
	
	static void listaAlunosAprovados(String alunos[], double notas[][]){
		System.out.println("Alunos aprovados: ");
		for (int i = 0; i < notas.length; i++) {
			if(mediaAluno(alunos[i], alunos, notas)>=6.0){
				System.out.println(alunos[i]);
			}
		}
	}
	static void alunosAprovadosAcimaMediaTurma(String alunos[], double notas[][]){
		double mediaAluno, mediaTurma;
		mediaTurma = mediaTurma(notas);
		
		for (int i = 0; i < notas.length; i++) {
			mediaAluno = mediaAluno(alunos[i], alunos, notas);
			if(mediaAluno >=6.0 && mediaAluno>mediaTurma){
				System.out.println(alunos[i]);
			}
		}
	}

	static int menu() {
		System.out.println("1 - Cadastra nomes e notas\n" + 
						   "2 - Calcula média aluno\n" + 
						   "3 - Calcula média da turma\n"+
						   "4 - Lista alunos aprovados\n"+
						   "5 - Listar alunos aprovados com média acima da média da turma\n"+
						   "0 - Sair\n"+
						   "Opção: ");
		return ler.nextInt();
	}
}
