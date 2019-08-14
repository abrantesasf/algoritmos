package revisao;

import java.util.Scanner;

public class Banco {
	// Atributos
	static ClienteVetor   clientes;
	static boolean        clientesOK = false;
	static Scanner        scan = new Scanner(System.in);

	public static void main(String[] args) {
		int    opcao      = 0;
		String semCliente = "ERRO, é necessário informar o número de clientes do banco primeiro.";
		String bancoCheio = "ERRO, o banco já está lotado de clientes, não é possível cadastrar.";
		
		do {
			System.out.println("--------------- MENU DE OPÇÕES ---------------\n" +
		                       "1 - Informar o número de clientes do banco\n" +
					           "2 - Cadastrar cliente\n" +
		                       "3 - Cadastrar cliente especial\n" +
		                       "4 - Listar clientes\n" +
		                       "5 - Procurar um cliente por nome\n" +
		                       "6 - Procurar um cliente pelo número da conta\n" +
		                       "7 - Solicitar empréstimo\n" +
					           "9 - Sair\n" +
		                       "----------------------------------------------\n"+
					           "Informe sua opção: ");
			opcao = scan.nextInt();
			scan.nextLine();
			
			switch (opcao) {
			case 1:
				informarClientes();
				break;
			case 2:
				if (clientesOK) {
					if (clientes.temEspacoNoVetor()) {
						cadastrarCliente(clientes, false);
					} else {
						System.out.println(bancoCheio);
					}
				} else {
					System.out.println(semCliente);
				}
				break;
			case 3:
				if (clientesOK) {
					if (clientes.temEspacoNoVetor()) {
						cadastrarCliente(clientes, true);
					} else {
						System.out.println(bancoCheio);
					}
				} else {
					System.out.println(semCliente);
				}
				break;
			case 4:
				if (clientesOK) {
					listarClientes(clientes);
				} else {
					System.out.println(semCliente);
				}
				break;
			case 5:
				if (clientesOK) {
					procurarCliente(clientes, 'n');
				} else {
					System.out.println(semCliente);
				}
				break;
			case 6:
				if (clientesOK) {
					procurarCliente(clientes, 'c');
				} else {
					System.out.println(semCliente);
				}
				break;
			case 7:
				if (clientesOK) {
					solicitarEmprestimo(clientes);
				} else {
					System.out.println(semCliente);
				}
				break;
			case 9:
				System.out.println("\nFim do programa. Moriturus te saluto!");
				break;
			default:
				System.out.println("Opção inválida, tente novamente:\n");
				break;
			}
		} while (opcao != 9);

	} // fecha main
	
	// informar clientes
	static void informarClientes() {
		if (clientesOK) {
			System.out.println("O banco já tem " + clientes.getQtdNoVetor() +"/" + clientes.retornaTamanhoDoVetor() + " clientes, não é possível alterar.\n");
			return;
		}
		
		boolean ok = true;
		int     n  = 0;
		
		while (ok) {
			try {
				System.out.println("Informe o número de clientes do banco:");
				n = scan.nextInt();
				scan.nextLine();
				if (n <= 0) {
					System.out.println("O número de clientes deve ser maior do que 0 (zero).");
					ok = true;
				} else {
					clientes = new ClienteVetor(n);
					clientesOK = true;
					ok = false;
					System.out.println("O banco terá " + n + " clientes.\n");
				}
			} catch (Exception e) {
				System.out.println("ERRO, você não digitou um número válido. Tente novamente.");
				scan.next();
				ok = true;
			}
		}
	} // fecha informar clientes
	
	// Cadastrar cliente
	static void cadastrarCliente(ClienteVetor clientes, boolean especial) {
		String  nome;
		String  cpf;
		int     conta = 0;
		double  saldo = 0;
		boolean ok    = true;
		
		System.out.println("Informe o nome do cliente:");
		nome = scan.nextLine();
		
		System.out.println("Informe o CPF do cliente:");
		cpf = scan.nextLine();
		
		ok = true;
		while (ok) {
			try {
				System.out.println("Informe o número da conta do cliente:");
				conta = scan.nextInt();
				scan.nextLine();
				if (conta <= 0) {
					System.out.println("O número da conta deve ser maior do que 0.");
					ok = true;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO, você não digitou um número válido.");
				scan.next();
				ok = true;
			}	
		}
		
		ok = true;
		while (ok) {
			try {
				System.out.println("Informe o saldo inicial da conta:");
				saldo = scan.nextDouble();
				scan.nextLine();
				if (saldo <= 0) {
					System.out.println("O saldo inicial da conta deve ser maior do que 0.");
					ok = true;
				} else {
					ok = false;
				}
			} catch (Exception e) {
				System.out.println("ERRO, você não digitou um número válido.");
				scan.next();
				ok = true;
			}
		}
			
		if (!especial) {
			Cliente novoCliente = new Cliente(nome, cpf, conta, saldo);
			if (clientes.inserirCliente(novoCliente)) {
				System.out.println("Cliente inserido com sucesso.");
			} else {
				System.out.println("ERRO, não foi possível inserir cliente.");
			}
		} else {
			ClienteEspecial novoCliente = new ClienteEspecial(nome, cpf, conta, saldo);
			if (clientes.inserirCliente(novoCliente)) {
				System.out.println("Cliente ESPECIAL inserido com sucesso.");
			} else {
				System.out.println("ERRO, não foi possível inserir cliente ESPECIAL.");
			}
		}
		
	} // fecha cadastrar cliente
	
	// Listar clientes
	static void listarClientes(ClienteVetor clientes) {
		System.out.println(clientes.toString());
	}
	
	// Procurar cliente
	static void procurarCliente(ClienteVetor clientes, char tipo) {
		int    posicao;
		if (tipo == 'n') {
			String nome = "";
			System.out.println("Informe o nome do cliente:");
			nome = scan.nextLine();
			
			posicao = clientes.posicaoNoVetor(nome);
			if (posicao != -1) {
				System.out.println(clientes.getVetor(posicao).toString());
			} else {
				System.out.println("Cliente não encontrado.");
			}
		} else {
			int conta = 0;
			boolean ok = true;
			while (ok) {
				try {
					System.out.println("Digite o número da conta do cliente:");
					conta = scan.nextInt();
					scan.nextLine();
					ok = false;
				} catch (Exception e) {
					System.out.println("ERRO, você não digitou uma conta válida. Tente novamente.");
					ok = true;
					scan.next();
				}
			}
			posicao = clientes.posicaoNoVetor(conta);
			if (posicao != -1) {
				System.out.println(clientes.getVetor(posicao).toString());
			} else {
				System.out.println("Cliente não encontrado.");
			}
		}
		
	} // fecha procurar cliente
	
	// solicitar empréstimo
	static void solicitarEmprestimo(ClienteVetor clientes) {
		int posicao;
		int conta;
		double valor = 0;
		double taxa  = 0;
		int    prazo = 0;
		boolean ok;
		
		System.out.println("Informe o número da conta do cliente:");
		conta = scan.nextInt();
		scan.nextLine();
		
		posicao = clientes.posicaoNoVetor(conta);
		
		if (posicao == -1) {
			System.out.println("ERRO, conta não cadastrada.");
		} else {
			ok = true;
			while (ok) {
				try {
					System.out.println("Informe o valor desejado do empréstimo:");
					valor = scan.nextDouble();
					scan.nextLine();
					if (valor <= 0) {
						System.out.println("ERRO, o valor do empréstimo deve ser maior do que zero.");
						ok = true;
					} else {
						ok = false;
					}
				} catch (Exception e) {
					System.out.println("ERRO, você não digitou um número válido, tente novamente.");
					scan.next();
					ok = true;
				}
			}
			
			ok = true;
			while (ok) {
				try {
					System.out.println("Informe a taxa % do empréstimo:");
					taxa = scan.nextDouble();
					scan.nextLine();
					if ((taxa < 0) && (taxa > 100)) {
						System.out.println("ERRO, o valor da taxa deve estar entre 0% e 100%.");
						ok = true;
					} else {
						ok = false;
					}
				} catch (Exception e) {
					System.out.println("ERRO, você não digitou um número válido, tente novamente.");
					scan.next();
					ok = true;
				}
			}
			
			ok = true;
			while (ok) {
				try {
					System.out.println("Informe o prazo do empréstimo, em meses:");
					prazo = scan.nextInt();
					scan.nextLine();
					if ((prazo < 0) && (prazo > 120)) {
						System.out.println("ERRO, o prazo deve estar entre 1 e 120 meses");
						ok = true;
					} else {
						ok = false;
					}
				} catch (Exception e) {
					System.out.println("ERRO, você não digitou um número válido, tente novamente.");
					scan.next();
					ok = true;
				}
			}
			
			if (clientes.getVetor(posicao).pegaEmprestimo(valor, taxa, prazo)) {
				System.out.println("Empréstimo concedido!");
			} else {
				System.out.println("ERRO! Empréstimo NÃO concedido.");
			}
			
		} // fecha if-else
		
	} // fecha solicitar empréstimo
}
