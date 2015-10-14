package listalinear.duplamenteligada;

public class No {
	private Comparable elemento;
	private No proximo;
	private No anterior;
	
	
	public No() {
		elemento = null;
		proximo = null;
		anterior = null;
	}
	
	public No(Comparable elemento, No proximo, No anterior) {
		this.elemento = elemento;
		this.proximo = proximo;
		this.anterior = anterior;
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
	
	public No getAnterior() {
		return anterior;
	}
	
	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}

}
