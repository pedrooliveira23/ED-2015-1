package capitulo3.ex8;

/**
 * Esta classe implementa uma lista linear utilizando uma representa��o baseada
 * em lista ligada.
 * 
 * @author Auri Vincenzi
 * @version 08-2005
 */
public class LinkedLinearList implements LinearList {
	// Quantidade de elementos da lista
	private int size;

	// N� que representa o in�cio da lista
	private Node head;

	public LinkedLinearList() {
		size = 0;
		head = null;
	}

	/**
	 * Verifica se a lista est� vazia.
	 * 
	 * @return true se e somente se a lista estiver vazia, false caso contr�rio.
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Tamanho da lista.
	 * 
	 * @return o n�mero corrente de elementos na lista.
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
	public Comparable getCoeficienteLista(int index) {
		checkIndex(index);
		Node p = head;
		for (int i = 0; i < index; i++) {
			p = p.getNext();
		}
		return p.getCoeficiente();
	}
	
	public Comparable getExpoenteLista(int index) {
		checkIndex(index);
		Node p = head;
		for (int i = 0; i < index; i++) {
			p = p.getNext();
		}
		return p.getExpoente();
	}

	/**
	 * Busca o �ndice de determinado elemento.
	 * 
	 * @return o �ndice da primeira ocorr�ncia do elemento na lista. Retorna -1
	 *         se o elemento n�o for encontrado.
	 */
	public int indexOfCoeficiente(Comparable theElement) {
		Node p = head;
		for (int i = 0; i < size; i++) {
			if (theElement.compareTo(p.getCoeficiente()) == 0)
				return i;
			p = p.getNext();
		}
		return -1;
	}
	
	public int indexOfExpoente(Comparable theElement) {
		Node p = head;
		for (int i = 0; i < size; i++) {
			if (theElement.compareTo(p.getExpoente()) == 0)
				return i;
			p = p.getNext();
		}
		return -1;
	}

	/**
	 * Adiciona um novo elemento a lista em uma dada posi��o.
	 * 
	 * Todos elementos com �ndice igual ou superior ao �ndice fornecido ter�o
	 * seus �ndices incrementados em uma unidade
	 * 
	 * @throws LinearListOverflowException
	 *             quando a lista estiver cheia.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando index n�o estiver entre 0 e size.
	 */
	public void add(int index, Comparable Coeficiente, Comparable Expoente) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("�ndice = " + index
					+ "  tamanho = " + size);

		Node novo = new Node(Coeficiente, Expoente, null);
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
	 * com �ndice superior ao �ndice fornecido ter�o seus valores decrementado
	 * em uma unidade.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando index n�o estiver entre 0 e size - 1.
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
		return toRemove.getCoeficiente();
	}

	/**
	 * Converte a lista em um String.
	 * 
	 * @return uma String representando a lista.
	 */
	public String toString() {
		StringBuffer s = new StringBuffer();
		// inserindo os elementos no buffer
		for (Node n = head; n != null; n = n.getNext())
			if (n.getCoeficiente() == null)
				s.append("null, ");
			else
				if(Integer.parseInt(n.getCoeficiente().toString()) < 0){
					s.append(n.getCoeficiente().toString() + "x^" + n.getExpoente().toString());
				} else {
					s.append("+"+n.getCoeficiente().toString() + "x^" + n.getExpoente().toString());
				}

		return new String(s);
	}

	/**
	 * Verifica a validade de determinado �ndice. Um �ndice v�lido esta entre 0
	 * e size - 1, inclusive.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando index n�o estiver entre 0 e size - 1.
	 */
	void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("�ndice = " + index
					+ "  tamanho = " + size);
	}

	/**
	 * Busca elemento em determinada posi��o da lista.
	 * 
	 * @return o n� contendo o elemento da posi��o index.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando o �ndice fornecido n�o estiver entre 0 e size - 1.
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