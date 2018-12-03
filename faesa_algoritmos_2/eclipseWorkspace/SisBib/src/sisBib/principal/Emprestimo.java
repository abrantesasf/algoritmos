package sisBib.principal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Emprestimo {
	
	private int codigo;
	private int matriculaCliente;
	private int matriculaFuncionario;
	private String dataEmprestimoString;
	private Date dataEmprestimo = null;
	private String dataDevolucaoString;
	private Date dataDevolucao = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Emprestimo(int codigo, int matriculaCliente, int matriculaFuncionario, String dataEmprestimoString, String dataDevolucaoString) {
		this.setCodigo(codigo);
		this.setMatriculaCliente(matriculaCliente);
		this.setMatriculaFuncionario(matriculaFuncionario);
		this.setDataEmprestimoString(dataEmprestimoString);
		this.setDataDevolucaoString(dataDevolucaoString);
	}

	public int getCodigo() {
		return this.codigo;
	}

	public int getMatriculaCliente() {
		return this.matriculaCliente;
	}

	public int getMatriculaFuncionario() {
		return this.matriculaFuncionario;
	}

	public String getDataEmprestimoString() {
		return this.dataEmprestimoString;
	}

	public Date getDataEmprestimo() {
		return this.dataEmprestimo;
	}

	public String getDataDevolucaoString() {
		return dataDevolucaoString;
	}

	public Date getDataDevolucao() {
		return this.dataDevolucao;
	}

	public void setCodigo(int codigo) {
		if (checaLimitesCodigoOuMatricula(codigo)) {
			this.codigo = codigo;
		} else {
			System.out.println("ERRO! Codigo fora dos limites permitidos (1 até 99999999).");
		}
	}

	public void setMatriculaCliente(int matriculaCliente) {
		if (checaLimitesCodigoOuMatricula(matriculaCliente)) {
			this.matriculaCliente = matriculaCliente;
		} else {
			System.out.println("ERRO! Matrícula fora dos limites permitidos (1 até 99999999).");
		}
	}

	public void setMatriculaFuncionario(int matriculaFuncionario) {
		if (checaLimitesCodigoOuMatricula(matriculaFuncionario)) {
			this.matriculaFuncionario = matriculaFuncionario;
		} else {
			System.out.println("ERRO! Matrícula fora dos limites permitidos (1 até 99999999).");
		}
	}

	public void setDataEmprestimoString(String dataEmprestimoString) {
		if (setDataEmprestimo(dataEmprestimoString)) {
			this.dataEmprestimoString = dataEmprestimoString;
		} else {
			System.out.println("ERRO! Data em formato inválido.");
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

	private boolean setDataEmprestimo(String dataEmprestimoString) {
		try {
			this.dataEmprestimo = sdf.parse(dataEmprestimoString);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private boolean checaLimitesCodigoOuMatricula(int codigoOuMatricula) {
		if ((codigoOuMatricula >= 1) & (codigoOuMatricula <= 99999999)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public String toString() {
		String resposta = "";
		resposta += "Código do Empréstimo:     " + this.getCodigo()               + "\n" +
		            "Matrícula do Cliente:     " + this.getMatriculaCliente()     + "\n" +
				    "Matrícula do Funcionário: " + this.getMatriculaFuncionario() + "\n" +
		            "Data do Empréstimo:       " + this.getDataEmprestimoString() + "\n" +
				    "Data da Devolução:        " + this.getDataDevolucaoString();
		return resposta;
	}
	
	

}
