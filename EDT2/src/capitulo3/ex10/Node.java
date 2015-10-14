package capitulo3.ex10;

/**
 * Esta classe representa um n� de uma lista ligada.
 * 
 * @author Auri Vincenzi
 * @version 08-2005
 */
public class Node {
	// O elemento a ser armazenado
	private Comparable element;

	// O apontador para o pr�ximo n� da lista
	private Node next;

	// Construtores
	public Node() {
		this(null, null);
	}

	public Node(Comparable e, Node n) {
		element = e;
		next = n;
	}

	// M�todos de acesso
	public Comparable getElement() {
		return element;
	}

	public Node getNext() {
		return next;
	}

	// M�todos modificadores
	public void setElement(Comparable newElem) {
		element = newElem;
	}

	public void setNext(Node newNext) {
		next = newNext;
	}
}
