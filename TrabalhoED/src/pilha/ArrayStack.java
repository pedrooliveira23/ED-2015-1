package pilha;

/**
 * Implementa��o da interface {@link Stack} utilizando um vetor de tamanho fixo.
 * Uma exce��o {@link StackFullException} � lan�ada pela opera��o push quando o
 * tamanho da pilha � igual ao tamanho do vetor.
 * 
 * @author Auri Vincenzi (Adaptado de Natasha Gelfand & Roberto Tamassia)
 * @see StackFullException
 */
public class ArrayStack implements Stack {
	/**
	 * Vetor utilizado para implementar a pilha.
	 */
	private Comparable S[];

	/**
	 * �ndice do elemento do topo.
	 */
	private int size;

	/**
	 * Inicializa a pilha com um tamanho de 50 elementos.
	 */
	public ArrayStack() {
		this(50);
	}

	/**
	 * Initializa a pilha com um tamanho fornecido pelo usu�rio.
	 * 
	 * @param cap
	 *            o tamanho do vetor.
	 */
	public ArrayStack(int cap) {
		size = 0;
		S = new Comparable[cap];
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
	 *                se a pilha estiver cheia.
	 */
	public void push(Comparable obj) {
		if (size() == S.length)
			throw new StackFullException("Pilha cheia.");
		S[size++] = obj;
	}

	/**
	 * Consulta o topo da pilha.
	 * 
	 * @return o elemento no topo da pilha.
	 * @exception StackEmptyException
	 *                se a pilha est� vazia.
	 */
	public Comparable top() {
		if (isEmpty())
			throw new StackEmptyException("Pilha vazia.");
		return S[size - 1];
	}

	/**
	 * Remove o elemento do topo da pilha.
	 * 
	 * @return o elemento removido.
	 * @exception StackEmptyException
	 *                se a pilha est� vazia.
	 */
	public Comparable pop() {
		Comparable poped;
		if (isEmpty())
			throw new StackEmptyException("Pilha vazia.");
		size--;
		poped = S[size];
		S[size] = null;
		return poped;
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

		Stack aux = new ArrayStack(size());
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
