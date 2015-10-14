package ed;

/**
 * Implementa��o da interface {@link Stack} utilizando uma lista simplemente
 * encadeada.
 * 
 * @author Auri Vincenzi (Adaptado de Natasha Gelfand & Roberto Tamassia)
 * @see StackFullException
 */
public class LinkedStack implements Stack {
	/**
	 * N� que representa o in�cio da lista (ou o topo da pilha).
	 */
	private Node topo;

	/**
	 * N�mero de elementos na pilha.
	 */
	private int size = -1;

	/**
	 * Inicializa a pilha.
	 */
	public LinkedStack() {
		size = 0;
		topo = null;
	}

	/**
	 * @return o n�mero de elementos na pilha.
	 */
	public int size() {
		return (size);
	}

	/**
	 * @return true se a pilha est� vazia, false caso contr�rio.
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Insere um elemento no topo da pilha.
	 * 
	 * @param obj
	 *            o elemento a ser empilhado.
	 * @exception StackFullException
	 *                se a pilha estiver cheia (sem mem�ria para incluir um novo
	 *                elemento).
	 */
	public void push(Comparable obj) {
		Node novo = new Node(obj, null);

		if (novo == null) {
			throw new StackFullException("Pilha cheia.");
		} else {
			size++;
			novo.setNext(topo);
			topo = novo;
		}
	}

	/**
	 * Consulta o topo da pilha.
	 * 
	 * @return o elemento no topo da pilha.
	 * @exception StackEmptyException
	 *                se a pilha est� vazia.
	 */
	public Comparable top() {
		return topo.getElement();
	}

	/**
	 * Remove o elemento do topo da pilha.
	 * 
	 * @return o elemento removido.
	 * @exception StackEmptyException
	 *                se a pilha est� vazia.
	 */
	public Comparable pop() {
		Node poped;
		if (isEmpty())
			throw new StackEmptyException("Pilha vazia.");

		poped = topo;
		topo = topo.getNext();
		poped.setNext(null);

		size--;

		return poped.getElement();
	}

	/**
	 * Converte a pilha em um String. Os elementos s�o desempilhados e
	 * empilhados novamente. Portanto a ordem de impress�o � do topo para a
	 * cauda.
	 * 
	 * @return uma String representando a pilha.
	 */
	public String toString() {
		StringBuffer s = new StringBuffer("[");

		Stack aux = new ArrayStack();
		while (!isEmpty()) {
			Comparable elem = pop();
			aux.push(elem);
			if (elem == null)
				s.append("null, ");
			else
				s.append(elem.toString() + ", ");
		}
		if (!aux.isEmpty()) {
			s.delete(s.length() - 2, s.length());
			while (!aux.isEmpty()) {
				push(aux.pop());
			}
		}
		s.append("]");
		// criando a String equivalente
		return new String(s);
	}
}
