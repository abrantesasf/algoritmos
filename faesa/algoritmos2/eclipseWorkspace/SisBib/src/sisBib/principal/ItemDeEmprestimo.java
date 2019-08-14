package sisBib.principal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ItemDeEmprestimo {
	
	private int codigoItem;
	private int codigoEmprestimo;
	private int codigoLivro;
	private int codigoPeriodico;
	private String dataDevolucaoString;
	private Date dataDevolucao;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public ItemDeEmprestimo(int codigoItem, int codigoEmprestimo, int codigoLivro, int codigoPeriodico, String dataDevolucaoString) {
		this.setCodigoItem(codigoItem);
		this.setCodigoEmprestimo(codigoEmprestimo);
		this.setCodigoLivro(codigoLivro);
		this.setCodigoPeriodico(codigoPeriodico);
		this.setDataDevolucaoString(dataDevolucaoString);
	}

	public int getCodigoItem() {
		return codigoItem;
	}

	public int getCodigoEmprestimo() {
		return codigoEmprestimo;
	}

	public int getCodigoLivro() {
		return codigoLivro;
	}

	public int getCodigoPeriodico() {
		return codigoPeriodico;
	}

	public String getDataDevolucaoString() {
		return dataDevolucaoString;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setCodigoItem(int codigoItem) {
		if (checaLimitesCodigoOuMatricula(codigoItem)) {
			this.codigoItem = codigoItem;
		} else {
			System.out.println("ERRO! Codigo fora dos limites permitidos (1 até 99999999).");
		}
	}

	public void setCodigoEmprestimo(int codigoEmprestimo) {
		if (checaLimitesCodigoOuMatricula(codigoEmprestimo)) {
			this.codigoEmprestimo = codigoEmprestimo;
		} else {
			System.out.println("ERRO! Codigo fora dos limites permitidos (1 até 99999999).");
		}
	}

	public void setCodigoLivro(int codigoLivro) {
		if (checaLimitesCodigoOuMatricula(codigoLivro)) {
			this.codigoLivro = codigoLivro;
		} else {
			System.out.println("ERRO! Codigo fora dos limites permitidos (1 até 99999999).");
		}
	}

	public void setCodigoPeriodico(int codigoPeriodico) {
		if (checaLimitesCodigoOuMatricula(codigoPeriodico)) {
			this.codigoPeriodico = codigoPeriodico;
		} else {
			System.out.println("ERRO! Codigo fora dos limites permitidos (1 até 99999999).");
		}
	}


	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	private boolean checaLimitesCodigoOuMatricula(int codigoOuMatricula) {
		if ((codigoOuMatricula >= 1) & (codigoOuMatricula <= 99999999)) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean setDataDevolucao(String dataDevolucaoString) {
		try {
			this.dataDevolucao = sdf.parse(dataDevolucaoString);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setDataDevolucaoString(String dataDevolucaoString) {
		if (setDataDevolucao(dataDevolucaoString)) {
			this.dataDevolucaoString = dataDevolucaoString;
		} else {
			System.out.println("ERRO! Data em formato inválido.");
		}
	}
	
	public String toString() {
		String resposta = "";
		resposta += "Código do Item:       " + this.getCodigoItem()           + "\n" +
		            "Código do Empréstimo: " + this.getCodigoEmprestimo()     + "\n" +
				    "Código do Livro:      " + this.getCodigoLivro()          + "\n" +
		            "Código do Periódico:  " + this.getCodigoPeriodico()      + "\n" +
				    "Data de Devolução:    " + this.getDataDevolucaoString();
		return resposta;
	}
	
	

}
