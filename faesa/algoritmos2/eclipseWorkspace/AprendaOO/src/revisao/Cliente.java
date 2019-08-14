package revisao;

public class Cliente extends Pessoa {
	// Atributos
	private int    conta;
	private double saldo;
	private int    numeroDeEmprestimosSimultaneos;
	private int    numeroDeEmprestimosAtivos;
	private double limitePorEmprestimo;
	private double limiteGlobalDeEnvididamento;
	private EmprestimoVetor emprestimos;
	
	// Construtores
	public Cliente(String nome, String cpf, int conta, double saldo) {
		super(nome, cpf);
		this.conta = conta;
		this.saldo = saldo;
		this.emprestimos = new EmprestimoVetor(10);
		configuraEmprestimos(1, 0, 0, 0);
	}
	
	public Cliente() {
	}

	// Getters
	public int getConta() {
		return this.conta;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumeroDeEmprestimosPermitidos() {
		return this.numeroDeEmprestimosSimultaneos;
	}
	
	public int getNumeroDeEmprestimosAvitos() {
		return this.numeroDeEmprestimosAtivos;
	}
	
	public double getLimitePorEmprestimo() {
		return this.limitePorEmprestimo;
	}
	
	public double getLimiteGlobalDeEndividamento() {
		return this.limiteGlobalDeEnvididamento;
	}

	// Setters:
	public void setConta(int conta) {
		this.conta = conta;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void setNumeroDeEmprestimosPermitidos(int n) {
		this.numeroDeEmprestimosSimultaneos = n;
	}
	
	public void setNumeroDeEmprestimosAtivos(int n) {
		this.numeroDeEmprestimosAtivos = n;
	}
	
	public void setLimitePorEmprestimo(double d) {
		this.limitePorEmprestimo = d;
	}
	
	public void setLimiteGlobalDeEndividamento(double d) {
		this.limiteGlobalDeEnvididamento = d;
	}
	
	// toString:
	public String toString() {
		String resposta = "";
		resposta = super.toString() +
				   "Conta:         " + this.conta + "\n" +
				   "Saldo:         " + this.saldo + "\n" +
				   "Num. Emp.:     " + this.numeroDeEmprestimosSimultaneos + "\n" +
				   "Emp. Ativ.:    " + this.numeroDeEmprestimosAtivos + "\n" +
				   "Lim. por Emp.: " + this.limitePorEmprestimo + "\n" +
				   "Lim. Global:   " + this.limiteGlobalDeEnvididamento + "\n";
		if (this.numeroDeEmprestimosAtivos > 0) {
			resposta += "----------------------------\n";
			resposta += "Informaçṍes dos empréstimos:\n";
			resposta += this.emprestimos.toString();
			resposta += "----------------------------";
		}
		return resposta;
	}
	
	// Configura empréstimos:
	protected void configuraEmprestimos(int empSimul, int empAtiv, double limPor, double limGlob) {
		this.numeroDeEmprestimosSimultaneos = empSimul;
		this.numeroDeEmprestimosAtivos = empAtiv;
		this.limitePorEmprestimo = limPor;
		this.limiteGlobalDeEnvididamento = limGlob;
	}
	
	// Total de endividamento
	private double endividamentoTotal() {
		double valor = 0;
		for (int i = 0; i < this.numeroDeEmprestimosAtivos; i++) {
			valor += this.emprestimos.getEmprestimo(i).getValor();
		}
		return valor;
	}
	
	// Pega Empréstimo
	public boolean pegaEmprestimo(double valor, double taxa, int prazo) {
		boolean retorno = false;
		if (this.numeroDeEmprestimosAtivos == this.numeroDeEmprestimosSimultaneos) {
			System.out.println("ERRO, este cliente não pode mais pegar empréstimos.");
		} else if (valor > this.limitePorEmprestimo) {
			System.out.println("ERRO, o valor solicitado está acima do limite por empréstimo.");
		} else if (valor + this.endividamentoTotal() > this.limiteGlobalDeEnvididamento) {
			System.out.println("ERRO, o endividamento será muito grande.");
		} else {
			Emprestimo novoEmprestimo = new Emprestimo(valor, taxa, prazo);
			this.emprestimos.inserirEmprestimo(novoEmprestimo);
			this.numeroDeEmprestimosAtivos += 1;
			retorno = true;
		}
		return retorno;
	}
	
}
