package sisBib.principal;

// Importação de bibliotecas
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.boot.model.source.internal.hbm.ManyToOneAttributeColumnsAndFormulasSource;

import sisBib.db.*;
import sisBib.principal.*;
import sisBib.util.*;

/**
 * <p>A classe SisBib é a classe principal do sistema de biblioteca.</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-12-03
 */
public class SisBib {
	
	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////
	
	private static Scanner                  scan       = new Scanner(System.in);
	private static Arquivos                 arq        = new Arquivos();
	private static CSV                      csv        = new CSV();
	private static Datas                    fmtData    = new Datas();
	private static TextUtils                textUtil   = new TextUtils();
	private static Validacoes               validacoes = new Validacoes();
	private static PostgreSQL               db         = new PostgreSQL();
	private static String                   sql        = "";
	private static VetorDeUsuarios          usuarios;
	private static VetorDeAlunos            alunos;
	private static VetorDeProfessores       professores;
	private static VetorDeFuncionarios      funcionarios;
	private static VetorDeLivros            livros;
	private static VetorDePeriodicos        periodicos;
	private static VetorDeAcervo            acervo;
	private static VetorDeEmprestimos       emprestimos;
	private static VetorDeItensDeEmprestimo itens;
	private static boolean                  usuariosOK = false;
	private static String                   csvFuncionarios = "/home/abrantesasf/funcionarios.csv";
	private static String                   csvAlunos       = "/home/abrantesasf/alunos.csv";
	private static String                   csvProfessores  = "/home/abrantesasf/professores.csv";
	private static String                   csvLivros       = "/home/abrantesasf/livros.csv";
	private static String                   csvPeriodicos   = "/home/abrantesasf/periodicos.csv";
	private static String                   csvEmprestimos  = "/home/abrantesasf/emprestimos.csv";
	private static String                   csvItens        = "/home/abrantesasf/itens.csv";
	private static int                      matFunc;
	

	/**
	 * <p><b>main(String[] args)</b></p>
	 * <p>Método MAIN do SisBib.</p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		// Abre conexão remota ao PostgreSQL para uso demonstrativo
		System.out.println("O programa está sendo carregado, por favor aguarde...\n");
		db.abrirConexao("sisbib", "12345");
		
		///////////////////////////////////////////////////
		// Lê planilha de funcionários e mostra login:
		///////////////////////////////////////////////////
		
		funcionarios = new VetorDeFuncionarios(arq.contarLinhas(csvFuncionarios) + 100);
		try {
			if (csv.lerCSVfuncionarios(csvFuncionarios, funcionarios)) {
			}
		} catch (Exception e) {
			System.out.println("Planilha corrompida");
		}
		if (funcionarios.getQtdNoVetor() != 0) {
			boolean conta = true;
			String login;
			String senha;
			do {
				System.out.println("Para entrar no sistema, é necessário digitar seu LOGIN e sua SENHA.");
				System.out.println("Digite seu login: ");
				login = scan.nextLine();
				if (funcionarios.procuraLogin(login)) {
					conta = true;
					matFunc = funcionarios.buscaMatriculaPorLogin(login); 
					System.out.println("Digite sua senha: ");
					senha = scan.nextLine();
					if (funcionarios.procuraSenha(senha)) {
						conta = false;
					} else {
						System.out.println("Senha não encontrada.");
						conta = true;
					}
				} else {
					System.out.println("Login não encontrado.");
					conta = true;
				}
			} while (conta);
		} else {
			System.out.println("ATENÇÃO: não existe nenhum funcionário cadastrado, portanto o sistema será encerrado!");
			System.out.println("Cadastre alguns funcionários (via arquivo CSV) e depois tente novamente.");
			return;
		}
		
		
		///////////////////////////////////////////////////
		// Carrega arquivos de dados e mostra menu
		///////////////////////////////////////////////////
		try {
			alunos      = new VetorDeAlunos(arq.contarLinhas(csvAlunos) + 100);
			try {
				if (csv.lerCSValunos(csvAlunos, alunos)) {
				}
			} catch (Exception e) {
				System.out.println("Planilha corrompida");
			}
		} catch (Exception e) {
			System.out.println("Não foi possível ler o arquivo de alunos. O sistema não será iniciado.");
			return;
		}
		
		try {
			professores = new VetorDeProfessores(arq.contarLinhas(csvProfessores) + 100);
			try {
				if (csv.lerCSVprofessores(csvProfessores, professores)) {
				}
			} catch (Exception e) {
				System.out.println("Planilha corrompida");
			}
		} catch (Exception e) {
			System.out.println("Não foi possível ler o arquivo de professores. O sistema não será iniciado.");
			return;
		}
		
		try {
			livros      = new VetorDeLivros(arq.contarLinhas(csvLivros) + 100);
			try {
				if (csv.lerCSVlivros(csvLivros, livros)) {
				}
			} catch (Exception e) {
				System.out.println("Planilha corrompida");
			}
		} catch (Exception e) {
			System.out.println("Não foi possível ler o arquivo de livros. O sistema não será iniciado.");
			return;
		}
		
		try {
			periodicos  = new VetorDePeriodicos(arq.contarLinhas(csvPeriodicos) + 100);
			try {
				if (csv.lerCSVperiodicos(csvPeriodicos, periodicos)) {
				}
			} catch (Exception e) {
				System.out.println("Planilha corrompida");
			}
		} catch (Exception e) {
			System.out.println("Não foi possível ler o arquivo de periódicos. O sistema não será iniciado.");
			return;
		}
		
		try {
			emprestimos  = new VetorDeEmprestimos(arq.contarLinhas(csvEmprestimos) + 100);
			try {
				if (csv.lerCSVemprestimos(csvEmprestimos, emprestimos)) {
				}
			} catch (Exception e) {
				System.out.println("Planilha corrompida");
			}
		} catch (Exception e) {
			System.out.println("Não foi possível ler o arquivo de periódicos. O sistema não será iniciado.");
			return;
		}
		
		try {
			itens = new VetorDeItensDeEmprestimo(arq.contarLinhas(csvItens) + 100);
			try {
				if (csv.lerCSVitensDeEmprestimos(csvItens, itens)) {
				}
			} catch (Exception e) {
				System.out.println("Planilha corrompida");
			}
		} catch (Exception e) {
			System.out.println("Não foi possível ler o arquivo de periódicos. O sistema não será iniciado.");
			return;
		}
		
		
		System.out.println("\nUsuário identificado e arquivos de dados lidos! Bem-vindo!\n");
		
		int menu = 0;
		int submenu = 0;
		
		do {
			System.out.println("--------------- MENU DE OPÇÕES ---------------\n" +
		                       "1 - Cadastrar usuários ou itens\n" +
					           "2 - Cadastrar empréstimos\n" +
		                       "3 - Devolução de empréstimos\n" +
					           "4 - Remover cadastro de usuários ou itens\n" +
		                       "5 - Ver cadastros na tela\n" +
					           "8 - Demonstração do uso de um PostgreSQL remoto\n" +
		                       "9 - Sair\n" +
		                       "----------------------------------------------\n"+
					           "Informe sua opção: ");
			menu = scan.nextInt();
			scan.nextLine();
			
			switch (menu) {
			case 1:
				do {

					System.out.println(  "1 - Cadastrar Aluno" + 
					                   "\n2 - Cadastrar Professor" + 
							           "\n3 - Cadastrar Funcionario" +
					                   "\n4 - Cadastrar Livro" + 
							           "\n5 - Cadastrar Periódico" + 
					                   "\n6 - Voltar");
					submenu = scan.nextInt();
					scan.nextLine();
					
					switch (submenu) {
					case 1:

						System.out.println("Matricula do aluno: ");
						int mat = scan.nextInt();
						scan.nextLine();
						
						System.out.println("Nome do aluno: ");
						String nome = scan.nextLine();
						
						System.out.println("endereço do aluno: ");
						String endereco = scan.nextLine();
						
						System.out.println("Curso do aluno: ");
						String curso = scan.nextLine();
						
						System.out.println("Data de ingresso do aluno: ");
						String data = scan.nextLine();
						
						System.out.println("Multas em aberto: ");
						double multa = scan.nextDouble();
//						try {
//							if (csv.lerCSValunos(aluno, vAlunos)) {
//								System.out.println("Planilha de Alunos lida com sucesso");
//							}
//
//						} catch (Exception e) {
//							System.out.println("Erro na leitura de Alunos");
//						}
						Aluno novoAluno = new Aluno(mat, nome, endereco, curso, data, multa);
						if (alunos.inserirAluno(novoAluno)) {
							try {
								csv.gravarCSValunos(csvAlunos, alunos);
								System.out.println("Aluno inserido com sucesso!");
							} catch (Exception e) {
								System.out.println("Erro na gravação do arquivo CSV.");
							}
						}
						break;
					case 2:
						System.out.println("Matricula do professor: ");
						mat = scan.nextInt();
						scan.nextLine();
						
						System.out.println("Nome do professor: ");
						nome = scan.nextLine();
						
						System.out.println("Endereço do professor: ");
						endereco = scan.nextLine();
						
						System.out.println("Data de ingresso do professor: ");
						data = scan.nextLine();
						
						System.out.println("Setor do professor: ");
						String setor = scan.nextLine();
						
//						try {
//							if (csv.lerCSVprofessores(professor, vProfs)) {
//
//							}
//						} catch (Exception e) {
//							System.out.println("Planilha corrompida");
//						}
						Professor novoProfessor = new Professor(mat, nome, endereco, data, setor);
						if (professores.inserirProfessor(novoProfessor)) {
							try {
								csv.gravarCSVprofessores(csvProfessores, professores);
								System.out.println("Professor inserido com sucesso!");
							} catch (Exception e) {
								System.out.println("Erro na gravação do arquivo CSV.");
							}
						}
						break;
					case 3:
						System.out.println("Matricula do Funcionario: ");
						mat = scan.nextInt();
						scan.nextLine();
						
						System.out.println("Nome do Funcionario: ");
						nome = scan.nextLine();
						
						System.out.println("Endereço do Funcionario");
						endereco = scan.nextLine();
						
						System.out.println("Data de ingresso do Funcionario: ");
						data = scan.nextLine();
						
						System.out.println("Setor do Funcionario: ");
						setor = scan.nextLine();
						
						System.out.println("Senha do Funcionario: ");
						String senha = scan.nextLine();
						
						System.out.println("Login do Funcionario: ");
						String login = scan.nextLine();
						
						Funcionario novoFuncionario = new Funcionario(mat, nome, endereco, data, setor, senha, login);
						if (funcionarios.inserirFuncionario(novoFuncionario)) {
							try {
								csv.gravarCSVfuncionario(csvFuncionarios, funcionarios);
								System.out.println("Funcionário inserido com sucesso!");
							} catch (Exception e) {
								System.out.println("Erro na gravação do arquivo CSV.");
							}
						}
						break;
					case 4:
						System.out.println("Código do livro");
						int cod = scan.nextInt();
						scan.nextLine();
						
						System.out.println("autor do livro");
						String autor = scan.nextLine();
						
						System.out.println("titulo do livro");
						String titulo = scan.nextLine();
						
						System.out.println("editora do livro");
						String editora = scan.nextLine();
						
						System.out.println("tipo do livro");
						char tipo = scan.next().charAt(0);
						
						System.out.println("ano de publicação do livro");
						int ano = scan.nextInt();
						scan.nextLine();
						
						System.out.println("ISBN do livro");
						String isbn = scan.nextLine();
						
						Livro novoLivro = new Livro(cod, autor, titulo, editora, tipo, ano, isbn);
						if (livros.inserirLivro(novoLivro)) {
							try {
								csv.gravarCSVlivros(csvLivros, livros);
								System.out.println("Livro inserido com sucesso!");
							} catch (Exception e) {
								System.out.println("Erro na gravação do arquivo CSV.");
							}
						}
						break;
					case 5:
						System.out.println("Código do periodico");
						cod = scan.nextInt();
						scan.nextLine();
						
						System.out.println("autor do periodico");
						autor = scan.nextLine();
						
						System.out.println("titulo do periodico");
						titulo = scan.nextLine();
						
						System.out.println("tipo do periodico");
						tipo = scan.next().charAt(0);
						
						System.out.println("Fator de impacto do periodico");
						double FatorDeImpacto = scan.nextDouble();
						scan.nextLine();
						
						System.out.println("ISSN do periodico");
						String isnn = scan.nextLine();
//						try {
//							if (csv.lerCSVperiodico(periodicos, vPeriodicos)) {
//
//							}
//						} catch (Exception e) {
//							System.out.println("Arquivo corrompido");
//						}
						Periodico novoPeriodico = new Periodico(cod, autor, titulo, tipo, FatorDeImpacto, isnn);
						if (periodicos.inserirPeriodico(novoPeriodico)) {
							try {
								csv.gravarCSVperiodicos(csvPeriodicos, periodicos);
								System.out.println("Periódico inserido com sucesso!");
							} catch (Exception e) {
								System.out.println("Erro na gravação do arquivo CSV.");
							}
						}
						break;
					case 6:
						// nada só volta para o menu principal
						break;
					default:
						System.out.println("Opção inválida, tente novamente.");
						break;
					}
				} while (submenu != 6);
				break;
			case 2:
				System.out.println("Digite o código do Empréstimo:");
				int codigoEmprestimo = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Digite o código do Cliente:");
				int codigoCliente = scan.nextInt();
				scan.nextLine();
				
				int codigoFuncionario = matFunc;
				
				System.out.println("Digite a data do empréstimo: ");
				String dataEmprestimoString = scan.nextLine();
				
				System.out.println("Digite a data da devolução: ");
				String dataDevolucaoString = scan.nextLine();
				
				int codigoItem = codigoEmprestimo + 123; // aleatório mesmo só para simplificar
				
				System.out.println("Digite o código do livro: ");
				int codigoLivro = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Digite o código do periódico: ");
				int codigoPeriodico = scan.nextInt();
				scan.nextLine();
				
				Emprestimo novoEmprestimo = new Emprestimo(codigoEmprestimo, codigoCliente, codigoFuncionario, dataEmprestimoString, dataDevolucaoString);
				ItemDeEmprestimo novoItemDeEmprestimo = new ItemDeEmprestimo(codigoItem, codigoEmprestimo, codigoLivro, codigoPeriodico, dataDevolucaoString);
				if ( (emprestimos.inserirEmprestimo(novoEmprestimo)) & (itens.inserirItemDeEmprestimo(novoItemDeEmprestimo))) {
					try {
						csv.gravarCSVemprestimos(csvEmprestimos, emprestimos);
						csv.gravarCSVitensDeEmprestimos(csvItens, itens);
						System.out.println("Empréstimo inserido com sucesso!");
					} catch (Exception e) {
						System.out.println("Erro na gravação dos arquivos CSV de empréstimo e/ou itens.");
					}
				}
				break;
			case 3:
				System.out.println("Digite o código do empréstimo que deseja fazer a devolução: ");
				codigoEmprestimo = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Existe multa para o cliente (S ou N)?" );
				char temMulta = scan.nextLine().charAt(0);
				
				if (temMulta == 'S') {
					System.out.println("Informe o valor da multa: ");
					double multa = scan.nextDouble();
					scan.nextLine();
					
					codigoCliente = 0;
					for (int i = 0; i < emprestimos.getQtdNoVetor(); i++) {
						if (emprestimos.getEmprestimo(i).getCodigo() == codigoEmprestimo) {
							codigoCliente = emprestimos.getEmprestimo(i).getMatriculaCliente();
						}
					}
					
					for (int i = 0; i < alunos.getQtdNoVetor(); i++) {
						if (alunos.getAluno(i).getMatricula() == codigoCliente) {
							alunos.getAluno(i).setMulta(multa);
						}
					}
				}
				
				try {
					csv.gravarCSValunos(csvAlunos, alunos);
					System.out.println("Empréstimo devolvido com sucesso!");
				} catch (Exception e) {
					System.out.println("Erro na gravação dos arquivos CSV de empréstimo e/ou itens.");
				}
				
				break;
			case 4:
				do {
					System.out.println("Remover cadastro por matricula/código");
					System.out.println("1 - Cadastro de Aluno");
					System.out.println("2 - Cadastro de Professor");
					System.out.println("3 - Cadastro de Funcionario");
					System.out.println("4 - Cadastro de Livro");
					System.out.println("5 - Cadastro de Periodico");
					System.out.println("6 - Voltar");
					submenu = scan.nextInt();
					switch (submenu) {
					case 1:
						System.out.println("Digite a matricula do Aluno");
						int mat = scan.nextInt();
						scan.nextLine();
						try {
							alunos.removerAluno((alunos.posicaoNoVetor(mat)));
							csv.gravarCSValunos(csvAlunos, alunos);
							System.out.println("Aluno removido com sucesso.");
						} catch (Exception e) {
							System.out.println("Não foi possível remover o aluno.");
						}
						break;
					case 2:
						System.out.println("Digite a matricula do Professor");
						mat = scan.nextInt();
						scan.nextLine();
						try {
							professores.removerProfessor((professores.posicaoNoVetor(mat)));
							csv.gravarCSVprofessores(csvProfessores, professores);
							System.out.println("Professor removido com sucesso.");
						} catch (Exception e) {
							System.out.println("Não foi possível remover o professor");
						}
						break;
					case 3:
						System.out.println("Digite a matricula do Funcionario");
						mat = scan.nextInt();
						scan.nextLine();
						try {
							funcionarios.removerFuncionario((funcionarios.posicaoNoVetor(mat)));
							csv.gravarCSVfuncionario(csvFuncionarios, funcionarios);
							System.out.println("Funcionário removido com sucesso.");
						} catch (Exception e) {
							System.out.println("Não foi possível remover o funcionário");
						}
						break;
					case 4:
						System.out.println("Digite o Código do livro");
						int cod = scan.nextInt();
						scan.nextLine();
						try {
							livros.removerLivro((livros.posicaoNoVetor(cod)));
							csv.gravarCSVlivros(csvLivros, livros);
							System.out.println("Livro removido com sucesso.");
						} catch (Exception e) {
							System.out.println("Não foi possível remover o livro");
						}
						break;
					case 5:
						System.out.println("Digite o Código do Periodico");
						cod = scan.nextInt();
						scan.nextLine();
						try {
							periodicos.removerPeriodico((periodicos.posicaoNoVetor(cod)));
							csv.gravarCSVperiodicos(csvPeriodicos, periodicos);
							System.out.println("Periódico removido com sucesso.");
						} catch (Exception e) {
							System.out.println("Não foi possível remover o periódico.");
						}
						break;
					default:
						System.out.println("Opção inválida, tente novamente.");
						break;
					}

				} while (submenu != 6);
				break;
			case 5:
				do {
				System.out.println("Quais dados você deseja vizualizar: ");
				System.out.println(  "1 - Planilha de Alunos" +
				                   "\n2 - plhanilha de professores" +
						           "\n3 - Plhanilha de funcionarios" +
						           "\n4 - Planilha de Livros" + 
						           "\n5 - Planilha de Periodicos" +
						           "\n9 - Voltar");
				submenu = scan.nextInt();
				scan.nextLine();
				
				switch (submenu) {
				case 1:
					System.out.println(alunos.toString());
					break;
				case 2:
					System.out.println(professores.toString());
					break;
				case 3:
					System.out.println(funcionarios.toString());
					break;
				case 4:
					System.out.println(livros.toString());
					break;
				case 5:
					System.out.println(periodicos.toString());
				case 9:
					// só volta mesmo
					break;
				}
			} while (submenu != 9);
				break;
			case 8:
				System.out.println("Esse menu é uma DEMONSTRAÇÃO ONLINE da conexão de nosso sistema de biblioteca baseado em arquivo");
				System.out.println("à um banco de dados PostgreSQL 11.1, hospedado na Amazon AWS em um servidor Linux de um dos autores.");
				System.out.println("A conexão é feita através de CERTIFICADOS SSL e VERIFICAÇÃO DE AUTORIDADE CERTIFICADORA, de modo que");
				System.out.println("o servidor só aceite conexões de clientes previamente autorizadas e com um CERTIFICADO SSL válido.");
				System.out.println("Do mesmo modo, o cliente só aceita se conectar ao servidor se o CERTIFICADO SSL do servidor estiver");
				System.out.println("assinado e for confivável em sua cadeia de certificação.");
				System.out.println(" ");
				System.out.println("O objetivo dessa demonstração é apresentar um início de mapeamento OBJETO-RELACIONAL para o trabalho.");
				System.out.println("Executando a query em PGSQL.ENDOSCOPIA.VIX.BR:");
				
				sql = "SELECT a.matricula, "
						+ "       a.nome, "
					    + "       a.data, "
						+ "       c.curso "
						+ "FROM sisbib.alunos a "
						+ "INNER JOIN sisbib.cursos c ON (a.codigo_curso = c.codigo) "
						+ "ORDER BY a.nome ";
				
				try {
					db.prepararQuery(sql);
					db.executarQuery();
					int matricula;
					String nome, data, curso;
					System.out.println("Imprimindo o ResultSet:");
					while (db.resultadosDaQuery().next()) {
						matricula = Integer.parseInt(db.resultadosDaQuery().getString("matricula"));
						nome = db.resultadosDaQuery().getString("nome");
						data = db.resultadosDaQuery().getString("data");
						curso = db.resultadosDaQuery().getString("curso");
						System.out.printf("%3d\t%-30s\t%-30s\t%-10s\n", matricula, nome, curso, data);
					}
					db.terminaQuery();
				} catch (Exception e) {
					e.toString();
				}
				db.fecharConexao();
				break;
			case 9:
				System.out.println("\nSaindo do SisBib!");
				System.out.println("Moriturus te saluto!");
				break;
			default:
				System.out.println("\nOpção inválida, tente novamente:\n");
				break;
			}
			
		} while (menu != 9);
		
		// Fecha conexão ao banco de dados
		db.fecharConexao();

	} // Fecha método main

}
