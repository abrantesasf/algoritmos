// Importação de bibliotecas
import java.util.Scanner;
import java.io.IOException;
import java.text.Normalizer;

// Classe TF_C3:
public class TF_C3 {
	
	// Método main
	public static void main(String[] args) throws IOException {
		
		// Declara variáveis, vetores e matrizes principais:
		String   nomeDoCondominio          = "SEM NOME";
		int      qtdDePrediosNoCondominio  = 0;
		String[] vet_nomeDosPredios        = null;
		String[] vet_tiposDeComodos        = {"Quartos", "Suítes", "Cozinhas", "Salas", "Banheiros", "Varandas"};
		int[][]  mat_comodosDosPredios     = null;
		
		// Declara variáveis de controle diversas:		
		boolean sair1     = true;
		boolean sair2     = true;
		boolean ok        = true;
		boolean dadosOK   = false;
		int     numero    = 0;
		char    opcao1    = ' ';
        char    opcao2    = ' ';
        String  nome      = null;
        String  temp      = null;
        String  temp2     = null;
		
        // Declara scanner para entrada de dados:
		Scanner scan = new Scanner(System.in);
		
		// Lógica principal do programa:
		do {
			// Mostra menu inicial
			menu();
			
			// Pega opção do menu principal:
			do {
				System.out.print("  Insira a opção desejada: ");
				temp = scan.nextLine();
				if (temp.length() != 1) {
					System.out.print("\n  Opção inválida. Por favor, tente novamente:\n");
				}
			} while (temp.length() != 1);
			opcao1 = temp.charAt(0);
			
			// Decide o que fazer de acordo com a opção do menu principal:
			switch (opcao1) {
			
			// Cadastrar condomínio:
			case '0':
				// Pega o nome do condomínio
				System.out.print("\n  Informe o nome do condomínio: ");
				nome = scan.nextLine();
				nomeDoCondominio = nome;
				
				// Ao terminar o cadastro, informa e aguardo o ENTER do usuário:
				System.out.print("  Cadastro do condomínio realizado com sucesso!");
				esperar();
				break;
			
			// Cadastrar dados:
			case '1':
				// Pega a quantidade de prédios no condomínio:
				ok = true;
				while (ok) {
					try {
						System.out.print("\n  Quantos prédios existem no condomínio \"" + nomeDoCondominio + "\"?\n  Por favor, digite um número inteiro >= 1: ");
						numero = scan.nextInt();
						scan.nextLine();
						if (numero >= 1) {
							qtdDePrediosNoCondominio = numero;
							ok = false;
						} else {
							System.out.println("\tERRO! A quantidade de prédios deve ser >= 1! Tente novamente...");
							ok = true;
						} // fecha if-else
					} catch (Exception e) {
						System.out.println("\tERRO! Você não digitou um número inteiro válido! Tente novamente...");
						ok = true;
						scan.next();
					} // fecha try-catch
				} // fecha while
				
				// Cria um vetor para armazenar os nomes dos prédios, conforme a
				// quantidade de prédios no condomínio:
				vet_nomeDosPredios = new String[qtdDePrediosNoCondominio];
				
				// Cria uma matriz para armazenar as informações dos cômodos de cada prédio,
				// conforme a quantidade de prédios no condomínio: 
				mat_comodosDosPredios = new int[qtdDePrediosNoCondominio][vet_tiposDeComodos.length];
				
				// Popula a matriz com as informações dos cômodos de cada prédio:
				for (int i = 0; i < qtdDePrediosNoCondominio; i++) {
					// Solicita o nome do prédio e armazena no vetor:
					System.out.print("\n\tInforme o nome do " + (i + 1) + "º prédio: ");
					//scan.nextLine();
					nome = scan.nextLine();
					vet_nomeDosPredios[i] = nome;
					
					// Para cada prédio, solicita a quantidade de cômodos e preenche a matriz:
					for (int j = 0; j < vet_tiposDeComodos.length; j++) {
						// Solicita a quantidade de cada tipo de cômodo:
						ok = true;
						while (ok) {
							try {
								System.out.print("\t\tInforme a quantidade de " + vet_tiposDeComodos[j] + ": ");
								numero = scan.nextInt();
								scan.nextLine();
								if (numero >= 0) {
									mat_comodosDosPredios[i][j] = numero;
									ok = false;
								} else {
									System.out.print("\t\t\tERRO!A quantidade precisa ser >= 0! Informe novamente...\n");
									ok = true;
								} // fecha if-else
							} catch (Exception e) {
								System.out.print("\t\t\tERRO!Você não digitou um número válido! Informe novamente...\n");
								ok = true;
								scan.next();
							} // fecha try-catch
						} // fecha while
					} // fecha for interno
				} // fecha for externo
				
				// Ao terminar o cadastro, informa e aguardo o ENTER do usuário:
				dadosOK = true;
				System.out.print("\n  Cadastro dos prédios e cômodos realizado com sucesso!");
				esperar();
				break;
				
			// Mostrar dados:
			case '2':
				// Verifica se os dados já foram cadastrados, e mostra:
				if (dadosOK) {
					System.out.println("\n  Dados dos prédios do condomínio \"" + nomeDoCondominio + "\":\n");
					System.out.print("\t          ");
					for (int linha = 0; linha < vet_tiposDeComodos.length; linha++) {
						System.out.print(String.format("\t%-10s" , vet_tiposDeComodos[linha]));
					}
					System.out.println("");
					for (int i = 0; i < mat_comodosDosPredios.length; i++) {
						System.out.print(String.format("\t%-10s" , vet_nomeDosPredios[i]));
						for (int j = 0; j < mat_comodosDosPredios[i].length; j++) {
							System.out.print(String.format("\t%-10s" , mat_comodosDosPredios[i][j]));
						} // fecha for interno
						System.out.println("");
					} // fecha for externo
					esperar();
					break;
				} else {
					System.out.print("\n  Por favor, termine o cadastro dos dados (opções 0 e 1)\n  antes de exibir as informações.");
				}
				
				// Ao terminar, aguarda o ENTER do usuário:
				esperar();
				break;
				
			// Alterar dados:
			case '4':
				// Verifica se os dados já foram cadastrados e mostra o menu alterar
				if (!dadosOK) {
					System.out.print("\n  Por favor, termine o cadastro dos dados (opções 0 e 1)\n  antes de utilizar as funções de alteração.");
					esperar();
				} else {
					do {
						alterar();
						sair2 = true;
						// Pega a opção do menu alterar
						do {
							System.out.print("\n\t  Insira a opção desejada: ");
							temp2 = scan.nextLine();
							if(temp2.length() != 1) {
								System.out.print("\n\t  Opção inválida. Por favor, tente novamente:");
							}
						} while (temp2.length() != 1);
					    opcao2 = temp2.charAt(0);
						System.out.println("");
						
						// Decide o que fazer de acordo com a opção do menu alterar:
						switch (opcao2) {
						
						// Altera o nome do condomínio:
						case '1':
							System.out.print("\t\tAlterar o nome do condomínio (\"" + nomeDoCondominio + "\") para: ");
							nomeDoCondominio = scan.nextLine();
							System.out.print("\t\tAlterado com sucesso!\n");
							esperar2();
							break;
						
						// Altera a quantidade de prédios no condomínio:
						case '2':
							System.out.print("\t\tAlterar a quantidade de prédios no condomínio.");
							System.out.print("\n\t\tATENÇÃO: isso apaga todos os dados anteriores e abre a tela de cadastro.\n\n");
							ok = true;
							while (ok) {
								try {
									System.out.print("\t\tDigite a nova quantidade de prédios no condomínio \"" + nomeDoCondominio + "\": ");
									numero = scan.nextInt();
									scan.nextLine();
									if (numero >= 1) {
										qtdDePrediosNoCondominio = numero;
										ok = false;
									} else {
										System.out.print("\t\t\tERRO! A quantidade de prédios deve ser >= 1!");
										ok = true;
									} // fecha if-else
								} catch (Exception e) {
									System.out.print("\t\t\tERRO! Você não digitou um número válido!");
									ok = true;
									scan.next();
								} // fecha try-catch
							} // fecha while
							
							// Cria um vetor para armazenar os nomes dos prédios, conforme a
							// quantidade de prédios no condomínio:
							vet_nomeDosPredios = new String[qtdDePrediosNoCondominio];
							
							// Cria uma matriz para armazenar as informações dos cômodos de cada prédio,
							// conforme a quantidade de prédios no condomínio: 
							mat_comodosDosPredios = new int[qtdDePrediosNoCondominio][vet_tiposDeComodos.length];
							
							// Popula a matriz com as informações dos cômodos de cada prédio:
							for (int i = 0; i < qtdDePrediosNoCondominio; i++) {
								// Solicita o nome do prédio e armazena no vetor:
								System.out.print("\n\t\t\tInforme o novo nome do " + (i + 1) + "º prédio: ");
								nome = scan.nextLine();
								vet_nomeDosPredios[i] = nome;
								
								// Para cada prédio, solicita a quantidade de cômodos e preenche a matriz:
								for (int j = 0; j < vet_tiposDeComodos.length; j++) {
									// Solicita a quantidade de cada tipo de cômodo:
									ok = true;
									while (ok) {
										try {
											System.out.print("\t\t\t\tInforme a nova quantidade de " + vet_tiposDeComodos[j] + ": ");
											numero = scan.nextInt();
											scan.nextLine();
											if (numero >= 0) {
												mat_comodosDosPredios[i][j] = numero;
												ok = false;
											} else {
												System.out.print("\t\t\t\t\tERRO! A quantidade precisa ser >= 0!\n");
												ok = true;
											} // fecha if-else
										} catch (Exception e) {
											System.out.print("\t\t\t\t\tERRO! Você não digitou um número válido!\n");
											ok = true;
											scan.next();
										} // fecha try-catch
									} // fecha while
								} // fecha for interno
							} // fecha for externo
							System.out.print("\n\t\tAlterado com sucesso!");
							esperar2();
							break;
							
						// Altera os nomes dos prédios
						case '3':
							for (int i = 0; i < qtdDePrediosNoCondominio; i++) {
								System.out.print("\t\tDigite o novo nome do " + (i + 1) + "º prédio (o nome atual é \"" + vet_nomeDosPredios[i] + "\"): ");
								nome = scan.nextLine();
								vet_nomeDosPredios[i] = nome;
							}
							System.out.print("\t\tAlterado com sucesso!\n");
							esperar2();
							break;
							
						// Alteração dos dos cômodos
						case '4':
							for (int i = 0; i < qtdDePrediosNoCondominio; i++) {
								System.out.print("\t\tAltere a quantidade de cômodos do " + (i + 1) + "º prédio (" + vet_nomeDosPredios[i] + "): \n");
								for(int j = 0; j < vet_tiposDeComodos.length; j++) {
									System.out.print("\t\t\tQuantidade de " + vet_tiposDeComodos[j] + ": ");
									numero = scan.nextInt();
									scan.nextLine();
									mat_comodosDosPredios[i][j] = numero;
								}
							}
							System.out.print("\t\tAlterado com sucesso!\n");
							esperar2();
							break;
							
						// Sair do menu de alteração
						case '5':
							System.out.print("\t  Saindo do menu de alteração.\n");
							sair2 = false;
							break;
							
						// Opção padrão do switch interno
						default:
							System.out.print("\n\t  Tente novamente e digite um número valido!");
							esperar2();
						} // fecha switch interno
					} while (sair2);
				} // fecha if-else
				
				break;
				
			// Pesquisar
			case '3':
				// Verifica se o cadastro está pronto e pesquisa
				if (!dadosOK) {
					System.out.print("\n  Por favor, termine o cadastro dos dados (opções 0 e 1)\n  antes de pesquisar as informações.");
				} else {
					System.out.print("\n  Insira o nome (ou parte do nome) do prédio para pesquisar,\n  ou apenas digite ENTER para todas as informações: ");
					nome = scan.nextLine();
					
					ok = false;
					for (int i = 0; i < vet_nomeDosPredios.length; i++) {
						// Ajudinha de: https://stackoverflow.com/questions/86780/how-to-check-if-a-string-contains-another-string-in-a-case-insensitive-manner-in/40508106#40508106
						if (Normalizer.normalize(vet_nomeDosPredios[i], Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").toLowerCase().contains(Normalizer.normalize(nome, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").toLowerCase())) {
							ok = true;
							System.out.print("\tO edificio \"" + vet_nomeDosPredios[i] + "\" tem ");
							for (int j = 0; j < mat_comodosDosPredios[i].length; j++) {
								System.out.print(mat_comodosDosPredios[i][j] + " ");
								System.out.print(vet_tiposDeComodos[j]);
								if (j == mat_comodosDosPredios[i].length-1) {
									System.out.print(". ");
								} else {
									System.out.print(", ");
								}
							}
							System.out.print("\n");
						}
					}
					if (!ok) {
						System.out.print("\n  Nenhum prédio encontrado com o nome informado.");
					}
				}
				esperar();
				break;
				
			// Encerra o programa:
			case '5':
				System.out.print("\n\n\n\tMoriturus te saluto!");
				System.out.print("\n\tTrabalho de algoritmo de: Brendhom, Abrantes e Iuri.");
				System.out.print("\n\tAdeus!\n\n");
				sair1 = false;
				break;
				
			// Opção padrão para o switch do menu principal:
			default:
				System.out.print("\n  Tente novamente e digite um número valido!");
				esperar();
			}
		} while (sair1);
		
		// Fecha o scan:
		scan.close();
		
	} // Fecha o método Main
	
	
	// Cria método para exibir menu de opções
	public static void menu() {
		System.out.print("\n====================================="
				+ "\n==>    Controle de Condomínios    <==\n"
				+ "====================================="
				+ "\n  0) Cadastrar o Condomínio"
				+ "\n  1) Cadastrar os Prédios"
				+ "\n  2) Mostrar todos os dados"
				+ "\n  3) Pesquisar dados do Prédio"
				+ "\n  4) Alterar dados"
				+ "\n  5) Sair do programa\n"
				+ "=====================================\n");
	}
	
	
	// Cria método para mostrar opções de alterações de dados
	public static void alterar() {
		System.out.print("\n\t-------------------------------------------------"
				+ "\n\t--> Alteração de Dados                        <--"
				+ "\n\t-------------------------------------------------"
				+ "\n\t  1) Nome do condominio"
				+ "\n\t  2) Quantidade de prédios (ATENÇÃO: apaga tudo!)"
				+ "\n\t  3) Nomes dos prédios"
				+ "\n\t  4) Quantidade de cômodos de todos os prédios"
				+ "\n\t  5) Voltar ao menu principal\n"
				+ "\t-------------------------------------------------");
	}
	
	
	// Cria método para esperar o ENTER do usuário para continuar:
	public static void esperar() throws IOException {
		Scanner scanner = new Scanner(System.in);
		boolean ok = true;
		while (ok) {
			System.out.print("\n  Pressione ENTER para continuar...");
	 		String readString = scanner.nextLine();
			if (readString.isEmpty()) {
				//System.out.println("ENTER");
				ok = false;
			} else {
				ok = true;
			}
		}
	}
	
	// Cria método para esperar o ENTER do usuário para continuar:
	//public static void esperar2() throws IOException {
	//	System.out.print("\n\t  Pressione ENTER para continuar...");
	//	System.in.read();
	//}	
	public static void esperar2() throws IOException {
		Scanner scanner = new Scanner(System.in);
		boolean ok = true;
		while (ok) {
			System.out.print("\n\t  Pressione ENTER para continuar...");
	 		String readString = scanner.nextLine();
			if (readString.isEmpty()) {
				//System.out.println("ENTER");
				ok = false;
			} else {
				ok = true;
			}
		}
	}
	
} // Fecha a classe TF_C3
