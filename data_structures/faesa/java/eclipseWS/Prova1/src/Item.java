
public class Item {
	
	private int chave;
	
	public Item ( int chave ) {
		this.setChave(chave);
	}

	public int getChave() {
		return this.chave;
	}

	public void setChave ( int chave ) {
		this.chave = chave;
	}
	
	public String toString() {
		String retorno = "";
		retorno = "A chave é: " + getChave();
		return retorno;
	}

}