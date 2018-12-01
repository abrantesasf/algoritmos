package util;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import principal.Produto;
import principal.VetorDeProdutos;

public class Arquivo {

	private String mensagemDeErro = "";
	
	public Arquivo() {
	}
	
	public boolean lerCSVprodutos(String arquivo, VetorDeProdutos vProd) throws IOException {
		int             numeroCampos = 4;
		String          divisor      = ";";
		String          linha        = "";
		boolean         ok           = true;
		//VetorDeProdutos vTemp        = new VetorDeProdutos(vProd.getTamanhoDoVetor());
		VetorDeProdutos vTemp        = new VetorDeProdutos(contarLinhas(arquivo));

		try {
			FileReader     arq    = new FileReader(arquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			
			try {
				lerArq.readLine();
				
				while (((linha = lerArq.readLine()) != null) && ok) {
					
					String[] vetor = linha.split(divisor);
					
					if (vetor.length != numeroCampos) {
						ok = false;
						this.mensagemDeErro = "Erro de estrutura do arquivo CSV de professores (mais ou menos campos do que o especificado para o SisBib).";
						this.mensagemDeErro += "\nA leitura e importação dos dados NÃO FOI realizada.";
						break;
					} else {
						Produto novoProduto = new Produto(Integer.parseInt(vetor[0]), vetor[1], Double.parseDouble(vetor[2]), Integer.parseInt(vetor[3]));
						if (!vTemp.inserirProduto(novoProduto)) {
							ok = false;
							this.mensagemDeErro = "Erro durante a inserção do professor no vetor temporário.";
							this.mensagemDeErro += "\nA leitura e importação dos dados NÃO FOI realizada.";
							break;
						}
					}
				} // Fecha While
			} catch (Exception e) {
				e.printStackTrace();	
			} finally {
				lerArq.close();
				arq.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		if (ok)	{
			for (int i = 0; i < vTemp.getQtdNoVetor(); i++) {
				if(!vProd.inserirProduto(vTemp.getProduto(i))) {
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
		
		vTemp = null;
		return ok;
		
	} // Fecha Método lerCSVprofessores
	
	public String getMensagem() {
		return this.mensagemDeErro;
	}
	
	public boolean salvarCSVprodutos(String arquivo, VetorDeProdutos vProd) {
		boolean ok = false;
		try {
			PrintWriter saida = new PrintWriter(arquivo, "UTF-8");
			saida.print("codigo;descricao;valor;qtd_no_estoque");
			saida.print(System.getProperty("line.separator"));
			
			for (int i = 0; i < vProd.getQtdNoVetor(); i++) {
				saida.print(vProd.getProduto(i).getCodigo());
				saida.print(";");
				saida.print(vProd.getProduto(i).getDescricao());
				saida.print(";");
				saida.print(vProd.getProduto(i).getValor());
				saida.print(";");
				saida.print(vProd.getProduto(i).getQtdNoEstoque());
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
	
	public int contarLinhas(String arquivo) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(arquivo));
	    
	    try {
	        byte[] c = new byte[1024];
	        int contador = 0;
	        int caracteresLidos = 0;
	        boolean arquivoVazio = true;
	        
	        while ((caracteresLidos = is.read(c)) != -1) {
	            arquivoVazio = false;
	            
	            for (int i = 0; i < caracteresLidos; ++i) {
	                if (c[i] == '\n') {
	                    ++contador;
	                }
	            }
	        }
	        return (contador == 0 && !arquivoVazio) ? 1 : contador;
	    } finally {
	        is.close();
	    }
	}
}
