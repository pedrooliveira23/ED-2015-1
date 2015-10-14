package br.ufg.inf.ed1.lista;

public class DLinkedLinearList2 implements LinearList {
	private DLNode cabeca; // referencia para o primeiro elemento

	private DLNode cauda; // referencia para o último elemento

	private int size; // quantidade de elementos na lista

	public DLinkedLinearList2() {
		size = 0;
		cabeca = null;
		cauda = null;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}

	public Comparable get(int index) {
		Node aux = getNode(index);
		return aux.getElement();
	}

	public int indexOf(Comparable theElement) {
		if (isEmpty())
			return -1;

		Node aux = getNode(0);
		for (int i = 0; i < size; i++) {
			Comparable elem = aux.getElement();
			if (elem.compareTo(theElement) == 0)
				return i; // elemento encontrado

			aux = aux.getNext(); // não encontrado, procura no próximo nó
		}
		return -1;
	}

	public Comparable remove(int index) {
		checkIndex(index); // índice válido

		DLNode aux = getNode(index);
		Comparable removedElement = aux.getElement();

		if (index == 0) {
			cabeca = (DLNode) aux.getNext();
			if (cabeca == null)
				cauda = null;
			else
				cabeca.setPrev(null);

			aux.setNext(null);
		} else {
			Node prev = aux.getPrev();
			Node prox = aux.getNext();

			prev.setNext(prox);

			if (prox != null)
				((DLNode) prox).setPrev(prev);
			else
				cauda = (DLNode) prev;

			aux.setNext(null);
			aux.setPrev(null);
		}
		size--;
		return removedElement;
	}

	public void add(int index, Comparable theElement) {
		DLNode novo = new DLNode(theElement, null, null);

		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("index = " + index
					+ "  size = " + size);

		if (index == 0) {
			novo.setNext(cabeca);
			if (cabeca != null)
				cabeca.setPrev(novo);
			else
				cauda = (DLNode) novo;
			cabeca = (DLNode) novo;
		} else {
			DLNode prev = (DLNode) getNode(index - 1);
			DLNode prox = (DLNode) prev.getNext();

			prev.setNext(novo);
			novo.setPrev(prev);

			novo.setNext(prox);
			if (prox != null)
				prox.setPrev(novo);
			else
				cauda = (DLNode) novo;

		}
		size++;
	}

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

	private void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("index = " + index
					+ "  size = " + size);
	}

	private DLNode getNode(int index) {
		checkIndex(index);

		int meio = size() / 2;
		DLNode aux = null;
		if (index <= meio) {
			aux = cabeca;
			for (int i = 0; i < index; i++)
				aux = (DLNode) aux.getNext();
		} else {
			aux = cauda;
			for (int i = size() - 1; i > index; i--)
				aux = (DLNode) aux.getPrev();

		}
		return aux;
	}
}