package simplesmente;
import dados.*;
public class ListaSimples {
	private No prim;
	private No ult;
	private int quantNos;

	public ListaSimples(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}
	public No getPrim() {
		return this.prim;
	}
	public void setPrim(No novo) {
		this.prim = novo;
	}
	public No getUlt() {
		return this.ult;
	}
	public void setUlt(No novo) {
		this.ult = novo;
	}
	public int getQuantNos() {
		return this.quantNos;
	}
	public void setQuantNos(int novo) {
		this.quantNos = novo;
	}
	public boolean eVazia(){   //ser� usando em m�todos de pesquisa e remo��o
		return this.prim==null;
	}
	//------------------------------------------------------
	//inserir um n� no final da lista
	public void inserirNo (Item novo){
		No novoNo = new No(novo);
		if (this.eVazia()){
			this.prim = novoNo;
		}else{
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}
	//mostrar conte�do da lista
	public String toString(){
		String msg = "";
		No atual = this.prim;
		while (atual != null){
			msg += atual.getInfo().getChave()+"\n";
			atual = atual.getProx();
		}
		return msg;
	}
	//inserir um novo n� ap�s determinado n�
	public boolean inserirAposDeterminado(int x, Item elem){
		if (this.eVazia()){
			return false;
		}else{
			No atual = this.prim;
			//procurar o n� com o valor de x
			while (atual != null && atual.getInfo().getChave()!=x){
				atual = atual.getProx();
			}
			if (atual==null){    //n�o o achou o x
				return false;
			}else{
				No novoNo = new No(elem);
				if (atual==this.ult){     
					this.ult.setProx(novoNo);
					this.ult = novoNo;
				}else{
					novoNo.setProx(atual.getProx());
					atual.setProx(novoNo);
				}
				this.quantNos++;
				return true;
			}
		}
	}
	//outra solu��o - inserir um novo n� ap�s determinado n�
	public boolean inserirAposDeterminado2(int x, Item elem){
		if (this.eVazia()){
			return false;
		}else{
			No atual = this.prim;
			//procurar o n� com o valor de x
			while (atual != null && atual.getInfo().getChave()!=x){
				atual = atual.getProx();
			}
			if (atual==null){    //n�o o achou o x
				return false;
			}else{
				No novoNo = new No(elem);
				if (atual!=this.ult){     
					novoNo.setProx(atual.getProx());
				}else{	
					this.ult = novoNo;
				}
				atual.setProx(novoNo);
				this.quantNos++;
				return true;
			}
		}
	}
	//inserir depois do �ltimo
	// o c�digo est� na p�gina 11 da apostila

	//remover 1�  n�
	public boolean removerPrimeiroNo(){
		if (this.eVazia()){
			return false;
		}else{
			this.prim = this.prim.getProx();
			if (this.prim==null){
				this.ult = null;
			}
			this.quantNos--;
			return true;
		}
	}
	//remover �ltimo n�
	public boolean removerUltimoNo(){
		if (this.eVazia()){
			return false;
		}else{
			if (this.prim==this.ult){
				this.prim=null;
				this.ult=null;
			}else{
				No atual = this.prim;
				while (atual.getProx()!= this.ult){ //p�ra no penultimo 
					atual = atual.getProx();
				}
				this.ult = atual;
				this.ult.setProx(null);
			}
			this.quantNos--;
			return true;
		}
	}
	//concatenar duas listas(permanecer todos os n�s na 1� lista)
	public void concatenarListas(ListaSimples lista2){
		if (!lista2.eVazia()){
			if (this.eVazia()){
				this.prim = lista2.prim;
				this.ult = lista2.ult;
			}else{
				this.ult.setProx(lista2.prim);
				this.ult = lista2.ult;
			}
			this.quantNos += lista2.quantNos;
			lista2.prim = null;
			lista2.ult = null;
			lista2.quantNos=0;
		}
	}
	//remover o k-�ssimo n� da lista
	//ver a execu��o deste m�todo no programa Teste 02 dentro deste pacote
	public boolean removerkesimo(int k){
		if (this.eVazia()|| k>this.quantNos){
			return false;
		}else{
			if (k==1){
				this.prim = this.prim.getProx();
				if (this.prim==null){
					this.ult = null;
				}
			}else{
				No atual = this.prim;
				for (int i=1;i<k-1;i++){
					atual = atual.getProx();
				}
				atual.setProx(atual.getProx().getProx());
				if (atual.getProx()==this.ult){
					this.ult=null;
				}
			}
			this.quantNos--;
			return true;
		}
	}
//lista 01 numero 13
	public boolean separarLista(ListaSimples novaLista, int n){
		if (this.eVazia() || this.ult.getInfo().getChave()==n){
			return false;
		}else{
			No atual = this.prim;
			int cont=1;
			while (atual!=null && atual.getInfo().getChave()!=n){
				atual = atual.getProx();
				cont++;
			}
			if (atual==null){
				return false;
			}else{
				novaLista.prim = atual.getProx();
				novaLista.ult = this.ult;
				this.ult = atual;
				this.ult.setProx(null);
				novaLista.quantNos = this.quantNos-cont;
				this.quantNos = cont;
				return true;
			}
		}
	}
}
