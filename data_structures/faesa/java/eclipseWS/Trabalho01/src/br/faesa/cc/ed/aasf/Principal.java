package br.faesa.cc.ed.aasf;

import java.util.Scanner;

/**
 * A classe <b>Principal</b> implementa um pequeno sistema de teste da lista
 * encadeada que armazena informações sobre Carros.
 * @author Abrantes Araújo Silva Filho
 *         <a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>
 */
public class Principal {
	
	/**
	 * Scanner para a entrada de dados do usuário
	 */
	private static Scanner scan = new Scanner(System.in);
	
	/**
	 * Lista Simplesmente Encadeada para armazenar os carros NOVOS
	 */
	private static ListaSimplesmenteEncadeada lseNovos = new ListaSimplesmenteEncadeada();
	
	/**
	 * Lista Simiplesmente encadeada para armazenar os carros TRANSFERIDOS
	 */
	private static ListaSimplesmenteEncadeada lseTransferidos = new ListaSimplesmenteEncadeada();
	
	/**
	 * Método Main da Classe Principal
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Exibe o menu de opções
		int menu = 0;		
		do {
			System.out.println("--------------- MENU DE OPÇÕES ---------------\n" +
		                       "1. Inserir carro novo\n" +
					           "2. Remover carro novo\n" +
		                       "3. Listar carros novos\n" +
					           "4. Listar carros transferidos\n" +
		                       "5. Transferir carro para outra fábrica\n" +
					           "6. Pesquisar carros novos de mesmo modelo\n" +
		                       "7. Sair\n" +
		                       "----------------------------------------------\n"+
					           "Informe sua opção: ");
			
			// Pega a opção escolhida pelo usuário
			menu = scan.nextInt();
			scan.nextLine();
			
			// Realiza as ações conforme a opção do usuário
			switch (menu) {
			case 1:
				inserirCarroNovo(lseNovos);
				break;
			case 2:
				removerCarro(lseNovos);
				break;
			case 3:
				mostrarCarros(lseNovos);
				break;
			case 4:
				mostrarCarros(lseTransferidos);
				break;
			case 5:
				transferirCarro();
				break;
			case 6:
				pesquisarCarro(lseNovos);
				break;
			case 7:
				System.out.println("Programa encerrado.");
				System.out.println("Moriturus te saluto!");
				break;
			default:
				System.out.println("Opção inválida, favor informar novamente.\n");
				break;
			}
		} while (menu != 7);

		// Fecha o scanner
		scan.close();
		
	} // fim do main
	
	
	///////////////////////////////////////////////////
	// Outros métodos
	///////////////////////////////////////////////////
	
	
	///////////////////////////////////////////////////
	// 1. inserirCarroNovo
	///////////////////////////////////////////////////	
	public static void inserirCarroNovo(ListaSimplesmenteEncadeada lista) {
		int id = 0;
		String modelo = "";
		String cor = "";
		int ano = 0;
		
		System.out.println("Digite a ID do carro: ");
		id = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Digite o modelo do carro: ");
		modelo = scan.nextLine();
		
		System.out.println("Digite a cor do carro: ");
		cor = scan.nextLine();
		
		System.out.println("Digite o ano do carro: ");
		ano = scan.nextInt();
		scan.nextLine();
		
		// Cria um novo carro
		Carro novoCarro = new Carro(id, modelo, cor, ano);
		
		// Tenta inserir o carro:
		if (lista.inserirCarroNoFinal(novoCarro)) {
			System.out.println("Carro cadastrado.");
		} else {
			System.out.println("ERRO.");
		}
	}
	
	
	///////////////////////////////////////////////////
	// 2. removerCarro
	///////////////////////////////////////////////////	
	public static void removerCarro(ListaSimplesmenteEncadeada lista) {
		int id = 0;
		
		System.out.println("Digite o ID do carro que deseja remover:");
		id = scan.nextInt();
		scan.nextLine();
		
		// Tenta remover o carro:
		if (lista.removerCarro(id)) {
			System.out.println("Carro removido.");
		} else {
			System.out.println("Não foi possível remover o carro.");
		}
	}
	
	
	///////////////////////////////////////////////////
	// 3/4. mostrarCarros
	///////////////////////////////////////////////////	
	public static void mostrarCarros(ListaSimplesmenteEncadeada lista) {
		System.out.println(lista.toString());
	}
	
	
	///////////////////////////////////////////////////
	// 5. transferirCarro
	///////////////////////////////////////////////////	
	public static void transferirCarro() {
		
		// Verifica se a lista está vazia e termina caso verdadeiro:
		if (lseNovos.estaVazia()) {
			System.out.println("A lista de carros está vazia, não existem carros a transferir.");
			return;
		}
		
		// A lista não está vazia, vamos perguntar o ID do carro a ser transferido:
		int id = -1;
		System.out.println("Digite o ID do carro que deseja transferir: ");
		id = scan.nextInt();
		scan.nextLine();
		
		// Agora vamos criar um objeto do tipo carro e pesquisar se o carro
		// desejado está na lista. Se estiver, o novoCarro receberá os dados desse
		// carro e poderemos transferir:
		Carro novoCarro = new Carro(-1, "", "", -1);
		if (lseNovos.buscaCarroNaListaPorID(id, novoCarro)) {
			// OK, o carro existe e foi retornado, vamos inserir na lista de transferidos
			if (lseTransferidos.inserirCarroOrdenadoPorID(novoCarro)) {
				System.out.println("O carro foi transferido para a nova lista,");
				if (lseNovos.removerCarro(id)) {
					System.out.println("e removido da lista antiga.");
				}
			} else {
				System.out.println("ERRO.");
				novoCarro = null;
			}		
		} else {
			System.out.println("Não existe um carro com o ID informado, não é possível transferir.");
			novoCarro = null;
		}
	}
	
	
	///////////////////////////////////////////////////
	// 6. pesquisarCarro
	///////////////////////////////////////////////////
	public static void pesquisarCarro(ListaSimplesmenteEncadeada lista) {
		String modelo = "";
		System.out.println("Informe o modelo a pesquisar: ");
		modelo = scan.nextLine();		
		System.out.println(lista.pesquisarModelo(modelo));
	}

}