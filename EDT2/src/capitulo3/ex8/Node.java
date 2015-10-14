package capitulo3.ex8;

/**
 * Esta classe representa um n� de uma lista ligada.
 * 
 * @author Auri Vincenzi
 * @version 08-2005
 */
public class Node {
	// O elemento a ser armazenado
	private Comparable coeficiente;
	private Comparable expoente;
	// O apontador para o pr�ximo n� da lista
	private Node next;

	// Construtores
	public Node() {
		this(null, null, null);
	}

	public Node(Comparable c, Comparable e, Node n) {
		coeficiente = c;
		expoente = e;
		next = n;
	}

	// M�todos de acesso
	public Comparable getCoeficiente() {
		return coeficiente;
	}
	
	public Comparable getExpoente() {
		return expoente;
	}

	public Node getNext() {
		return next;
	}

	// M�todos modificadores
	public void setCoeficiente(Comparable newElem) {
		coeficiente = newElem;
	}
	
	public void setExpoente(Comparable newElem) {
		expoente = newElem;
	}

	public void setNext(Node newNext) {
		next = newNext;
	}
}
