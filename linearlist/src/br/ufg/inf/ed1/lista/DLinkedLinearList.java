package br.ufg.inf.ed1.lista;

/**
 * Esta classe implementa uma lista linear utilizando uma representa��o baseada
 * em uma lista duplamente encadeada.
 * 
 * @author Auri Vincenzi
 */
public class DLinkedLinearList implements LinearList {
	private DLNode cabeca; // referencia ao primeiro elemento

	private int size; // quantidade de elementos na lista

	/**
	 * Cria uma lista dupla vazia
	 */
	public DLinkedLinearList() {
		size = 0;
		cabeca = null;
	}

	/**
	 * Verifica se a lista esta vazia.
	 * 
	 * @return true se e somente se a lista estiver vazia, false caso contrario.
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Tamanho da lista.
	 * 
	 * @return o numero corrente de elementos na lista.
	 */
	public int size() {
		return size;
	}

	/**
	 * Busca elemento em determinada posi��o da lista.
	 * 
	 * @return o elemento localizado da posi��o index.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando o �ndice fornecido n�o estiver entre 0 e size - 1.
	 */
	public Comparable get(int index) {
		Node aux = getNode(index);
		return aux.getElement();
	}

	/**
	 * Busca o �ndice de determinado elemento.
	 * 
	 * @return o indice da primeira ocorr�ncia do elemento na lista. Retorna -1
	 *         se o elemento nao for encontrado.
	 */
	public int indexOf(Comparable theElement) {
		// procura pelo elemento
		if (isEmpty())
			return -1;

		Node aux = getNode(0);
		for (int i = 0; i < size; i++) {
			Comparable elem = aux.getElement();
			if (elem.compareTo(theElement) == 0)
				return i; // elemento encontrado

			aux = aux.getNext(); // n�o encontrado, procura no pr�ximo n�
		}
		return -1;
	}

	/**
	 * Remove o elemento localizado no index especificado. Todos os elementos
	 * com indice superior ao indice fornecido terao seus valores decrementado
	 * em uma unidade.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando index nao estiver entre 0 e size - 1.
	 * @return o elemento removido.
	 */
	public Comparable remove(int index) {
		checkIndex(index); // �ndice v�lido

		DLNode aux = getNode(index);
		Comparable removedElement = aux.getElement();

		if (index == 0) {
			cabeca = (DLNode) aux.getNext();
			aux.setNext(null);
			cabeca.setPrev(null);
		} else {
			Node prev = aux.getPrev();
			Node prox = aux.getNext();

			prev.setNext(prox);

			if (prox != null)
				((DLNode) prox).setPrev(prev);

			aux.setNext(null);
			aux.setPrev(null);
		}
		size--;
		return removedElement;
	}

	/**
	 * Adiciona um novo elemento a lista em uma dada posicao.
	 * 
	 * Todos elementos com indice igual ou superior ao indice fornecido terao
	 * seus indices incrementados em uma unidade
	 * 
	 * @throws LinearListOverflowException
	 *             quando a lista estiver cheia.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando index nao estiver entre 0 e size.
	 */
	public void add(int index, Comparable theElement) {
		DLNode novo = new DLNode(theElement, null, null);

		if (novo == null) // sem espa�o
			throw new LinearListOverflowException("Lista cheia");

		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("index = " + index
					+ "  size = " + size);

		if (index == 0) {
			novo.setNext(cabeca);
			if (cabeca != null)
				cabeca.setPrev(novo);
			cabeca = (DLNode) novo;
		} else {
			DLNode prev = (DLNode) getNode(index - 1);
			DLNode prox = (DLNode) prev.getNext();

			prev.setNext(novo);
			novo.setPrev(prev);

			novo.setNext(prox);
			if (prox != null)
				prox.setPrev(novo);
		}
		size++;
	}

	/**
	 * Converte a lista em um String.
	 * 
	 * @return uma String representando a lista.
	 */
	public String toString() {
		StringBuffer s = new StringBuffer("[");
		// inserindo os elementos no buffer
		for (int i = 0; i < size(); i++) {
			Object elem = get(i);
			if (elem == null)
				s.append("null, ");
			else
				s.append(elem.toString() + ", ");
		}
		if (size > 0)
			s.delete(s.length() - 2, s.length());
		s.append("]");
		// criando a String equivalente
		return new String(s);
	}

	/**
	 * Verifica a validade de determinado indice. Um indice valido esta entre 0
	 * e size - 1, inclusive.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando index nao estiver entre 0 e size - 1.
	 */
	private void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("index = " + index
					+ "  size = " + size);
	}

	/**
	 * Busca um n� em determinada posi��o da lista.
	 * 
	 * @return o n� localizado da posi��o index.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando o �ndice fornecido n�o estiver entre 0 e size - 1.
	 */
	private DLNode getNode(int index) {
		checkIndex(index);

		DLNode aux = cabeca;
		for (int i = 0; i < index; i++)
			aux = (DLNode) aux.getNext();

		return aux;
	}
}