package br.ufg.inf.ed1.lista;

/**
 * Esta classe implementa uma lista linear utilizando uma representação baseada
 * em lista ligada.
 * 
 * @author Auri Vincenzi
 * @version 08-2005
 */
public class LinkedLinearList implements LinearList {
	// Quantidade de elementos da lista
	private int size;

	// Nó que representa o início da lista
	private Node head;

	public LinkedLinearList() {
		size = 0;
		head = null;
	}

	/**
	 * Verifica se a lista está vazia.
	 * 
	 * @return true se e somente se a lista estiver vazia, false caso contrário.
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Tamanho da lista.
	 * 
	 * @return o número corrente de elementos na lista.
	 */
	public int size() {
		return size;
	}

	/**
	 * Busca elemento em determinada posição da lista.
	 * 
	 * @return o elemento localizado da posição index.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando o índice fornecido não estiver entre 0 e size - 1.
	 */
	public Comparable get(int index) {
		checkIndex(index);
		Node p = head;
		for (int i = 0; i < index; i++) {
			p = p.getNext();
		}
		return p.getElement();
	}

	/**
	 * Busca o índice de determinado elemento.
	 * 
	 * @return o índice da primeira ocorrência do elemento na lista. Retorna -1
	 *         se o elemento não for encontrado.
	 */
	public int indexOf(Comparable theElement) {
		Node p = head;
		for (int i = 0; i < size; i++) {
			if (theElement.compareTo(p.getElement()) == 0)
				return i;
			p = p.getNext();
		}
		return -1;
	}

	/**
	 * Adiciona um novo elemento a lista em uma dada posição.
	 * 
	 * Todos elementos com índice igual ou superior ao índice fornecido terão
	 * seus índices incrementados em uma unidade
	 * 
	 * @throws LinearListOverflowException
	 *             quando a lista estiver cheia.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando index não estiver entre 0 e size.
	 */
	public void add(int index, Comparable theElement) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Índice = " + index
					+ "  tamanho = " + size);

		Node novo = new Node(theElement, null);
		if (index == 0) {
			novo.setNext(head);
			head = novo;
		} else {
			Node ant = null;
			Node aux = head;
			for (int i = 0; i < index; i++) {
				ant = aux;
				aux = aux.getNext();
			}
			ant.setNext(novo);
			novo.setNext(aux);
		}
		size++;
	}

	/**
	 * Remove o elemento localizado no index especificado. Todos os elementos
	 * com índice superior ao índice fornecido terão seus valores decrementado
	 * em uma unidade.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando index não estiver entre 0 e size - 1.
	 * @return o elemento removido.
	 */
	public Comparable remove(int index) {
		checkIndex(index);

		Node toRemove = head;
		if (index == 0) {
			head = head.getNext();
		} else {
			Node ant = getNode(index - 1);
			toRemove = ant.getNext();
			ant.setNext(toRemove.getNext());
		}
		toRemove.setNext(null);
		size--;
		return toRemove.getElement();
	}

	/**
	 * Converte a lista em um String.
	 * 
	 * @return uma String representando a lista.
	 */
	public String toString() {
		StringBuffer s = new StringBuffer("[");
		// inserindo os elementos no buffer
		for (Node n = head; n != null; n = n.getNext())
			if (n.getElement() == null)
				s.append("null, ");
			else
				s.append(n.getElement().toString() + ", ");

		if (size > 0)
			s.delete(s.length() - 2, s.length());

		s.append("]");

		return new String(s);
	}

	/**
	 * Verifica a validade de determinado índice. Um índice válido esta entre 0
	 * e size - 1, inclusive.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando index não estiver entre 0 e size - 1.
	 */
	void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Índice = " + index
					+ "  tamanho = " + size);
	}

	/**
	 * Busca elemento em determinada posição da lista.
	 * 
	 * @return o nó contendo o elemento da posição index.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando o índice fornecido não estiver entre 0 e size - 1.
	 */
	public Node getNode(int index) {
		checkIndex(index);
		Node p = head;
		for (int i = 0; i < index; i++) {
			p = p.getNext();
		}
		return p;
	}
}