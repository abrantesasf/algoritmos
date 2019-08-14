package tempo_livre;

import java.util.Scanner;

public class TestaConcessionaria {
	static Scanner scan = new Scanner(System.in);
	static Concessionaria robauto = new Concessionaria(10);

	public static void main(String[] args) {
		int opcao = 0;
		
		do {
			System.out.println("Escolha a opção desejada:\n" +
					           "1. Cadastrar caminhão\n" +
					           "2. Listar caminhões\n" +
					           "3. Remover caminhão\n" +
					           "9. Sair");
			opcao = scan.nextInt();
			scan.nextLine();
			
			switch (opcao) {
			case 1:
				cadastrarCaminhao(robauto);
				break;
			case 2:
				System.out.println(robauto.toString());
				break;
			case 3:
				removerCaminhao(robauto);
				break;
			case 9:
				System.out.println("Saiu.");
				break;
			default:
				System.out.println("Opção inválida. Tenta novamente.");
				break;
			}
		} while (opcao != 9);

	} // fecha main
	
	// Cadastrar caminhão
	static void cadastrarCaminhao(Concessionaria robauto) {
		Caminhao novoCaminhao = new Caminhao();
		
		int    anoFabricacao;
		String modelo;
		int    capacidadeCarga;
		char   combustivel;
		String placa;
		
		System.out.println("Informe o ano de fabricação:");
		anoFabricacao = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Informe o modelo:");
		modelo = scan.nextLine();
		
		System.out.println("Informe a capacidade de carga:");
		capacidadeCarga = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Informe o combustível (G ou D):");
		combustivel = scan.nextLine().toUpperCase().charAt(0);
		
		System.out.println("Informe a placa:");
		placa = scan.nextLine();
		
		novoCaminhao.setAnoFabricacao(anoFabricacao);
		novoCaminhao.setModelo(modelo);
		novoCaminhao.setCapacidadeCarga(capacidadeCarga);
		novoCaminhao.setCombustivel(combustivel);
		novoCaminhao.setPlaca(placa);
		
		if (robauto.inserirCaminhao(novoCaminhao)) {
			System.out.println("Caminhão inserido com sucesso.");
		} else {
			System.out.println("ERRO, não foi possível inserir o caminhão.");
		}
		
	}
	
	// Remover caminhão
	static void removerCaminhao(Concessionaria robauto) {
		if (robauto.removerCaminhao(0)) {
			System.out.println("Removido.");
		} else {
			System.out.println("Xabu");
		}
	}

}
