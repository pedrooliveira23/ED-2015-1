package br.ufg.inf.ed1.lista;

/**
 * Esta classe representa um nó de uma lista ligada.
 * 
 * @author Auri Vincenzi
 * @version 08-2005
 */
public class Node {
	// O elemento a ser armazenado
	private Comparable element;

	// O apontador para o próximo nó da lista
	private Node next;

	// Construtores
	public Node() {
		this(null, null);
	}

	public Node(Comparable e, Node n) {
		element = e;
		next = n;
	}

	// Métodos de acesso
	public Comparable getElement() {
		return element;
	}

	public Node getNext() {
		return next;
	}

	// Métodos modificadores
	public void setElement(Comparable newElem) {
		element = newElem;
	}

	public void setNext(Node newNext) {
		next = newNext;
	}
}
