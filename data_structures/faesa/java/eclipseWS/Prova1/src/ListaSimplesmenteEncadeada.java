
public class ListaSimplesmenteEncadeada {
	
	/////////////////////////////////////////////////////////////////
	// Atributos
	/////////////////////////////////////////////////////////////////
	private No  prim;
	private No  ult;
	private int qtdNos;
	
	
	/////////////////////////////////////////////////////////////////
	// Construtor
	/////////////////////////////////////////////////////////////////
	public ListaSimplesmenteEncadeada() {
		setPrim(null);
		setUlt(null);
		setQtdNos(0);
	}
	
	
	/////////////////////////////////////////////////////////////////
	// Getters
	/////////////////////////////////////////////////////////////////	
	public No getPrim () {
		return prim;
	}

	public No getUlt () {
		return ult;
	}
	
	public int getQtdNos () {
		return qtdNos;
	}	
	
	
	/////////////////////////////////////////////////////////////////
	// Setters
	/////////////////////////////////////////////////////////////////	
	public void setPrim ( No prim ) {
		this.prim = prim;
	}

	public void setUlt ( No ult ) {
		this.ult = ult;
	}

	public void setQtdNos ( int qtdNos ) {
		this.qtdNos = qtdNos;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// eVazia?
	/////////////////////////////////////////////////////////////////
	public boolean eVazia () {
		if ( getPrim() == null ) {
			return true;	
		} else {
			return false;
		}
	}
	
	
	/////////////////////////////////////////////////////////////////
	// getTamanho
	/////////////////////////////////////////////////////////////////
	public int getTamanho () {
		return getQtdNos();
	}
	
	
	/////////////////////////////////////////////////////////////////
	// inserirNoInicio
	/////////////////////////////////////////////////////////////////
	public boolean inserirNoInicio ( No novoNo ) {
		boolean retorno = false;
		
		if ( eVazia() ) {
			setPrim(novoNo);
			setUlt(novoNo);
			retorno = true;
			setQtdNos( getQtdNos() + 1 );
		} else {
			novoNo.setProx(getPrim());
			setPrim(novoNo);
			retorno = true;
			setQtdNos( getQtdNos() + 1 );
		}
		
		return retorno;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// inserirNoFinal
	/////////////////////////////////////////////////////////////////
	public boolean inserirNoFinal ( No novoNo ) {
		boolean retorno = false;
		
		if ( eVazia() ) {
			setPrim(novoNo);
			setUlt(novoNo);
			setQtdNos( getQtdNos() + 1 );
			retorno = true;
		} else {
			ult.setProx(novoNo);
			setUlt(novoNo);
			setQtdNos( getQtdNos() + 1 );
			retorno = true;
		}
		
		return retorno;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// inserirOrdenado
	/////////////////////////////////////////////////////////////////
	public boolean inserirOrdenado (No novoNo) {
		boolean retorno = false;
		
		if ( eVazia() ) {
			if ( inserirNoInicio(novoNo) ) {
				retorno = true;
			}
		} else {
			No atual    = getPrim();
			No anterior = null;
			
			while ( (novoNo.getInfo().getChave() > atual.getInfo().getChave()) && atual.getProx() != null) {
				anterior = atual;
				atual    = atual.getProx();
			}
			
			if (atual == getPrim() && atual.getProx() == null ) {
				if ( novoNo.getInfo().getChave() >= atual.getInfo().getChave() ) {
					atual.setProx(novoNo);
					setUlt(novoNo);
					setQtdNos( getQtdNos() + 1 );
					retorno = true;
				} else {
					novoNo.setProx(atual);
					setPrim(novoNo);
					setQtdNos( getQtdNos() + 1 );
					retorno = true;
				}
			} else if (atual == getPrim() && atual.getProx() != null ) {
				if ( novoNo.getInfo().getChave() >= atual.getInfo().getChave() ) {
					novoNo.setProx(atual.getProx());
					atual.setProx(novoNo);
					setQtdNos( getQtdNos() + 1 );
					retorno = true;
				} else {
					novoNo.setProx(atual);
					setPrim(novoNo);
					setQtdNos( getQtdNos() + 1 );
					retorno = true;
				}
			} else if (atual == getUlt()  ) {
				if ( novoNo.getInfo().getChave() >= atual.getInfo().getChave() ) {
					atual.setProx(novoNo);
					setUlt(novoNo);
					setQtdNos( getQtdNos() + 1 );
					retorno = true;
				} else {
					novoNo.setProx(atual);
					anterior.setProx(novoNo);
					setQtdNos( getQtdNos() + 1 );
					retorno = true;
				}
			} else {
				novoNo.setProx(atual);
				anterior.setProx(novoNo);
				setQtdNos( getQtdNos() + 1 );
				retorno = true;
			}
		}
		
		return retorno;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// inserirAposDeterminadoNoPelaChave
	/////////////////////////////////////////////////////////////////
	public boolean inserirAposNo(No novoNo, int n) {
		boolean retorno = false;
		
		if ( ! eVazia() ) {
			No anterior = null;
			No atual    = getPrim();
			
			while (n != atual.getInfo().getChave() && atual.getProx() != null) {
				anterior = atual;
				atual = atual.getProx();
			}
			
			if (atual == getPrim() && atual.getInfo().getChave() == n) {
				if ( atual.getProx() == null ) {
					atual.setProx(novoNo);
					setUlt(novoNo);
					setQtdNos( getQtdNos() + 1 );
					retorno = true;
				} else {
					novoNo.setProx(atual.getProx());
					atual.setProx(novoNo);
					setQtdNos( getQtdNos() + 1 );
					retorno = true;
				}
			} else if (atual == getUlt() && atual.getInfo().getChave() == n) {
				atual.setProx(novoNo);
				setUlt(novoNo);
				setQtdNos(getQtdNos() + 1 );
				retorno = true;
			} else if ( atual.getInfo().getChave() == n){
				novoNo.setProx(atual.getProx());
				atual.setProx(novoNo);
				setQtdNos( getQtdNos() + 1 );
				retorno = true;
			}
		}
		
		return retorno;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// inserirAntesDeterminadoNoPelaChave
	/////////////////////////////////////////////////////////////////
	public boolean inserirAntesNo(No novoNo, int n) {
		boolean retorno = false;
		
		if ( ! eVazia() ) {
			No anterior = null;
			No atual    = getPrim();
			
			while (n != atual.getInfo().getChave() && atual.getProx() != null) {
				anterior = atual;
				atual = atual.getProx();
			}
			
			if (atual == getPrim() && atual.getInfo().getChave() == n) {
				novoNo.setProx(atual);
				setPrim(novoNo);
				setQtdNos(getQtdNos() + 1 );
				retorno = true;
			} else if (atual == getUlt() && atual.getInfo().getChave() == n) {
				novoNo.setProx(atual);
				anterior.setProx(novoNo);
				setQtdNos(getQtdNos() + 1 );
				retorno = true;
			} else if ( atual.getInfo().getChave() == n){
				novoNo.setProx(atual);
				anterior.setProx(novoNo);
				setQtdNos(getQtdNos() + 1 );
				retorno = true;
			}
		}
		
		return retorno;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// inserirAposKesimo
	/////////////////////////////////////////////////////////////////
	public boolean inserirAposKesimo(No novoNo, int k) {
		boolean retorno = false;
		
		if ( ! eVazia() ) {
			No  anterior = null;
			No  atual    = getPrim();
			int contador = 1;
			
			while ( contador < k ) {
				anterior = atual;
				atual = atual.getProx();
				contador++;
			}
			
			if ( atual == getPrim() ) {
				if ( atual.getProx() == null ) {
					atual.setProx(novoNo);
					setUlt(novoNo);
					setQtdNos( getQtdNos() + 1);
					retorno = true;
				} else {
					novoNo.setProx(atual.getProx());
					atual.setProx(novoNo);
					setQtdNos( getQtdNos() + 1);
					retorno = true;
				}
			} else if ( atual == getUlt() ) {
				atual.setProx(novoNo);
				setUlt(novoNo);
				setQtdNos( getQtdNos() + 1);
				retorno = true;
			} else {
				novoNo.setProx(atual.getProx());
				atual.setProx(novoNo);
				setQtdNos( getQtdNos() + 1);
				retorno = true;
			}
			
		}
		
		return retorno;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// inserirAposKesimo
	/////////////////////////////////////////////////////////////////
	public boolean inserirAntesKesimo(No novoNo, int k) {
		boolean retorno = false;
		
		if ( ! eVazia() ) {
			No  anterior = null;
			No  atual    = getPrim();
			int contador = 1;
			
			while (contador < k) {
				anterior = atual;
				atual    = atual.getProx();
				contador++;
			}
			
			if ( atual == getPrim() ) {
				if ( inserirNoInicio(novoNo) ) {
					return true;
				}
			} else if ( atual == getUlt() ) {
				novoNo.setProx(getUlt());
				anterior.setProx(novoNo);
				setQtdNos(getQtdNos()+1);
				retorno = true;
			} else {
				novoNo.setProx(atual);
				anterior.setProx(novoNo);
				setQtdNos(getQtdNos()+1);
				retorno = true;
			}
			
		}
		
		return retorno;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// removerPrimeiro
	/////////////////////////////////////////////////////////////////
	public boolean removerPrimeiro() {
		boolean retorno = false;
		
		if ( ! eVazia() ) {
			if (getPrim().getProx() != null) {
				setPrim(getPrim().getProx());
				setQtdNos(getQtdNos()-1);
				retorno = true;
			} else {
				setPrim(null);
				setUlt(null);
				setQtdNos(getQtdNos()-1);
				retorno = true;
			}
		}
		
		return retorno;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// removerUltimo
	/////////////////////////////////////////////////////////////////
	public boolean removerUltimo() {
		boolean retorno = false;
		
		if ( eVazia() ) {
			System.out.println("\nLista vazia, nada a remover.");
		} else {
			No atual    = getPrim();
			No anterior = null;
			while (atual.getProx() != null) {
				anterior = atual;
				atual    = atual.getProx();
			}
			if (atual == getPrim()) {
				setPrim(null);
				setUlt(null);
				setQtdNos(getQtdNos()-1);
				retorno = true;
			} else {
				setUlt(anterior);
				anterior.setProx(null);
				setQtdNos(getQtdNos()-1);
				retorno = true;
			}
		}

		return retorno;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// removerNoPelaChave
	/////////////////////////////////////////////////////////////////
	public boolean removerNoPelaChave(int chave) {
		boolean retorno = false;
		
		if ( ! eVazia() ) {
			No anterior = null;
			No atual    = getPrim();
			
			while ( (atual.getInfo().getChave() != chave) && (atual.getProx() != null) ) {
				anterior = atual;
				atual = atual.getProx();
			}
			
			if (atual == getPrim() && atual.getInfo().getChave() == chave) {
				if (atual.getProx() == null) {
					if (removerPrimeiro()) {
						retorno = true;
					}
				} else {
					setPrim(atual.getProx());
					atual.setProx(null);
					setQtdNos(getQtdNos()-1);
					retorno = true;
				}
			} else if (atual == getUlt() && atual.getInfo().getChave() == chave) {
				if (removerUltimo()) {
					retorno = true;
				}
			} else if (atual.getInfo().getChave() == chave) {
				anterior.setProx(atual.getProx());
				atual.setProx(null);
				setQtdNos(getQtdNos()-1);
				retorno = true;
			} else {
				System.out.println("\nO nó buscado não está na lista.");
			}
		}
		
		return retorno;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// removerKesimo
	/////////////////////////////////////////////////////////////////
	public boolean removerKesimo(int k) {
		boolean retorno = false;
		
		No anterior  = null;
		No atual     = getPrim();
		int contador = 1;
		
		while (contador < k) {
			anterior = atual;
			atual = atual.getProx();
			contador++;
		}
		
		if (atual == getPrim()) {
			if (removerPrimeiro()) {
				retorno = true;
			}
		} else if (atual == getUlt()) {
			if (removerUltimo()) {
				retorno = true;
			}
		} else {
			anterior.setProx(atual.getProx());
			atual.setProx(null);
			setQtdNos(getQtdNos() - 1);
			retorno = true;
		}
		
		return retorno;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// toString
	/////////////////////////////////////////////////////////////////
	public String toString () {
		String retorno = "\n";
		if ( eVazia() ) {
			System.out.println("\nLista vazia, nada a exibir.\n");
		} else {
			retorno += "A lista tem " + getTamanho() + " nó(s):\n";
			retorno += "PRIM=>";
			No atual = getPrim();
			do {
				retorno += " " + atual.getInfo().getChave() + " ";
				if (atual.getProx() != null) {
					retorno += "->";
				}
				atual = atual.getProx();
			} while (atual != null);
			retorno += "<=ULT";
		}
		
		return retorno;
	}
	
}
