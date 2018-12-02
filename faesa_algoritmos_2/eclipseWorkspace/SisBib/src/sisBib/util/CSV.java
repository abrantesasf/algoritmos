package sisBib.util;

//Importação de bibliotecas:
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.BufferedReader;
import java.util.Scanner;

import sisBib.principal.Aluno;
import sisBib.principal.Professor;
import sisBib.principal.VetorDeAlunos;
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
	
	/**
	 * <p><b>scan</b>:</p>
	 * <ul>
	 * <li>Utilizado para escanear os dados de um arquivo, linha a linha</li>
	 * <li>Tipo: Scanner</li>
	 * </ul>
	 */
	private Scanner scan;
	
	/**
	 * <p><b>scanDados</b>:</p>
	 * <ul>
	 * <li>Após o Scanner "scan" ler um arquivo CSV linha a linha, este Scanner
	 * "scanDados" é configurado para utilizar um determinado delimitador (padrão é ;)
	 * e receber cada linha do Scanner "scan", e processar cada linha de acordo com
	 * os campos estabelecidos na documentação do SisBib.</li>
	 * <li>Tipo: Scanner</li>
	 * </ul>
	 */
	private Scanner scanDados;
	
	/**
	 * <p><b>indice</b>:</p>
	 * <ul>
	 * <li>Inteiro que faz a contagem de em qual campo o scanDados está.</li>
	 * <li>Tipo: int</li>
	 * </ul>
	 */
	private int indice ;
	
	/**
	 * <p><b>matricula, nome, endereco, data</b>:</p>
	 * <ul>
	 * <li>Variáveis temporárias para a obtenção dos dados do arquivo CSV.</li>
	 * <li>Tipo: int (matricula); String (nome, endereco, data)</li>
	 * </ul>
	 */
	private int    matricula;
	private String nome;
	private String endereco;
	private String data;
	
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
	
	/**
	 * <p><b>lerCSVfuncionarios(String arquivo)</b></p>
	 * <p>Lê um arquivo CSV contendo dados dos funcionários,
	 * conforme a especificação do SisBib.</p>
	 * 
	 * @param arquivo (String representando o path para um arquivo CSV)
	 */
	public void lerCSVfuncionarios(String arquivo) throws IOException {
		// Scanner que lê as linhas do arquivo:
		scan = new Scanner(new File(arquivo));
		
		// Scanner que, a cada linha, lê os campos separados pelo delimitador
		scanDados = null;
		
		// Inicia a numeração dos campos com 0
		indice = 0;
		
		// Força o Scanner do arquivo a pular a primeira linha, que só contém
		// a especificação dos campos:
		scan.nextLine();
		
		// A cada linha do arquivo (a partir da segunda):
		while (scan.hasNextLine()) {
			// Lê a linha inteira e configura o delimitador padrão
			scanDados = new Scanner(scan.nextLine());
			scanDados.useDelimiter(";");
			
			// A cada campo da linha, separado pelo delimitador padrão:
			while (scanDados.hasNext()) {
				String dados = scanDados.next();
				if (indice == 0) {
					matricula = Integer.parseInt(dados);
					System.out.println("Matrícula: " + matricula);
				} else if (indice == 1) {
					nome = dados;
					System.out.println("Nome: " + nome);
				} else if (indice == 2) {
					endereco = dados;
					System.out.println("Endereço: " + endereco);
				} else if (indice == 3) {
					data = dados;
					System.out.println("Data: " + data);
				} else {
					// Ôpa, tem mais colunas do que a especificação!
					System.out.println("ERRO!!!!!!!!!!");
				}
				// Incrementa o contador de campos:
				indice++;
			}
			
			// Zera o contador de campos para a próxima linha:
			indice = 0;
		}
		
		// Fecha os Scanners abertos:
		scanDados.close();
		scan.close();
		
	} // Fecha o método lerCSVfuncionarios
	
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
	
	public String getMensagem() {
		return this.mensagem;
	}
	
} // Fecha Classe CSV
