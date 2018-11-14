package revisao;

public class ClienteEspecial extends Cliente {
	// Atributos
	private boolean clienteEspecial;

	// Construtor
	public ClienteEspecial(String nome, String cpf, int conta, double saldo) {
		super(nome, cpf, conta, saldo);
		super.configuraEmprestimos(2, 0, 500, 1000);
		this.clienteEspecial = true;
	}

	// Getter
	public boolean isClienteEspecial() {
		return this.clienteEspecial;
	}

	// Setter
	public void setClienteEspecial(boolean clienteEspecial) {
		this.clienteEspecial = clienteEspecial;
	}
	
	// toString
	public String toString() {
		String resposta = "";
		String especial = "";
		
		if (this.clienteEspecial) {
			especial = "     Sim";
		} else {
			especial = "     Não";
		}
		
		resposta = super.toString() + "\n" +
		           "Especial: " + especial + "\n";
		return resposta;
	}

}
