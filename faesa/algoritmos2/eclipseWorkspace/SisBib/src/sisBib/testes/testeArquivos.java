package sisBib.testes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class testeArquivos {

	public static void main(String[] args) {
		// Atributos
		String[] leitura = new String[6];
		FuncionariosTesteArquivos[] funcionariosVet = new FuncionariosTesteArquivos[100];
		
		Scanner scan = new Scanner(System.in);
		String nomeArq = "/home/abrantesasf/repositoriosGit/algoritmos/faesa_algoritmos_2/eclipseWorkspace/SisBib/src/sisBib/testes/funcionarios.csv";
		
	    System.out.printf("\nConteúdo do arquivo texto:\n");
	    try {
	      FileReader arq = new FileReader(nomeArq);
	      BufferedReader lerArq = new BufferedReader(arq);
	 
	      String linha = lerArq.readLine(); // lê a primeira linha
	      while (linha != null) {
	        System.out.printf("%s\n", linha);
	 
	        linha = lerArq.readLine(); // lê da segunda até a última linha
	        leitura = linha.split(";");
	        for(int i = 0; i < 2; i++) {
	        	funcionariosVet[i].setMatricula(Integer.valueOf(leitura[0]));
	        	funcionariosVet[i].setNome(leitura[1]);
	        	funcionariosVet[i].setEndereco(leitura[2]);
	        	funcionariosVet[i].setData(leitura[3]);
	        	funcionariosVet[i].setSetor(leitura[4]);
	        	funcionariosVet[i].setSalario(Double.valueOf(leitura[5]));
	        	
	        }
	      }
	 
	      arq.close();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }
	 
	    System.out.println();

	}

}
