package SistemaDeBiblioteca;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class Arquivo { // manipulação de arquivos
	public boolean PreencheAluno(String caminho, int matricula, String nome, String endereco, String curso,
			String dataString, double multa) { // preencher planilha de alunos
		if (multa >= 0.0) {
			if (ValidaCod(matricula)) {
				System.out.println("matricula inválida");
				return false;
			}
			if (!(nome.equals("") || endereco.equals("") || dataString.equals(""))) {
				try {
					FileWriter arq = new FileWriter(caminho, true);
					PrintWriter gravarArq = new PrintWriter(arq);
					if (Valida(caminho) && Valida(nome) && Valida(endereco) && Valida(dataString)
							&& Valida(matricula)) {
						gravarArq.println(matricula + ";" + nome + ";" + endereco + ";" + curso + ";" + dataString + ";"
								+ multa + ";");
					} else {
						System.out.println("Preenchimento inválido");
					}
					gravarArq.close();
					return true;
				} catch (IOException e) {
					System.out.println("Falha ao escrever no arquivo");
					return false;
				}
			} else {
				System.out.println("Campo ou caminho especificado não preenchido ou não localizado");
				return false;
			}
		}
		System.out.println("Valor da multa inválido");
		return false;

	}

	public boolean PreencheProfessor(String caminho, int matricula, String nome, String endereco, String dataString,
			String setor) { // preencher planilha de Professores
		if (!(nome.equals("") || endereco.equals("") || dataString.equals(""))) {
			if (ValidaCod(matricula)) {
				System.out.println("matricula inválida");
				return false;
			}
			try {
				FileWriter arq = new FileWriter(caminho, true);
				PrintWriter gravarArq = new PrintWriter(arq);
				if (Valida(caminho) && Valida(nome) && Valida(dataString) && Valida(endereco) && Valida(setor)) {
					gravarArq.println(matricula + ";" + nome + ";" + setor + ";" + endereco + ";" + dataString + ";");
				}
				gravarArq.close();
				return true;
			} catch (IOException e) {
				System.out.println("Falha ao escrever no arquivo");
				return false;
			}
		} else {
			System.out.println("Campo ou caminho especificado não preenchido ou não localizado");
			return false;
		}

	}

	public boolean PreencheFuncionario(String caminho, int matricula, String nome, String endereco, String dataString,
			String setor, String senha, String login) { // preencher planilha de Funcionario
		if (!(nome.equals("") || endereco.equals("") || dataString.equals(""))) {
			if (ValidaCod(matricula)) {
				System.out.println("matricula inválida");
				return false;
			}
			try {
				FileWriter arq = new FileWriter(caminho, true);
				PrintWriter gravarArq = new PrintWriter(arq);
				if (Valida(caminho) && Valida(matricula) && Valida(nome) && Valida(dataString) && Valida(endereco)
						&& Valida(setor) && Valida(senha) && Valida(login)) {
					gravarArq.println(matricula + ";" + nome + ";" + setor + ";" + endereco + ";" + dataString + ";"
							+ senha + ";" + login + ";");
				}
				gravarArq.close();
				return true;
			} catch (IOException e) {
				System.out.println("Falha ao escrever no arquivo");
				return false;
			}
		} else {
			System.out.println("Campo ou caminho especificado não preenchido ou não localizado");
			return false;
		}

	}

	public boolean PreencheLivro(String caminho, int codigo, String autor, String titulo, String editora, String tipo,
			int anoDePublic, int isnn) { // preencher planilha de livros
		if (!(autor.equals("") || titulo.equals("") || editora.equals("") || tipo.equals(""))) {
			if (ValidaCod(codigo)) {
				System.out.println("matricula inválida");
				return false;
			}
			try {
				FileWriter arq = new FileWriter(caminho, true);
				PrintWriter gravarArq = new PrintWriter(arq);
				if (Valida(caminho) && Valida(codigo) && Valida(autor) && Valida(titulo) && Valida(editora)
						&& Valida(tipo) && Valida(anoDePublic) && Valida(isnn)) {
					gravarArq.println(codigo + ";" + autor + ";" + titulo + ";" + editora + ";" + tipo + ";"
							+ anoDePublic + ";" + isnn + ";");
				}
				gravarArq.close();
				return true;
			} catch (IOException e) {
				System.out.println("Falha ao escrever no arquivo");
				return false;
			}
		} else {
			System.out.println("Campo ou caminho especificado não preenchido ou não localizado");
			return false;
		}

	}

	public boolean PreenchePeriodico(String caminho, String codigo, String autor, String titulo, String tipo,
			String impacto, String isnn) { // preencher planilha de periódicos
		if (!(codigo.equals("") || autor.equals("") || titulo.equals("") || tipo.equals("") || impacto.equals("")
				|| isnn.equals(""))) {
			try {
				FileWriter arq = new FileWriter(caminho, true);
				PrintWriter gravarArq = new PrintWriter(arq);
				if (Valida(caminho) && Valida(codigo) && Valida(autor) && Valida(titulo) && Valida(tipo)
						&& Valida(impacto) && Valida(isnn)) {
					gravarArq.println(
							codigo + ";" + autor + ";" + titulo + ";" + tipo + ";" + impacto + ";" + isnn + ";");
				}
				gravarArq.close();
				return true;
			} catch (IOException e) {
				System.out.println("Falha ao escrever no arquivo");
				return false;
			}
		} else {
			System.out.println("Campo ou caminho especificado não preenchido ou não localizado");
			return false;
		}

	}

	public boolean PreencheEmprestimo(String caminho, String codigo, String matriculaCliente, String matriculaFunc,
			String dataEmprestimo, String dataDevolucao) { // preencher planilha de empréstimos
		if (!(codigo.equals("") || matriculaCliente.equals("") || matriculaFunc.equals("") || dataEmprestimo.equals("")
				|| dataDevolucao.equals(""))) {
			try {
				FileWriter arq = new FileWriter(caminho, true);
				PrintWriter gravarArq = new PrintWriter(arq);
				if (Valida(caminho) && Valida(codigo) && Valida(matriculaCliente) && Valida(matriculaFunc)
						&& Valida(dataEmprestimo) && Valida(dataDevolucao)) {
					gravarArq.println(codigo + ";" + matriculaCliente + ";" + matriculaFunc + ";" + dataEmprestimo + ";"
							+ dataDevolucao + ";");
				}
				gravarArq.close();
				return true;
			} catch (IOException e) {
				System.out.println("Falha ao escrever no arquivo");
				return false;
			}
		} else {
			System.out.println("Campo ou caminho especificado não preenchido ou não localizado");
			return false;
		}

	}

	public boolean PreencheItens(String caminho, String codigoItem, String codigoEmprestimo, String CodigoLivro,
			String codigoDevolucao) { // preencher planilha de itens
		if (!(codigoItem.equals("") || codigoEmprestimo.equals("") || CodigoLivro.equals("")
				|| codigoDevolucao.equals(""))) {
			try {
				FileWriter arq = new FileWriter(caminho, true);
				PrintWriter gravarArq = new PrintWriter(arq);
				if (Valida(caminho) && Valida(codigoItem) && Valida(codigoEmprestimo) && Valida(CodigoLivro)
						&& Valida(codigoDevolucao)) {
					gravarArq.println(
							codigoItem + ";" + codigoEmprestimo + ";" + CodigoLivro + ";" + codigoDevolucao + ";");
				}
				gravarArq.close();
				return true;
			} catch (IOException e) {
				System.out.println("Falha ao escrever no arquivo");
				return false;
			}
		} else {
			System.out.println("Campo ou caminho especificado não preenchido ou não localizado");
			return false;
		}

	}

	public static boolean Valida(String campo) { // valida se tem ponto e vírgula no que foi digitado pro arquivo
		int cont = 0;
		char[] testa = campo.toCharArray();
		for (int i = 0; i < testa.length; i++) {
			if (testa[i] == ';') {
				break;
			} else {
				cont++;
			}
		}
		if (cont == testa.length) {
			return true;
		}
		System.out.println("Digitação inválida");
		return false;

	}

	public boolean Valida(int campo) { // válida se é campo vázio
		int cont = 0;
		String mat = Integer.toString(campo);
		char[] testa = mat.toCharArray();
		for (int i = 0; i < testa.length; i++) {
			if (testa[i] == ';') {
				break;
			} else {
				cont++;
			}
		}
		if (cont == testa.length) {
			return true;
		}
		System.out.println("Digitação inválida");
		return false;
	}

	public boolean ValidaCod(int campo) { // válida se é campo vázio
		if (campo <= 10000000 || campo >= 99999999) {

			System.out.println("Valor inválido");
			return true;
		} else {

			return false;
		}

	}

	public static String LeitorAluno(String ArquivoCSV, Aluno[] vetAluno) { // leitor de planilha aluno
		int qtd = 0;
		String divisor = ";";
		int cont = 0;
		int convertInt = 0;
		double convertDouble = 0;
		String linha;
		try {
			try {
				FileReader arq = new FileReader(ArquivoCSV);
				LineNumberReader lineCounter = new LineNumberReader(arq);
				while ((lineCounter.readLine()) != null) { // conta as linhas dentro do arquivo
					qtd++;
				}
			} catch (Exception done) {
				done.printStackTrace();
			}
			FileReader arq = new FileReader(ArquivoCSV);
			BufferedReader lerArq = new BufferedReader(arq);
			vetAluno = new Aluno[qtd]; // instância o vetor com o número de linhas do arquivo
			try {
				while ((linha = lerArq.readLine()) != null) {
					String[] vetorCSV = linha.split(divisor);
					if (vetorCSV.length == 6) {
						ValidaValores(vetorCSV);
						convertInt = Integer.parseInt(vetorCSV[0]);
						vetAluno[cont].setMatricula(convertInt);
						vetAluno[cont].setNome(vetorCSV[1]);
						vetAluno[cont].setEndereco(vetorCSV[2]);
						vetAluno[cont].setCurso(vetorCSV[3]);
						vetAluno[cont].setDataString(vetorCSV[4]);
						convertDouble = Double.parseDouble(vetorCSV[5]);
						vetAluno[cont].setMulta(convertDouble);
						cont++;
					}
				}
				arq.close();
				return "";
			} catch (IOException ex) {
				System.out.println("Ocorreu um erro na leitura");
				return "";
			}

		} catch (FileNotFoundException e) {
			System.out.println("Ocorreu um erro na leitura");
			return "";
		}

	}

	public static String LeitorProf(String ArquivoCSV, Professor[] vetProf) { // leitor de planilha aluno
		int qtd = 0;
		String divisor = ";";
		int cont = 0;
		int convertInt = 0;
		String linha;
		try {
			try {
				FileReader arq = new FileReader(ArquivoCSV);
				LineNumberReader lineCounter = new LineNumberReader(arq);
				while ((lineCounter.readLine()) != null) { // conta as linhas dentro do arquivo
					qtd++;
				}
			} catch (Exception done) {
				done.printStackTrace();
			}
			FileReader arq = new FileReader(ArquivoCSV);
			BufferedReader lerArq = new BufferedReader(arq);
			vetProf = new Professor[qtd]; // instância o vetor com o número de linhas do arquivo
			try {
				while ((linha = lerArq.readLine()) != null) {
					String[] vetorCSV = linha.split(divisor);
					if (vetorCSV.length == 5) {
						ValidaValores(vetorCSV);
						convertInt = Integer.parseInt(vetorCSV[0]);
						vetProf[cont].setMatricula(convertInt);
						vetProf[cont].setNome(vetorCSV[1]);
						vetProf[cont].setEndereco(vetorCSV[2]);
						vetProf[cont].setDataString(vetorCSV[3]);
						vetProf[cont].setSetor(vetorCSV[4]);
						cont++;
					}
				}
				arq.close();
				return "";
			} catch (IOException ex) {
				System.out.println("Ocorreu um erro na leitura");
				return "";
			}

		} catch (FileNotFoundException e) {
			System.out.println("Ocorreu um erro na leitura");
			return "";
		}

	}

	public static String LeitorFunc(String ArquivoCSV, Funcionario[] vetFunc) { // leitor de planilha aluno
		int qtd = 0;
		String divisor = ";";
		int cont = 0;
		int convertInt = 0;
		String linha;
		try {
			try {
				FileReader arq = new FileReader(ArquivoCSV);
				LineNumberReader lineCounter = new LineNumberReader(arq);
				while ((lineCounter.readLine()) != null) { // conta as linhas dentro do arquivo
					qtd++;
				}
			} catch (Exception done) {
				done.printStackTrace();
			}
			FileReader arq = new FileReader(ArquivoCSV);
			BufferedReader lerArq = new BufferedReader(arq);
			vetFunc = new Funcionario[qtd]; // instância o vetor com o número de linhas do arquivo
			try {
				while ((linha = lerArq.readLine()) != null) {
					String[] vetorCSV = linha.split(divisor);
					if (vetorCSV.length == 7) {
						ValidaValores(vetorCSV);
						convertInt = Integer.parseInt(vetorCSV[0]);
						vetFunc[cont].setMatricula(convertInt);
						vetFunc[cont].setNome(vetorCSV[1]);
						vetFunc[cont].setEndereco(vetorCSV[2]);
						vetFunc[cont].setDataString(vetorCSV[3]);
						vetFunc[cont].setSetor(vetorCSV[4]);
						vetFunc[cont].setSenha(vetorCSV[5]);
						vetFunc[cont].setLogin(vetorCSV[6]);
						cont++;
					}
				}
				arq.close();
				return "";
			} catch (IOException ex) {
				System.out.println("Ocorreu um erro na leitura");
				return "";
			}

		} catch (FileNotFoundException e) {
			System.out.println("Ocorreu um erro na leitura");
			return "";
		}

	}

	public static String Leitorlivro(String ArquivoCSV, Livros[] vetLivro) { // leitor de planilha aluno
		int qtd = 0;
		String divisor = ";";
		int cont = 0;
		int convertInt = 0;
		String linha;
		try {
			try {
				FileReader arq = new FileReader(ArquivoCSV);
				LineNumberReader lineCounter = new LineNumberReader(arq);
				while ((lineCounter.readLine()) != null) { // conta as linhas dentro do arquivo
					qtd++;
				}
			} catch (Exception done) {
				done.printStackTrace();
			}
			FileReader arq = new FileReader(ArquivoCSV);
			BufferedReader lerArq = new BufferedReader(arq);
			vetLivro = new Livros[qtd]; // instância o vetor com o número de linhas do arquivo
			try {
				while ((linha = lerArq.readLine()) != null) {
					String[] vetorCSV = linha.split(divisor);
					if (vetorCSV.length == 7) {
						ValidaValores(vetorCSV);
						convertInt = Integer.parseInt(vetorCSV[0]);
						vetLivro[cont].setCodigo(convertInt);
						vetLivro[cont].setAutor(vetorCSV[1]);
						vetLivro[cont].setTitulo(vetorCSV[2]);
						vetLivro[cont].setEditora(vetorCSV[3]);
						vetLivro[cont].setTipo(vetorCSV[4]);
						vetLivro[cont].setPublicacao(vetorCSV[5]);
						vetLivro[cont].setIssn(vetorCSV[6]);
						cont++;
					}
				}
				arq.close();
				return "";
			} catch (IOException ex) {
				System.out.println("Ocorreu um erro na leitura");
				return "";
			}

		} catch (FileNotFoundException e) {
			System.out.println("Ocorreu um erro na leitura");
			return "";
		}

	}

	public static String LeitorPeriodico(String ArquivoCSV, Livros[] vetLivro) { // leitor de planilha aluno
		int qtd = 0;
		String divisor = ";";
		int cont = 0;
		int convertInt = 0;
		String linha;
		try {
			try {
				FileReader arq = new FileReader(ArquivoCSV);
				LineNumberReader lineCounter = new LineNumberReader(arq);
				while ((lineCounter.readLine()) != null) { // conta as linhas dentro do arquivo
					qtd++;
				}
			} catch (Exception done) {
				done.printStackTrace();
			}
			FileReader arq = new FileReader(ArquivoCSV);
			BufferedReader lerArq = new BufferedReader(arq);
			vetLivro = new Livros[qtd]; // instância o vetor com o número de linhas do arquivo
			try {
				while ((linha = lerArq.readLine()) != null) {
					String[] vetorCSV = linha.split(divisor);
					if (vetorCSV.length == 7) {
						ValidaValores(vetorCSV);
						convertInt = Integer.parseInt(vetorCSV[0]);
						vetLivro[cont].setCodigo(convertInt);
						vetLivro[cont].setAutor(vetorCSV[1]);
						vetLivro[cont].setTitulo(vetorCSV[2]);
						vetLivro[cont].setEditora(vetorCSV[3]);
						vetLivro[cont].setTipo(vetorCSV[4]);
						vetLivro[cont].setPublicacao(vetorCSV[5]);
						vetLivro[cont].setIssn(vetorCSV[6]);
						cont++;
					}
				}
				arq.close();
				return "";
			} catch (IOException ex) {
				System.out.println("Ocorreu um erro na leitura");
				return "";
			}

		} catch (FileNotFoundException e) {
			System.out.println("Ocorreu um erro na leitura");
			return "";
		}

	}

	public static String LeitorEmprestimo(String ArquivoCSV, Emprestimo[] vetEmprestimo) { // leitor de planilha aluno
		int qtd = 0;
		String divisor = ";";
		int cont = 0;
		int convertInt = 0;
		String linha;
		try {
			try {
				FileReader arq = new FileReader(ArquivoCSV);
				LineNumberReader lineCounter = new LineNumberReader(arq);
				while ((lineCounter.readLine()) != null) { // conta as linhas dentro do arquivo
					qtd++;
				}
			} catch (Exception done) {
				done.printStackTrace();
			}
			FileReader arq = new FileReader(ArquivoCSV);
			BufferedReader lerArq = new BufferedReader(arq);
			vetEmprestimo = new Emprestimo[qtd]; // instância o vetor com o número de linhas do arquivo
			try {
				while ((linha = lerArq.readLine()) != null) {
					String[] vetorCSV = linha.split(divisor);
					if (vetorCSV.length == 8) {
						ValidaValores(vetorCSV);
						convertInt = Integer.parseInt(vetorCSV[0]);
						vetEmprestimo[cont].setCodigo(convertInt);
						convertInt = Integer.parseInt(vetorCSV[1]);
						vetEmprestimo[cont].setMatCliente(convertInt);
						convertInt = Integer.parseInt(vetorCSV[2]);
						vetEmprestimo[cont].setMatFunc(convertInt);
						vetEmprestimo[cont].setDataEmprestimo(vetorCSV[3]);
						vetEmprestimo[cont].setDataDevolucao(vetorCSV[4]);

						cont++;
					}
				}
				arq.close();
				return "";
			} catch (IOException ex) {
				System.out.println("Ocorreu um erro na leitura");
				return "";
			}

		} catch (FileNotFoundException e) {
			System.out.println("Ocorreu um erro na leitura");
			return "";
		}

	}

	public static String LeitorEmprestimoLivro(String ArquivoCSV, EmprestimoLivro[] vetEmLivro) { // leitor de planilha
																									// aluno
		int qtd = 0;
		String divisor = ";";
		int cont = 0;
		int convertInt = 0;
		String linha;
		try {
			try {
				FileReader arq = new FileReader(ArquivoCSV);
				LineNumberReader lineCounter = new LineNumberReader(arq);
				while ((lineCounter.readLine()) != null) { // conta as linhas dentro do arquivo
					qtd++;
				}
			} catch (Exception done) {
				done.printStackTrace();
			}
			FileReader arq = new FileReader(ArquivoCSV);
			BufferedReader lerArq = new BufferedReader(arq);
			vetEmLivro = new EmprestimoLivro[qtd]; // instância o vetor com o número de linhas do arquivo
			try {
				while ((linha = lerArq.readLine()) != null) {
					String[] vetorCSV = linha.split(divisor);
					if (vetorCSV.length == 4) {
						ValidaValores(vetorCSV);
						convertInt = Integer.parseInt(vetorCSV[0]);
						vetEmLivro[cont].setCodigoItem(convertInt);
						convertInt = Integer.parseInt(vetorCSV[1]);
						vetEmLivro[cont].setCodigoEmprestimo(convertInt);
						convertInt = Integer.parseInt(vetorCSV[2]);
						vetEmLivro[cont].setCodigoLivro(convertInt);
						vetEmLivro[cont].setDataDevolucao(vetorCSV[3]);

						cont++;
					}
				}
				arq.close();
				return "";
			} catch (IOException ex) {
				System.out.println("Ocorreu um erro na leitura");
				return "";
			}

		} catch (FileNotFoundException e) {
			System.out.println("Ocorreu um erro na leitura");
			return "";
		}

	}

	public static String LeitorEmprestimoPeriodico(String ArquivoCSV, EmprestimoPeriodico[] vetEmPeriodico) { // leitor
																												// de
																												// planilha
		// aluno
		int qtd = 0;
		String divisor = ";";
		int cont = 0;
		int convertInt = 0;
		String linha;
		try {
			try {
				FileReader arq = new FileReader(ArquivoCSV);
				LineNumberReader lineCounter = new LineNumberReader(arq);
				while ((lineCounter.readLine()) != null) { // conta as linhas dentro do arquivo
					qtd++;
				}
			} catch (Exception done) {
				done.printStackTrace();
			}
			FileReader arq = new FileReader(ArquivoCSV);
			BufferedReader lerArq = new BufferedReader(arq);
			vetEmPeriodico = new EmprestimoPeriodico[qtd]; // instância o vetor com o número de linhas do arquivo
			try {
				while ((linha = lerArq.readLine()) != null) {
					String[] vetorCSV = linha.split(divisor);
					if (vetorCSV.length == 4) {
						ValidaValores(vetorCSV);
						convertInt = Integer.parseInt(vetorCSV[0]);
						vetEmPeriodico[cont].setCodigoItem(convertInt);
						convertInt = Integer.parseInt(vetorCSV[1]);
						vetEmPeriodico[cont].setCodigoEmprestimo(convertInt);
						convertInt = Integer.parseInt(vetorCSV[2]);
						vetEmPeriodico[cont].setCodigoPeriodico(convertInt);
						vetEmPeriodico[cont].setDataDevolucao(vetorCSV[3]);

						cont++;
					}
				}
				arq.close();
				return "";
			} catch (IOException ex) {
				System.out.println("Ocorreu um erro na leitura");
				return "";
			}

		} catch (FileNotFoundException e) {
			System.out.println("Ocorreu um erro na leitura");
			return "";
		}

	}

	public static String LeitorEmprestimoItem(String ArquivoCSV, EmprestimoItem[] vetEmItem) { // leitor
		// de
		// planilha
// aluno
		int qtd = 0;
		String divisor = ";";
		int cont = 0;
		int convertInt = 0;
		String linha;
		try {
			try {
				FileReader arq = new FileReader(ArquivoCSV);
				LineNumberReader lineCounter = new LineNumberReader(arq);
				while ((lineCounter.readLine()) != null) { // conta as linhas dentro do arquivo
					qtd++;
				}
			} catch (Exception done) {
				done.printStackTrace();
			}
			FileReader arq = new FileReader(ArquivoCSV);
			BufferedReader lerArq = new BufferedReader(arq);
			vetEmItem = new EmprestimoItem[qtd]; // instância o vetor com o número de linhas do arquivo
			try {
				while ((linha = lerArq.readLine()) != null) {
					String[] vetorCSV = linha.split(divisor);
					if (vetorCSV.length == 5) {
						ValidaValores(vetorCSV);
						convertInt = Integer.parseInt(vetorCSV[0]);
						vetEmItem[cont].setCodigoItem(convertInt);
						convertInt = Integer.parseInt(vetorCSV[1]);
						vetEmItem[cont].setCodigoEmprestimo(convertInt);
						convertInt = Integer.parseInt(vetorCSV[2]);
						vetEmItem[cont].setCodigoLivro(convertInt);
						convertInt = Integer.parseInt(vetorCSV[3]);
						vetEmItem[cont].setCodigoPeriodico(convertInt);
						vetEmItem[cont].setDataDevolucao(vetorCSV[4]);

						cont++;
					}
				}
				arq.close();
				return "";
			} catch (IOException ex) {
				System.out.println("Ocorreu um erro na leitura");
				return "";
			}

		} catch (FileNotFoundException e) {
			System.out.println("Ocorreu um erro na leitura");
			return "";
		}

	}

	public static boolean ValidaValores(String[] vetor) {
		int cont = 0;
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i].equals("") || vetor.equals(null) || vetor[i].equals(";")) {
				break;
			} else {
				cont++;
				if (cont == vetor.length) {
					return true;
				}
			}
		}
		return false;

	}

	public String LeitorUsuario(String ArquivoAluno, String ArquivoProfessor, Usuario[] vetUsuario) {
		String divisor = ";";
		int cont = 0;
		int convertInt = 0;
		double convertDouble = 0.0;
		String linha;
		try {
			FileReader arq = new FileReader(ArquivoAluno);
			BufferedReader lerArq = new BufferedReader(arq);
			try {
				while ((linha = lerArq.readLine()) != null) {
					String[] vetorCSV = linha.split(divisor);
					if (vetorCSV.length == 6) {
						ValidaValores(vetorCSV);
						convertInt = Integer.parseInt(vetorCSV[0]);
						vetUsuario[cont].setMatricula(convertInt);
						vetUsuario[cont].setNome(vetorCSV[1]);
						vetUsuario[cont].setEndereco(vetorCSV[2]);
						((Aluno) vetUsuario[cont]).setCurso(vetorCSV[3]);
						vetUsuario[cont].setDataString(vetorCSV[4]);
						convertDouble = Double.parseDouble(vetorCSV[5]);
						((Aluno) vetUsuario[cont]).setMulta(convertDouble);
						cont++;
					} else {
						if (vetorCSV.length == 5) {
							ValidaValores(vetorCSV);
							convertInt = Integer.parseInt(vetorCSV[0]);
							vetUsuario[cont].setMatricula(convertInt);
							vetUsuario[cont].setNome(vetorCSV[1]);
							vetUsuario[cont].setEndereco(vetorCSV[2]);
							vetUsuario[cont].setDataString(vetorCSV[3]);
							((Professor) vetUsuario[cont]).setSetor(vetorCSV[4]);
							cont++;
						}
					}
				}
				arq.close();
				return "";
			} catch (IOException ex) {
				System.out.println("Ocorreu um erro na leitura");
				return "";
			}

		} catch (FileNotFoundException e) {
			System.out.println("Ocorreu um erro na leitura");
			return "";
		}

	}

	public int instanciaVetor(String caminho1, String caminho2) {
		int qtd = 0;
		try {
			FileReader arq = new FileReader(caminho1);
			LineNumberReader lineCounter = new LineNumberReader(arq);
			while ((lineCounter.readLine()) != null) { // conta as linhas dentro do arquivo
				qtd++;
			}
			FileReader arq2 = new FileReader(caminho2);
			LineNumberReader lineCounter2 = new LineNumberReader(arq2);
			while ((lineCounter2.readLine()) != null) { // conta as linhas dentro do arquivo
				qtd++;

			}
			return qtd;
		} catch (Exception done) {
			done.printStackTrace();
			return 0;
		}
	}

}
