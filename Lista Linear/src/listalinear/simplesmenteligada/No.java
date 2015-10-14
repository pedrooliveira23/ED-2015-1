package listalinear.simplesmenteligada;

public class No {
	private Comparable elemento;
	private No proximo;
	
	
	public No() {
		elemento = null;
		proximo = null;
	}
	
	public No(Comparable elemento, No proximo) {
		this.elemento = elemento;
		this.proximo = proximo;
	}
	
	public Comparable getElemento() {
		return elemento;
	}
	public void setElemento(Comparable elemento) {
		this.elemento = elemento;
	}
	
	public No getProximo() {
		return proximo;
	}
	
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	

}
