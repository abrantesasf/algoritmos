package principal;
import java.io.IOException;
import java.util.Scanner;

import util.Arquivo;

public class Programa {
	static Scanner         scan      = new Scanner(System.in);
	static Arquivo         arq       = new Arquivo();
	static VetorDeProdutos produtos  = null;

	public static void main(String[] args) throws IOException {
		String path = "/home/abrantesasf/produtos.csv";
		int qtdAdicional = 100;
		VetorDeProdutos produtos = new VetorDeProdutos(arq.contarLinhas(path) + qtdAdicional);
		
		int opcao = 0;
		do {
			System.out.println("------------------------ MENU ------------------------\n" +
		                       "1. Ler arquivo de produtos\n" +
					           "2. Consultar produtos por código\n" +
		                       "3. Listar todos os produtos\n" +
					           "4. Inserir novo produto\n" +
		                       "5. Salvar arquivo de produtos\n" +
		                       "9. Sair\n" +
					           "------------------------------------------------------\n" +
		                       "Digite sua opção: ");
			opcao = scan.nextInt();
			scan.nextLine();
			
			switch (opcao) {
			case 1:
				lerArquivoDeProdutos(produtos, path);
				break;
			case 2:
				System.out.println(consultarProduto(produtos));
				break;
			case 3:
				System.out.println(produtos.toString());
				break;
			case 4:
				inserirNovoProduto(produtos);
				break;
			case 5:
				salvarArquivoDeProdutos(produtos, path);
				break;
			case 9:
				System.out.println("\n\nPrograma encerrado.\nMoriturus te Saluto, Abrantes!");
				break;
			default:
				System.out.println("Opção inválida, escolha novamente: ");
				break;
			}
		} while (opcao != 9);

	} // fecha main
	
	static void lerArquivoDeProdutos(VetorDeProdutos produtos, String path) {
		try {
			if (! arq.lerCSVprodutos(path, produtos)) {
				System.out.println(arq.getMensagem());
			}
		} catch (Exception e) {
			System.out.println("ERRO NA LEITURA DO ARQUIVO.");
		}
	}
	
	static String consultarProduto(VetorDeProdutos produtos) {
		int codigo = 0;
		String resposta = "Produto não cadastrado.";
		System.out.println("Digite o código do produto: ");
		codigo = scan.nextInt();
		scan.nextLine();
		
		for (int i = 0; i < produtos.getQtdNoVetor(); i++) {
			if (produtos.getProduto(i).getCodigo() == codigo) {
				resposta = produtos.getProduto(i).toString();
				break;
			}
		}
		return resposta;
	}
	
	static void inserirNovoProduto(VetorDeProdutos produtos) {
		int codigo = 0;
		String descricao = "";
		double valor = 0;
		int qtdNoEstoque = 0;
		
		System.out.println("Informe o código: ");
		codigo = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Informe a descrição: ");
		descricao = scan.nextLine();
		
		System.out.println("Informe o valor: ");
		valor = scan.nextDouble();
		scan.nextLine();
		
		System.out.println("Informe a quantidade em estoque: ");
		qtdNoEstoque = scan.nextInt();
		scan.nextLine();
		
		Produto novoProduto = new Produto(codigo, descricao, valor, qtdNoEstoque);
		
		if (! produtos.inserirProduto(novoProduto)) {
			System.out.println("ERRO na inserção do novo produto.");
		} else {
			System.out.println("Produto inserido com sucesso!");
		}
	}
	
	static void salvarArquivoDeProdutos(VetorDeProdutos produtos, String arquivo) {
		try {
			if (! arq.salvarCSVprodutos(arquivo, produtos)) {
				System.out.println("ERRO ao salvar o arquivo1.");
			} else {
				System.out.println("Arquivo salvo com sucesso.");
			}
		} catch (Exception e) {
			System.out.println("ERRO ao salvar o arquivo2.");
		}
	}

} // fecha programa
