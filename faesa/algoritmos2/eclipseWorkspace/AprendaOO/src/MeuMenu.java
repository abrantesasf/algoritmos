/**
 * 
 * @author abrantesasf
 *
 */
public class MeuMenu {
	// Atributos
	private int qtdOpcoes;
	private String[] descOpcoes;
	
	// Construtor
	public MeuMenu(int qtdOpcoes) {
		this.qtdOpcoes = qtdOpcoes;
	}

	// Getters
	protected int getQtdOpcoes() {
		return qtdOpcoes;
	}

	protected String[] getDescOpcoes() {
		return descOpcoes;
	}

	// Setters
	public void setQtdOpcoes(int qtdOpcoes) {
		this.qtdOpcoes = qtdOpcoes;
	}

	public void setDescOpcoes(String[] descOpcoes) {
		for (int i = 0; i < descOpcoes.length; i++) {
			boolean ok = true;
			while (ok) {
				try {
					System.out.println("Informe a DESCRIÇÃO da " + (i + 1) + "ª opção do menu:");
					this.descOpcoes[i] = "teste"; 
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	
}
