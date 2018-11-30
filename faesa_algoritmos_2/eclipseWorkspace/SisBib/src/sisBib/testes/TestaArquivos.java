package sisBib.testes;
import java.io.IOException;

import sisBib.principal.VetorDeProfessores;
import sisBib.util.Arquivos;
import sisBib.util.CSV;

public class TestaArquivos {

	public static void main(String[] args) throws IOException {
		Arquivos arq = new Arquivos();
		VetorDeProfessores profs = new VetorDeProfessores(100);
		CSV csv = new CSV();
		
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
			csv.lerFuncionariosCSV2("/home/abrantesasf/professor.csv", 'p', profs);
		} catch (Exception e) {
			System.out.println("ERRO");
		}
		
		System.out.println(profs.toString());

	} // fecha main

}
