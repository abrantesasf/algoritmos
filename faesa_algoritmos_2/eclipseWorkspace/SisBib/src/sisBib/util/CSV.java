package sisBib.util;

//Importação de bibliotecas:
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import sisBib.principal.Professor;
import sisBib.principal.Usuario;
import sisBib.principal.VetorDeProfessores;
import sisBib.principal.VetorDeUsuarios;

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
	
	private String mensagemDeErro = "";
	
	/**
	 * <p><b>novoUsuario</b>:</p>
	 * <ul>
	 * <li>Variável temporária para a criação de um novo usuário.</li>
	 * <li>Tipo: Usuário</li>
	 * </ul>
	 */
	private Usuario novoUsuario;
	
	private VetorDeUsuarios vetor = new VetorDeUsuarios(100);
	private boolean ok = false;
	
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
	
	
	public boolean lerCSVprofessores(String arquivo, VetorDeProfessores vProfs) throws IOException {
		int    numeroCampos = 5;
		String divisor      = ";";
		String linha        = "";
		boolean ok          = true;
		VetorDeProfessores vTemp = new VetorDeProfessores(vProfs.getTamanhoDoVetor());

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
						this.mensagemDeErro = "Erro de estrutura do arquivo CSV de professores (mais ou menos campos do que o especificado para o SisBib).";
						this.mensagemDeErro += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a matrícula está nos conformes
					} else if (!this.validacoes.validaMatricula(Integer.parseInt(vetor[0]))) {
						ok = false;
						this.mensagemDeErro = "Erro de matrícula: \"" + vetor[0] + "\" está fora dos limites especificados para o SisBib.";
						this.mensagemDeErro += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Valida se a data está nos conformes
					} else if (!this.validacoes.validaData(vetor[3])) {
						ok = false;
						this.mensagemDeErro = "Erro de data: \"" + vetor[3] + "\" não é uma data válida.";
						this.mensagemDeErro += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
					
					// Valida se já existe algum professor cadastrado com o mesmo número de matrícula
					} else if (vProfs.matriculaExiste(Integer.parseInt(vetor[0])) ||
							   vTemp.matriculaExiste(Integer.parseInt(vetor[0]))) {
						ok = false;
						this.mensagemDeErro = "Erro de matrícula duplicada: \"" + vetor[0] + "\" já está cadastrada.";
						this.mensagemDeErro += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
						
					// Se tudo estiver nos conformes, cria novo professor
					} else {
						Professor novoProfessor = new Professor(Integer.parseInt(vetor[0]), vetor[1], vetor[2], vetor[3], vetor[4]);
						
						// Tenta inserir o professor no vetor
						if (!vTemp.inserirProfessor(novoProfessor)) {
							ok = false;
							this.mensagemDeErro = "Erro durante a inserção do professor no vetor temporário.";
							this.mensagemDeErro += "\nA leitura e importação dos dados NÃO FOI realizada.";
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
				if(!vProfs.inserirProfessor(vTemp.getProfessor(i))) {
					ok = false;
					this.mensagemDeErro = "Erro DESCONHECIDO durante o retorno dos dados. Entre em contato com o suporte.";
					this.mensagemDeErro += "\nSeus dados podem estar corrompidos. Verifique!";
					break;
				} else {
					this.mensagemDeErro = "Nenhum erro encontrado!";
					this.mensagemDeErro += "\nA leitura e importação dos dados foi concluída com sucesso!";
				};
			}
		}
		
		// Anula vetor temporário e retorna True ou False
		vTemp = null;
		return ok;
		
	} // Fecha Método lerCSVprofessores
	
	public String getMensagem() {
		return this.mensagemDeErro;
	}
	
} // Fecha Classe CSV
