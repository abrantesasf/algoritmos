// Revisão de Modularização
// Abrantes Araújo Silva Filho

import java.text.Normalizer;
import java.util.Scanner;

public class LojaModificadoNovo {
	// Variáveis
	static int[]    codVendedor;
	static String[] nomeVendedor;
	static double[] vendaMensal;
	

	public static void main(String[] args) {
		int[]    acao          = {0};
		int[]    cadastroOK    = {0};		
		
		while (! (acao[0] == 5)) {
			menu(acao, cadastroOK);
		}
		
		// Sai do programa
		System.out.println("\nMoriturus te saluto!");

	} // fecha main
	
	// Método para mostrar o menu
	static void menu(int[] refAcao, int[] refCadastroOK) {
		int opcao = 0;
		boolean ok = true;
		Scanner scan = new Scanner(System.in);
		
		while (ok) {
			try {
				System.out.println("-----------------------------------");
				System.out.println("Escolha uma opção:");
				System.out.println("-----------------------------------");
				System.out.println("1 - Incluir dados dos vendedores");
				System.out.println("2 - Alterar a venda de um vendedor");
				System.out.println("3 - Melhor vendedor");
				System.out.println("4 - Mostrar dados");
				System.out.println("5 - Sair");
				System.out.println("-----------------------------------");
				System.out.println("Digite sua opção: ");
				opcao = scan.nextInt();
				if ((opcao < 1) || (opcao > 5)) {
					System.out.println("Opção inexistente. Informe novamente.");
					opcao = 0;
					ok = true;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO! Você não digitou um número válido.");
				scan.next();
				ok = true;
			}
		} // fecha while
			
		// Executa opções do Menu
		switch (opcao) {
		case 5:
			// Informe ao método main que o usuário deseja sair do programa
			refAcao[0] = opcao;
			break;
		
		case 4:
			// Mostra dados:
			if (refCadastroOK[0] == 1) {
				mostrarDados();
			} else {
				System.out.println("\nOPA! Você não fez o cadastro dos dados ainda!");
				System.out.println("Você será direcionado ao menu principal.\n");
			}			
			break;
		
		case 1:
			// Chama método para cadastrar dados dos vendedores
			cadastrarDados();
			refCadastroOK[0] = 1;
			// Volta para o menu
			refAcao[0] = 0;
			break;
		
		case 3:
			// Chame método para mostraro melhor vendedor, se o cadastro está feito
			if (refCadastroOK[0] == 1) {
				mostrarMelhorVendedor();
			} else {
				System.out.println("\nOPA! Você não fez o cadastro dos dados ainda!");
				System.out.println("Você será direcionado ao menu principal.\n");
			}
			// Volta para o menu
			refAcao[0] = 0;
			break;
			
		case 2:
			// Chama método para pesquisar o nome de um vendedor e alterar sua venda:
			if (refCadastroOK[0] == 1) {
				alterarVenda();
			} else {
				System.out.println("\nOPA! Você não fez o cadastro dos dados ainda!");
				System.out.println("Você será direcionado ao menu principal.\n");
			}
			// Volta para o menu
			refAcao[0] = 0;
			break;

		// NÃO É NECESSÁRIO default por causa das checagens anteriores
		//default:
		///	break;
		}
		
		// fecha scanner
		//scan.close();		
		
	} // fecha método menu
	
	// Método cadastrarDados
	static void cadastrarDados() {
		// Simula perguntar quantos vendedores e inicializa as variáveis:
		int qtdVendedores = 3;
		codVendedor    = new int[qtdVendedores];
		nomeVendedor   = new String[qtdVendedores];
		vendaMensal    = new double[qtdVendedores];
		
		// Variáveis e objetos:
		Scanner scanc = new Scanner(System.in);
		
		System.out.println("Cadastre os dados dos vendedores:");
		for (int i = 0; i < codVendedor.length; i++) {
			boolean ok         = true;			
			while (ok) {
				try {
					System.out.println("\nInforme o código do " + (i+1) + "º vendedor: ");
					codVendedor[i] = scanc.nextInt();
					scanc.nextLine();
					System.out.println("Informe o nome do " + (i+1) + "º vendedor: ");
					nomeVendedor[i] = scanc.nextLine();
					System.out.println("Informe a venda mensal do " + (i+1) + "º vendedor: ");
					vendaMensal[i] = scanc.nextDouble();
					ok = false;
				} catch (Exception e) {
					System.out.println("ERRO! Você não digitou um código válido. Tente novamente.");
					scanc.next();
					ok = true;
				}
			} // fecha while
		} // fecha for
		
		// Fecha scanner
		//scanc.close();
	} // fecha cadastrarDados
	
	// Método mostrarMelhorVendedor
	static void mostrarMelhorVendedor() {
		double maior = 0;
		int indice = 0;
		
		for (int i = 0; i < vendaMensal.length; i++) {
			if (vendaMensal[i] > maior) {
				maior = vendaMensal[i];
				indice = i;
			}
		}
		
		System.out.println("\nO vendedor com a maior venda mensal é: " + nomeVendedor[indice]);
		System.out.println("Você será direcionado para o menu principal.\n");
	} // Fecha método mostrarMelhorVendedor
	
	// Método alterarVenda
	static void alterarVenda() {
		// Variáveis e objetos:
		Scanner scan = new Scanner(System.in);
		String nome = "";
		int indice = -1;
		boolean ok = true;
		
		while (ok) {
			try {
				System.out.println("Informe o nome do vendedor para alterar sua venda:");
				nome = scan.nextLine();
				ok = false;
			} catch (Exception e) {
				System.out.println("ERRO. Informe novamente:");
				ok = true;
			}
		} // fecha while
		
		// Pesquisa por nome e obtém o índice (-1 se não achar)
		for (int i = 0; i < nomeVendedor.length; i++) {
			// Normaliza os nomes (remova acentos, caracteres especiais, etc., e compara a string normalizada).
			// Claro, com a ajudinha de:
			//https://stackoverflow.com/questions/86780/how-to-check-if-a-string-contains-another-string-in-a-case-insensitive-manner-in/40508106#40508106
			if (Normalizer.normalize(nomeVendedor[i], Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").toLowerCase().contains(Normalizer.normalize(nome, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").toLowerCase())) {
				indice = i;
			}
		}
		
		if (indice == -1) {
			System.out.println("\nNão existe o vendedor informado.");
			System.out.println("Você será direcionado ao menu principal.\n");
		} else {
			ok = true;
			while (ok) {
				try {
					System.out.println("Altere o valor da venda mensal para o vendedor: " + nomeVendedor[indice]);
					vendaMensal[indice] = scan.nextDouble();
					ok = false;
					System.out.println("Valor da venda alterado com sucesso.");
					System.out.println("Você será direcionado ao menu principal.\n");
				} catch (Exception e) {
					System.out.println("ERRO. Você não digitou um número válido. Tente novamente:");
					scan.next();
					ok = true;
				}
			} // while
		} // if else
	} // alterarVenda
	
	// Método mostrarDados
	static void mostrarDados () {
		System.out.println("Vendedores cadastrados:");
		System.out.println("CÓDIGO\t\tVENDA\t\tNOME");
		for (int i = 0; i < codVendedor.length; i++) {
			System.out.println(codVendedor[i] + "\t\t" + vendaMensal[i] + "\t\t" + nomeVendedor[i] + "\n");
		}
	}

} // fecha classe Loja
