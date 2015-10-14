package br.ufg.inf.ed1.lista;

/**
 * Essa classe implementa um n� em uma lista duplamente encadeada
 * 
 * @author Auri Vincenzi
 */
public class DLNode extends Node {
	// private Comparable element; // herdado de Node
	// private Node next; // herdado de Node

	private DLNode prev;

	public DLNode() {
		this(null, null, null);
	}

	public DLNode(Comparable e, DLNode p, DLNode n) {
		super(e, n); // inicializando element e prev via construtor de Node
		prev = p;
	}

	// public void setElement(Comparable newElem) { element = newElem; } //
	// herdado de Node
	// public void setNext(Node newNext) { next = newNext; } // herdado de Node
	// public Comparable getElement() { return element; } // herdado de Node
	// public Node getNext() { return next; } // herdado de Node
	public void setPrev(Node newPrev) {
		prev = (DLNode) newPrev;
	}

	public Node getPrev() {
		return prev;
	}
}