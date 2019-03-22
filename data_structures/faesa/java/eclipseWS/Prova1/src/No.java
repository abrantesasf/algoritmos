
public class No {
	
	private Item info;
	private No   prox;
	
	public No ( Item info ) {
		setInfo( info );
		setProx( null );
	}
	
	public Item getInfo () {
		return this.info;
	}
	
	public No getProx () {
		return this.prox;
	}	
	
	public void setInfo ( Item info ) {
		this.info = info;
	}
	
	public void setProx ( No prox ) {
		this.prox = prox;
	}
	
	public String toString () {
		String retorno = "";
		retorno = this.getInfo().toString();
		return retorno;
	}
}