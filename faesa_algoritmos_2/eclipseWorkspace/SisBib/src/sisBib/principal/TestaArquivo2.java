package sisBib.principal;

import java.io.IOException;

import sisBib.util.Arquivos;
import sisBib.util.CSV;

public class TestaArquivo2 {

	public static void main(String[] args) throws IOException {
		Arquivos arq = new Arquivos();
		CSV      csv = new CSV();
		VetorDeAlunos alunos = new VetorDeAlunos(arq.contarLinhas("/home/abrantesasf/alunos.csv") + 100);
		
		try {
			if (csv.lerCSValunos("/home/abrantesasf/alunos.csv", alunos)) {
				System.out.println("Alunos lidos com sucesso.");
			} else {
				System.out.println("Erro na leitura dos alunos.");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(alunos.toString());
		
		Aluno novoAluno = new Aluno(88888888, "Isaac Miranda", "Rua do Escorrega e Lá vai 2", "Ciência da Computação", "01/12/2018", 0);
		alunos.inserirAluno(novoAluno);
		
		System.out.println(alunos.toString());
		
		csv.gravarCSValunos("/home/abrantesasf/alunos.csv", alunos);

	}

}
