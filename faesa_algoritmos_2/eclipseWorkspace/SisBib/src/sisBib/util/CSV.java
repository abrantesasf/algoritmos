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
 * <p>A classe CSV contém os métodos para realizar importação e a exportação dos dados
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
	private int matricula;
	private String nome;
	private String endereco;
	private String data;
	
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
	
	
	public String lerFuncionariosCSV2(String arquivo, char tipo, VetorDeProfessores profs) throws IOException {
		String resposta = "ok";
		String divisor = ";";
		String linha;

		try {
			FileReader arq = new FileReader(arquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			
			try {
				lerArq.readLine();
				while ((linha = lerArq.readLine()) != null) {
					String[] vetor = linha.split(divisor);
					switch (tipo) {
					case 'p':
						if (vetor.length != 5) {
							System.out.println("ERRO! Arquivo fora do padrão especificado.");
							System.out.println("ERRO! A leitura será encerrada!");
							return resposta;
						}
						break;
					default:
						System.out.println("ERRO! O tipo informado de arquivo não existe!");
						System.out.println("ERRO! A leitura será encerrada!");
						return resposta;
					}
					
					Professor novoProfessor = new Professor(Integer.parseInt(vetor[0]), vetor[1], vetor[2], vetor[3], vetor[4]);
					if (!profs.inserirProfessor(novoProfessor)) {
						System.out.println("ERRO!!!!!!!!!!!!!!!");
					} else {
						System.out.println("professor inserido no vetor");
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lerArq.close();
				arq.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ocorreu um erro na leitura");
		}
		
		
		return resposta;
	}
	
} // Fecha Classe CSV
