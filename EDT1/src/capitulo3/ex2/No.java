package capitulo3.ex2;

public class No {
	private Comparable elemento;
	private No proximo;

	No() {
		this(null, null);
	}

	No(Comparable elemento, No proximo) {
		this.elemento = elemento;
		this.proximo = proximo;
	}

	public Comparable getElemento() {
		return elemento;
	}

	public No getProximo() {
		return proximo;
	}

	public void setElemento(Comparable novoElemento) {
		elemento = novoElemento;
	}

	public void setProximo(No novoProximo) {
		proximo = novoProximo;
	}
}
