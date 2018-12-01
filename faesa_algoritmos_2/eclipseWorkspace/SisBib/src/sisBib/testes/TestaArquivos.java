package sisBib.testes;
import java.io.IOException;

import sisBib.principal.VetorDeAlunos;
import sisBib.principal.VetorDeProfessores;
import sisBib.util.Arquivos;
import sisBib.util.CSV;
import sisBib.util.Validacoes;

public class TestaArquivos {

	public static void main(String[] args) throws IOException {
		Arquivos arq = new Arquivos();
		CSV csv = new CSV();
		Validacoes validacoes = new Validacoes();
		VetorDeProfessores profs = new VetorDeProfessores(100);
		VetorDeAlunos alunos = new VetorDeAlunos(arq.contarLinhas("/home/abrantesasf/alunos.csv") + 100);
		
		
		if (arq.arquivoExiste("/home/abrantesasf/javaEumSaco.txt")) {
			System.out.println("sim");
		} else {
			System.out.println("não");
		}
		
		try {
			System.out.println(arq.contarLinhas("/home/abrantesasf/repositoriosGit/intelliway/otimizacao-e-qualidade-do-estoque/dados/tratados/segunda_entrega/csv/lista_utilizacao.csv"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRO");
			//e.printStackTrace();
		}
		
//		try {
//			csv.lerCSVfuncionarios("/home/abrantesasf/professor.csv");
//		} catch (Exception e) {
//			System.out.println("ERRO.");
//		}
		
		System.out.println("\n\n Método NOVO:");
		try {
			if(!csv.lerCSVprofessores("/home/abrantesasf/professor.csv", profs)) {
				System.out.println(csv.getMensagem());
			} else {
				System.out.println(csv.getMensagem());
			}
		} catch (Exception e) {
			System.out.println("ERRO");
		}
		
		System.out.println(profs.toString());
		profs.getProfessor(0).setNome("Tomás ; Cardoso ; Araújo");
		System.out.println(profs.getProfessor(0).toString());
		csv.gravarCSVprofessores("/home/abrantesasf/professor2.csv", profs);
		
		System.out.println(validacoes.removeCaractereDeString("texto;com;vários;", ";"));
		
		try {
			if (! csv.lerCSValunos("/home/abrantesasf/alunos.csv", alunos)) {
				System.out.println(csv.getMensagem());
			} else {
				System.out.println(csv.getMensagem());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(alunos.toString());
		alunos.getAluno(0).setNome("Seu Zé Tomás");
		System.out.println(alunos.getAluno(0).toString());
		csv.gravarCSValunos("/home/abrantesasf/alunos2.csv", alunos);

	} // fecha main

}
