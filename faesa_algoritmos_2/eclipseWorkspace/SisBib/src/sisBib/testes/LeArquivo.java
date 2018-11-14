package sisBib.testes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
 
public class LeArquivo {

	public static void main(String[] args) {
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
	      }
	 
	      arq.close();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }
	 
	    System.out.println();
	  }
	}