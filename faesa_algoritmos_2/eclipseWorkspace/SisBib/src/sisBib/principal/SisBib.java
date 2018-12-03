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
	
	private static Scanner            scan       = new Scanner(System.in);
	private static Arquivos           arq        = new Arquivos();
	private static CSV                csv        = new CSV();
	private static Datas              fmtData    = new Datas();
	private static TextUtils          textUtil   = new TextUtils();
	private static Validacoes         validacoes = new Validacoes();
	private static PostgreSQL         db         = new PostgreSQL();
	private static String             sql        = "";
	private static VetorDeUsuarios    usuarios;
	private static VetorDeAlunos      alunos;
	private static VetorDeProfessores professores;
	private static VetorDeFuncionarios funcionarios;
	private static VetorDeLivros      livros;
	private static VetorDePeriodicos  periodicos;
	private static VetorDeAcervo      acervo;
	private static boolean            usuariosOK = false;
	private static String             csvFuncionarios = "/home/abrantesasf/funcionarios.csv";
	private static String             csvAlunos       = "/home/abrantesasf/alunos.csv";
	private static String             csvProfessores  = "/home/abrantesasf/professores.csv";
	private static String             csvLivros       = "/home/abrantesasf/livros.csv";
	private static String             csvPeriodicos   = "/home/abrantesasf/periodicos.csv";
	private static int                matFunc;
	

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
		
		System.out.println("\nUsuário identificado e arquivos de dados lidos! Bem-vindo!\n");
		
		int menu = 0;
		int submenu = 0;
		
		do {
			System.out.println("--------------- MENU DE OPÇÕES ---------------\n" +
		                       "1 - Cadastrar usuários ou itens\n" +
					           "2 - Cadastrar empréstimos\n" +
		                       //"3 - Devolução de empréstimos\n" +
					           "4 - Remover cadastro de usuários ou itens\n" +
		                       "5 - Ver cadastros na tela\n" +
					           //"8 - Demonstração do uso de um PostgreSQL remoto\n" +
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
