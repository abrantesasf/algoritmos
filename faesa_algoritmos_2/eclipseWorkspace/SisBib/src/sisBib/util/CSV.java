package sisBib.util;

//Importação de bibliotecas:
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.BufferedReader;
//import java.util.Scanner;
import sisBib.principal.Aluno;
import sisBib.principal.Emprestimo;
import sisBib.principal.Funcionario;
import sisBib.principal.ItemDeEmprestimo;
import sisBib.principal.Livro;
import sisBib.principal.Periodico;
import sisBib.principal.Professor;
import sisBib.principal.VetorDeAlunos;
import sisBib.principal.VetorDeEmprestimos;
import sisBib.principal.VetorDeFuncionarios;
import sisBib.principal.VetorDeItensDeEmprestimo;
import sisBib.principal.VetorDeLivros;
import sisBib.principal.VetorDePeriodicos;
import sisBib.principal.VetorDeProfessores;


/**
 * <p>A classe CSV contém os métodos para realizar importação, validação e a exportação dos dados
 * especificados no projeto do SisBib, em formato CSV.</p>
 * 
 * <p>Sistema de Biblioteca (SisBib): trabalho desenvolvido na disciplina 
 * Algoritmo II, do curso de Ciência da Computação da Faesa, Prof. Rober Marconi.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 * @author Isaac de Miranda Campos (<a href="mailto:isaac.miranda321@gmail.com">isaac.miranda321@gmail.com</a>)
 * @version 1.0
 * @since   2018-11-17
 */
public class CSV {
	
	///////////////////////////////////////////////////
	// Definições de atributos:
	///////////////////////////////////////////////////	
	
//	/**
//	 * <p><b>scan</b>:</p>
//	 * <ul>
//	 * <li>Utilizado para escanear os dados de um arquivo, linha a linha</li>
//	 * <li>Tipo: Scanner</li>
//	 * </ul>
//	 */
//	private Scanner scan;
	
//	/**
//	 * <p><b>scanDados</b>:</p>
//	 * <ul>
//	 * <li>Após o Scanner "scan" ler um arquivo CSV linha a linha, este Scanner
//	 * "scanDados" é configurado para utilizar um determinado delimitador (padrão é ;)
//	 * e receber cada linha do Scanner "scan", e processar cada linha de acordo com
//	 * os campos estabelecidos na documentação do SisBib.</li>
//	 * <li>Tipo: Scanner</li>
//	 * </ul>
//	 */
//	private Scanner scanDados;
	
//	/**
//	 * <p><b>indice</b>:</p>
//	 * <ul>
//	 * <li>Inteiro que faz a contagem de em qual campo o scanDados está.</li>
//	 * <li>Tipo: int</li>
//	 * </ul>
//	 */
//	private int indice ;
	
//	/**
//	 * <p><b>matricula, nome, endereco, data</b>:</p>
//	 * <ul>
//	 * <li>Variáveis temporárias para a obtenção dos dados do arquivo CSV.</li>
//	 * <li>Tipo: int (matricula); String (nome, endereco, data)</li>
//	 * </ul>
//	 */
//	private int    matricula;
//	private String nome;
//	private String endereco;
//	private String data;
	
	/**
	 * <p><b>mensagem</b>:</p>
	 * <ul>
	 * <li>Variável para armazenar mensagens importantes que serão geradas durante
	 * o processamento dos métodos desta classe.</li>
	 * <li>Tipo: String</li>
	 * </ul>
	 */
	private String mensagem = "";
	
	/**
	 * <p><b>validacoes</b>:</p>
	 * <ul>
	 * <li>É uma instância das validaçṍes gerais das regras de negócio
	 * específicas do SisBib.</li>
	 * <li>Tipo: Validacoes</li>
	 * </ul>
	 */	
	private Validacoes validacoes = new Validacoes();
	
	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////
	
	/**
	 * <p>O construtor para a classe CSV não recebe nada.</p>
	 */
	public CSV() {
		// Só o construtor padrão aqui
	}
	
	
	///////////////////////////////////////////////////
	// Métodos
	///////////////////////////////////////////////////	
	
//	/**
//	 * <p><b>lerCSVfuncionarios(String arquivo)</b></p>
//	 * <p>Lê um arquivo CSV contendo dados dos funcionários,
//	 * conforme a especificação do SisBib.</p>
//	 * 
//	 * @param arquivo (String representando o path para um arquivo CSV)
//	 */
//	public void lerCSVfuncionarios(String arquivo) throws IOException {
//		// Scanner que lê as linhas do arquivo:
//		scan = new Scanner(new File(arquivo));
//		
//		// Scanner que, a cada linha, lê os campos separados pelo delimitador
//		scanDados = null;
//		
//		// Inicia a numeração dos campos com 0
//		indice = 0;
//		
//		// Força o Scanner do arquivo a pular a primeira linha, que só contém
//		// a especificação dos campos:
//		scan.nextLine();
//		
//		// A cada linha do arquivo (a partir da segunda):
//		while (scan.hasNextLine()) {
//			// Lê a linha inteira e configura o delimitador padrão
//			scanDados = new Scanner(scan.nextLine());
//			scanDados.useDelimiter(";");
//			
//			// A cada campo da linha, separado pelo delimitador padrão:
//			while (scanDados.hasNext()) {
//				String dados = scanDados.next();
//				if (indice == 0) {
//					matricula = Integer.parseInt(dados);
//					System.out.println("Matrícula: " + matricula);
//				} else if (indice == 1) {
//					nome = dados;
//					System.out.println("Nome: " + nome);
//				} else if (indice == 2) {
//					endereco = dados;
//					System.out.println("Endereço: " + endereco);
//				} else if (indice == 3) {
//					data = dados;
//					System.out.println("Data: " + data);
//				} else {
//					// Ôpa, tem mais colunas do que a especificação!
//					System.out.println("ERRO!!!!!!!!!!");
//				}
//				// Incrementa o contador de campos:
//				indice++;
//			}
//			
//			// Zera o contador de campos para a próxima linha:
//			indice = 0;
//		}
//		
//		// Fecha os Scanners abertos:
//		scanDados.close();
//		scan.close();
//		
//	} // Fecha o método lerCSVfuncionarios
	

	public boolean lerCSVfuncionarios(String arquivo, VetorDeFuncionarios vFuncionarios) throws IOException {
		int    numeroCampos = 7;
		String divisor      = ";";
		String linha        = "";
		boolean ok          = true;
		VetorDeFuncionarios vTemp = new VetorDeFuncionarios(vFuncionarios.getTamanhoDoVetor());

		try {
			// Cria objeto FileReader para "apontar" para o arquivo passado como argumento; e
			// Cria objeto BufferedReader que lê o conteúdo do arquivo apontado pelo FileReader.
			FileReader     arq    = new FileReader(arquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			
			try {
				// Pula a linha de cabeçalho do arquivo
				lerArq.readLine();
				
				// Enquanto ainda existem linhas a serem lidas e não há erros (ok = true):
				while (((linha = lerArq.readLine()) != null) && ok) {
					
					// Pega a próxima linha, divide os campos nos divisores e coloca em vetor
					String[] vetor = linha.split(divisor);
					
					// Valida se o número de campos da linha está nos conformes
					if (vetor.length != numeroCampos) {
						ok = false;
						this.mensagem = "Erro de estrutura do arquivo CSV de funcionários (mais ou menos campos do que o especificado para o SisBib).";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a matrícula está nos conformes
					} else if (!this.validacoes.validaMatricula(Integer.parseInt(vetor[0]))) {
						ok = false;
						this.mensagem = "Erro de matrícula: \"" + vetor[0] + "\" está fora dos limites especificados para o SisBib.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a data está nos conformes
					} else if (!this.validacoes.validaData(vetor[3])) {
						ok = false;
						this.mensagem = "Erro de data: \"" + vetor[3] + "\" não é uma data válida.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
					
					// Valida se já existe algum aluno cadastrado com o mesmo número de matrícula
					} else if (vFuncionarios.matriculaExiste(Integer.parseInt(vetor[0])) ||
							   vTemp.matriculaExiste(Integer.parseInt(vetor[0]))) {
						ok = false;
						this.mensagem = "Erro de matrícula duplicada: \"" + vetor[0] + "\" já está cadastrada.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Se tudo estiver nos conformes, cria novo professor
					} else {
						Funcionario novoFuncionario = new Funcionario(Integer.parseInt(vetor[0]), vetor[1], vetor[2], vetor[3], vetor[4], vetor[5], vetor[6]);
						
						// Tenta inserir o professor no vetor
						if (!vTemp.inserirFuncionario(novoFuncionario)) {
							ok = false;
							this.mensagem = "Erro durante a inserção do funcionário no vetor temporário.";
							this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
							break;
						}
					}
				} // Fecha While
			} catch (Exception e) {
				// Se deu algum xabu, mostra o stack de erro
				e.printStackTrace();	
			} finally {
				// Se não deu xabu, fecha o FileReader e o BufferedReader
				lerArq.close();
				arq.close();
			}
		} catch (Exception e2) {
			// Se deu algum xabu, mosgtra o stack de erro
			e2.printStackTrace();
		}
		
		// Se chegou até aqui e ok continua True, então podemos tirar os dados do
		// vetor temporário e passar de volta para o real
		if (ok)	{
			for (int i = 0; i < vTemp.getQtdNoVetor(); i++) {
				if(!vFuncionarios.inserirFuncionario(vTemp.getFuncionario(i))) {
					ok = false;
					this.mensagem = "Erro DESCONHECIDO durante o retorno dos dados. Entre em contato com o suporte.";
					this.mensagem += "\nSeus dados podem estar corrompidos. Verifique!";
					break;
				} else {
					this.mensagem = "Nenhum erro encontrado!";
					this.mensagem += "\nA leitura e importação dos dados foi concluída com sucesso!";
				};
			}
		}
		
		// Anula vetor temporário e retorna True ou False
		vTemp = null;
		return ok;		
	}
	

	public boolean gravarCSVfuncionario(String arquivo, VetorDeFuncionarios vFunc) {
		boolean ok = false;
		try {
			// Instancia objeto do tipo PrintWriter, usanto UTF-8 por padrÃ£o
			PrintWriter saida = new PrintWriter(arquivo, "UTF-8");

			// Grava linha de cabeÃ§alho e o separador de linha adequado para o SO:
			saida.print("matricula;nome;endereco;data;setor;senha;login");
			saida.print(System.getProperty("line.separator"));

			// Percorre o vetor e salva os dados no arquivo (removendo qualquer ";"
			// que estiver no meio das informaÃ§Ãµes do tipo String), colocando o separador
			// ";"
			// entre os campos e, ao final, o caractere de final de linha adequado para o SO
			for (int i = 0; i < vFunc.getQtdNoVetor(); i++) {
				saida.print(vFunc.getFuncionario(i).getMatricula());
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vFunc.getFuncionario(i).getNome(), ";"));
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vFunc.getFuncionario(i).getEndereco(), ";"));
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vFunc.getFuncionario(i).getDataString(), ";"));
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vFunc.getFuncionario(i).getSetor(), ";"));
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vFunc.getFuncionario(i).getSenha(), ";"));
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vFunc.getFuncionario(i).getLogin(), ";"));
				saida.print(System.getProperty("line.separator"));
			}
			ok = true;
			saida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	/**
	 * <p><b>lerCSVprofessores(String arquivo, VetorDeProfessores vProfessores)</b></p>
	 * <p>Lê um arquivo CSV contendo dados dos professores,
	 * conforme a especificação do SisBib. Se ocorrer algum problema durante o processamento
	 * deste método, os dados do arquivo CSV não são retornados ao vetor vProfs.</p>
	 * 
	 * @param arquivo (String representando o path para um arquivo CSV)
	 * @param vProfessores (Vetor de Professores que receberá os dados lidos do arquivo CSV)
	 * @return <b>True</b>, se o método foi executado com sucesso<br /><b>False</b>, se o método não foi executado com sucesso
	 */
	public boolean lerCSVprofessores(String arquivo, VetorDeProfessores vProfessores) throws IOException {
		int    numeroCampos = 5;
		String divisor      = ";";
		String linha        = "";
		boolean ok          = true;
		VetorDeProfessores vTemp = new VetorDeProfessores(vProfessores.getTamanhoDoVetor());

		try {
			// Cria objeto FileReader para "apontar" para o arquivo passado como argumento; e
			// Cria objeto BufferedReader que lê o conteúdo do arquivo apontado pelo FileReader.
			FileReader     arq    = new FileReader(arquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			
			try {
				// Pula a linha de cabeçalho do arquivo
				lerArq.readLine();
				
				// Enquanto ainda existem linhas a serem lidas e não há erros (ok = true):
				while (((linha = lerArq.readLine()) != null) && ok) {
					
					// Pega a próxima linha, divide os campos nos divisores e coloca em vetor
					String[] vetor = linha.split(divisor);
					
					// Valida se o número de campos da linha está nos conformes
					if (vetor.length != numeroCampos) {
						ok = false;
						this.mensagem = "Erro de estrutura do arquivo CSV de professores (mais ou menos campos do que o especificado para o SisBib).";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a matrícula está nos conformes
					} else if (!this.validacoes.validaMatricula(Integer.parseInt(vetor[0]))) {
						ok = false;
						this.mensagem = "Erro de matrícula: \"" + vetor[0] + "\" está fora dos limites especificados para o SisBib.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a data está nos conformes
					} else if (!this.validacoes.validaData(vetor[3])) {
						ok = false;
						this.mensagem = "Erro de data: \"" + vetor[3] + "\" não é uma data válida.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
					
					// Valida se já existe algum professor cadastrado com o mesmo número de matrícula
					} else if (vProfessores.matriculaExiste(Integer.parseInt(vetor[0])) ||
							   vTemp.matriculaExiste(Integer.parseInt(vetor[0]))) {
						ok = false;
						this.mensagem = "Erro de matrícula duplicada: \"" + vetor[0] + "\" já está cadastrada.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Se tudo estiver nos conformes, cria novo professor
					} else {
						Professor novoProfessor = new Professor(Integer.parseInt(vetor[0]), vetor[1], vetor[2], vetor[3], vetor[4]);
						
						// Tenta inserir o professor no vetor
						if (!vTemp.inserirProfessor(novoProfessor)) {
							ok = false;
							this.mensagem = "Erro durante a inserção do professor no vetor temporário.";
							this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
							break;
						}
					}
				} // Fecha While
			} catch (Exception e) {
				// Se deu algum xabu, mostra o stack de erro
				e.printStackTrace();	
			} finally {
				// Se não deu xabu, fecha o FileReader e o BufferedReader
				lerArq.close();
				arq.close();
			}
		} catch (Exception e2) {
			// Se deu algum xabu, mosgtra o stack de erro
			e2.printStackTrace();
		}
		
		// Se chegou até aqui e ok continua True, então podemos tirar os dados do
		// vetor temporário e passar de volta para o real
		if (ok)	{
			for (int i = 0; i < vTemp.getQtdNoVetor(); i++) {
				if(!vProfessores.inserirProfessor(vTemp.getProfessor(i))) {
					ok = false;
					this.mensagem = "Erro DESCONHECIDO durante o retorno dos dados. Entre em contato com o suporte.";
					this.mensagem += "\nSeus dados podem estar corrompidos. Verifique!";
					break;
				} else {
					this.mensagem = "Nenhum erro encontrado!";
					this.mensagem += "\nA leitura e importação dos dados foi concluída com sucesso!";
				};
			}
		}
		
		// Anula vetor temporário e retorna True ou False
		vTemp = null;
		return ok;
		
	} // Fecha Método lerCSVprofessores
	
	/**
	 * <p><b>gravarCSVprofessores(String arquivo, VetorDeProfessores vProfs)</b></p>
	 * <p>Recebe uma String representando um caminho para um arquivo no sistema de arquivos,
	 * e um vetor de professores de onde os dados serão extraídos para serem gravados no arquivo.</p>
	 * 
	 * @param arquivo (String representando um caminho até um arquivo - existente ou não)
	 * @param vProfs (VetorDeProfessores)
	 * 
	 * @return <b>True</b>, se o arquivo foi gravado corretamente<br /><b>False</b>, se o arquivo não pôde ser gravado
	 */
	public boolean gravarCSVprofessores(String arquivo, VetorDeProfessores vProfs) {
		boolean ok = false;
		try {
			// Instancia objeto do tipo PrintWriter, usanto UTF-8 por padrão
			PrintWriter saida = new PrintWriter(arquivo, "UTF-8");
			
			// Grava linha de cabeçalho e o separador de linha adequado para o SO:
			saida.print("matricula;nome;endereco;data;setor");
			saida.print(System.getProperty("line.separator"));
			
			// Percorre o vetor e salva os dados no arquivo (removendo qualquer ";"
			// que estiver no meio das informações do tipo String), colocando o separador ";"
			// entre os campos e, ao final, o caractere de final de linha adequado para o SO
			for (int i = 0; i < vProfs.getQtdNoVetor(); i++) {
				saida.print(vProfs.getProfessor(i).getMatricula());
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vProfs.getProfessor(i).getNome(), ";"));
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vProfs.getProfessor(i).getEndereco(), ";"));
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vProfs.getProfessor(i).getDataString(), ";"));
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vProfs.getProfessor(i).getSetor(), ";"));
				saida.print(System.getProperty("line.separator"));
			}
			ok = true;
			saida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	/**
	 * <p><b>lerCSValunos(String arquivo, VetorDeAlunos vAlunos)</b></p>
	 * <p>Lê um arquivo CSV contendo dados dos alunos,
	 * conforme a especificação do SisBib. Se ocorrer algum problema durante o processamento
	 * deste método, os dados do arquivo CSV não são retornados ao vetor vAlunos.</p>
	 * 
	 * @param arquivo (String representando o path para um arquivo CSV)
	 * @param vAlunos (Vetor de Alunos que receberá os dados lidos do arquivo CSV)
	 * @return <b>True</b>, se o método foi executado com sucesso<br /><b>False</b>, se o método não foi executado com sucesso
	 */
	public boolean lerCSValunos(String arquivo, VetorDeAlunos vAlunos) throws IOException {
		int    numeroCampos = 6;
		String divisor      = ";";
		String linha        = "";
		boolean ok          = true;
		VetorDeAlunos vTemp = new VetorDeAlunos(vAlunos.getTamanhoDoVetor());

		try {
			// Cria objeto FileReader para "apontar" para o arquivo passado como argumento; e
			// Cria objeto BufferedReader que lê o conteúdo do arquivo apontado pelo FileReader.
			FileReader     arq    = new FileReader(arquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			
			try {
				// Pula a linha de cabeçalho do arquivo
				lerArq.readLine();
				
				// Enquanto ainda existem linhas a serem lidas e não há erros (ok = true):
				while (((linha = lerArq.readLine()) != null) && ok) {
					
					// Pega a próxima linha, divide os campos nos divisores e coloca em vetor
					String[] vetor = linha.split(divisor);
					
					// Valida se o número de campos da linha está nos conformes
					if (vetor.length != numeroCampos) {
						ok = false;
						this.mensagem = "Erro de estrutura do arquivo CSV de alunos (mais ou menos campos do que o especificado para o SisBib).";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a matrícula está nos conformes
					} else if (!this.validacoes.validaMatricula(Integer.parseInt(vetor[0]))) {
						ok = false;
						this.mensagem = "Erro de matrícula: \"" + vetor[0] + "\" está fora dos limites especificados para o SisBib.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a data está nos conformes
					} else if (!this.validacoes.validaData(vetor[4])) {
						ok = false;
						this.mensagem = "Erro de data: \"" + vetor[3] + "\" não é uma data válida.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
					
					// Valida se já existe algum aluno cadastrado com o mesmo número de matrícula
					} else if (vAlunos.matriculaExiste(Integer.parseInt(vetor[0])) ||
							   vTemp.matriculaExiste(Integer.parseInt(vetor[0]))) {
						ok = false;
						this.mensagem = "Erro de matrícula duplicada: \"" + vetor[0] + "\" já está cadastrada.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a multa é menor do que zero
					} else if (!validacoes.checaMulta(Double.parseDouble(vetor[5]))) {
						ok = false;
						this.mensagem = "Erro na multa: \"" + vetor[5] + "\" não é um valor válido.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						
					// Se tudo estiver nos conformes, cria novo professor
					} else {
						Aluno novoAluno = new Aluno(Integer.parseInt(vetor[0]), vetor[1], vetor[2], vetor[3], vetor[4], Double.parseDouble(vetor[5]));
						
						// Tenta inserir o professor no vetor
						if (!vTemp.inserirAluno(novoAluno)) {
							ok = false;
							this.mensagem = "Erro durante a inserção do aluno no vetor temporário.";
							this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
							break;
						}
					}
				} // Fecha While
			} catch (Exception e) {
				// Se deu algum xabu, mostra o stack de erro
				e.printStackTrace();	
			} finally {
				// Se não deu xabu, fecha o FileReader e o BufferedReader
				lerArq.close();
				arq.close();
			}
		} catch (Exception e2) {
			// Se deu algum xabu, mosgtra o stack de erro
			e2.printStackTrace();
		}
		
		// Se chegou até aqui e ok continua True, então podemos tirar os dados do
		// vetor temporário e passar de volta para o real
		if (ok)	{
			for (int i = 0; i < vTemp.getQtdNoVetor(); i++) {
				if(!vAlunos.inserirAluno(vTemp.getAluno(i))) {
					ok = false;
					this.mensagem = "Erro DESCONHECIDO durante o retorno dos dados. Entre em contato com o suporte.";
					this.mensagem += "\nSeus dados podem estar corrompidos. Verifique!";
					break;
				} else {
					this.mensagem = "Nenhum erro encontrado!";
					this.mensagem += "\nA leitura e importação dos dados foi concluída com sucesso!";
				};
			}
		}
		
		// Anula vetor temporário e retorna True ou False
		vTemp = null;
		return ok;
		
	} // Fecha Método lerCSVprofessores
	
	/**
	 * <p><b>gravarCSValunos(String arquivo, VetorDeAlunos vAlunos)</b></p>
	 * <p>Recebe uma String representando um caminho para um arquivo no sistema de arquivos,
	 * e um vetor de alunos de onde os dados serão extraídos para serem gravados no arquivo.</p>
	 * 
	 * @param arquivo (String representando um caminho até um arquivo - existente ou não)
	 * @param vAlunos (VetorDeAlunos)
	 * 
	 * @return <b>True</b>, se o arquivo foi gravado corretamente<br /><b>False</b>, se o arquivo não pôde ser gravado
	 */
	public boolean gravarCSValunos(String arquivo, VetorDeAlunos vAlunos) {
		boolean ok = false;
		try {
			// Instancia objeto do tipo PrintWriter, usanto UTF-8 por padrão
			PrintWriter saida = new PrintWriter(arquivo, "UTF-8");
			
			// Grava linha de cabeçalho e o separador de linha adequado para o SO:
			saida.print("matricula;nome;endereco;curso;data;multa");
			saida.print(System.getProperty("line.separator"));
			
			// Percorre o vetor e salva os dados no arquivo (removendo qualquer ";"
			// que estiver no meio das informações do tipo String), colocando o separador ";"
			// entre os campos e, ao final, o caractere de final de linha adequado para o SO
			for (int i = 0; i < vAlunos.getQtdNoVetor(); i++) {
				saida.print(vAlunos.getAluno(i).getMatricula());
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vAlunos.getAluno(i).getNome(), ";"));
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vAlunos.getAluno(i).getEndereco(), ";"));
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vAlunos.getAluno(i).getCurso(), ";"));
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vAlunos.getAluno(i).getDataString(), ";"));
				saida.print(";");
				saida.print(vAlunos.getAluno(i).getMulta());
				saida.print(System.getProperty("line.separator"));
			}
			ok = true;
			saida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	public boolean lerCSVlivros(String arquivo, VetorDeLivros vLivros) throws IOException {
		int    numeroCampos = 7;
		String divisor      = ";";
		String linha        = "";
		boolean ok          = true;
		VetorDeLivros vTemp = new VetorDeLivros(vLivros.getTamanhoDoVetor());

		try {
			// Cria objeto FileReader para "apontar" para o arquivo passado como argumento; e
			// Cria objeto BufferedReader que lê o conteúdo do arquivo apontado pelo FileReader.
			FileReader     arq    = new FileReader(arquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			
			try {
				// Pula a linha de cabeçalho do arquivo
				lerArq.readLine();
				
				// Enquanto ainda existem linhas a serem lidas e não há erros (ok = true):
				while (((linha = lerArq.readLine()) != null) && ok) {
					
					// Pega a próxima linha, divide os campos nos divisores e coloca em vetor
					String[] vetor = linha.split(divisor);
					
					// Valida se o número de campos da linha está nos conformes
					if (vetor.length != numeroCampos) {
						ok = false;
						this.mensagem = "Erro de estrutura do arquivo CSV de livros (mais ou menos campos do que o especificado para o SisBib).";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a matrícula está nos conformes
					} else if (!this.validacoes.validaCodigo(Integer.parseInt(vetor[0]))) {
						ok = false;
						this.mensagem = "Erro de código: \"" + vetor[0] + "\" está fora dos limites especificados para o SisBib.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a data está nos conformes
					} else if (!this.validacoes.validaAno(Integer.parseInt(vetor[5]))) {
						ok = false;
						this.mensagem = "Erro de ano: \"" + vetor[3] + "\" não é um ano válido.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
					
					// Valida se já existe algum aluno cadastrado com o mesmo número de matrícula
					} else if (vLivros.codigoExiste(Integer.parseInt(vetor[0])) ||
							   vTemp.codigoExiste(Integer.parseInt(vetor[0]))) {
						ok = false;
						this.mensagem = "Erro de matrícula duplicada: \"" + vetor[0] + "\" já está cadastrada.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a multa é menor do que zero
					} else if (!validacoes.validaTipo(vetor[4].charAt(0))) {
						ok = false;
						this.mensagem = "Erro no tipo: \"" + vetor[4] + "\" não é um tipo válido.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Se tudo estiver nos conformes, cria novo professor
					} else {
						Livro novoLivro = new Livro(Integer.parseInt(vetor[0]), vetor[1], vetor[2], vetor[3], vetor[4].charAt(0), Integer.parseInt(vetor[5]), vetor[6]);
						
						// Tenta inserir o professor no vetor
						if (!vTemp.inserirLivro(novoLivro)) {
							ok = false;
							this.mensagem = "Erro durante a inserção do aluno no vetor temporário.";
							this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
							break;
						}
					}
				} // Fecha While
			} catch (Exception e) {
				// Se deu algum xabu, mostra o stack de erro
				e.printStackTrace();	
			} finally {
				// Se não deu xabu, fecha o FileReader e o BufferedReader
				lerArq.close();
				arq.close();
			}
		} catch (Exception e2) {
			// Se deu algum xabu, mosgtra o stack de erro
			e2.printStackTrace();
		}
		
		// Se chegou até aqui e ok continua True, então podemos tirar os dados do
		// vetor temporário e passar de volta para o real
		if (ok)	{
			for (int i = 0; i < vTemp.getQtdNoVetor(); i++) {
				if(!vLivros.inserirLivro(vTemp.getLivro(i))) {
					ok = false;
					this.mensagem = "Erro DESCONHECIDO durante o retorno dos dados. Entre em contato com o suporte.";
					this.mensagem += "\nSeus dados podem estar corrompidos. Verifique!";
					break;
				} else {
					this.mensagem = "Nenhum erro encontrado!";
					this.mensagem += "\nA leitura e importação dos dados foi concluída com sucesso!";
				};
			}
		}
		
		// Anula vetor temporário e retorna True ou False
		vTemp = null;
		return ok;
		
	}
	
	public boolean gravarCSVlivros(String arquivo, VetorDeLivros vLivro) {
		boolean ok = false;
		try {
			// Instancia objeto do tipo PrintWriter, usanto UTF-8 por padrÃ£o
			PrintWriter saida = new PrintWriter(arquivo, "UTF-8");

			// Grava linha de cabeÃ§alho e o separador de linha adequado para o SO:
			saida.print("código;autores;titulo;editora;tipo;ano;isbn");
			saida.print(System.getProperty("line.separator"));

			// Percorre o vetor e salva os dados no arquivo (removendo qualquer ";"
			// que estiver no meio das informaÃ§Ãµes do tipo String), colocando o separador
			// ";"
			// entre os campos e, ao final, o caractere de final de linha adequado para o SO
			for (int i = 0; i < vLivro.getQtdNoVetor(); i++) {
				saida.print(vLivro.getLivro(i).getCodigo());
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vLivro.getLivro(i).getAutores(), ";"));
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vLivro.getLivro(i).getTitulo(), ";"));
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vLivro.getLivro(i).getEditora(), ";"));
				saida.print(";");
				saida.print(vLivro.getLivro(i).getTipo());
				saida.print(";");
				saida.print(vLivro.getLivro(i).getAno());
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vLivro.getLivro(i).getIsbn(), ";"));
				saida.print(System.getProperty("line.separator"));
			}
			ok = true;
			saida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	public boolean lerCSVperiodicos(String arquivo, VetorDePeriodicos vPeriodicos) throws IOException {
		int    numeroCampos = 6;
		String divisor      = ";";
		String linha        = "";
		boolean ok          = true;
		VetorDePeriodicos vTemp = new VetorDePeriodicos(vPeriodicos.getTamanhoDoVetor());

		try {
			// Cria objeto FileReader para "apontar" para o arquivo passado como argumento; e
			// Cria objeto BufferedReader que lê o conteúdo do arquivo apontado pelo FileReader.
			FileReader     arq    = new FileReader(arquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			
			try {
				// Pula a linha de cabeçalho do arquivo
				lerArq.readLine();
				
				// Enquanto ainda existem linhas a serem lidas e não há erros (ok = true):
				while (((linha = lerArq.readLine()) != null) && ok) {
					
					// Pega a próxima linha, divide os campos nos divisores e coloca em vetor
					String[] vetor = linha.split(divisor);
					
					// Valida se o número de campos da linha está nos conformes
					if (vetor.length != numeroCampos) {
						ok = false;
						this.mensagem = "Erro de estrutura do arquivo CSV de periódicos (mais ou menos campos do que o especificado para o SisBib).";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a matrícula está nos conformes
					} else if (!this.validacoes.validaCodigo(Integer.parseInt(vetor[0]))) {
						ok = false;
						this.mensagem = "Erro de código: \"" + vetor[0] + "\" está fora dos limites especificados para o SisBib.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a data está nos conformes
//					} else if (!this.validacoes.validaAno(Integer.parseInt(vetor[5]))) {
//						ok = false;
//						this.mensagem = "Erro de ano: \"" + vetor[3] + "\" não é um ano válido.";
//						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
//						break;
					
					// Valida se já existe algum aluno cadastrado com o mesmo número de matrícula
					} else if (vPeriodicos.codigoExiste(Integer.parseInt(vetor[0])) ||
							   vTemp.codigoExiste(Integer.parseInt(vetor[0]))) {
						ok = false;
						this.mensagem = "Erro de código duplicada: \"" + vetor[0] + "\" já está cadastrada.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a multa é menor do que zero
					} else if (!validacoes.validaTipo(vetor[3].charAt(0))) {
						ok = false;
						this.mensagem = "Erro no tipo: \"" + vetor[3] + "\" não é um tipo válido.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
							
					// Se tudo estiver nos conformes, cria novo professor
					} else {
						Periodico novoPeriodico = new Periodico(Integer.parseInt(vetor[0]), vetor[1], vetor[2], vetor[3].charAt(0), Double.parseDouble(vetor[4]), vetor[5]);
						
						// Tenta inserir o professor no vetor
						if (!vTemp.inserirPeriodico(novoPeriodico)) {
							ok = false;
							this.mensagem = "Erro durante a inserção do aluno no vetor temporário.";
							this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
							break;
						}
					}
				} // Fecha While
			} catch (Exception e) {
				// Se deu algum xabu, mostra o stack de erro
				e.printStackTrace();	
			} finally {
				// Se não deu xabu, fecha o FileReader e o BufferedReader
				lerArq.close();
				arq.close();
			}
		} catch (Exception e2) {
			// Se deu algum xabu, mosgtra o stack de erro
			e2.printStackTrace();
		}
		
		// Se chegou até aqui e ok continua True, então podemos tirar os dados do
		// vetor temporário e passar de volta para o real
		if (ok)	{
			for (int i = 0; i < vTemp.getQtdNoVetor(); i++) {
				if(!vPeriodicos.inserirPeriodico(vTemp.getPeriodico(i))) {
					ok = false;
					this.mensagem = "Erro DESCONHECIDO durante o retorno dos dados. Entre em contato com o suporte.";
					this.mensagem += "\nSeus dados podem estar corrompidos. Verifique!";
					break;
				} else {
					this.mensagem = "Nenhum erro encontrado!";
					this.mensagem += "\nA leitura e importação dos dados foi concluída com sucesso!";
				}
			}
		}
		
		// Anula vetor temporário e retorna True ou False
		vTemp = null;
		return ok;
		
	}
	
	public boolean gravarCSVperiodicos(String arquivo, VetorDePeriodicos vPeriodicos) {
		boolean ok = false;
		try {
			// Instancia objeto do tipo PrintWriter, usanto UTF-8 por padrÃ£o
			PrintWriter saida = new PrintWriter(arquivo, "UTF-8");

			// Grava linha de cabeÃ§alho e o separador de linha adequado para o SO:
			saida.print("código;autores;titulo;tipo;impacto;issn");
			saida.print(System.getProperty("line.separator"));

			// Percorre o vetor e salva os dados no arquivo (removendo qualquer ";"
			// que estiver no meio das informaÃ§Ãµes do tipo String), colocando o separador
			// ";"
			// entre os campos e, ao final, o caractere de final de linha adequado para o SO
			for (int i = 0; i < vPeriodicos.getQtdNoVetor(); i++) {
				saida.print(vPeriodicos.getPeriodico(i).getCodigo());
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vPeriodicos.getPeriodico(i).getAutores(), ";"));
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vPeriodicos.getPeriodico(i).getTitulo(), ";"));
				saida.print(";");
				saida.print(vPeriodicos.getPeriodico(i).getTipo());
				saida.print(";");
				saida.print(vPeriodicos.getPeriodico(i).getImpacto());
				saida.print(";");
				saida.print(validacoes.removeCaractereDeString(vPeriodicos.getPeriodico(i).getISSN(), ";"));
				saida.print(System.getProperty("line.separator"));
			}
			ok = true;
			saida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	public boolean lerCSVemprestimos(String arquivo, VetorDeEmprestimos	 vEmprestimos) throws IOException {
		int    numeroCampos = 5;
		String divisor      = ";";
		String linha        = "";
		boolean ok          = true;
		VetorDeEmprestimos vTemp = new VetorDeEmprestimos(vEmprestimos.getTamanhoDoVetor());

		try {
			// Cria objeto FileReader para "apontar" para o arquivo passado como argumento; e
			// Cria objeto BufferedReader que lÃª o conteÃºdo do arquivo apontado pelo FileReader.
			FileReader     arq    = new FileReader(arquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			
			try {
				// Pula a linha de cabeÃ§alho do arquivo
				lerArq.readLine();
				
				// Enquanto ainda existem linhas a serem lidas e nÃ£o hÃ¡ erros (ok = true):
				while (((linha = lerArq.readLine()) != null) && ok) {
					
					// Pega a prÃ³xima linha, divide os campos nos divisores e coloca em vetor
					String[] vetor = linha.split(divisor);
					
					// Valida se o nÃºmero de campos da linha estÃ¡ nos conformes
					if (vetor.length != numeroCampos) {
						ok = false;
						this.mensagem = "Erro de estrutura do arquivo CSV de emprestimos (mais ou menos campos do que o especificado para o SisBib).";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a matrÃ­cula estÃ¡ nos conformes
					} else if (!this.validacoes.validaCodigo(Integer.parseInt(vetor[0]))) {
						ok = false;
						this.mensagem = "Erro de código: \"" + vetor[0] + "\" está fora dos limites especificados para o SisBib.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a data estÃ¡ nos conformes
					} else if (!this.validacoes.validaCodigo(Integer.parseInt(vetor[1]))) {
						ok = false;
						this.mensagem = "Erro de código: \"" + vetor[1] + "\" está fora dos limites especificados para o SisBib.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
					
					// Valida se jÃ¡ existe algum aluno cadastrado com o mesmo nÃºmero de matrÃ­cula
					} else if (!this.validacoes.validaCodigo(Integer.parseInt(vetor[2]))) {
						ok = false;
						this.mensagem = "Erro de código: \"" + vetor[2] + "\" está fora dos limites especificados para o SisBib.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a multa Ã© menor do que zero
					} else if(!validacoes.validaData(vetor[3])){
						ok = false;
						this.mensagem = "Erro na data: \"" + vetor[3] + "\" não é uma data válida.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					} else if(!validacoes.validaData(vetor[4])){
						ok = false;
						this.mensagem = "Erro na data: \"" + vetor[4] + "\" não é uma data válida.";
						this.mensagem += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					} else {
					
						Emprestimo novoEmprestimo = new Emprestimo(Integer.parseInt(vetor[0]), Integer.parseInt(vetor[1]), Integer.parseInt(vetor[2]), vetor[3], vetor[4]);
						
						// Tenta inserir o professor no vetor
						if (!vTemp.inserirEmprestimo(novoEmprestimo)) {
							ok = false;
							this.mensagem = "Erro durante a inserÃ§Ã£o do item no vetor temporÃ¡rio.";
							this.mensagem += "\nA leitura e importaÃ§Ã£o dos dados NÃƒO FOI realizada.";
							break;
						}
					}
				}
				
			} catch (Exception e) {
				// Se deu algum xabu, mostra o stack de erro
				e.printStackTrace();	
			} finally {
				// Se nÃ£o deu xabu, fecha o FileReader e o BufferedReader
				lerArq.close();
				arq.close();
			}
		} catch (Exception e2) {
			// Se deu algum xabu, mosgtra o stack de erro
			e2.printStackTrace();
		}
		
		// Se chegou atÃ© aqui e ok continua True, entÃ£o podemos tirar os dados do
		// vetor temporÃ¡rio e passar de volta para o real
		if (ok)	{
			for (int i = 0; i < vTemp.getQtdNoVetor(); i++) {
				if(!vEmprestimos.inserirEmprestimo(vTemp.getEmprestimo(i))) {
					ok = false;
					this.mensagem = "Erro DESCONHECIDO durante o retorno dos dados. Entre em contato com o suporte.";
					this.mensagem += "\nSeus dados podem estar corrompidos. Verifique!";
					break;
				} else {
					this.mensagem = "Nenhum erro encontrado!";
					this.mensagem += "\nA leitura e importaÃ§Ã£o dos dados foi concluÃ­da com sucesso!";
				};
			}
		}
		
		// Anula vetor temporÃ¡rio e retorna True ou False
		vTemp = null;
		return ok;
		
	}
	public boolean gravarCSVemprestimos(String arquivo, VetorDeEmprestimos vEmprestimo) {
		boolean ok = false;
		try {
			// Instancia objeto do tipo PrintWriter, usanto UTF-8 por padrÃƒÂ£o
			PrintWriter saida = new PrintWriter(arquivo, "UTF-8");

			// Grava linha de cabeÃƒÂ§alho e o separador de linha adequado para o SO:
			saida.print("CodigoItem;MatriculaCliente;MatriculaFuncionario;DataEmprestimo;DataDevolução");
			saida.print(System.getProperty("line.separator"));

			// Percorre o vetor e salva os dados no arquivo (removendo qualquer ";"
			// que estiver no meio das informaÃƒÂ§ÃƒÂµes do tipo String), colocando o separador
			// ";"
			// entre os campos e, ao final, o caractere de final de linha adequado para o SO
			for (int i = 0; i < vEmprestimo.getQtdNoVetor(); i++) {
				saida.print(vEmprestimo.getEmprestimo(i).getCodigo());
				saida.print(";");
				saida.print(vEmprestimo.getEmprestimo(i).getMatriculaCliente());
				saida.print(";");
				saida.print(vEmprestimo.getEmprestimo(i).getMatriculaFuncionario());
				saida.print(";");
				saida.print(vEmprestimo.getEmprestimo(i).getDataEmprestimoString());
				saida.print(";");
				saida.print(vEmprestimo.getEmprestimo(i).getDataDevolucao());
				saida.print(System.getProperty("line.separator"));
			}
			ok = true;
			saida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	
	public boolean lerCSVitensDeEmprestimos(String arquivo, VetorDeItensDeEmprestimo vItens) throws IOException {
		int    numeroCampos = 5;
		String divisor      = ";";
		String linha        = "";
		boolean ok          = true;
		VetorDeItensDeEmprestimo vTemp = new VetorDeItensDeEmprestimo(vItens.getTamanhoDoVetor());

		try {
			// Cria objeto FileReader para "apontar" para o arquivo passado como argumento; e
			// Cria objeto BufferedReader que lÃª o conteÃºdo do arquivo apontado pelo FileReader.
			FileReader     arq    = new FileReader(arquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			
			try {
				// Pula a linha de cabeÃ§alho do arquivo
				lerArq.readLine();
				
				// Enquanto ainda existem linhas a serem lidas e nÃ£o hÃ¡ erros (ok = true):
				while (((linha = lerArq.readLine()) != null) && ok) {
					
					// Pega a prÃ³xima linha, divide os campos nos divisores e coloca em vetor
					String[] vetor = linha.split(divisor);
					
					// Valida se o nÃºmero de campos da linha estÃ¡ nos conformes
					if (vetor.length != numeroCampos) {
						ok = false;
						this.mensagem = "Erro de estrutura do arquivo CSV de Itens de emprestimos (mais ou menos campos do que o especificado para o SisBib).";
						this.mensagem += "\nA leitura e importaÃ§Ã£o dos dados NÃƒO FOI realizada.";
						break;
						
					// Valida se a matrÃ­cula estÃ¡ nos conformes
					} else if (!this.validacoes.validaCodigo(Integer.parseInt(vetor[0]))) {
						ok = false;
						this.mensagem = "Erro de cÃ³digo: \"" + vetor[0] + "\" estÃ¡ fora dos limites especificados para o SisBib.";
						this.mensagem += "\nA leitura e importaÃ§Ã£o dos dados NÃƒO FOI realizada.";
						break;
						
					// Valida se a data estÃ¡ nos conformes
					} else if (!this.validacoes.validaCodigo(Integer.parseInt(vetor[1]))) {
						ok = false;
						this.mensagem = "Erro de código: \"" + vetor[1] + "\" nÃ£o Ã© um ano vÃ¡lido.";
						this.mensagem += "\nA leitura e importaÃ§Ã£o dos dados NÃƒO FOI realizada.";
						break;
					
					// Valida se jÃ¡ existe algum aluno cadastrado com o mesmo nÃºmero de matrÃ­cula
					} else if (!this.validacoes.validaCodigo(Integer.parseInt(vetor[2]))) {
						ok = false;
						this.mensagem = "Erro de matrÃ­cula duplicada: \"" + vetor[2] + "\" jÃ¡ estÃ¡ cadastrada.";
						this.mensagem += "\nA leitura e importaÃ§Ã£o dos dados NÃƒO FOI realizada.";
						break;
						
					// Valida se a multa Ã© menor do que zero
					} else if (!validacoes.validaCodigo(Integer.parseInt(vetor[3]))) {
						ok = false;
						this.mensagem = "Erro no tipo: \"" + vetor[3] + "\" nÃ£o Ã© um tipo vÃ¡lido.";
						this.mensagem += "\nA leitura e importaÃ§Ã£o dos dados NÃƒO FOI realizada.";
						break;
						
					// Se tudo estiver nos conformes, cria novo professor
					} else if(!validacoes.validaData(vetor[4])){
						ok = false;
						this.mensagem = "Erro no tipo: \"" + vetor[3] + "\" nÃ£o Ã© um tipo vÃ¡lido.";
						this.mensagem += "\nA leitura e importaÃ§Ã£o dos dados NÃƒO FOI realizada.";
						break;
						
					} else {
					
						ItemDeEmprestimo novoItem = new ItemDeEmprestimo(Integer.parseInt(vetor[0]), Integer.parseInt(vetor[1]), Integer.parseInt(vetor[2]), Integer.parseInt(vetor[3]), vetor[4]);
						
						// Tenta inserir o professor no vetor
						if (!vTemp.inserirItemDeEmprestimo(novoItem)) {
							ok = false;
							this.mensagem = "Erro durante a inserÃ§Ã£o do item no vetor temporÃ¡rio.";
							this.mensagem += "\nA leitura e importaÃ§Ã£o dos dados NÃƒO FOI realizada.";
							break;
						}
					}
				}
			} catch (Exception e) {
				// Se deu algum xabu, mostra o stack de erro
				e.printStackTrace();	
			} finally {
				// Se nÃ£o deu xabu, fecha o FileReader e o BufferedReader
				lerArq.close();
				arq.close();
			}
		} catch (Exception e2) {
			// Se deu algum xabu, mosgtra o stack de erro
			e2.printStackTrace();
		}
		
		// Se chegou atÃ© aqui e ok continua True, entÃ£o podemos tirar os dados do
		// vetor temporÃ¡rio e passar de volta para o real
		if (ok)	{
			for (int i = 0; i < vTemp.getQtdNoVetor(); i++) {
				if(!vItens.inserirItemDeEmprestimo(vTemp.getItemDeEmprestimo(i))) {
					ok = false;
					this.mensagem = "Erro DESCONHECIDO durante o retorno dos dados. Entre em contato com o suporte.";
					this.mensagem += "\nSeus dados podem estar corrompidos. Verifique!";
					break;
				} else {
					this.mensagem = "Nenhum erro encontrado!";
					this.mensagem += "\nA leitura e importaÃ§Ã£o dos dados foi concluÃ­da com sucesso!";
				};
			}
		}
		
		// Anula vetor temporÃ¡rio e retorna True ou False
		vTemp = null;
		return ok;
		
	}
	public boolean gravarCSVitensDeEmprestimos(String arquivo, VetorDeItensDeEmprestimo vItens) {
		boolean ok = false;
		try {
			// Instancia objeto do tipo PrintWriter, usanto UTF-8 por padrÃƒÂ£o
			PrintWriter saida = new PrintWriter(arquivo, "UTF-8");

			// Grava linha de cabeÃƒÂ§alho e o separador de linha adequado para o SO:
			saida.print("CodigoItem;CodigoEmprestimo;CodigoLivro;CodigoPeriodico;DataDevolução");
			saida.print(System.getProperty("line.separator"));

			// Percorre o vetor e salva os dados no arquivo (removendo qualquer ";"
			// que estiver no meio das informaÃƒÂ§ÃƒÂµes do tipo String), colocando o separador
			// ";"
			// entre os campos e, ao final, o caractere de final de linha adequado para o SO
			for (int i = 0; i < vItens.getQtdNoVetor(); i++) {
				saida.print(vItens.getItemDeEmprestimo(i).getCodigoItem());
				saida.print(";");
				saida.print(vItens.getItemDeEmprestimo(i).getCodigoEmprestimo());
				saida.print(";");
				saida.print(vItens.getItemDeEmprestimo(i).getCodigoLivro());
				saida.print(";");
				saida.print(vItens.getItemDeEmprestimo(i).getCodigoPeriodico());
				saida.print(";");
				saida.print(vItens.getItemDeEmprestimo(i).getDataDevolucao());
				saida.print(System.getProperty("line.separator"));
			}
			ok = true;
			saida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	
	public String getMensagem() {
		return this.mensagem;
	}
	
} // Fecha Classe CSV
